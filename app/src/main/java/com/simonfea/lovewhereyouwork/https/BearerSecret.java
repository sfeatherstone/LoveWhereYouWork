package com.simonfea.lovewhereyouwork.https;

import android.util.Base64;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by simonfea on 18/10/2016.
 */

public class BearerSecret {

    final static String consumerKey = "AaGvDUHTeohv1VEfsQ4ClpRzG";
    final static String consumerSecret = "hDtegDJ1q6BwBSr8bgIVKAjnn6z1ihkp23DEdlRs4Js0qfJEwD";
    final static String baseUrl = "https://api.twitter.com/";
    static String bearerAuth = null;
    //final static String auth_url = "oauth2/token";

    public static String getBearerAuth() {
        if (bearerAuth == null) {
            fetchBearerAuth();
        }
        return bearerAuth;
    }

    static void fetchBearerAuth() {
        String combined = consumerKey + ":" + consumerSecret;
        String base64Encoding = Base64.encodeToString(combined.getBytes(), Base64.NO_WRAP);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TwitterAPI.AuthService service = retrofit.create(TwitterAPI.AuthService.class);

        Call<TwitterAPI.BearerAccessToken> bearer = service.getBearer("Basic " + base64Encoding, "client_credentials");

        try {
            Response<TwitterAPI.BearerAccessToken> response = bearer.execute();
            if (response.isSuccessful()) {
                bearerAuth = response.body().toString();
            }
        } catch (IOException e) {
            // handle error
        }


    }
}
