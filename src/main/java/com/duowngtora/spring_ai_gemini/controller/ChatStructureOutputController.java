package com.duowngtora.spring_ai_gemini.controller;

import com.duowngtora.spring_ai_gemini.service.IChatService;
import com.duowngtora.spring_ai_gemini.service.dto.request.ChatMessageReqDto;
import com.duowngtora.spring_ai_gemini.service.dto.response.ExpenseInfoResDto;
import com.duowngtora.spring_ai_gemini.service.dto.response.FilmInfoResDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/chat-structure-output")
public class ChatStructureOutputController {

    private final IChatService chatService;

    public ChatStructureOutputController(IChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/film-info")
    public ResponseEntity<List<FilmInfoResDto>> listFilmInfo(@RequestBody ChatMessageReqDto chatMessageReqDto) {
        return ResponseEntity.ok().body(this.chatService.chatWithStructureOutput(chatMessageReqDto));
    }

    @PostMapping("/expense-info")
    public ResponseEntity<ExpenseInfoResDto> expenseInfo(@RequestBody ChatMessageReqDto chatMessageReqDto) {
        return ResponseEntity.ok().body(this.chatService.convertToExpenseInfo(chatMessageReqDto));
    }
}
