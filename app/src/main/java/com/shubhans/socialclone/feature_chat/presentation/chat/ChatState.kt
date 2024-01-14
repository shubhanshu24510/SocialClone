package com.shubhans.socialclone.feature_chat.presentation.chat

import com.shubhans.socialclone.feature_chat.domain.model.Chat
data class ChatState(
    val chats: List<Chat> = emptyList(),
    val isLoading: Boolean = false
)
