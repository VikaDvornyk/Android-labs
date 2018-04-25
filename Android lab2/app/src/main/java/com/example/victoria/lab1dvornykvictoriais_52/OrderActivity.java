package com.example.victoria.lab1dvornykvictoriais_52;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    private ListView listView;
    int[] images = {R.drawable.margarita,
    R.drawable.gavai,
    R.drawable.barbeku,
    R.drawable.meet,
    R.drawable.filadelfia};

    private String [] pizza = new String[]{"Маргарита", "Гаваї", "Барбекю", "М'ясо", "Філадельфія"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        listView = (ListView) findViewById(R.id.listView);
        //адаптує масив
        CustomAdapter adapter = new CustomAdapter();
        listView.setAdapter(adapter);
    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int i) {
            return pizza[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = getLayoutInflater().inflate(R.layout.pizzas, null);
            ImageView imageView = view1.findViewById(R.id.imageView1);
            final TextView textView = view1.findViewById(R.id.textView);
            final Button detail_button = view1.findViewById(R.id.detail_button);
            imageView.setImageResource(images[i]);
            textView.setText(pizza[i]);
            detail_button.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view1) {
                            Intent intent = new Intent("com.example.victoria.lab1dvornykvictoriais_52.OrderDetailsActivity");
                            startActivity(intent);
                        }
                    }
            );
            return view1;
        }
    }
}
