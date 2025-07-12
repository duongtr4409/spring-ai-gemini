package com.duowngtora.spring_ai_gemini.controller;

import com.duowngtora.spring_ai_gemini.service.IChatService;
import com.duowngtora.spring_ai_gemini.service.dto.ChatMessageReqDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/chat")
public class ChatMessageController {

    private final IChatService chatService;

    public ChatMessageController(IChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/chat-message")
    public ResponseEntity<String> chatMessage(@RequestBody ChatMessageReqDto chatMessageReqDto){
        return ResponseEntity.ok().body(this.chatService.chatMessage(chatMessageReqDto));
    }

    @PostMapping("/chat-with-file")
    public ResponseEntity<String> chatWithFile(@RequestParam("file") MultipartFile file,
                                               @RequestParam("message") String message){
        return ResponseEntity.ok().body(this.chatService.chatWithFile(file, message));
    }
}
