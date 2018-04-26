package com.example.root.gloryapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Button btn_login;
    private EditText username1, password1;
    String username2, password2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_login = (Button) findViewById(R.id.button);
        username1 =(EditText) findViewById(R.id.username);
        password1 =(EditText) findViewById(R.id.password);


    }

    public void pindah(View view){

        username2 = username1.getText().toString();
        password2 = password1.getText().toString();

             if (username2.equals("glory")&&password2.equals("bakery")){
                 Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                 startActivity(intent);
              Toast.makeText(MainActivity.this, "Login Sukses, Glory.", Toast.LENGTH_SHORT).show();
              } else{
                 Toast.makeText(MainActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
             }

    }
}









