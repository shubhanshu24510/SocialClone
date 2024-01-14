package com.shubhans.socialclone.feature_chat.data.repository

import com.shubhans.socialclone.R
import com.shubhans.socialclone.core.util.Resource
import com.shubhans.socialclone.core.util.UiText
import com.shubhans.socialclone.feature_chat.data.remote.ChatApi
import com.shubhans.socialclone.feature_chat.data.remote.ChatService
import com.shubhans.socialclone.feature_chat.data.remote.data.WsClientMessage
import com.shubhans.socialclone.feature_chat.di.ScarletInstance
import com.shubhans.socialclone.feature_chat.domain.model.Chat
import com.shubhans.socialclone.feature_chat.domain.model.Message
import com.shubhans.socialclone.feature_chat.domain.repository.ChatRepository
import com.tinder.scarlet.WebSocket
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.receiveAsFlow
import okhttp3.OkHttpClient
import retrofit2.HttpException
import java.io.IOException

class ChatRepositoryImpl(
    private val chatApi: ChatApi,
    private val okHttpClient: OkHttpClient
): ChatRepository {

    private var chatService: ChatService? = null

    override fun initialize() {
        chatService = ScarletInstance.getNewInstance(okHttpClient)
    }

    override suspend fun getChatsForUser(): Resource<List<Chat>> {
        return try {
            val chats = chatApi
                .getChatsForUser()
                .mapNotNull { it.toChat() }
            Resource.Success(data = chats)
        } catch(e: IOException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_could_not_found_server)
            )
        } catch(e: HttpException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.some_wrong)
            )
        }
    }

    override suspend fun getMessagesForChat(chatId: String, page: Int, pageSize: Int): Resource<List<Message>> {
        return try {
            val messages = chatApi
                .getMessagesForChat(chatId, page, pageSize)
                .map { it.toMessage() }
            Resource.Success(data = messages)
        } catch(e: IOException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_could_not_found_server)
            )
        } catch(e: HttpException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.some_wrong)
            )
        }
    }

    override fun observeChatEvents(): Flow<WebSocket.Event> {
        return chatService?.observeEvents()
            ?.receiveAsFlow() ?: flow {  }
    }

    override fun observeMessages(): Flow<Message> {
        return chatService
            ?.observeMessages()
            ?.receiveAsFlow()
            ?.map { it.toMessage() } ?: flow {  }
    }

    override fun sendMessage(toId: String, text: String, chatId: String?) {
        chatService?.sendMessage(
            WsClientMessage(
                toId = toId,
                text = text,
                chatId = chatId
            )
        )
    }
}