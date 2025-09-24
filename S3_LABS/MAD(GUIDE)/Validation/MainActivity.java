EditText username,password,email,phone;
Button b1;

username = findViewById(R.id.editTextText);
email = findViewById(R.id.editTextTextEmailAddress);
phone = findViewById(R.id.editTextPhone);
password =findViewById(R.id.editTextTextPassword);
b1 = findViewById(R.id.button);


 b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                if (validation())
                {
                    Toast.makeText(MainActivity.this, "Sign Up Successfully ", Toast.LENGTH_SHORT).show();
                }
            }
        });

    private boolean validation()
    {
        boolean a=true;

        String Uservar =username.getText().toString().trim();
        String Emailvar =email.getText().toString().trim();
        String Passwordvar =password.getText().toString();
        String Phonevar = phone.getText().toString().trim();

        if (Uservar.isEmpty()) {
            username.setError("Username cannot be empty");
            a =false;
        }

        // Email validation
        if (Emailvar.isEmpty()) {
            email.setError("Email cannot be empty");
            a = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(Emailvar).matches()) {
            email.setError("Invalid email format");
            a = false;
        }

        // Phone validation
        if (Phonevar.isEmpty()) {
            phone.setError("Phone number cannot be empty");
            a = false;
        } else if (!Patterns.PHONE.matcher(Phonevar).matches() || phone.length() < 10) {
            phone.setError("Invalid phone number");
            a = false;
        }

        // Password validation
        if (Passwordvar.isEmpty()) {
            password.setError("Password cannot be empty");
            a = false;
        } else if (password.length() < 6) {
            password.setError("Password must be at least 6 characters");
            a = false;
        }

        return a;


    }
