package com.example.victoria.lab1dvornykvictoriais_52;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //переменная для кнопки
    private Button act_order;
    private Button exit_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }
    //зчитує натискання на кнопку
    public void addListenerOnButton(){
        act_order = (Button)findViewById(R.id.act_order);
        act_order.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //за допомогою цього класу переходимо на іншу сторінку
                        Intent intent = new Intent("com.example.victoria.lab1dvornykvictoriais_52.OrderActivity");
                        //запустити перехід на нову сторінку
                        startActivity(intent);
                    }
                }
        );
        exit_button = (Button)findViewById(R.id.exit_button);
        exit_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity.this);
                        a_builder.setMessage("Ви хочете закрити додаток?")
                                .setCancelable(false)
                                .setPositiveButton("Так", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        finish();
                                    }
                                })
                                .setNegativeButton("Ні", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.cancel();
                                    }
                                });
                        AlertDialog alertDialog = a_builder.create();
                        alertDialog.setTitle("Закриття додатку");
                        alertDialog.show();
                    }
                }
        );

    }
}
