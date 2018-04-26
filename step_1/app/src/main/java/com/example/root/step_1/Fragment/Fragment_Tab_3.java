package com.example.root.step_1.Fragment;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.root.step_1.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 * Created by root on 11/1/17.
 */

public class Fragment_Tab_3 extends Fragment {
    private static final String TAB = "tab3fragment";

    private Button tes;
    private TextView jam;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout .tab_3,container,false);
        jam = (TextView) view.findViewById(R.id.datetime);

        //datetime
        Calendar c1 = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("d/M/yyyy h:m:s a");
        String datetime = simpleDateFormat.format(c1.getTime());
        jam.setText(datetime);

        return view;
    }

}
