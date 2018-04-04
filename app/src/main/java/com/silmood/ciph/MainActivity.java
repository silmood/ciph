package com.silmood.ciph;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_cipher).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message  = ((EditText)findViewById(R.id.input_message)).getText().toString();

                if (message.isEmpty()){
                    ((EditText)findViewById(R.id.input_message)).setError(getString(R.string.error_empty));
                } else {
                    Cipher cipher = new Cipher();
                    String output = cipher.rot13(message);
                    ((TextView) findViewById(R.id.label_output)).setText(output);
                }
            }
        });
    }
}
