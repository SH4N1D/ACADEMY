package com.example.myapplication;

import  android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button b1;
    EditText E1,E2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toast.makeText(MainActivity.this,
                "on create ", Toast.LENGTH_SHORT).show();
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        E1=(EditText)findViewById(R.id.editTextText);
        E2=(EditText)findViewById(R.id.editTextText2);
        b1=(Button) findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username, password;

                username=E1.getText().toString();
                password=E2.getText().toString();

                if(username.equals("muhsin")&&password.equals("pass"))
                {
                    Toast.makeText(MainActivity.this,
                            "hello "+username+ " login success", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        Toast.makeText(MainActivity.this,
//                "on resume ", Toast.LENGTH_SHORT).show();
//    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        Toast.makeText(MainActivity.this,
//                "on start ", Toast.LENGTH_SHORT).show();
//
//    }

//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        Toast.makeText(MainActivity.this,
//                "on restart ", Toast.LENGTH_SHORT).show();
//    }
}