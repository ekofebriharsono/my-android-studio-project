package com.example.root.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    String[] listArray={"ID: 011200350021 \n 25-07-2017 12:46:02","ID: 011200350022 \n 27-07-2017 13:15:32","ID: 011200350023 \n 27-07-2017 09:49:52","ID: 011200350024 \n 28-07-2017 07:46:02",
            "ID: 011200350025 \n 29-07-2017 12:46:42","ID: 011200350026 \n 29-07-2017 09:35:39"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.activity_listview,listArray);
        ListView listview =(ListView) findViewById(R.id.array_list);
        listview.setAdapter(adapter);

    }
}
