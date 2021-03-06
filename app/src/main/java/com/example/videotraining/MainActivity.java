package com.example.videotraining;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<VideoItem> videoItems = new ArrayList<>();
    AdapterVideo adapterVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list_view);

        videoItems.add(new VideoItem("Клип",
                "Слава КПСС",
                "https://sf-download.com/get.php?data=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%3D"));

        /*videoItems.add(new VideoItem("Новости",
                "Россия 24",
                "https://ru.savefrom.net/1-%D0%B1%D1%8B%D1%81%D1%82%D1%80%D1%8B%D0%B9-%D1%81%D0%BF%D0%BE%D1%81%D0%BE%D0%B1-%D1%81%D0%BA%D0%B0%D1%87%D0%B0%D1%82%D1%8C-%D1%81-youtube/"));*/
        adapterVideo = new AdapterVideo(this, videoItems);
        listView.setAdapter(adapterVideo);


    }
}