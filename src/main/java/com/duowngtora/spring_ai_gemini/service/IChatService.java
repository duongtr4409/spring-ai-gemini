package com.duowngtora.spring_ai_gemini.service;

import com.duowngtora.spring_ai_gemini.service.dto.request.ChatMessageReqDto;
import com.duowngtora.spring_ai_gemini.service.dto.response.ExpenseInfoResDto;
import com.duowngtora.spring_ai_gemini.service.dto.response.FilmInfoResDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IChatService {

    String chatMessage(ChatMessageReqDto chatMessageReqDto);

    String chatWithFile(MultipartFile file, String message);

    List<FilmInfoResDto> chatWithStructureOutput(ChatMessageReqDto chatMessageReqDto);

    ExpenseInfoResDto convertToExpenseInfo(ChatMessageReqDto chatMessageReqDto);
}
