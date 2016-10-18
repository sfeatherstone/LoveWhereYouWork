package com.simonfea.lovewhereyouwork.https;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by simonfea on 18/10/2016.
 */

public class TwitterAPI {


    public interface AuthService {
        @FormUrlEncoded
        @Headers({"Accept-Encoding: gzip"})
        @POST("oauth2/token")
        Call<BearerAccessToken> getBearer(@Header("Authorization") String token, @Field("grant_type") String user);
    }

    static public class BearerAccessToken {
        public String token_type;
        public String access_token;

        public BearerAccessToken(String token_type, String access_token) {
            this.token_type = token_type;
            this.access_token = access_token;
        }
    }
}
