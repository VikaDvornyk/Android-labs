package com.example.victoria.lab4dvornykvictoriais_52;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button videobutton, audiobutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videobutton = (Button)findViewById(R.id.videobutton);
        audiobutton = (Button)findViewById(R.id.audiobutton);

        videobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //за допомогою цього класу переходимо на іншу сторінку
                Intent intent = new Intent("com.example.victoria.lab4dvornykvictoriais_52.VideoActivity");
                //запустити перехід на нову сторінку
                startActivity(intent);
            }
        });
        audiobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //за допомогою цього класу переходимо на іншу сторінку
                Intent intent = new Intent("com.example.victoria.lab4dvornykvictoriais_52.AudioActivity");
                //запустити перехід на нову сторінку
                startActivity(intent);
            }
        });
    }
}
