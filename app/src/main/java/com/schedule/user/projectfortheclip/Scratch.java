package com.schedule.user.projectfortheclip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cooltechworks.views.ScratchImageView;

public class Scratch extends AppCompatActivity {
    private ScratchImageView scratchImageView;
    private ImageView img;
    private Button b;
    private TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scratch);

        scratchImageView = (ScratchImageView) findViewById(R.id.sample_image);
        img=(ImageView)findViewById(R.id.imageView);
        b=(Button)findViewById(R.id.chat2);



        assert scratchImageView != null;
        //You must have this listener
        scratchImageView.setRevealListener(new ScratchImageView.IRevealListener() {
            @Override
            public void onRevealed(ScratchImageView scratchImageView) {

                b.setVisibility(View.VISIBLE); //顯示
                img.setVisibility(View.VISIBLE); //顯示
                //t.setVisibility(View.INVISIBLE); //不顯示

                //Toast.makeText(Main7Activity.this, "Revealed!", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
