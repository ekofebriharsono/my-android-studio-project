package com.example.root.step_1.Validation;

import android.widget.EditText;

/**
 * Created by root on 11/12/17.
 */

public class Validation {
    public static boolean isEmpty(EditText editText) {
        String text = editText.getText().toString();
        return text.trim().isEmpty();
    }
}
