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

public class MainActivity extends AppCompatActivity implements CipherView{

    CipherPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new CipherPresenter(this, new RemoteDataSource());
    }

    private void setResult(String output) {
        ((TextView) findViewById(R.id.label_output)).setText(output);
    }

    public void cipher(View view) {
        String message  = getInputMessage();

        if (message.isEmpty()) {
            showInputError(getString(R.string.error_empty));
        } else {
            presenter.cipher(message);
        }
    }

    @Override
    public void showResult(String result) {
        setResult(result);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT)
                .show();
    }

    private void showInputError(String error) {

        ((EditText)findViewById(R.id.input_message)).setError(error);
    }

    @NonNull
    private String getInputMessage() {
        return ((EditText)findViewById(R.id.input_message)).getText().toString();
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
