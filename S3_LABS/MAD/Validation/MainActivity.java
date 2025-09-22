package com.example.formvalidation;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText usernameEditText, emailEditText, phoneEditText, passwordEditText;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = (EditText) findViewById(R.id.editTextText);
        emailEditText = (EditText) findViewById(R.id.editTextTextEmailAddress);
        phoneEditText = (EditText) findViewById(R.id.editTextPhone);
        passwordEditText = (EditText) findViewById(R.id.editTextTextPassword);
        submitButton = (Button) findViewById(R.id.button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateForm()) {
                    Toast.makeText(MainActivity.this, "Form submitted successfully!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validateForm() {
        boolean isValid = true;

        String username = usernameEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String phone = phoneEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString();

        // Username validation
        if (username.isEmpty()) {
            usernameEditText.setError("Username cannot be empty");
            isValid = false;
        }

        // Email validation
        if (email.isEmpty()) {
            emailEditText.setError("Email cannot be empty");
            isValid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditText.setError("Invalid email format");
            isValid = false;
        }

        // Phone validation
        if (phone.isEmpty()) {
            phoneEditText.setError("Phone number cannot be empty");
            isValid = false;
        } else if (!Patterns.PHONE.matcher(phone).matches() || phone.length() < 10) {
            phoneEditText.setError("Invalid phone number");
            isValid = false;
        }

        // Password validation
        if (password.isEmpty()) {
            passwordEditText.setError("Password cannot be empty");
            isValid = false;
        } else if (password.length() < 6) {
            passwordEditText.setError("Password must be at least 6 characters");
            isValid = false;
        }

        return isValid;
    }
}