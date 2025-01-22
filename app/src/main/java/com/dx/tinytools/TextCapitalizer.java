package com.dx.tinytools;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TextCapitalizer extends AppCompatActivity {

    EditText edittext_enter_text;
    Button capitalize, selectall;
    TextView tv_capitalized_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_capitalizer);

        edittext_enter_text = (EditText) findViewById(R.id.edittext_enter_text);
        capitalize = (Button) findViewById(R.id.capitalize);
        tv_capitalized_text = (TextView) findViewById(R.id.tv_capitalized_text);
        selectall = (Button) findViewById(R.id.selectall);

        capitalize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edittext_enter_text.getText().toString().isEmpty()) {

                    tv_capitalized_text.setText(edittext_enter_text.getText().toString().toUpperCase());
                } else {
                    Toast.makeText(TextCapitalizer.this, "Enter Text", Toast.LENGTH_SHORT).show();
                }
            }
        });

        selectall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("copied text: ",tv_capitalized_text.getText().toString());
                clipboard.setPrimaryClip(clip);

            }
        });
    }
}