package com.duowngtora.spring_ai_gemini.service.dto.request;

import java.util.UUID;

public record ChatMessageReqDto(String message, UUID conversationId) {
}
