package com.example.root.divisikwu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button tes;
    private EditText edit_1, edit_2, edit_3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tes = (Button) findViewById(R.id.button1);
        edit_1 = (EditText) findViewById(R.id.editText);
        edit_2 = (EditText) findViewById(R.id.editText2);
        edit_3 = (EditText) findViewById(R.id.editText3);





    }


    public void coba(View view) {

        int hitung1 = Integer.parseInt(edit_1.getText().toString());
        int hitung2 = hitung1 * hitung1;
                int hitung3 = hitung2;

                edit_3.setText(hitung2);

    }
}
