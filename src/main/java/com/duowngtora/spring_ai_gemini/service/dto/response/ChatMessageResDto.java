package com.duowngtora.spring_ai_gemini.service.dto.response;

import java.util.UUID;

public record ChatMessageResDto(String resMessage, UUID conversationId) {
}
