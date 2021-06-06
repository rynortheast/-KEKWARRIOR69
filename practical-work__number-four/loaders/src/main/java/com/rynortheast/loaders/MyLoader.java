package com.rynortheast.loaders;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.loader.content.AsyncTaskLoader;
import java.util.ArrayList;
import java.util.Collections;

public class MyLoader extends AsyncTaskLoader<String> {
    public static final String ARG_WORD = "WORD";

    private String symbols;
    private String firstName;

    ArrayList<Character> charList;

    public MyLoader(@NonNull Context context, Bundle args, EditText editText) {
        super(context);
        if (args != null){
            firstName = args.getString(ARG_WORD);

            symbols = args.getString(ARG_WORD);
            charList = new ArrayList<>();
            for (char symbol : symbols.toCharArray()){
                charList.add(symbol);
            }
            Collections.shuffle(charList);
            symbols = charList.toString();
            for(char symbol : symbols.toCharArray()){
                if (symbol == '[' || symbol == ']' || symbol == ','){
                    symbols = symbols.replace(symbol, ' ');
                }
            }
            symbols = symbols.trim();
            editText.setText(symbols);
        }
    }

    @Override
    public String loadInBackground() {
        SystemClock.sleep(5000);
        return firstName;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
}
