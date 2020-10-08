package ru.arcadudu.retrofit2practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;

public class MainActivity extends AppCompatActivity {

    RecyclerView postRecyclerView;
    List<PostModel> postList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        postList = new ArrayList<>();

        postRecyclerView = findViewById(R.id.post_recyclerView);
        postRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        PostAdapter adapter = new PostAdapter(postList);
        postRecyclerView.setAdapter(adapter);

        App.getApi().getData("bash", 50).enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                postList.addAll(response.body());
                postRecyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Ошибка при чтении данных", Toast.LENGTH_SHORT).show();
            }
        });
    }
}