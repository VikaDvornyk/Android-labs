package com.example.victoria.lab1dvornykvictoriais_52;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class OrderDetailsActivity extends AppCompatActivity {
    private Button button_ok;
    private RadioGroup radioGrouptype;
    private RadioButton radioButtontype;
    private RadioGroup radioGroupsize;
    private RadioButton radioButtonsize;
    private RadioGroup radioGroupdough;
    private RadioButton radioButtondough;
    private EditText wishes;
    int selectedtypeId = 0;
    int selectedsizeId = 0;
    int selecteddoughId = 0;

    ArrayList<String> selectedItems = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        addListenerOnButton();
        ListView chl = (ListView)findViewById(R.id.checkable_list);
        chl.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        String[] items={"Маслини", "Оливки", "Креветки"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.colomnlayout,R.id.txt_lan,items);
        chl.setAdapter(adapter);
        chl.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = ((TextView)view).getText().toString();
                if(selectedItems.contains(selectedItem))
                    selectedItems.remove(selectedItem);
                else
                    selectedItems.add(selectedItem);

            }
        });
    }

    public void addListenerOnButton() {

        radioGrouptype = (RadioGroup) findViewById(R.id.type);
        radioGroupsize = (RadioGroup) findViewById(R.id.size);
        radioGroupdough = (RadioGroup) findViewById(R.id.dough);
        button_ok = (Button) findViewById(R.id.button_ok);

        button_ok.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                selectedtypeId = radioGrouptype.getCheckedRadioButtonId();
                selectedsizeId = radioGroupsize.getCheckedRadioButtonId();
                selecteddoughId = radioGroupdough.getCheckedRadioButtonId();
//                if(selectedtypeId == 0)
//                {
//                    Toast.makeText(OrderDetailsActivity.this, "Виберіть Тип, Розмір та Тісто!", Toast.LENGTH_LONG).show();
//                }
                String items = "";
                String w = "";
                for (String item:selectedItems){
                    items+="-"+item+"\n";
                }
                if (items.length() == 0)
                {
                    items = "Немає";
                }
                radioButtontype = (RadioButton) findViewById(selectedtypeId);
                radioButtonsize = (RadioButton) findViewById(selectedsizeId);
                radioButtondough = (RadioButton) findViewById(selecteddoughId);
//                if(!(radioButtontype.isChecked()))
//                {
//                    Toast.makeText(OrderDetailsActivity.this, "Виберіть Тип, Розмір та Тісто!", Toast.LENGTH_LONG).show();
//                }
                wishes = (EditText)findViewById(R.id.editText);
                if(wishes.getText().length() == 0) {
                    w = "Немає";
                }
                else
                {
                    w = wishes.getText().toString();
                }

                AlertDialog.Builder a_builder = new AlertDialog.Builder(OrderDetailsActivity.this);
                a_builder.setMessage("Ви замовили:\n" +
                        "Тип: "+radioButtontype.getText().toString()+"\n"+
                        "Розмір: "+radioButtonsize.getText().toString()+"\n"+
                        "Тісто: "+radioButtondough.getText().toString()+"\n"+
                        "Добавки: "+items+"\n"+
                        "Особисті побажання: " +w)
                        .setCancelable(false)
                        .setNegativeButton("Дякую!", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                AlertDialog alertDialog = a_builder.create();
                alertDialog.setTitle("Інформація про замовлення");
                alertDialog.show();

            }

        });
    }
}
