package com.si51.herolistml.API;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIRequestData {
    @GET("hero")
    Call<List<ListModel>>ardGet();
}
