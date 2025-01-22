package com.dx.tinytools;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button bmcalculator, text_capitalize, text_smallize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bmcalculator = findViewById(R.id.bmcalculator);
        text_capitalize = findViewById(R.id.text_capitalize);
        text_smallize = findViewById(R.id.text_smallize);

        bmcalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BMCalculator.class));
            }
        });
        text_capitalize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TextCapitalizer.class));
            }
        });
        text_smallize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TextSmallizer.class));
            }
        });

    }
}