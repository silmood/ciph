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

public class MainActivity extends AppCompatActivity implements CipherView {

    private CipherPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new CipherPresenter(new RemoteDataSourceImpl(), this);
    }

    private void setResult(String output) {
        ((TextView) findViewById(R.id.label_output)).setText(output);
    }

    public void cipher(View view) {
        String message = getInputMessage();
        presenter.cipher(message);
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

    @Override
    public void showResult(String result) {
        setResult(result);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(MainActivity.this,
                message,
                Toast.LENGTH_SHORT).show();
    }
}
