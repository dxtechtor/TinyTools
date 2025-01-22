package com.dx.tinytools;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TextSmallizer extends AppCompatActivity {

    EditText edittext_enter_text;
    Button smallize, selectall;
    TextView tv_smallized_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_capitalizer);

        edittext_enter_text = (EditText) findViewById(R.id.edittext_enter_text);
        smallize = (Button) findViewById(R.id.capitalize);
        tv_smallized_text = (TextView) findViewById(R.id.tv_capitalized_text);
        selectall = (Button) findViewById(R.id.selectall);

        smallize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edittext_enter_text.getText().toString().isEmpty()) {

                    tv_smallized_text.setText(edittext_enter_text.getText().toString().toLowerCase());
                } else {
                    Toast.makeText(TextSmallizer.this, "Enter Text", Toast.LENGTH_SHORT).show();
                }
            }
        });

        selectall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("copied text: ",tv_smallized_text.getText().toString());
                clipboard.setPrimaryClip(clip);

            }
        });
    }
}