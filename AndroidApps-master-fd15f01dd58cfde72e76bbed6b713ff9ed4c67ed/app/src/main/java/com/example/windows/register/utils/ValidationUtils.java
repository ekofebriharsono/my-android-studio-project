package com.example.windows.register.utils;

import android.widget.EditText;

/**
 * Created by m-hasan on 25/07/17.
 */

public class ValidationUtils {
    public static boolean isEmpty(EditText editText) {
        String text = editText.getText().toString();
        return text.trim().isEmpty();
    }
}
