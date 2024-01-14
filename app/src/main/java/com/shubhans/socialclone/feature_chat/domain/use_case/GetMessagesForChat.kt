package com.shubhans.socialclone.feature_chat.domain.use_case

import com.shubhans.socialclone.core.util.Constants.DEFAULT_PAGE_SIZE
import com.shubhans.socialclone.core.util.Resource
import com.shubhans.socialclone.feature_chat.domain.model.Message
import com.shubhans.socialclone.feature_chat.domain.repository.ChatRepository

class GetMessagesForChat(
    private val repository: ChatRepository
) {

    suspend operator fun invoke(
        chatId: String,
        page: Int,
        pageSize: Int = DEFAULT_PAGE_SIZE
    ): Resource<List<Message>> {
        return repository.getMessagesForChat(
            chatId, page, pageSize
        )
    }
}