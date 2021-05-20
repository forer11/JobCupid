package com.example.jobcupid;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;

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

import de.hdodenhof.circleimageview.CircleImageView;

@Layout(R.layout.tinder_card_view_candidate)
public class TinderCardCandidate {

    @View(R.id.profile_image)
    private CircleImageView profileImageView;

    @View(R.id.name)
    private TextView nameText;

    @View(R.id.phone)
    private TextView phoneText;

    @View(R.id.jobTitle)
    private TextView jobTitleText;

    @View(R.id.jobPercentage)
    private TextView jobPercentageText;

    @View(R.id.location)
    private TextView locationText;

    @View(R.id.age)
    private TextView ageText;

    private Candidate mProfile;
    private Context mContext;
    private SwipePlaceHolderView mSwipeView;

    public TinderCardCandidate(Context context, Candidate profile, SwipePlaceHolderView swipeView) {
        mContext = context;
        mProfile = profile;
        mSwipeView = swipeView;
    }

    @Resolve
    private void onResolved(){
        Glide.with(mContext).load(mProfile.getImageUrl()).into(profileImageView);
        nameText.setText(mProfile.getName());

        phoneText.append(mProfile.getPhone().toString());
        jobTitleText.append(mProfile.getJobTitle());
        jobPercentageText.append(mProfile.getJobPercentage());
        locationText.append(mProfile.getLocation());
        ageText.append(String.valueOf(mProfile.getAge()));
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