package com.example.victoria.lab4dvornykvictoriais_52;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;

public class VideoActivity extends AppCompatActivity {

    VideoView videoView;
    ListView listView;
    ArrayList<String> videoList;
    ArrayAdapter adapter;
    Button int_button;
    EditText url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        videoView = (VideoView)findViewById(R.id.videoView);
        listView = (ListView)findViewById(R.id.listView);
        int_button = (Button)findViewById(R.id.Internetbutton);
        url = (EditText)findViewById(R.id.editText);


        videoList = new ArrayList<>();
        videoList.add("Папуга");
        videoList.add("Котик, який любить їсти");
        videoList.add("Ще один котик");
        videoList.add("Танець пташки");
        videoList.add("Завантажити з Інтернету");

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, videoList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.v1));
                        break;
                    case 1:
                        videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.v2));
                        break;
                    case 2:
                        videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.v3));
                        break;
                    case 3:
                        videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.v4));
                        break;
                    default:
                        break;
                }
                videoView.setMediaController(new MediaController(VideoActivity.this));
                videoView.requestFocus();
                videoView.start();

            }
        });

        int_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoView.setVideoPath(url.getText().toString());
                videoView.setMediaController(new MediaController(VideoActivity.this));
                videoView.requestFocus();
                videoView.start();
            }
        });

    }
    public void play(View view){
        videoView.start();
    }
    public void pause(View view){
        videoView.pause();
    }
    public void stop(View view){
        videoView.stopPlayback();
        videoView.resume();
    }
}
