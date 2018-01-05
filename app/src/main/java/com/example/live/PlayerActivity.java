package com.example.live;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.VideoView;

import io.vov.vitamio.LibsChecker;

public class PlayerActivity extends AppCompatActivity implements View.OnClickListener{
    private String path = "";
    private VideoView mVideoView;
    private EditText mEditText;
    private Button mStartBtn;
    private Button mStopBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        if(!LibsChecker.checkVitamioLibs(this))
            return;
        mEditText = (EditText) findViewById(R.id.url);
        mVideoView = (VideoView) findViewById(R.id.surface_view);
        mStartBtn = (Button) findViewById(R.id.start);
        mStopBtn = (Button) findViewById(R.id.stop);
        mStartBtn.setOnClickListener(this);
        mStopBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.start:
                path = mEditText.getText().toString();
                if(!TextUtils.isEmpty(path)){
                    mVideoView.setVideoPath(path);
                }
                break;
            case R.id.stop:
                mVideoView.stopPlayback();
                break;
        }
    }
}
