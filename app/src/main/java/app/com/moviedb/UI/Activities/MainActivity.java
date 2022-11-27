package app.com.moviedb.UI.Activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import app.com.moviedb.Adapters.PagerViewAdapter;
import app.com.moviedb.R;

public class MainActivity extends AppCompatActivity {

    private TextView mTopRatedLabel;

    private ViewPager mViewPager;
    private PagerViewAdapter mPagerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTopRatedLabel = findViewById(R.id.top_movie);
        mViewPager = findViewById(R.id.main_pager);

        mPagerViewAdapter = new PagerViewAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerViewAdapter);


    }

    }
