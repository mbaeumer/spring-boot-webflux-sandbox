package se.mbaeumer.webflux.sandbox;


import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class GithubRepositoryService {

    private final WebClient webClient;

    public GithubRepositoryService(WebClient.Builder builder) {
        this.webClient = builder.build();
    }

    public String getRepositories(){
        Mono<String> response = webClient.get()
                .uri("https://api.github.com/users/mbaeumer/repos")

                .exchange().block().bodyToMono(String.class);
        String strResponse = response.block();
        System.out.println(strResponse);
        return strResponse;
    }

    public String getRepositoriesWithExchange(){
        return webClient.get()
                .uri("https://api.github.com/users/mbaeumer/repos")
                .retrieve().bodyToMono(String.class)
                .block();
    }
}
