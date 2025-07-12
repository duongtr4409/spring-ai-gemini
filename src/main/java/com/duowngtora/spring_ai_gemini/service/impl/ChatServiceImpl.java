package com.duowngtora.spring_ai_gemini.service.impl;

import com.duowngtora.spring_ai_gemini.service.IChatService;
import com.duowngtora.spring_ai_gemini.service.dto.ChatMessageReqDto;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements IChatService {

    private final ChatClient chatClient;

    public ChatServiceImpl(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @Override
    public String chatMessage(ChatMessageReqDto chatMessageReqDto) {
        return this.chatClient.prompt(chatMessageReqDto.message()).call().content();
    }
}
