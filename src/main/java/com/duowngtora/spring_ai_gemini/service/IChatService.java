package com.duowngtora.spring_ai_gemini.service;

import com.duowngtora.spring_ai_gemini.service.dto.request.ChatMessageReqDto;
import com.duowngtora.spring_ai_gemini.service.dto.response.ChatMessageResDto;
import com.duowngtora.spring_ai_gemini.service.dto.response.ExpenseInfoResDto;
import com.duowngtora.spring_ai_gemini.service.dto.response.FilmInfoResDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

public interface IChatService {

    ChatMessageResDto chatMessage(ChatMessageReqDto chatMessageReqDto);

    ChatMessageResDto chatWithFile(MultipartFile file, String message, UUID conversationId);

    List<FilmInfoResDto> chatWithStructureOutput(ChatMessageReqDto chatMessageReqDto);

    ExpenseInfoResDto convertToExpenseInfo(ChatMessageReqDto chatMessageReqDto);
}
