package com.duowngtora.spring_ai_gemini.service.impl;

import com.duowngtora.spring_ai_gemini.service.IChatService;
import com.duowngtora.spring_ai_gemini.service.dto.request.ChatMessageReqDto;
import com.duowngtora.spring_ai_gemini.service.dto.response.ExpenseInfoResDto;
import com.duowngtora.spring_ai_gemini.service.dto.response.FilmInfoResDto;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.content.Media;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;

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

    @Override
    public String chatWithFile(MultipartFile file, String message) {
        Media media = Media.builder()
                .mimeType(MimeTypeUtils.parseMimeType(Objects.requireNonNull(file.getContentType())))
                .data(file.getResource())
                .build();

        // cấu hình mức độ sáng tạo của AI (giá trị từ 0 -> 1: càng thấp thì sáng tạo càng ít càng chính xác)
        ChatOptions chatOptions = ChatOptions.builder()
                .temperature(0.1D)
                .build();

        return this.chatClient.prompt()
                .options(chatOptions)
                .system("""
                        Bạn là DuowngTora
                        """)
                .user(promptUserSpec ->
                        promptUserSpec.media(media)
                                .text(message))
                .call().content();
    }

    @Override
    public List<FilmInfoResDto> chatWithStructureOutput(ChatMessageReqDto chatMessageReqDto) {
        SystemMessage systemMessage = new SystemMessage("""
                Bạn là DuowngTora
                """);
        UserMessage userMessage = new UserMessage(chatMessageReqDto.message());
        ChatOptions chatOptions = ChatOptions.builder()
                .temperature(0.1D)
                .build();

        Prompt prompt = new Prompt(systemMessage, userMessage);

        return this.chatClient.prompt(prompt)
                .options(chatOptions)
                .call()
                .entity(new ParameterizedTypeReference<List<FilmInfoResDto>>() {
                });
    }

    @Override
    public ExpenseInfoResDto convertToExpenseInfo(ChatMessageReqDto chatMessageReqDto) {
        SystemMessage systemMessage = new SystemMessage("""
                Bạn là DuowngTora
                """);
        UserMessage userMessage = new UserMessage(chatMessageReqDto.message());
        Prompt prompt = new Prompt(systemMessage, userMessage);
        ChatOptions chatOptions = ChatOptions.builder()
                .temperature(0.1D)
                .build();
        return this.chatClient.prompt(prompt)
                .options(chatOptions)
                .call()
                .entity(ExpenseInfoResDto.class);
    }
}
