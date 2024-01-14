package com.shubhans.socialclone.feature_chat.domain.use_case

import com.shubhans.socialclone.core.util.Resource
import com.shubhans.socialclone.feature_chat.domain.model.Chat
import com.shubhans.socialclone.feature_chat.domain.repository.ChatRepository

class GetChatsForUser(
    private val repository: ChatRepository
) {

    suspend operator fun invoke(): Resource<List<Chat>> {
        return repository.getChatsForUser()
    }
}