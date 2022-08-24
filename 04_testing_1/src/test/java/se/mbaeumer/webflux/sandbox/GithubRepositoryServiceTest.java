package se.mbaeumer.webflux.sandbox;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class GithubRepositoryServiceTest {

    @Autowired
    private GithubRepositoryService githubRepositoryService;

    @Test
    public void testGetRepositories() {
        String actual = githubRepositoryService.getRepositories();
        assertNotNull(actual);
    }

    @Test
    public void testGetRepositoriesWithExchange() {
        String actual = githubRepositoryService.getRepositoriesWithExchange();
        assertNotNull(actual);
        assertTrue(actual.contains("spring-boot-webflux-sandbox"));
    }
}