package com.example.sharedpreferenceco21st;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DisplayActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_display); // link to XML
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.display), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });

            SharedPreferences sharedPref = getSharedPreferences("UserDetails", MODE_PRIVATE);

            String name = sharedPref.getString("Name", "DefaultName");
            String email = sharedPref.getString("Email", "DefaultName");
            String password = sharedPref.getString("Password", "DefaultName"); // second arg = default value
            // int age = sharedPref.getInt("age", 0); // default is 0 if not found

            TextView tv = findViewById(R.id.tvDisplay);
            TextView tv1 = findViewById(R.id.tvDisplay2);
            TextView tv2 = findViewById(R.id.tvDisplay3);

            tv.setText("Name: " + name );
            tv1.setText("Email: " + email );
            tv2.setText("Password: " + password );


        }
    }

