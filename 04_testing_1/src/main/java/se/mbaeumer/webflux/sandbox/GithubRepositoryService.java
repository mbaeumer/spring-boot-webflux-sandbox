package se.mbaeumer.webflux.sandbox;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class GithubRepositoryService {

    private final WebClient webClient;
    private final String baseUrl;

    public GithubRepositoryService(WebClient.Builder builder, @Value("github.baseurl") String baseUrl) {
        this.webClient = builder.build();
        this.baseUrl = baseUrl;
    }

    public String getRepositories(){
        ClientResponse response = webClient.get()
                .uri(baseUrl)
                .exchange().block();
        return response.toEntity(String.class).block().getBody();
    }

    public String getRepositoriesWithRetrieve(){
        return webClient.get()
                .uri(baseUrl)
                .retrieve().bodyToMono(String.class)
                .block();
    }
}
