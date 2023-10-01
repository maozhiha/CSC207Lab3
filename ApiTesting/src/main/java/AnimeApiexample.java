import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class AnimeApiexample {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        System.out.println(String.format("Using OkHTTP to call URL %s","https://api.jikan.moe/v4/anime?q=Naruto&sfw"));
        MediaType mediaType = MediaType.parse("text/plain");
        Request request = new Request.Builder()
                .url("https://api.jikan.moe/v4/anime?q=Naruto&sfw")
                .build();
        Response response = client.newCall(request).execute();

        JSONObject responseBody = new JSONObject(response.body().string());
        JSONArray dataArray = responseBody.getJSONArray("data");

        JSONObject first = dataArray.getJSONObject(0);

        System.out.println(String.format("The title of the First Anime in the request is %s", first.getString("title")));
        System.out.println(String.format("The Japanese title of the First Anime in the request is %s", first.getString("title_japanese")));

    }
}
