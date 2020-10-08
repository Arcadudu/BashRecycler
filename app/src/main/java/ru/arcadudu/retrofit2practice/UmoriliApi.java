package ru.arcadudu.retrofit2practice;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UmoriliApi {

    //Методы должны всегда возвращать объект типа Call<T> и иметь аннотацию типа запроса (GET, POST, PUT, DELETE).
    @GET("/api/get")
    Call<List<PostModel>> getData(@Query("name") String resourceName, @Query("num") int count );
}
