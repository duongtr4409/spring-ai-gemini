package com.duowngtora.spring_ai_gemini.service.impl;

import com.duowngtora.spring_ai_gemini.service.IChatService;
import com.duowngtora.spring_ai_gemini.service.dto.ChatMessageReqDto;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements IChatService {

    private final ChatClient chatClient;

    public ChatServiceImpl(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @Override
    public String chatMessage(ChatMessageReqDto chatMessageReqDto) {
        SystemMessage systemMessage = new SystemMessage("""
                    Bạn là DuowngTora, một chuyên viên chuyên xử lý những thủ tục hành chính công của Cục An Toàn Thực Phẩm
                    Bộ Y tế. Bạn có thể trả lời bằng tiếng Việt hoặc tiếng Anh tùy thuộc vào yêu cầu người dùng.
                    Hãy cố gắng trả lời ngắn gọn và rõ ràng nhất có thể để giúp đỡ người dùng tốt hơn.
                    Nếu bạn không chắc chắn về câu hỏi của người dùng, hãy nói rằng bạn sẽ tìm hiểu thêm trước khi trả lời.
                """);
        UserMessage userMessage = new UserMessage(chatMessageReqDto.message());
        Prompt prompt = new Prompt(systemMessage, userMessage);
        return this.chatClient.prompt(prompt).call().content();
    }
}
