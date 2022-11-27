package app.com.moviedb.UI;

import app.com.moviedb.Models.MovieResponse;
import app.com.moviedb.Network.Interfaces.ITopRatedMoviesAPI;
import app.com.moviedb.Network.Interfaces.MainPresenterInterface;
import app.com.moviedb.Network.Interfaces.MainViewInterface;
import app.com.moviedb.Network.RetrofitClient;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

import static app.com.moviedb.Utils.Constants.API_KEY;

public class MainPresenter implements MainPresenterInterface {

    MainViewInterface mainViewInterface;
    DisposableObserver<MovieResponse> mDisposableObserver;

    public MainPresenter(MainViewInterface mvi) {
        this.mainViewInterface = mvi;
    }


    @Override
    public void getTopRatedMovies() {
        getTopRatedObservable().subscribeWith(getObserver());
    }


    public Observable<MovieResponse> getTopRatedObservable(){
        return RetrofitClient.getInstance().create(ITopRatedMoviesAPI.class)
                .getUpcomingMovies(API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public DisposableObserver<MovieResponse> getObserver(){
        mDisposableObserver = new DisposableObserver<MovieResponse>() {
            @Override
            public void onNext(MovieResponse movieResponse) {
                mainViewInterface.displayMovies(movieResponse);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println(e);
            }

            @Override
            public void onComplete() {
                System.out.println("Worked");
            }
        };

        return  mDisposableObserver;
    }

}
