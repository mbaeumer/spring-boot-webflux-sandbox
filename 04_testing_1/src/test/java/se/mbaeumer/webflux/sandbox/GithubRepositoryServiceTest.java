package se.mbaeumer.webflux.sandbox;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GithubRepositoryServiceTest {

    public static MockWebServer mockBackEnd;

    @BeforeAll
    static void setUp() throws IOException {
        mockBackEnd = new MockWebServer();
        mockBackEnd.start();
    }

    @AfterAll
    static void tearDown() throws IOException {
        mockBackEnd.shutdown();
    }

    private GithubRepositoryService githubRepositoryService;

    @Test
    public void testGetRepositories() throws InterruptedException {
        mockBackEnd.url("https://api.github.com/users/mbaeumer/repos");
        mockBackEnd.enqueue(new MockResponse()
      .setBody("hello-dummy")
      .addHeader("Content-Type", "application/json"));

        githubRepositoryService = new GithubRepositoryService(WebClient.builder(),
                mockBackEnd.url("/").toString());

        String actual = githubRepositoryService.getRepositories();
        RecordedRequest recordedRequest = mockBackEnd.takeRequest();

        System.out.println("actual: " + actual);
        assertNotNull(actual);
        assertTrue("hello-dummy".equals(actual));
        System.out.println("recorded: " + recordedRequest.getMethod());

    }

    @Test
    public void testGetRepositoriesWithRetrieve() {
        mockBackEnd.url("https://api.github.com/users/mbaeumer/repos");
        mockBackEnd.enqueue(new MockResponse()
                .setBody("hello-dummy")
                .addHeader("Content-Type", "application/json"));

        githubRepositoryService = new GithubRepositoryService(WebClient.builder(),
                mockBackEnd.url("/").toString());

        String actual = githubRepositoryService.getRepositoriesWithRetrieve();
        assertNotNull(actual);
        assertTrue(actual.contains("hello-dummy"));
    }

    private String getMockedResponse(){
        return "[\n" +
                "  {\n" +
                "    \"id\": 23613477,\n" +
                "    \"node_id\": \"MDEwOlJlcG9zaXRvcnkyMzYxMzQ3Nw==\",\n" +
                "    \"name\": \"angular-ots-custom-navbar\",\n" +
                "    \"full_name\": \"mbaeumer/angular-ots-custom-navbar\",\n" +
                "    \"private\": false,\n" +
                "    \"owner\": {\n" +
                "      \"login\": \"mbaeumer\",\n" +
                "      \"id\": 5737140,\n" +
                "      \"node_id\": \"MDQ6VXNlcjU3MzcxNDA=\",\n" +
                "      \"avatar_url\": \"https://avatars.githubusercontent.com/u/5737140?v=4\",\n" +
                "      \"gravatar_id\": \"\",\n" +
                "      \"url\": \"https://api.github.com/users/mbaeumer\",\n" +
                "      \"html_url\": \"https://github.com/mbaeumer\",\n" +
                "      \"followers_url\": \"https://api.github.com/users/mbaeumer/followers\",\n" +
                "      \"following_url\": \"https://api.github.com/users/mbaeumer/following{/other_user}\",\n" +
                "      \"gists_url\": \"https://api.github.com/users/mbaeumer/gists{/gist_id}\",\n" +
                "      \"starred_url\": \"https://api.github.com/users/mbaeumer/starred{/owner}{/repo}\",\n" +
                "      \"subscriptions_url\": \"https://api.github.com/users/mbaeumer/subscriptions\",\n" +
                "      \"organizations_url\": \"https://api.github.com/users/mbaeumer/orgs\",\n" +
                "      \"repos_url\": \"https://api.github.com/users/mbaeumer/repos\",\n" +
                "      \"events_url\": \"https://api.github.com/users/mbaeumer/events{/privacy}\",\n" +
                "      \"received_events_url\": \"https://api.github.com/users/mbaeumer/received_events\",\n" +
                "      \"type\": \"User\",\n" +
                "      \"site_admin\": false\n" +
                "    },\n" +
                "    \"html_url\": \"https://github.com/mbaeumer/angular-ots-custom-navbar\",\n" +
                "    \"description\": null,\n" +
                "    \"fork\": false,\n" +
                "    \"url\": \"https://api.github.com/repos/mbaeumer/angular-ots-custom-navbar\",\n" +
                "    \"forks_url\": \"https://api.github.com/repos/mbaeumer/angular-ots-custom-navbar/forks\",\n" +
                "    \"keys_url\": \"https://api.github.com/repos/mbaeumer/angular-ots-custom-navbar/keys{/key_id}\",\n" +
                "    \"collaborators_url\": \"https://api.github.com/repos/mbaeumer/angular-ots-custom-navbar/collaborators{/collaborator}\",\n" +
                "    \"teams_url\": \"https://api.github.com/repos/mbaeumer/angular-ots-custom-navbar/teams\",\n" +
                "    \"hooks_url\": \"https://api.github.com/repos/mbaeumer/angular-ots-custom-navbar/hooks\",\n" +
                "    \"issue_events_url\": \"https://api.github.com/repos/mbaeumer/angular-ots-custom-navbar/issues/events{/number}\",\n" +
                "    \"events_url\": \"https://api.github.com/repos/mbaeumer/angular-ots-custom-navbar/events\",\n" +
                "    \"assignees_url\": \"https://api.github.com/repos/mbaeumer/angular-ots-custom-navbar/assignees{/user}\",\n" +
                "    \"branches_url\": \"https://api.github.com/repos/mbaeumer/angular-ots-custom-navbar/branches{/branch}\",\n" +
                "    \"tags_url\": \"https://api.github.com/repos/mbaeumer/angular-ots-custom-navbar/tags\",\n" +
                "    \"blobs_url\": \"https://api.github.com/repos/mbaeumer/angular-ots-custom-navbar/git/blobs{/sha}\",\n" +
                "    \"git_tags_url\": \"https://api.github.com/repos/mbaeumer/angular-ots-custom-navbar/git/tags{/sha}\",\n" +
                "    \"git_refs_url\": \"https://api.github.com/repos/mbaeumer/angular-ots-custom-navbar/git/refs{/sha}\",\n" +
                "    \"trees_url\": \"https://api.github.com/repos/mbaeumer/angular-ots-custom-navbar/git/trees{/sha}\",\n" +
                "    \"statuses_url\": \"https://api.github.com/repos/mbaeumer/angular-ots-custom-navbar/statuses/{sha}\",\n" +
                "    \"languages_url\": \"https://api.github.com/repos/mbaeumer/angular-ots-custom-navbar/languages\",\n" +
                "    \"stargazers_url\": \"https://api.github.com/repos/mbaeumer/angular-ots-custom-navbar/stargazers\",\n" +
                "    \"contributors_url\": \"https://api.github.com/repos/mbaeumer/angular-ots-custom-navbar/contributors\",\n" +
                "    \"subscribers_url\": \"https://api.github.com/repos/mbaeumer/angular-ots-custom-navbar/subscribers\",\n" +
                "    \"subscription_url\": \"https://api.github.com/repos/mbaeumer/angular-ots-custom-navbar/subscription\",\n" +
                "    \"commits_url\": \"https://api.github.com/repos/mbaeumer/angular-ots-custom-navbar/commits{/sha}\",\n" +
                "    \"git_commits_url\": \"https://api.github.com/repos/mbaeumer/angular-ots-custom-navbar/git/commits{/sha}\",\n" +
                "    \"comments_url\": \"https://api.github.com/repos/mbaeumer/angular-ots-custom-navbar/comments{/number}\",\n" +
                "    \"issue_comment_url\": \"https://api.github.com/repos/mbaeumer/angular-ots-custom-navbar/issues/comments{/number}\",\n" +
                "    \"contents_url\": \"https://api.github.com/repos/mbaeumer/angular-ots-custom-navbar/contents/{+path}\",\n" +
                "    \"compare_url\": \"https://api.github.com/repos/mbaeumer/angular-ots-custom-navbar/compare/{base}...{head}\",\n" +
                "    \"merges_url\": \"https://api.github.com/repos/mbaeumer/angular-ots-custom-navbar/merges\",\n" +
                "    \"archive_url\": \"https://api.github.com/repos/mbaeumer/angular-ots-custom-navbar/{archive_format}{/ref}\",\n" +
                "    \"downloads_url\": \"https://api.github.com/repos/mbaeumer/angular-ots-custom-navbar/downloads\",\n" +
                "    \"issues_url\": \"https://api.github.com/repos/mbaeumer/angular-ots-custom-navbar/issues{/number}\",\n" +
                "    \"pulls_url\": \"https://api.github.com/repos/mbaeumer/angular-ots-custom-navbar/pulls{/number}\",\n" +
                "    \"milestones_url\": \"https://api.github.com/repos/mbaeumer/angular-ots-custom-navbar/milestones{/number}\",\n" +
                "    \"notifications_url\": \"https://api.github.com/repos/mbaeumer/angular-ots-custom-navbar/notifications{?since,all,participating}\",\n" +
                "    \"labels_url\": \"https://api.github.com/repos/mbaeumer/angular-ots-custom-navbar/labels{/name}\",\n" +
                "    \"releases_url\": \"https://api.github.com/repos/mbaeumer/angular-ots-custom-navbar/releases{/id}\",\n" +
                "    \"deployments_url\": \"https://api.github.com/repos/mbaeumer/angular-ots-custom-navbar/deployments\",\n" +
                "    \"created_at\": \"2014-09-03T09:00:09Z\",\n" +
                "    \"updated_at\": \"2014-09-03T09:03:16Z\",\n" +
                "    \"pushed_at\": \"2014-09-25T12:56:58Z\",\n" +
                "    \"git_url\": \"git://github.com/mbaeumer/angular-ots-custom-navbar.git\",\n" +
                "    \"ssh_url\": \"git@github.com:mbaeumer/angular-ots-custom-navbar.git\",\n" +
                "    \"clone_url\": \"https://github.com/mbaeumer/angular-ots-custom-navbar.git\",\n" +
                "    \"svn_url\": \"https://github.com/mbaeumer/angular-ots-custom-navbar\",\n" +
                "    \"homepage\": null,\n" +
                "    \"size\": 680,\n" +
                "    \"stargazers_count\": 0,\n" +
                "    \"watchers_count\": 0,\n" +
                "    \"language\": \"JavaScript\",\n" +
                "    \"has_issues\": true,\n" +
                "    \"has_projects\": true,\n" +
                "    \"has_downloads\": true,\n" +
                "    \"has_wiki\": true,\n" +
                "    \"has_pages\": false,\n" +
                "    \"forks_count\": 0,\n" +
                "    \"mirror_url\": null,\n" +
                "    \"archived\": false,\n" +
                "    \"disabled\": false,\n" +
                "    \"open_issues_count\": 0,\n" +
                "    \"license\": null,\n" +
                "    \"allow_forking\": true,\n" +
                "    \"is_template\": false,\n" +
                "    \"web_commit_signoff_required\": false,\n" +
                "    \"topics\": [],\n" +
                "    \"visibility\": \"public\",\n" +
                "    \"forks\": 0,\n" +
                "    \"open_issues\": 0,\n" +
                "    \"watchers\": 0,\n" +
                "    \"default_branch\": \"master\"\n" +
                "  }]";
    }
}