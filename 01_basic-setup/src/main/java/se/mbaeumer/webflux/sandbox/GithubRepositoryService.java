package se.mbaeumer.webflux.sandbox;


import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class GithubRepositoryService {

    private final WebClient webClient;

    public GithubRepositoryService(WebClient.Builder builder) {
        this.webClient = builder.build();
    }

    public String getRepositories(){
        ClientResponse response = webClient.get()
                .uri("https://api.github.com/users/mbaeumer/repos")
                .exchange().block();
        return response.toEntity(String.class).block().getBody();
    }
}
