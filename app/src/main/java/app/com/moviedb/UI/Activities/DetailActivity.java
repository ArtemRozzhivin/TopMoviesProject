package app.com.moviedb.UI.Activities;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import app.com.moviedb.Models.Result;
import app.com.moviedb.R;
import app.com.moviedb.Utils.DateUtils;

public class DetailActivity extends AppCompatActivity {

    private final String TAG = "DetailActivity";
    private Result mResult;

    private ImageView detailMovieImage;
    private TextView detailMovieTitle;
    private TextView detailReleaseDate;
    private TextView detailOverview;
    private Toolbar mToolbar;

    private static final String IMAGE_URL_BASE_PATH="http://image.tmdb.org/t/p/w342//";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mToolbar = findViewById(R.id.detail_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(ContextCompat
                .getDrawable(DetailActivity.this,R.drawable.nav_back));
        getSupportActionBar().setTitle("");

        mResult = getIntent().getParcelableExtra("DetailObject");
        Log.i(TAG,mResult.getPosterPath());
        String image_url = IMAGE_URL_BASE_PATH+mResult.getPosterPath();

        detailMovieImage = findViewById(R.id.detail_movie_image);
        detailMovieTitle = findViewById(R.id.detail_movie_title);
        detailReleaseDate = findViewById(R.id.detail_movie_release_date);
        detailOverview = findViewById(R.id.movie_overview);

        Glide.with(DetailActivity.this).load(image_url).into(detailMovieImage);

        detailMovieTitle.setText(mResult.getTitle());
        detailOverview.setText(mResult.getOverview());
        detailOverview.setMovementMethod(new ScrollingMovementMethod());
        detailReleaseDate.setText(DateUtils.getStringDate(mResult.getReleaseDate()));
    }



}
