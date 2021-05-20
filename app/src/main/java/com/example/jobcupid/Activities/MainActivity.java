package com.example.jobcupid.Activities;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import com.example.jobcupid.Candidate;
import com.example.jobcupid.R;
import com.example.jobcupid.TinderCardCandidate;
import com.example.jobcupid.Utils;
import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends BaseMenuActivity {
    CircleImageView profileImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolbar();
    }

    private void setToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("JobCupid");
        setSupportActionBar(toolbar);
//        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.icon);// set drawable icon
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SwipePlaceHolderView mSwipeView = (SwipePlaceHolderView)findViewById(R.id.swipeView);
        Context mContext = getApplicationContext();

        mSwipeView.getBuilder()
                .setDisplayViewCount(3)
                .setSwipeDecor(new SwipeDecor()
                        .setPaddingTop(20)
                        .setRelativeScale(0.01f)
                        .setSwipeInMsgLayoutId(R.layout.tinder_swipe_in_msg_view)
                        .setSwipeOutMsgLayoutId(R.layout.tinder_swipe_out_msg_view));


        for(Candidate profile : Utils.loadCandidates(this.getApplicationContext())){
            mSwipeView.addView(new TinderCardCandidate(mContext, profile, mSwipeView));
        }


        profileImage = mSwipeView.findViewById(R.id.profile_image);

        findViewById(R.id.rejectBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSwipeView.doSwipe(false);
            }
        });

        findViewById(R.id.acceptBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSwipeView.doSwipe(true);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        setProfile();

        MenuItem searchItem = menu.findItem(R.id.search_bar);
        SearchView searchView = (SearchView) searchItem.getActionView();

        setSearchQueryTextListener(searchView);
        return true;
    }

    private void setSearchQueryTextListener(SearchView searchView) {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

}