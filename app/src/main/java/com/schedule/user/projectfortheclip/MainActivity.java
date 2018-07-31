package com.schedule.user.projectfortheclip;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    String randomname;
    String picture,picturep,holderid;
    String thedate;
    private TextView name,name2;
    private ImageView Image;
    private Gallery mGallery;
    private Timer mTimer;
    private TimerTask mTimerTask;
    private Handler mHandler = new Handler();
    static String activityID;
    static String theChatRoom;

    CardView card;
    ArrayList<Bitmap> imagesId;
    //Bitmap imagesId[];
    Gallery galleryp;
    ImageButton randomBtn,favorite,category,launch,profile,ring,map;
    private int[] Pics = {R.drawable.pic2,R.drawable.pic3,R.drawable.pic4} ;

    private SwipePlaceHolderView mSwipeView;
    private Context mContext;
    List<Profile> profileList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton random=(ImageButton)findViewById(R.id.random);
        random.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this , Scratch.class);
                startActivity(intent);
            }
        });

        //imagesId=new Bitmap[10];
        imagesId = new ArrayList<Bitmap>();

        //這個是連接資料庫所需要的程式碼  不然會他媽的打不開
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectDiskReads()
                .detectDiskWrites()
                .detectNetwork()
                .penaltyLog()
                .build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects()
                .penaltyLog()
                .penaltyDeath()
                .build());

        tindercard();
    }

    public void tindercard(){

//tinder card
        mSwipeView = (SwipePlaceHolderView)findViewById(R.id.swipeView);
        mContext = getApplicationContext();

        mSwipeView.getBuilder()
                .setDisplayViewCount(3)
                .setSwipeDecor(new SwipeDecor()
                        .setPaddingTop(20)
                        .setRelativeScale(0.01f)
                        .setSwipeInMsgLayoutId(R.layout.tinder_swipe_in_msg_view)
                        .setSwipeOutMsgLayoutId(R.layout.tinder_swipe_out_msg_view));


        Profile p=new Profile();
        p.name="沙灘排球";
        p.thedate="6/16";
        p.location="456";
        p.imageUrl= getResources().getDrawable(R.mipmap.beach);

        Profile p2=new Profile();
        p2.name="最愛 Club";
        p2.thedate="6/21";
        p2.location="456";
        p2.imageUrl= getResources().getDrawable(R.mipmap.pub);

        Profile p3=new Profile();
        p3.name="一起玩桌遊";
        p3.thedate="6/6";
        p3.location="456";
        p3.imageUrl= getResources().getDrawable(R.mipmap.table);

        Profile p4=new Profile();
        p4.name="蛋糕同樂會";
        p4.thedate="6/10";
        p4.location="456";
        p4.imageUrl= getResources().getDrawable(R.mipmap.cake);

        Profile p5=new Profile();
        p5.name="雷射槍大戰";
        p5.thedate="6/5";
        p5.location="456";
        p5.imageUrl= getResources().getDrawable(R.mipmap.gun);

        Profile p6=new Profile();
        p6.name="HBL加油團";
        p6.thedate="6/26";
        p6.location="456";
        p6.imageUrl= getResources().getDrawable(R.mipmap.cheer);


        profileList.add(p);
        profileList.add(p2);
        profileList.add(p3);
        profileList.add(p4);
        profileList.add(p5);
        profileList.add(p6);


        for(Profile profile : profileList){
            mSwipeView.addView(new TinderCard(mContext, profile, mSwipeView,MainActivity.this));
        }
    }

}
