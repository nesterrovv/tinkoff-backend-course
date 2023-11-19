package edu.hw6.task5;

import org.junit.jupiter.api.Test;
import java.net.http.HttpClient;
import static org.assertj.core.api.Assertions.assertThat;

public class HackerNewsTest {
    private final HttpClient client = HttpClient.newHttpClient();

    @Test
    void testNews() {
        // Arrange
        int exampleStoryId = 8863;
        String expected = "My YC app: Dropbox - Throw away your USB drive";
        HackerNews hackerNews = new HackerNews(client);

        // Act
        String result = hackerNews.news(exampleStoryId);

        // Assert
        assertThat(result).isEqualTo(expected);
    }

}
