package com.example.root.kalku_o;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by root on 11/1/17.
 */

public class fragment_3 extends Fragment {
    private static final String TAB = "tab3fragment";

    private Button tes;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab3,container,false);
        tes = (Button) view.findViewById(R.id.button3);

        tes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Fragment-3", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}
