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

    // application.yml의 OpenAI 설정으로 ChatClient가 자동 구성되어 주입됩니다.
    public AiSummaryService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public String summarize(String marketName, String tmiContent) {
        // AI에게 역할을 부여하고, 원하는 결과물의 형식을 지정해주는 '프롬프트'
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

        // AI API 호출
        //ChatResponse response = chatClient.call(prompt);
        // AI가 생성한 텍스트 결과만 추출하여 반환
        //return response.getResult().getOutput().getContent();
        return "hi";
    }
}