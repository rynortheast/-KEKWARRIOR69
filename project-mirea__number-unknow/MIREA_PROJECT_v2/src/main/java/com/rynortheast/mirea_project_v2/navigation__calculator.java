package com.rynortheast.mirea_project_v2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class navigation__calculator extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    TextView field__result;
    EditText field__number;
    TextView field__oper;

    String oper__last = "=";
    Double operand = null;

    public static navigation__calculator newInstance(String mParam1, String mParam2) {
        navigation__calculator fragment = new navigation__calculator();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, mParam1);
        args.putString(ARG_PARAM2, mParam2);
        fragment.setArguments(args);
        return fragment;
    }
}