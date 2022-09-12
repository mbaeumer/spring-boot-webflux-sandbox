package se.mbaeumer.webflux.sandbox;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

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

    public String getRepositoriesWithExchange(){
        return webClient.get()
                .uri("https://api.github.com/users/mbaeumer/repos")
                .retrieve().bodyToMono(String.class)
                .block();
    }
}
