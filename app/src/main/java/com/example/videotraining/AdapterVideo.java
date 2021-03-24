package com.example.videotraining;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.ArrayList;

public class AdapterVideo extends BaseAdapter{

    Context context;
    LayoutInflater inflater;
    ArrayList<VideoItem> videoItems;

    public AdapterVideo(Context context, ArrayList<VideoItem> videoItems) {
        this.context = context;
        this.videoItems = videoItems;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return videoItems.size();
    }

    @Override
    public Object getItem(int position) {
        return videoItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view==null){
            view = inflater.inflate(R.layout.item_video, parent, false);
        }
        ((TextView) view.findViewById(R.id.video_title)).setText(videoItems.get(position).getName());
        ((TextView) view.findViewById(R.id.video_desc)).setText(videoItems.get(position).getDesc());
        VideoView videoView = view.findViewById(R.id.vv);
        videoView.setVideoURI(Uri.parse(videoItems.get(position).getUrl()));
        MediaController mediaController = new MediaController(context);
        videoView.setMediaController(mediaController);
        videoView.requestFocus(0);
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
                videoView.start();
            }
        });
        return view;
    }
}
