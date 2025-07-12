package com.duowngtora.spring_ai_gemini.service;

import com.duowngtora.spring_ai_gemini.service.dto.ChatMessageReqDto;
import org.springframework.web.multipart.MultipartFile;

public interface IChatService {

    String chatMessage(ChatMessageReqDto chatMessageReqDto);

    String chatWithFile(MultipartFile file, String message);
}
