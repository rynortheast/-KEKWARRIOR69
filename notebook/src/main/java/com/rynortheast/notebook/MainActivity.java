package com.rynortheast.notebook;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private EditText et_fileName;
    private EditText et_fileText;
    private SharedPreferences preferences;
    final String SAVED_TEXT = "saved_text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_fileText = findViewById(R.id.editTextTypeText);
        et_fileName = findViewById(R.id.editTextFileName);
        preferences = getPreferences(MODE_PRIVATE);
        if (!preferences.getString(SAVED_TEXT, "Empty").equals("Empty"))
            et_fileName.setText(preferences.getString(SAVED_TEXT, "Empty"));
        et_fileText.setText(getTextFromFile());
    }

    public void clickSave(View view) {
        FileOutputStream outputStream;
        try {
            outputStream = openFileOutput(et_fileName.getText().toString(), Context.MODE_PRIVATE);
            outputStream.write(et_fileText.getText().toString().getBytes());
            outputStream.close();
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString(SAVED_TEXT, et_fileName.getText().toString());
            editor.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getTextFromFile() {
        String fileName = preferences.getString(SAVED_TEXT, "Empty");
        if (fileName.equals("Empty")) {
            return null;
        }
        FileInputStream fin = null;
        try {
            fin = openFileInput(fileName);
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            String text = new String(bytes);
            Log.d(LOG_TAG, text);
            return text;
        } catch (IOException ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        } finally {
            try {
                if (fin != null)
                    fin.close();
            } catch (IOException ex) {
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        return null;
    }
}