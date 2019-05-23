package com.example.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText_weight;
    EditText editText_height;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculate(View view)
    {
        editText_height = findViewById(R.id.get_height);
        editText_weight = findViewById(R.id.get_weight);
        button = findViewById(R.id.B1);

        String Height = editText_height.getText().toString();
        String Weight = editText_weight.getText().toString();

        if(Height.matches("") || Weight.matches(""))
        {
            Toast.makeText(this,"Please enter some value....",Toast.LENGTH_SHORT).show();
        }
        else {
            double height = Double.parseDouble(Height);
            double weight = Double.parseDouble(Weight);
            height = height / 100;
            double bmi = (weight / (height * height));

            Intent intent = new Intent(this, DisplayActivity.class);
            intent.putExtra("height", height * 100);
            intent.putExtra("weight", weight);
            intent.putExtra("bmi", bmi);
            startActivity(intent);
        }
    }

}
