package com.example.root.kalku_o;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by root on 11/1/17.
 */

public class fragment_2 extends Fragment {
    private static final String TAB = "tab2fragment";

    private Button tes, reset;
    private TextView harga;
    private EditText jumlah_kertas;
    private Spinner jenis_kertas;
    private CheckBox jilid, mika;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab2,container,false);
        tes = (Button) view.findViewById(R.id.button1);
        harga = (TextView) view.findViewById(R.id.harga);
        jumlah_kertas = (EditText) view.findViewById(R.id.jumlah_fc);
        jenis_kertas = (Spinner) view.findViewById(R.id.spinner_kertas);
        reset = (Button) view.findViewById(R.id.reset);
        jilid = (CheckBox) view.findViewById(R.id.checkBox_jilid);
        mika = (CheckBox) view.findViewById(R.id.checkBox_mika);
        mika.setEnabled(false);



        tes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(jumlah_kertas.length()==0 ){
                    Toast.makeText(getActivity(),"Harap Masukkan jumlah Kertas",Toast.LENGTH_LONG).show();
                }
                else {
                    total(view);
                    Toast.makeText(getActivity(), "Sukses", Toast.LENGTH_LONG).show();
                }
            }
        });



        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                reset(view);
                Toast.makeText(getActivity(), "Reset", Toast.LENGTH_LONG).show();
            }
        });

        jilid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 if(jilid.isChecked()==false) {
                    mika.setChecked(false);
                    mika.setEnabled(false);
                }else if(jilid.isChecked()){
                    mika.setEnabled(true);
                }

            }
        });
        return view;
    }


    public void hitung(){
        int fc_ = 150;
        int kertas_70 = 150;
        int kertas_80 = 200;
        int jilid_ = 2000;
        int mika_ = 1000;


        String jenis_kertas_1 = jenis_kertas.getSelectedItem().toString();
        int kertas_ = Integer.parseInt(jumlah_kertas.getText().toString());

        if (jenis_kertas_1.equals("Bawa Sendiri")){

            if(jilid.isChecked() && mika.isChecked()){

                int kertas = kertas_;
                int fc = fc_;
                int mika = mika_;
                int jilid = jilid_;

                int   hasil_1 = hitung_fc_jilid_mika(kertas,fc,mika,jilid);
                String hasil= String.valueOf(hasil_1);
                harga.setText("Rp. " +hasil.toString()+" ,-");
            } else if (jilid.isChecked()) {
                int kertas = kertas_;
                int fc = fc_;
                int jilid = jilid_;


                int   hasil_1 = hitung_fc_jilid(kertas,fc,jilid);
                String hasil= String.valueOf(hasil_1);
                harga.setText("Rp. " +hasil.toString()+" ,-");
            } else {
                int kertas = kertas_;
                int fc = fc_;

                int   hasil_1 = hitung_fc(kertas,fc);
                String hasil= String.valueOf(hasil_1);
                harga.setText("Rp. " +hasil.toString()+" ,-");
            }





        } else if(jenis_kertas_1.equals("70 GR")){

            if(jilid.isChecked() && mika.isChecked()){

                int kertas = kertas_ ;
                int fc = fc_ + kertas_70;
                int mika = mika_;
                int jilid = jilid_;

                int   hasil_1 = hitung_fc_jilid_mika(kertas,fc,mika,jilid);
                String hasil= String.valueOf(hasil_1);
                harga.setText("Rp. " +hasil.toString()+" ,-");
            } else if (jilid.isChecked()) {
                int kertas = kertas_ ;
                int fc = fc_ + kertas_70;
                int jilid = jilid_;

                int   hasil_1 = hitung_fc_jilid(kertas,fc,jilid);
                String hasil= String.valueOf(hasil_1);
                harga.setText("Rp. " +hasil.toString()+" ,-");
            } else {
                int kertas = kertas_;
                int fc = fc_  + kertas_70 ;

                int   hasil_1 = hitung_fc(kertas,fc);
                String hasil= String.valueOf(hasil_1);
                harga.setText("Rp. " +hasil.toString()+" ,-");
            }

        } else {
            if(jilid.isChecked() && mika.isChecked()){

                int kertas = kertas_ ;
                int fc = fc_ + kertas_80;
                int mika = mika_;
                int jilid = jilid_;

                int   hasil_1 = hitung_fc_jilid_mika(kertas,fc,mika,jilid);
                String hasil= String.valueOf(hasil_1);
                harga.setText("Rp. " +hasil.toString()+" ,-");
            } else if (jilid.isChecked()) {
                int kertas = kertas_ ;
                int fc = fc_ + kertas_80 ;
                int jilid = jilid_;

                int   hasil_1 = hitung_fc_jilid(kertas,fc,jilid);
                String hasil= String.valueOf(hasil_1);
                harga.setText("Rp. " +hasil.toString()+" ,-");
            } else {
                int kertas = kertas_ ;
                int fc = fc_ + kertas_80;

                int   hasil_1 = hitung_fc(kertas,fc);
                String hasil= String.valueOf(hasil_1);
                harga.setText("Rp. " +hasil.toString()+" ,-");
            }
        }


    }


    public int hitung_fc(int kertas , int fc){
        return kertas * fc;
    }

    public int hitung_fc_jilid_mika(int kertas , int fc , int jilid, int mika){
        return (kertas * fc)+jilid+mika;
    }

    public int hitung_fc_jilid(int kertas , int fc , int jilid){
        return (kertas * fc)+jilid;
    }

    public void reset(View view) {

        jumlah_kertas.setText(null);
        harga.setText("Rp. 0 ,-");
        jilid.setChecked(false);
        mika.setChecked(false);
        mika.setEnabled(false);
        Toast.makeText(getActivity(), "Reset", Toast.LENGTH_LONG).show();

    }

    public void total(View view) {
        hitung();
    }
}
