package com.silmood.ciph;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RemoteDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataSource = new RemoteDataSourceImpl();
    }

    private void setResult(String output) {
        ((TextView) findViewById(R.id.label_output)).setText(output);
    }

    public void cipher(View view) {
        String message = getInputMessage();

        dataSource.cipher(message, new RemoteDataSource.Callback() {
            @Override
            public void onSuccess(String result) {
                setResult(result);
            }

            @Override
            public void onError(Exception e) {
                Toast.makeText(MainActivity.this,
                        e.getMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @NonNull
    private String getInputMessage() {
        return ((EditText) findViewById(R.id.input_message)).getText().toString();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.menu_main_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.share)
            share(getInputMessage());

        return super.onOptionsItemSelected(item);
    }

    private void share(String inputMessage) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT, inputMessage);
        shareIntent.setType("text/plain");
        startActivity(shareIntent);
    }
}
