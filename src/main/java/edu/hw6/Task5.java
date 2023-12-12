package edu.hw6;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task5 {

    private Task5() {

    }

    public static class HackerNews {

        private static HttpResponse<String> sendHttpRequest(String url)
            throws URISyntaxException, IOException, InterruptedException {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .GET()
                .build();

            return HttpClient.newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());
        }

        public static long[] hackerNewsTopStories() {
            try {
                HttpResponse<String> response =
                    sendHttpRequest("https://hacker-news.firebaseio.com/v0/topstories.json");
                String responseBody = response.body();

                String[] storyIds = responseBody.replace("[", "")
                    .replace("]", "")
                    .split(",");

                long[] topStories = new long[storyIds.length];
                for (int i = 0; i < storyIds.length; i++) {
                    topStories[i] = Long.parseLong(storyIds[i]);
                }
                return topStories;
            } catch (URISyntaxException | IOException | InterruptedException exception) {
                return new long[0];
            }
        }

        public static String news(long id) throws URISyntaxException, IOException, InterruptedException {
            String url = "https://hacker-news.firebaseio.com/v0/item/" + id + ".json";
            HttpResponse<String> response = sendHttpRequest(url);

            String responseBody = response.body();
            String newsTitle = "";

            Pattern pattern = Pattern.compile("\"title\":\"(.*?)\"");
            Matcher matcher = pattern.matcher(responseBody);
            if (matcher.find()) {
                newsTitle = matcher.group(1);
            }
            return newsTitle;
        }
    }
}
