package com.example.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    TextView textView_height;
    TextView textView_weight;
    TextView textView_bmi;
    TextView textView_message;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent intent = getIntent();

        textView_bmi = findViewById(R.id.put_bmi);
        textView_height = findViewById(R.id.put_height);
        textView_weight = findViewById(R.id.put_weight);
        textView_message = findViewById(R.id.health);
        imageView = findViewById(R.id.image);

        Double bmi = intent.getDoubleExtra("bmi",18.5);
        Double weight = intent.getDoubleExtra("weight",62);
        Double height = intent.getDoubleExtra("height",183);

        textView_weight.setText(weight.toString());
        textView_height.setText(height.toString());
        textView_bmi.setText(bmi.toString());

        String message;

        if(bmi < 18.5) {
            textView_message.setText("You are Under-weighed");
            imageView.setImageResource(R.drawable.under_weighed);
        }
        else if(bmi<25) {
            textView_message.setText("You are normal weighed");
            imageView.setImageResource(R.drawable.healthy);
        }
        else {
            textView_message.setText("You are over-weighed");
            imageView.setImageResource(R.drawable.over_weight);
        }

    }

    public void backToMain(View view) {
        startActivity(new Intent(this,MainActivity.class));
    }
}
