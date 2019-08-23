package com.example.toolbox_test.View.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.example.toolbox_test.R;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.util.Util;

public class VideoActivity extends AppCompatActivity {

    private PlayerView videoView;
    private String videoPath = "http://download.blender.org/peach/bigbuckbunny_movies/BigBuckBunny_320x180.mp4";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        videoView = findViewById(R.id.videoview);
        initPlayer(videoPath);

    }

    private void initPlayer(String url){
        Uri link2uri = Uri.parse(url);

        SimpleExoPlayer player = ExoPlayerFactory.newSimpleInstance(this);

        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(this,
                Util.getUserAgent(this, "com.example.toolbox_test"));

        MediaSource videoSource = new ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(link2uri);

        player.prepare(videoSource);
        videoView.setPlayer(player);
        player.setPlayWhenReady(true);
    }
}

