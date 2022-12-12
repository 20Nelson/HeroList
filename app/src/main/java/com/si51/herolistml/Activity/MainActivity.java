package com.si51.herolistml.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.si51.herolistml.API.APIRequestData;
import com.si51.herolistml.API.RetroServer;
import com.si51.herolistml.Model.ListModel;
import com.si51.herolistml.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvHero;
    private ProgressBar pbHero;
    private List<ListModel> listHero;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvHero = findViewById(R.id.rv_hero);
        pbHero = findViewById(R.id.pb_hero);

        linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        rvHero.setLayoutManager(linearLayoutManager);

        retrieveQuote();

    }

    private void retrieveQuote() {
        pbHero.setVisibility(View.VISIBLE);

        APIRequestData ardData =
                RetroServer.connectRetrofit().create(APIRequestData.class);
        Call<List<ListModel>> retrieveProcess =
                ardData.ardGet();
        retrieveProcess.enqueue(new Callback<List<ListModel>>() {
            @Override
            public void onResponse(Call<List<ListModel>> call, Response<List<ListModel>> response) {
                ListModel = response.body();
                Adapter adapterQuote = new AdapterQuote(listHero);
                rvHero.setAdapter(adapterQuote);
                pbHero.setVisibility(View.INVISIBLE);
            }
            @Override
            public void onFailure(Call<List<QuoteModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Gagal Menghubungi Server : " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("CEK", t.getMessage());
                pbQuote.setVisibility(View.INVISIBLE);
            }
        });
    }
}