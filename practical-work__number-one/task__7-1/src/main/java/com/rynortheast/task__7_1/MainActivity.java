package com.rynortheast.task__7_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView text__preview;
    private Button button__ok;
    private Button button__cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text__preview = (TextView) findViewById(R.id.text__preview);

        button__ok = (Button) findViewById(R.id.button__ok);
        View.OnClickListener startButtonOk = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text__preview.setText("Благодарю! (^ヮ^)");
            }
        };
        button__ok.setOnClickListener(startButtonOk);

        button__cancel = (Button) findViewById(R.id.button__cancel);
        View.OnClickListener startButtonCancel = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text__preview.setText("ну и ладно, ну и пожалуйста (ಥ﹏ಥ)");
            }
        };
        button__cancel.setOnClickListener(startButtonCancel);
    }
}