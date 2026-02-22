package mini.codereview.config;

import mini.codereview.config.properties.OpenAIProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

import java.net.http.HttpClient;
import java.time.Duration;

@Configuration
@EnableConfigurationProperties(OpenAIProperties.class)
public class OpenAIConfig {

    @Bean
    public RestClient openAiRestClient(OpenAIProperties properties) {

        HttpClient httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(properties.getTimeoutSeconds()))
                .build();

        return RestClient.builder()
                .baseUrl(properties.getBaseUrl())
                .requestFactory(new JdkClientHttpRequestFactory(httpClient))
                .defaultHeader("Authorization", "Bearer " + properties.getApiKey())
                .defaultHeader("Content-Type", "application/json")
                .build();
    }

}
