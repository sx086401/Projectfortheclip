package com.schedule.user.projectfortheclip;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.swipe.SwipeCancelState;
import com.mindorks.placeholderview.annotations.swipe.SwipeIn;
import com.mindorks.placeholderview.annotations.swipe.SwipeInState;
import com.mindorks.placeholderview.annotations.swipe.SwipeOut;
import com.mindorks.placeholderview.annotations.swipe.SwipeOutState;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2017/5/16.
 */

@Layout(R.layout.tinder_card_view)
public class TinderCard {
    String randomname;
    String picture,holderid;
    String theDate;
    Integer count=0;
    Integer checkit=0;
    String response2;

    @View(R.id.profileImageView)
    private ImageView profileImageView;

    @View(R.id.nameAgeTxt)
    private TextView nameAgeTxt;

    @View(R.id.chat)
    private Button chat;


    @View(R.id.cardview)
    private CardView card;

    private Profile mProfile;
    private Context mContext;
    private SwipePlaceHolderView mSwipeView;
    private Activity activity;

    List<Profile> profileList2 = new ArrayList<>();


    public TinderCard(Context context, Profile profile, SwipePlaceHolderView swipeView, Activity act) {
        mContext = context;
        mProfile = profile;
        mSwipeView = swipeView;
        activity = act;
    }

    @Resolve
    private void onResolved(){
        profileImageView.setImageDrawable(mProfile.getImageUrl());
        nameAgeTxt.setText(mProfile.getName() + ", " + mProfile.getDate());

        chat.setBackgroundResource(R.mipmap.chat);
        chat.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {

            }
        });




        card.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {


            }
        });

    }


    @SwipeOut
    private void onSwipedOut(){
    }

    @SwipeCancelState
    private void onSwipeCancelState(){
        Log.d("EVENT", "onSwipeCancelState");
    }

    @SwipeIn
    private void onSwipeIn(){

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