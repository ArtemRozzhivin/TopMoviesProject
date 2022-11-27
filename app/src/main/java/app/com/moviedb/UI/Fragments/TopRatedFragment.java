package app.com.moviedb.UI.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import app.com.moviedb.Adapters.MovieAdapter;
import app.com.moviedb.Models.MovieResponse;
import app.com.moviedb.Models.Result;
import app.com.moviedb.Network.Interfaces.MainViewInterface;
import app.com.moviedb.R;
import app.com.moviedb.UI.MainPresenter;


public class TopRatedFragment extends Fragment implements MainViewInterface {

    private View mMainView;
    RecyclerView mMoviewRecyclerView;
    LinearLayoutManager mLinearLayoutManager;
    MovieAdapter mMovieAdapter;
    MainPresenter mainPresenter;
    List<Result> mTopRatedMovies = new ArrayList<Result>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mMainView = inflater.inflate(R.layout.fragment_top_rated, container, false);
        setupMVP();
        initRecyclerView(container);
        getTopRatedMovies();
        return mMainView;
    }

    private void setupMVP(){
        mainPresenter = new MainPresenter(this);
    }
    private void initRecyclerView(ViewGroup container){
        mLinearLayoutManager = new LinearLayoutManager(container.getContext());
        mMoviewRecyclerView = mMainView.findViewById(R.id.top_rated_movie_recycler_view);
        mMoviewRecyclerView.setLayoutManager(mLinearLayoutManager);
        mMoviewRecyclerView.setHasFixedSize(true);
    }
    private void getTopRatedMovies(){
        mainPresenter.getTopRatedMovies();
    }


    @Override
    public void displayMovies(MovieResponse movieResponse) {
            mTopRatedMovies = movieResponse.getResults();
            mMovieAdapter = new MovieAdapter(mTopRatedMovies);
            mMoviewRecyclerView.setAdapter(mMovieAdapter);
    }

}
