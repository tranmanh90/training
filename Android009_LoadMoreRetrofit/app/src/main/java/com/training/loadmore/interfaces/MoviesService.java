package com.training.loadmore.interfaces;

import com.training.loadmore.models.MovieModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Tran Manh on 9/17/2018.
 * Email: tranmanh.vn90@gmail.com
 */
public interface MoviesService {
    @GET("movies.php")
    Call<List<MovieModel>> getMovies(@Query("index") int index);
}
