package com.training.loadmore.pserenters;

import com.training.loadmore.interfaces.MoviesService;
import com.training.loadmore.models.MovieModel;
import com.training.loadmore.network.ServiceGenerator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Tran Manh on 9/17/2018.
 * Email: tranmanh.vn90@gmail.com
 */
public class GetDataPresenter implements IGetDataPresenter {

    @Override
    public void getListMovies(final OnFinishedListener listener, int index) {
        MoviesService service = ServiceGenerator.createService(MoviesService.class);
        Call<List<MovieModel>> call = service.getMovies(index);
        call.enqueue(new Callback<List<MovieModel>>() {
            @Override
            public void onResponse(Call<List<MovieModel>> call, Response<List<MovieModel>> response) {
                listener.onFinished(response.body());
            }

            @Override
            public void onFailure(Call<List<MovieModel>> call, Throwable t) {
                listener.onFailure(t);
            }
        });
    }
}
