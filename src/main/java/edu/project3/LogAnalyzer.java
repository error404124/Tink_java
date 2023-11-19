package edu.project3;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

@SuppressWarnings("MultipleStringLiterals")

public class LogAnalyzer {
    private LogAnalyzer() {

    }

    public static String[] getLog() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(
                    "https://raw.githubusercontent.com/elastic/examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs"))
                .GET()
                .build();

            HttpResponse<String> response = HttpClient.newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());

            String responseBody = response.body();

            String[] logLines = responseBody.split("\n");

            return Arrays.stream(logLines)
                .filter(line -> !line.trim().isEmpty())
                .toArray(String[]::new);
        } catch (URISyntaxException | IOException | InterruptedException exception) {
            return new String[0];
        }
    }

    public static String[] getAddr(String[] logs) {
        String[] addr = new String[logs.length];
        for (int i = 0; i < logs.length; ++i) {
            addr[i] = logs[i].substring(0, logs[i].indexOf(" "));
        }
        return addr;
    }

    public static OffsetDateTime[] getData(String[] logs) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z", Locale.ENGLISH);

        OffsetDateTime[] d = new OffsetDateTime[logs.length];

        for (int i = 0; i < logs.length; ++i) {
            String timeString = logs[i].substring(logs[i].indexOf("[") + 1, logs[i].lastIndexOf("]"));
            OffsetDateTime dateTime = OffsetDateTime.parse(timeString, formatter);
            d[i] = dateTime;
        }
        return d;
    }

    public static String[] getRequest(String[] logs) {
        String[] request = new String[logs.length];
        for (int i = 0; i < logs.length; ++i) {
            int index = logs[i].indexOf("\"");
            request[i] = logs[i].substring(logs[i].indexOf("\"") + 1, logs[i].indexOf("\"", index + 1));
        }
        return request;
    }

    public static String[] getStatus(String[] logs) {
        String[] status = new String[logs.length];
        for (int i = 0; i < logs.length; ++i) {
            if (logs[i].contains("\"-\"")) {
                status[i] = logs[i].substring(logs[i].indexOf("\" ") + 2, logs[i].indexOf("\"-\"") - 1);
            } else if (logs[i].contains("\"\"")) {
                status[i] = logs[i].substring(logs[i].indexOf("\" ") + 2, logs[i].indexOf("\"\"") - 1);
            } else if (logs[i].contains("\"h")) {
                status[i] = logs[i].substring(logs[i].indexOf("\" ") + 2, logs[i].indexOf("\"h") - 1);
            }
        }
        return status;
    }

    public static String[] getHttpReferer(String[] logs) {
        String[] referer = new String[logs.length];
        for (int i = 0; i < logs.length; ++i) {
            int index = logs[i].indexOf("\"");
            int index2 = logs[i].indexOf("\"", index + 1);
            int index3 = logs[i].indexOf("\"", index2 + 1);
            referer[i] = logs[i].substring(logs[i].indexOf("\"", index2 + 1) + 1, logs[i].indexOf("\"", index3 + 1));
        }
        return referer;
    }

    public static String[] getHttpUserAgent(String[] logs) {
        String[] agent = new String[logs.length];
        for (int i = 0; i < logs.length; ++i) {
            int index = logs[i].indexOf("\"");
            int index2 = logs[i].indexOf("\"", index + 1);
            int index3 = logs[i].indexOf("\"", index2 + 1);
            int index4 = logs[i].indexOf("\"", index3 + 1);
            agent[i] = logs[i].substring(logs[i].indexOf("\"", index4 + 1) + 1, logs[i].lastIndexOf("\""));
        }
        return agent;
    }

    public static int countGet(String[] logs) {
        return logs.length;
    }

    public static LinkedHashMap<String, Integer> mostFrequentLog(String[] logs) {
        LinkedHashMap<String, Integer> frequentLog = new LinkedHashMap<>();
        String[] str = new String[logs.length];
        String[] request = getRequest(logs);
        for (int i = 0; i < logs.length; ++i) {
            str[i] = request[i].split(" ")[1];
            if (frequentLog.containsKey(str[i])) {
                frequentLog.put(str[i], frequentLog.get(str[i]) + 1);
            } else {
                frequentLog.put(str[i], 1);
            }
        }
        return frequentLog;
    }

    public static LinkedHashMap<String, Integer> mostFrequentStatus(String[] logs) {
        LinkedHashMap<String, Integer> answer = new LinkedHashMap<>();
        String[] str = new String[logs.length];
        String[] status = getStatus(logs);
        for (int i = 0; i < logs.length; ++i) {
            str[i] = status[i].split(" ")[0];
            if (answer.containsKey(str[i])) {
                answer.put(str[i], answer.get(str[i]) + 1);
            } else {
                answer.put(str[i], 1);
            }
        }
        return answer;
    }

    public static long sizeStatus(String[] logs) {
        long answer = 0;
        String[] str = getStatus(logs);
        for (int i = 0; i < logs.length; ++i) {
            answer += Long.parseLong(str[i].split(" ")[1]);
        }
        return answer / logs.length;
    }

    public static LinkedHashMap<Month, Integer> mostPopularMonth(String[] logs) {
        LinkedHashMap<Month, Integer> month = new LinkedHashMap<>();
        Month[] str = new Month[logs.length];
        OffsetDateTime[] data = getData(logs);
        for (int i = 0; i < logs.length; ++i) {
            str[i] = data[i].getMonth();
            if (month.containsKey(str[i])) {
                month.put(str[i], month.get(str[i]) + 1);
            } else {
                month.put(str[i], 1);
            }
        }
        return month;
    }

    public static String mostPopularIP(String[] logs) {
        HashMap<String, Integer> popularIP = new HashMap<>();
        String[] ip = getAddr(logs);
        for (int i = 0; i < logs.length; ++i) {
            if (popularIP.containsKey(ip[i])) {
                popularIP.put(ip[i], popularIP.get(ip[i]) + 1);
            } else {
                popularIP.put(ip[i], 1);
            }
        }
        int maxCount = 0;
        String mostPopularIP = null;
        for (Map.Entry<String, Integer> entry : popularIP.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostPopularIP = entry.getKey();
            }
        }

        return mostPopularIP + " : " + maxCount;
    }
}
