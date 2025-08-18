package org.example.marketback.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AiSummaryService {

    private final ChatClient chatClient;

    // application.yml의 AI 설정(이제 Gemini)으로 ChatClient가 자동 구성되어 주입됩니다.
    public AiSummaryService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public String summarize(String marketName, String tmiContent) {
        // 프롬프트는 Gemini에서도 잘 동작하므로 수정할 필요가 없습니다.
        String promptText = """
                당신은 전통시장 홍보 플랫폼의 콘텐츠 관리자입니다.
                '{marketName}' 가게에 대해 어제 하루 동안 사람들이 남긴 다양한 이야기(TMI)들이 아래에 있습니다.
                이 이야기들을 바탕으로, 마치 한 명의 작가가 쓴 것처럼 부드러운 문체로 2~3 문단의 흥미로운 일일 요약 보고서를 작성해주세요.
                방문객의 긍정적인 평가나 재미있는 사건을 중심으로 요약하고, 글 끝에는 항상 "오늘도 활기 넘치는 하루였네요!" 라고 덧붙여 주세요.

                ---
                {tmiContent}
                ---
                """;

        PromptTemplate promptTemplate = new PromptTemplate(promptText);
        Prompt prompt = promptTemplate.create(Map.of("marketName", marketName, "tmiContent", tmiContent));

        // 이 코드는 이제 OpenAI가 아닌 Gemini API를 호출하게 됩니다.
        return chatClient.prompt(prompt)
                .call()
                .content();
    }
}