package myboard.spring.repository;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Repository
public class HackerNewsAPIRepository implements WebAPIRepository {

    private static final String baseUrl = "https://hacker-news.firebaseio.com/v0/";

    @Override
    public String request(HttpMethod method, String urlPath) throws IOException {
        URL url = new URL(baseUrl + urlPath);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod(method.toString());
        conn.setDoOutput(true);
        conn.connect();

        int status = conn.getResponseCode();
        if (2 == status / 100) {
            StringBuilder sb = new StringBuilder();
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            br.close();
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        } else {
            return "";
        }
    }

}
