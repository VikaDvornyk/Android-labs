package com.example.victoria.lab1dvornykvictoriais_52;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class ResultFragment extends Fragment {
    TextView typetext;
    TextView sizetext;
    TextView doughtext;
    TextView wtext;
    Button setonfile;
    Button setondb;
    Button openfile;
    Button opendb;
    String type, size, dough, w;
    DBHelper dbHelper;
    SQLiteDatabase sqLiteDatabase;
    ContentValues contentValues;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View handle = inflater.inflate(R.layout.fragment_result, container, false);
        dbHelper = new DBHelper(getActivity());
        sqLiteDatabase = dbHelper.getWritableDatabase();
        contentValues = new ContentValues();//для добавления новых строк в таблицу

        Bundle bundle = getArguments();
        type = bundle.getString("Type");
        size = bundle.getString("Size");
        dough = bundle.getString("Dough");
        w = bundle.getString("Wishes");

        typetext = (TextView) handle.findViewById(R.id.type);
        sizetext = (TextView) handle.findViewById(R.id.size);
        doughtext = (TextView) handle.findViewById(R.id.dough);
        wtext = (TextView) handle.findViewById(R.id.wishes);

        typetext.append(" " + type);
        sizetext.append(" " + size);
        doughtext.append(" " + dough);
        wtext.append(" " + w);

        Button btnExit = (Button) handle.findViewById(R.id.button_exit);
        setonfile = (Button) handle.findViewById(R.id.writetofile);
        openfile = (Button)handle.findViewById(R.id.readfile);
        setondb = (Button)handle.findViewById(R.id.writetodb);
        opendb = (Button)handle.findViewById(R.id.readdb);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


                fragmentTransaction.replace(R.id.place, new OrderFragment());
                fragmentTransaction.commit();
            }
        });
        setonfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myTxt = typetext.getText().toString() + " " + sizetext.getText().toString() + " " +
                        doughtext.getText().toString() + " " + wtext.getText().toString();
                try {

                    FileOutputStream fileOutputStream = getActivity().openFileOutput("example.txt", getActivity().MODE_PRIVATE);
                    fileOutputStream.write(myTxt.getBytes());
                    fileOutputStream.close();
                    Toast.makeText(getActivity(), "Все було збережено!", Toast.LENGTH_LONG).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        openfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream fileInputStream = getActivity().openFileInput("example.txt");
                    InputStreamReader reader = new InputStreamReader(fileInputStream);
                    BufferedReader bufferedReader = new BufferedReader(reader);
                    StringBuffer stringBuffer = new StringBuffer();
                    String lines;
                    while ((lines = bufferedReader.readLine())!=null)
                    {
                        stringBuffer.append(lines+"\n");
                    }
                    //TextView resultfile = (TextView)getActivity().findViewById(R.id.resultfile);
                    //resultfile.setText(stringBuffer.toString());
                    //за допомогою цього класу переходимо на іншу сторінку
                    Intent intent = new Intent("com.example.victoria.lab1dvornykvictoriais_52.Information");
                    //запустити перехід на нову сторінку
                    intent.putExtra("adapterMessage",stringBuffer.toString());
                    startActivity(intent);


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        setondb.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                contentValues.put(DBHelper.KEY_TYPE, type);
                contentValues.put(DBHelper.KEY_SIZE, size);
                contentValues.put(DBHelper.KEY_DOUGH, dough);
                contentValues.put(DBHelper.KEY_WISHES, w);

                sqLiteDatabase.insert(DBHelper.TABLE_PIZZAS, null, contentValues);
                Toast.makeText(getActivity(), "Все було збережено!", Toast.LENGTH_LONG).show();
            }
        });

        opendb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = sqLiteDatabase.query(DBHelper.TABLE_PIZZAS, null, null, null, null, null, null);
                Intent intent = new Intent("com.example.victoria.lab1dvornykvictoriais_52.Information");
                if (cursor.moveToFirst()) {
                    int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
                    int typeIndex = cursor.getColumnIndex(DBHelper.KEY_TYPE);
                    int sizeIndex = cursor.getColumnIndex(DBHelper.KEY_SIZE);
                    int doughIndex = cursor.getColumnIndex(DBHelper.KEY_DOUGH);
                    int wishesIndex = cursor.getColumnIndex(DBHelper.KEY_WISHES);

                    do {
                        intent.putExtra("adapterMessage","ID = " + cursor.getInt(idIndex) +
                                ", type = " + cursor.getString(typeIndex) +
                                ", size = " + cursor.getString(sizeIndex) +
                                ", dough = " + cursor.getString(doughIndex) +
                                ", wishes = " + cursor.getString(wishesIndex));
                        Log.d("mLog", "ID = " + cursor.getInt(idIndex) +
                                ", type = " + cursor.getString(typeIndex) +
                                ", size = " + cursor.getString(sizeIndex) +
                                ", dough = " + cursor.getString(doughIndex) +
                                ", wishes = " + cursor.getString(wishesIndex));
                    } while (cursor.moveToNext());
                } else
                    Log.d("mLog","0 rows");

                cursor.close();
                startActivity(intent);
            }
        });
        // Inflate the layout for this fragment
        return handle;
    }
}
