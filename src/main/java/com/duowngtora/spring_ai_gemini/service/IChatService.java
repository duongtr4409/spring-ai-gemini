package com.duowngtora.spring_ai_gemini.service;

import com.duowngtora.spring_ai_gemini.service.dto.ChatMessageReqDto;

public interface IChatService {

    String chatMessage(ChatMessageReqDto chatMessageReqDto);
}
