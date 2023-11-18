package edu.hw6;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.net.URISyntaxException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask5 {
    @Test
    void test1() throws URISyntaxException, IOException, InterruptedException {
        long[] topStories = Task5.HackerNews.hackerNewsTopStories();
        long newsId = 38320698;
        String answer = Task5.HackerNews.news(newsId);
        assertThat("I disagree with Geoff Hinton regarding \\" ).isEqualTo(Task5.HackerNews.news(newsId));
    }
}
