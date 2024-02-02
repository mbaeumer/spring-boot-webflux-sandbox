package se.mbaeumer.webflux.sandbox;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GithubRepositoryServiceTest extends TestCase {

    @Autowired
    private GithubRepositoryService githubRepositoryService;

    @Test
    public void testGetRepositories() {
        String actual = githubRepositoryService.getRepositories();
        Assert.assertNotNull(actual);
    }

    @Test
    public void testGetRepositoriesWithExchange() {
        String actual = githubRepositoryService.getRepositoriesWithExchange();
        System.out.println(actual);
        Assert.assertNotNull(actual);
        Assert.assertTrue(actual.contains("spring-boot-webflux-sandbox"));
    }
}