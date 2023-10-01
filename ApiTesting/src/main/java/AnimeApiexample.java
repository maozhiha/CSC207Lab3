import okhttp3.*;

import java.io.IOException;

public class AnimeApiexample {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        Request request = new Request.Builder()
                .url("https://api.jikan.moe/v4/anime?q=Naruto&sfw")
                .build();
        Response response = client.newCall(request).execute();

        System.out.println(response.body().string());
    }
}
