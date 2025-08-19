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

    /**
     * 가게의 기존 히스토리와 새로운 사용자 후기를 바탕으로 AI 요약 스토리를 생성합니다.
     * @param marketName 가게 이름
     * @param originalHistory 가게의 기존 히스토리 내용
     * @param userReviews 새로 수집된 사용자 후기 (TMI) 내용
     * @return AI가 생성한 새로운 히스토리 스토리
     */
    public String summarize(String marketName, String originalHistory, String userReviews) {
        // 요청하신 새로운 프롬프트로 교체
        String promptText = """
                당신은 죽도시장의 역사 큐레이터입니다.
                아래에 있는 '{marketName}' 가게의 기존 역사와 최근 방문객들의 후기를 엮어서, 방문 예정인 사용자들이 흥미를 느낄만한 하나의 완성된 이야기로 각색해주세요.

                [작성 규칙]
                1. 목적: 가게의 과거와 현재를 자연스럽게 연결하여, 시장을 잘 모르는 사용자도 쉽고 편하게 이해할 수 있는 소개글을 작성합니다.
                2. 분량: 본문은 공백 포함 200자 이내로 작성해주세요.
                3. 어조: '했습니다'와 '해요' 체를 섞어, 옆에서 친절하게 설명해주는 큐레이터처럼 따뜻하고 부드러운 문체를 사용해주세요. (예: "옛날엔 작은 가게였지만 지금은 3호점까지 확장했어요.")
                4. 내용: 주어진 데이터 중에서 흥미롭거나 긍정적인 내용을 중심으로 사용하고, 기존 역사와 방문객 후기의 비중을 비슷하게 맞춰 자연스럽게 연결해주세요. (예: "과거엔 아는 사람만 찾아오던 곳이었지만, 이제는 많은 분들이 인생 맛집이라며 극찬하는 가게가 되었어요.")
                5. 마무리: 글의 제일 마지막에는, 가게의 가장 큰 장점과 방문을 유도하는 홍보 문구를 한 문장으로 요약해서 작성해주세요. (예: "신선한 회가 일품인 포항대게, 오늘 저녁으로 어떠세요?")
                6. 스타일: 문장은 간결하게, 설명은 정확하게 작성하고 이모지는 사용하지 마세요.
                7. 반드시 주어진 [가게의 기존 역사]와 [최근 방문객 후기] 내용만을 활용하여 작성해야 합니다.

                ---
                [가게의 기존 역사]
                {originalHistory}
                ---
                [최근 방문객 후기]
                {userReviews}
                ---
                """;

        PromptTemplate promptTemplate = new PromptTemplate(promptText);
        Prompt prompt = promptTemplate.create(Map.of(
                "marketName", marketName,
                "originalHistory", originalHistory,
                "userReviews", userReviews
        ));

        // 1.0.0-M2 버전에 맞는 .call(prompt) 방식으로 수정
        return chatClient.prompt(prompt).call().content();
    }
}