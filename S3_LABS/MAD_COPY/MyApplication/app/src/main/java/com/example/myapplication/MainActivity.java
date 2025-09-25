package com.example.myapplication;

import static java.lang.Double.parseDouble;

import android.os.Bundle;
import android.view.TextureView;
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
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        E1=(EditText)findViewById(R.id.editTextText2);
        E2=(EditText)findViewById(R.id.editTextText3);


        b1=(Button) findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username;

                Double password;

                username=E1.getText().toString();
                password=Double.parseDouble(E2.getText().toString());

                    if(username.equals(password))
                    {
                        Toast.makeText(MainActivity.this,
                                "login success"+username, Toast.LENGTH_LONG).show();
                    }




            }
        });
    }
}