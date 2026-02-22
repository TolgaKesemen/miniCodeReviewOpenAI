package mini.codereview.service.impl;

import lombok.RequiredArgsConstructor;
import mini.codereview.config.properties.OpenAIProperties;
import mini.codereview.dto.Message;
import mini.codereview.handler.exception.CoreReviewException;
import mini.codereview.request.OpenAIRequest;
import mini.codereview.response.CodeReviewResponse;
import mini.codereview.response.OpenAIResponse;
import mini.codereview.service.CodeReviewService;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CodeReviewServiceImpl implements CodeReviewService {

    private final RestClient openAiRestClient;
    private final OpenAIProperties properties;

    public CodeReviewResponse review(String code) {
        String prompt = """
                You are a senior Java software engineer.
                Review the following Java code.
                Answer in Turkish.
                Focus on:
                - Clean code
                - SOLID principles
                - Performance
                - Security issues
                - Refactoring suggestions
                
                Code:
                %s
                """.formatted(code);

        OpenAIRequest request = new OpenAIRequest(properties.getModel(), List.of(new Message("user", prompt)), 0.2);

        OpenAIResponse response = openAiRestClient.post()
                .uri("/chat/completions")
                .body(request)
                .retrieve()
                .onStatus(HttpStatusCode::isError,
                        (req, res) -> {
                            throw new CoreReviewException("OpenAI API error: " + res.getStatusCode());
                        })
                .body(OpenAIResponse.class);

        if (response == null || response.getChoices() == null || response.getChoices().isEmpty()
                || response.getChoices().getFirst().getMessage() == null) {
            throw new CoreReviewException("OpenAI returned empty response");
        }

        return new CodeReviewResponse(response.getChoices().getFirst().getMessage().getContent());
    }

}
