Button b1;

b1 = findViewById(R.id.button);
b1.setOnClickListener(new View.OnClickListener()
{
    @Override
    public void onClick(View v) {
        Intent intent = new Intent( MainActivity.this, DisplayActivity.class);
        startActivity(intent);
        }
}
);