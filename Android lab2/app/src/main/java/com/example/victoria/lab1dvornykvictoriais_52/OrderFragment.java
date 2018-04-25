package com.example.victoria.lab1dvornykvictoriais_52;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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


public class OrderFragment extends Fragment {
    private RadioGroup radioGrouptype;
    private RadioButton radioButtontype;
    private RadioGroup radioGroupsize;
    private RadioButton radioButtonsize;
    private RadioGroup radioGroupdough;
    private RadioButton radioButtondough;
    private EditText wishes;
    private String w = "";
    private int selectedtypeId = 0;
    private int selectedsizeId = 0;
    private int selecteddoughId = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_order, container, false);
        radioGrouptype = (RadioGroup)v.findViewById(R.id.type);
        radioGroupsize = (RadioGroup)v.findViewById(R.id.size);
        radioGroupdough = (RadioGroup)v.findViewById(R.id.dough);




        Button btnOK = (Button)v.findViewById(R.id.button123);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedtypeId = radioGrouptype.getCheckedRadioButtonId();
                selectedsizeId = radioGroupsize.getCheckedRadioButtonId();
                selecteddoughId = radioGroupdough.getCheckedRadioButtonId();


//                if(selectedtypeId == -1)
//                {
//                    Toast.makeText(getActivity(), "Виберіть Тип, Розмір та Тісто!", Toast.LENGTH_LONG).show();
//                    TextView error = (TextView)getView().findViewById(R.id.error);
//                    error.setText("Виберіть Тип, Розмір та Тісто!");
//               }
                radioButtontype = (RadioButton)getView().findViewById(selectedtypeId);
                radioButtonsize = (RadioButton)getView().findViewById(selectedsizeId);
                radioButtondough = (RadioButton)getView().findViewById(selecteddoughId);

                wishes = (EditText)getView().findViewById(R.id.editText);
                if(wishes.getText().length() == 0) {
                    w = " Немає";
                }
                else
                {
                    w = wishes.getText().toString();
                }
                String type = radioButtontype.getText().toString();
                String size = radioButtonsize.getText().toString();
                String dough = radioButtondough.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("Type", type);
                bundle.putString("Size", size);
                bundle.putString("Dough", dough);
                bundle.putString("Wishes", w);

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                ResultFragment resultFragment = new ResultFragment();
                resultFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.place, resultFragment);
                fragmentTransaction.commit();
            }
        });
        // Inflate the layout for this fragment
        return v;
    }
}
