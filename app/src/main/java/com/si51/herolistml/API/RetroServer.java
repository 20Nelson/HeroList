package com.si51.herolistml.API;

import androidx.appcompat.app.AppCompatDelegate;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroServer {
    private static final String baseURL = "https://api.dazelpro.com/mobile-legends/hero";
    private static Retrofit retro;
    public static  Retrofit connectRetrofit(){
        if (retro == null) {
            retro = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retro;
    }
}
