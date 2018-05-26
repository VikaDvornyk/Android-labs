package com.example.victoria.lab4dvornykvictoriais_52;
import android.Manifest;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//class Mp3Filter implements FilenameFilter{
//    @Override
//    public boolean accept(File file, String s) {
//        return s.endsWith(".mp3");
//    }
//}
public class AudioActivity extends Activity {
    MediaPlayer mPlayer = new MediaPlayer();
    ListView listViewaudio;
    ArrayList<String> songs;
    ArrayAdapter adapter1;
    Button intbuttonaudio;
    EditText urlaudio;
    Button pauseButton, stopButton;
    //private static final String SD_PATH = new String("/sdcard");
    Button buttonmusicon;
    AudioManager audioManager;
    SeekBar volumeControl;
    //MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Environment.getExternalStorageState();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);
        buttonmusicon = (Button) findViewById(R.id.buttonmusic);
        pauseButton = (Button)findViewById(R.id.button_pause);
        stopButton = (Button)findViewById(R.id.button_stop);
        listViewaudio = (ListView) findViewById(R.id.listaudio);
        intbuttonaudio = (Button) findViewById(R.id.Internetbuttonaudio);
        urlaudio = (EditText) findViewById(R.id.editTextaudio);
//        buttonmusicon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mediaPlayer = new MediaPlayer();
//                String media_path = "sdcard/m1.mp3";
//                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
//                Uri uri = Uri.parse(media_path);
//                try {
//                    mediaPlayer.setDataSource(getApplicationContext(), uri);
//                    mediaPlayer.prepare();
//                    mediaPlayer.start();
//                    Toast.makeText(getApplicationContext(),"Started", Toast.LENGTH_LONG).show();
//                    buttonmusicon.setEnabled(false);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//                    @Override
//                    public void onCompletion(MediaPlayer mediaPlayer) {
//                        buttonmusicon.setEnabled(true);
//                        mediaPlayer.release();
//                        mediaPlayer = null;
//                        Toast.makeText(getApplicationContext(),"Finished", Toast.LENGTH_LONG).show();
//                    }
//                });
//            }
//        });
        songs = new ArrayList<>();
        songs.add("Пісня №1");
        songs.add("Пісня №2");
        songs.add("Пісня №3");
        songs.add("Пісня №4");

        adapter1 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, songs);
        listViewaudio.setAdapter(adapter1);

        listViewaudio.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        //mPlayer=MediaPlayer.create(getApplicationContext(), R.raw.m1);
                        mPlayer.reset();
                        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.m1);
                        try {
                            mPlayer.reset();
                            mPlayer.setDataSource(getApplicationContext(), uri);
                            mPlayer.prepare();
                            mPlayer.start();
                            Toast.makeText(getApplicationContext(), "Іспішно!", Toast.LENGTH_LONG).show();
                            buttonmusicon.setEnabled(false);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                buttonmusicon.setEnabled(true);
                                stopPlay();
                            }
                        });
                        break;
                    case 1:
                        mPlayer.reset();
                        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                        Uri uri1 = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.m2);
                        try {

                            mPlayer.reset();
                            mPlayer.setDataSource(getApplicationContext(), uri1);
                            mPlayer.prepare();
                            mPlayer.start();
                            Toast.makeText(getApplicationContext(), "Іспішно!", Toast.LENGTH_LONG).show();
                           //buttonmusicon.setEnabled(false);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                buttonmusicon.setEnabled(true);
                                stopPlay();
                            }
                        });
                        break;
                    case 2:
                        mPlayer.reset();
                        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                        Uri uri2 = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.m3);
                        try {
                            mPlayer.reset();
                            mPlayer.setDataSource(getApplicationContext(), uri2);
                            mPlayer.prepare();
                            mPlayer.start();
                            Toast.makeText(getApplicationContext(), "Іспішно!", Toast.LENGTH_LONG).show();
                            //buttonmusicon.setEnabled(false);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                buttonmusicon.setEnabled(true);
                                stopPlay();
                            }
                        });
                        break;
                    case 3:
                        mPlayer.reset();
                        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                        Uri uri3 = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.m4);
                        try {
                            mPlayer.reset();
                            //mPlayer.seekTo(0);
                            //mPlayer.start();
                            mPlayer.setDataSource(getApplicationContext(), uri3);
                            mPlayer.prepare();
                            mPlayer.start();
                            Toast.makeText(getApplicationContext(), "Іспішно!", Toast.LENGTH_LONG).show();
                            //buttonmusicon.setEnabled(false);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                buttonmusicon.setEnabled(true);
                                stopPlay();
                            }
                        });
                        break;
                    default:
                        break;
                }
            }
        });
        intbuttonaudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPlayer.reset();
                mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                String myurl = "http://cdndl.zaycev.net/118516/5068/zhuki_-_batareyka_%28zaycev.net%29.mp3";
                Uri uri3 = Uri.parse(myurl);
                try {
                    mPlayer.reset();
                    //mPlayer.seekTo(0);
                    //mPlayer.start();
                    mPlayer.setDataSource(getApplicationContext(), uri3);
                    mPlayer.prepare();
                    mPlayer.start();
                    Toast.makeText(getApplicationContext(), "Іспішно!", Toast.LENGTH_LONG).show();
                    //buttonmusicon.setEnabled(false);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        buttonmusicon.setEnabled(true);
                        stopPlay();
                    }
                });
            }
        });
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curValue = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        volumeControl = (SeekBar) findViewById(R.id.volumeControl);
        volumeControl.setMax(maxVolume);
        volumeControl.setProgress(curValue);
        volumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
        private void stopPlay(){
            mPlayer.stop();
            pauseButton.setEnabled(false);
            stopButton.setEnabled(false);
            try {
                mPlayer.prepare();
                mPlayer.seekTo(0);
                buttonmusicon.setEnabled(true);
            }
            catch (Throwable t) {
                Toast.makeText(this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }

        public void play(View view){

            mPlayer.start();
            buttonmusicon.setEnabled(false);
            pauseButton.setEnabled(true);
            stopButton.setEnabled(true);
        }
        public void pause(View view){

            mPlayer.pause();
            buttonmusicon.setEnabled(true);
            pauseButton.setEnabled(false);
            stopButton.setEnabled(true);
        }
        public void stop(View view){
            stopPlay();
        }
        @Override
        public void onDestroy() {
            super.onDestroy();
            if (mPlayer.isPlaying()) {
                stopPlay();
            }
        }

    }
