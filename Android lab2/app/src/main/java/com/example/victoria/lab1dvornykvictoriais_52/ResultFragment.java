package com.example.victoria.lab1dvornykvictoriais_52;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class ResultFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View handle = inflater.inflate(R.layout.fragment_result, container, false);

        Bundle bundle = getArguments();
        String type = bundle.getString("Type");
        String size = bundle.getString("Size");
        String dough = bundle.getString("Dough");
        String w = bundle.getString("Wishes");

        TextView typetext = (TextView)handle.findViewById(R.id.type);
        TextView sizetext = (TextView)handle.findViewById(R.id.size);
        TextView doughtext = (TextView)handle.findViewById(R.id.dough);
        TextView wtext = (TextView)handle.findViewById(R.id.wishes);

        typetext.append(" "+type);
        sizetext.append(" "+size);
        doughtext.append(" "+dough);
        wtext.append(" "+ w);

        Button btnExit = (Button)handle.findViewById(R.id.button_exit);
        btnExit.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                           FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                                           FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


                                           fragmentTransaction.replace(R.id.place, new OrderFragment());
                                           fragmentTransaction.commit();
                                       }
                                   });
        // Inflate the layout for this fragment
        return handle;
}
}
