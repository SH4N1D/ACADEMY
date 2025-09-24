EditText e1,e2;
Button b1;


e1=findViewById(R.id.editTextText);
e2=findViewById(R.id.editTextTextPassword);
b1=findViewById(R.id.button);


b1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {

                String username=e1.getText().toString();
                String password=e2.getText().toString();
                if (username.equals("User")&&password.equals("123"))
                {
                    Toast.makeText(MainActivity.this,"Welcome "+username,Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Invalid Username or Password ",Toast.LENGTH_SHORT).show();
                }
            }
        });

