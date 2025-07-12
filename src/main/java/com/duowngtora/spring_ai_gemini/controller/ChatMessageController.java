package com.duowngtora.spring_ai_gemini.controller;

import com.duowngtora.spring_ai_gemini.service.IChatService;
import com.duowngtora.spring_ai_gemini.service.dto.ChatMessageReqDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/chat-message")
public class ChatMessageController {

    private final IChatService chatService;

    public ChatMessageController(IChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("")
    public ResponseEntity<String> chatMessage(@RequestBody ChatMessageReqDto chatMessageReqDto){
        return ResponseEntity.ok().body(this.chatService.chatMessage(chatMessageReqDto));
    }
}
