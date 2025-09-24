ToggleButton tb;
ImageView iv;



tb = findViewById(R.id.toggleButton);
iv = findViewById(R.id.imageView);



tb.setOnCheckedChangeListener((CompoundButton buttonView, boolean isChecked) -> {
    if (isChecked) {
        iv.setImageResource(R.drawable.on);
    } else {
        iv.setImageResource(R.drawable.off);

    }
});