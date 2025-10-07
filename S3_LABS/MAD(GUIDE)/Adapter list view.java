package com.example.adapterlistview;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String fruitNames[]
            = {"Banana", "Grape", "Guava",
            "Mango", "Orange", "Watermelon"};
    int fruitImageIds[]
            = {R.drawable.banana, R.drawable.grape,
            R.drawable.guava, R.drawable.mango,
            R.drawable.orange, R.drawable.watermelon};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listView = findViewById(R.id.listview);
        ArrayList<HashMap<String, Object>> list = new ArrayList<>();

        for (int i = 0; i < fruitNames.length; i++) {

            // creating an Object of HashMap class
            HashMap<String, Object> map = new HashMap<>();

            // Data entry in HashMap
            map.put("fruitName", fruitNames[i]);
            map.put("fruitImage", fruitImageIds[i]);

            // adding the HashMap to the ArrayList
            list.add(map);
        }

        String[] from = { "fruitName", "fruitImage" };

        int to[] = { R.id.textView, R.id.imageView };


        SimpleAdapter simpleAdapter = new SimpleAdapter(
                getApplicationContext(), list,
                R.layout.list_row_items, from, to);

        // now setting the simpleAdapter to the ListView
        listView.setAdapter(simpleAdapter);
    }
}