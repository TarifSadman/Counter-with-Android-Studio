package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Map extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        recyclerView = findViewById(R.id.rc);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JSONPlaceholder jsonPlaceholder = retrofit.create(JSONPlaceholder.class);
        Call<List<Post>> Call = jsonPlaceholder.getPost();
        Call.enqueue(new Callback<List<Post>>(

        ) {
            @Override
            public void onResponse(retrofit2.Call<List<Post>> call, Response<List<Post>> response) {
if(!response.isSuccessful()){
    Toast.makeText(Map.this, response.code(),Toast.LENGTH_SHORT).show();
    return;
}
List<Post> postList = response.body();
PostAdapter postAdapter = new PostAdapter(Map.this, postList);
recyclerView.setAdapter(postAdapter);
            }

            @Override
            public void onFailure(retrofit2.Call<List<Post>> call, Throwable t) {
                Toast.makeText(Map.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}