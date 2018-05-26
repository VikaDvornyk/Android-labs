package com.example.victoria.lab1dvornykvictoriais_52;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Information extends AppCompatActivity {
    TextView resultfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        resultfile = (TextView)findViewById(R.id.resultfile);
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            resultfile.setText(extras.getString("adapterMessage").toString());
        }
    }
}
