package com.example.jobcupid;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.swipe.SwipeCancelState;
import com.mindorks.placeholderview.annotations.swipe.SwipeIn;
import com.mindorks.placeholderview.annotations.swipe.SwipeInState;
import com.mindorks.placeholderview.annotations.swipe.SwipeOut;
import com.mindorks.placeholderview.annotations.swipe.SwipeOutState;

@Layout(R.layout.tinder_card_view_businesse)
public class TinderCardBusiness {

    @View(R.id.profile_image)
    private ImageView profileImageView;

    @View(R.id.nameAndLocation)
    private TextView nameAndLocation;

    @View(R.id.jobTitleAndPhone)
    private TextView jobTitleAndPhone;

    @View(R.id.cardView)
    private CardView cardView;

    private Candidate mProfile;
    private Context mContext;
    private SwipePlaceHolderView mSwipeView;

    public TinderCardBusiness(Context context, Candidate profile, SwipePlaceHolderView swipeView) {
        mContext = context;
        mProfile = profile;
        mSwipeView = swipeView;
    }

    @Resolve
    private void onResolved(){
        Glide.with(mContext).load(mProfile.getImageUrl()).into(profileImageView);
        nameAndLocation.setText(mProfile.getName() + " - " + mProfile.getLocation());
        jobTitleAndPhone.append(mProfile.getJobTitle() + " - Contact Info: 0" + mProfile.getPhone());
        cardView.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
            }
        });
    }

    @SwipeOut
    private void onSwipedOut(){
        Log.d("EVENT", "onSwipedOut");
        mSwipeView.addView(this);
    }

    @SwipeCancelState
    private void onSwipeCancelState(){
        Log.d("EVENT", "onSwipeCancelState");
    }

    @SwipeIn
    private void onSwipeIn(){
        Log.d("EVENT", "onSwipedIn");
    }

    @SwipeInState
    private void onSwipeInState(){
        Log.d("EVENT", "onSwipeInState");
    }

    @SwipeOutState
    private void onSwipeOutState(){
        Log.d("EVENT", "onSwipeOutState");
    }
}