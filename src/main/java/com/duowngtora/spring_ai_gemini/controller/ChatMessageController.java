package com.duowngtora.spring_ai_gemini.controller;

import com.duowngtora.spring_ai_gemini.service.IChatService;
import com.duowngtora.spring_ai_gemini.service.dto.request.ChatMessageReqDto;
import com.duowngtora.spring_ai_gemini.service.dto.response.ChatMessageResDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/chat")
public class ChatMessageController {

    private final IChatService chatService;

    public ChatMessageController(IChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/chat-message")
    public ResponseEntity<ChatMessageResDto> chatMessage(@RequestBody ChatMessageReqDto chatMessageReqDto){
        return ResponseEntity.ok().body(this.chatService.chatMessage(chatMessageReqDto));
    }

    @PostMapping("/chat-with-file")
    public ResponseEntity<ChatMessageResDto> chatWithFile(@RequestParam("file") MultipartFile file,
                                               @RequestParam("message") String message,
                                               @RequestParam(value = "conversationId", required = false) UUID conversationId){
        return ResponseEntity.ok().body(this.chatService.chatWithFile(file, message, conversationId));
    }
}
