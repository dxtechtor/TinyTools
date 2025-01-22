package com.dx.tinytools;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BMCalculator extends AppCompatActivity {

    EditText bm_startreading, bm_endreading, bm_petrolprice, bm_fillprice, bm_travelled;
    TextView bm_final_average;
    Button calculate_bm, btn_petrolprice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmcalculator);

        bm_startreading = findViewById(R.id.bm_startreading);
        bm_endreading = findViewById(R.id.bm_endreading);
        bm_petrolprice = findViewById(R.id.bm_petrolprice);
        bm_fillprice = findViewById(R.id.bm_fillprice);
        bm_final_average = findViewById(R.id.bm_final_average);
        bm_travelled = findViewById(R.id.bm_travelled);
        calculate_bm = findViewById(R.id.calculate_bm);
        btn_petrolprice = findViewById(R.id.btn_petrolprice);

        btn_petrolprice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bm_petrolprice.setText("94.4");
            }
        });
        calculate_bm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (bm_petrolprice.getText().toString().isEmpty() || bm_fillprice.getText().toString().isEmpty()) {
                    Toast.makeText(BMCalculator.this, "Enter All Values", Toast.LENGTH_SHORT).show();
                } else {

                    if (bm_startreading.getText().toString().isEmpty() || bm_endreading.getText().toString().isEmpty()) {
                        if (!bm_travelled.getText().toString().isEmpty()) {
                            double petrol_price = Double.parseDouble(bm_petrolprice.getText().toString());
                            double fill_price = Double.parseDouble(bm_fillprice.getText().toString());
                            double total_litre = fill_price / petrol_price;
                            double total_travel = Double.parseDouble(bm_travelled.getText().toString());
                            double average = total_travel / total_litre;
                            bm_final_average.setText(String.valueOf(average));
                        } else {
                            Toast.makeText(BMCalculator.this, "2", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        double start_reading = Double.parseDouble(bm_startreading.getText().toString());
                        double end_reading = Double.parseDouble(bm_endreading.getText().toString());
                        double petrol_price = Double.parseDouble(bm_petrolprice.getText().toString());
                        double fill_price = Double.parseDouble(bm_fillprice.getText().toString());
                        double total_litre = fill_price / petrol_price;
                        double total_travel = end_reading - start_reading;
                        double average = total_travel / total_litre;
                        bm_final_average.setText(String.valueOf(average));
                    }
                }
            }
        });
    }

}