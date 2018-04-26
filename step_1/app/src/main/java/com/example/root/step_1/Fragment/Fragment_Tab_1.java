package com.example.root.step_1.Fragment;

/**
 * Created by root on 11/12/17.
 */


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
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

import com.example.root.step_1.Controller.User_Controller;
import com.example.root.step_1.Model.Own_Call_Back;
import com.example.root.step_1.R;
import com.example.root.step_1.Validation.Validation;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Maseko on 11/1/17.
 */

public class Fragment_Tab_1 extends Fragment {
    private static final String TAB = "tab1fragment";


    private Button hitung, btnreset;
    private EditText jumlah_print_, catatan_;
    private Spinner print, kertas;
    private TextView harga ,simpan;
    private CheckBox jilid, mika;
    private FloatingActionButton fab_;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_1,container,false);

        hitung = (Button) view.findViewById(R.id.button1);
        btnreset = (Button) view.findViewById(R.id.reset);
        jumlah_print_ = (EditText) view.findViewById(R.id.jumlah_print);
        catatan_ = (EditText) view.findViewById(R.id.Catatan);
        print  = (Spinner) view.findViewById(R.id.spinner_print);
        simpan = (TextView) view.findViewById(R.id.textView_simpan);
        kertas  = (Spinner) view.findViewById(R.id.spinner_kertas);
        harga = (TextView) view.findViewById(R.id.harga);
        jilid = (CheckBox) view.findViewById(R.id.checkBox_jilid);
        mika = (CheckBox) view.findViewById(R.id.checkBox_mika);
        fab_ = (FloatingActionButton) view.findViewById(R.id.fab);
        mika.setEnabled(false);
        fab_.setEnabled(false);



        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fieldsValidation()  ){
                    total(view);
                    simpan.setText("Simpan Data >>>>>>>");
                    fab_.setEnabled(true);
                }
                else {
                    Toast.makeText(getActivity(), R.string.kertas_kosong,Toast.LENGTH_LONG).show();
                }
            }}
        );


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

        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
            }
        });



        fab_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fieldsValidation() ){
                    Toast.makeText(getActivity(),"sukses",Toast.LENGTH_LONG).show();

                }
                else {
                    Toast.makeText(getActivity(), R.string.kertas_kosong,Toast.LENGTH_LONG).show();
                }
            }}

        );

        return view;
    }

    private boolean fieldsValidation() {
        return !Validation.isEmpty(jumlah_print_) ;
    }

    private void Print() {
        //datetime
        Calendar c1 = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("d/M/yyyy h:m:s a");
        String datetime_ = simpleDateFormat.format(c1.getTime());

        String jenis_kertas = kertas.getSelectedItem().toString();
        String jenis_print = print.getSelectedItem().toString();
        final String jumlah_kertas = jumlah_print_.getText().toString().trim();
        String total = harga.getText().toString();
        String catatan = catatan_.getText().toString();
        String tanggal = datetime_.toString();

        final ProgressDialog dialog = new ProgressDialog(getActivity());
        dialog.setTitle("Tunggu Sebentar");
        dialog.setMessage("Menyimpan Data ...");
        dialog.setCancelable(false);
        dialog.show();

        User_Controller.print(jenis_kertas, jenis_print, jumlah_kertas,total,catatan,tanggal , new Own_Call_Back() {
            @Override
            public void onSuccess(String message) {
                reset();

                dialog.dismiss();
                Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(String errorCode, String message) {
                dialog.dismiss();
                Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void reset() {

        jumlah_print_.setText(null);
        harga.setText("Rp. 0 ,-");
        jilid.setChecked(false);
        mika.setChecked(false);
        mika.setEnabled(false);
        catatan_.setText(null);
        fab_.setEnabled(false);
        simpan.setText(null);
        Toast.makeText(getActivity(), "Reset", Toast.LENGTH_LONG).show();
    }


    public void hitung(){

        int biaya_hitam_putih = 350;
        int biaya_text_berwarna = 550;
        int biaya_full_berwarna = 850;
        int kertas_70 = 150;
        int kertas_80 = 200;
        int jilid_ = 2000;
        int mika_ = 1000;

        String   kertas_1 = kertas.getSelectedItem().toString();
        String   print_1 = print.getSelectedItem().toString();
        int jumlah = Integer.parseInt(jumlah_print_.getText().toString());

        if (kertas_1.equals("Bawa Sendiri")){

            if (print_1.equals("Hitam Putih")){


                if(jilid.isChecked() && mika.isChecked()){

                    int kertas_print = biaya_hitam_putih;
                    int jumlah_print = jumlah;

                    int mika = mika_;
                    int jilid = jilid_;

                    int   hasil_1 = hitung_pr_jilid_mika(kertas_print ,jumlah_print, mika, jilid);
                    String hasil= String.valueOf(hasil_1);
                    harga.setText("Rp. " +hasil.toString()+" ,-");
                } else if (jilid.isChecked()) {
                    int kertas_print = biaya_hitam_putih;
                    int jumlah_print = jumlah;
                    int jilid = jilid_;


                    int   hasil_1 = hitung_pr_jilid(kertas_print,jumlah_print,jilid);
                    String hasil= String.valueOf(hasil_1);
                    harga.setText("Rp. " +hasil.toString()+" ,-");
                } else {
                    int kertas_print = biaya_hitam_putih;
                    int jumlah_print = jumlah;



                    int   hasil_1 = print(kertas_print,jumlah_print);
                    String hasil= String.valueOf(hasil_1);
                    harga.setText("Rp. " +hasil.toString()+" ,-");
                }


            } else if (print_1.equals("Berwarna")){


                if(jilid.isChecked() && mika.isChecked()){

                    int kertas_print = biaya_text_berwarna;
                    int jumlah_print = jumlah;

                    int mika = mika_;
                    int jilid = jilid_;

                    int   hasil_1 = hitung_pr_jilid_mika(kertas_print ,jumlah_print, mika, jilid);
                    String hasil= String.valueOf(hasil_1);
                    harga.setText("Rp. " +hasil.toString()+" ,-");
                } else if (jilid.isChecked()) {
                    int kertas_print = biaya_text_berwarna;
                    int jumlah_print = jumlah;
                    int jilid = jilid_;


                    int   hasil_1 = hitung_pr_jilid(kertas_print,jumlah_print,jilid);
                    String hasil= String.valueOf(hasil_1);
                    harga.setText("Rp. " +hasil.toString()+" ,-");
                } else {
                    int kertas_print = biaya_text_berwarna;
                    int jumlah_print = jumlah;

                    int   hasil_1 = print(kertas_print,jumlah_print);
                    String hasil= String.valueOf(hasil_1);
                    harga.setText("Rp. " +hasil.toString()+" ,-");
                }



            } else if (print_1.equals("Warna Full")){


                if(jilid.isChecked() && mika.isChecked()){

                    int kertas_print =  biaya_full_berwarna;
                    int jumlah_print = jumlah;

                    int mika = mika_;
                    int jilid = jilid_;

                    int   hasil_1 = hitung_pr_jilid_mika(kertas_print ,jumlah_print, mika, jilid);
                    String hasil= String.valueOf(hasil_1);
                    harga.setText("Rp. " +hasil.toString()+" ,-");
                } else if (jilid.isChecked()) {
                    int kertas_print =  biaya_full_berwarna;
                    int jumlah_print = jumlah;
                    int jilid = jilid_;


                    int   hasil_1 = hitung_pr_jilid(kertas_print,jumlah_print,jilid);
                    String hasil= String.valueOf(hasil_1);
                    harga.setText("Rp. " +hasil.toString()+" ,-");
                } else {
                    int kertas_print = biaya_full_berwarna;
                    int jumlah_print = jumlah;

                    int   hasil_1 = print(kertas_print,jumlah_print);
                    String hasil= String.valueOf(hasil_1);
                    harga.setText("Rp. " +hasil.toString()+" ,-");
                }

            }


        } else if (kertas_1.equals("70 GR")){

            if (print_1.equals("Hitam Putih")){

                if(jilid.isChecked() && mika.isChecked()){

                    int kertas_print =  biaya_hitam_putih + kertas_70;
                    int jumlah_print = jumlah;

                    int mika = mika_;
                    int jilid = jilid_;

                    int   hasil_1 = hitung_pr_jilid_mika(kertas_print ,jumlah_print, mika, jilid);
                    String hasil= String.valueOf(hasil_1);
                    harga.setText("Rp. " +hasil.toString()+" ,-");
                } else if (jilid.isChecked()) {
                    int kertas_print =  biaya_hitam_putih + kertas_70;
                    int jumlah_print = jumlah;
                    int jilid = jilid_;


                    int   hasil_1 = hitung_pr_jilid(kertas_print,jumlah_print,jilid);
                    String hasil= String.valueOf(hasil_1);
                    harga.setText("Rp. " +hasil.toString()+" ,-");
                } else {
                    int kertas_print = biaya_hitam_putih + kertas_70;
                    int jumlah_print = jumlah;

                    int   hasil_1 = print(kertas_print,jumlah_print);
                    String hasil= String.valueOf(hasil_1);
                    harga.setText("Rp. " +hasil.toString()+" ,-");
                }


            } else if (print_1.equals("Berwarna")){

                if(jilid.isChecked() && mika.isChecked()){

                    int kertas_print = biaya_text_berwarna + kertas_70;
                    int jumlah_print = jumlah;

                    int mika = mika_;
                    int jilid = jilid_;

                    int   hasil_1 = hitung_pr_jilid_mika(kertas_print ,jumlah_print, mika, jilid);
                    String hasil= String.valueOf(hasil_1);
                    harga.setText("Rp. " +hasil.toString()+" ,-");
                } else if (jilid.isChecked()) {
                    int kertas_print =  biaya_text_berwarna + kertas_70;
                    int jumlah_print = jumlah;
                    int jilid = jilid_;


                    int   hasil_1 = hitung_pr_jilid(kertas_print,jumlah_print,jilid);
                    String hasil= String.valueOf(hasil_1);
                    harga.setText("Rp. " +hasil.toString()+" ,-");
                } else {
                    int kertas_print = biaya_text_berwarna + kertas_70;
                    int jumlah_print = jumlah;

                    int   hasil_1 = print(kertas_print,jumlah_print);
                    String hasil= String.valueOf(hasil_1);
                    harga.setText("Rp. " +hasil.toString()+" ,-");
                }


            } else if (print_1.equals("Warna Full")){


                if(jilid.isChecked() && mika.isChecked()){

                    int kertas_print = biaya_full_berwarna + kertas_70;
                    int jumlah_print = jumlah;

                    int mika = mika_;
                    int jilid = jilid_;

                    int   hasil_1 = hitung_pr_jilid_mika(kertas_print ,jumlah_print, mika, jilid);
                    String hasil= String.valueOf(hasil_1);
                    harga.setText("Rp. " +hasil.toString()+" ,-");
                } else if (jilid.isChecked()) {
                    int kertas_print =  biaya_full_berwarna + kertas_70;
                    int jumlah_print = jumlah;
                    int jilid = jilid_;


                    int   hasil_1 = hitung_pr_jilid(kertas_print,jumlah_print,jilid);
                    String hasil= String.valueOf(hasil_1);
                    harga.setText("Rp. " +hasil.toString()+" ,-");
                } else {
                    int kertas_print = biaya_full_berwarna + kertas_70;
                    int jumlah_print = jumlah;

                    int   hasil_1 = print(kertas_print,jumlah_print);
                    String hasil= String.valueOf(hasil_1);
                    harga.setText("Rp. " +hasil.toString()+" ,-");
                }



            }

        } else {

            if (print_1.equals("Hitam Putih")){

                if(jilid.isChecked() && mika.isChecked()){

                    int kertas_print = biaya_hitam_putih + kertas_80;
                    int jumlah_print = jumlah;

                    int mika = mika_;
                    int jilid = jilid_;

                    int   hasil_1 = hitung_pr_jilid_mika(kertas_print ,jumlah_print, mika, jilid);
                    String hasil= String.valueOf(hasil_1);
                    harga.setText("Rp. " +hasil.toString()+" ,-");
                } else if (jilid.isChecked()) {
                    int kertas_print =  biaya_hitam_putih + kertas_80;
                    int jumlah_print = jumlah;
                    int jilid = jilid_;


                    int   hasil_1 = hitung_pr_jilid(kertas_print,jumlah_print,jilid);
                    String hasil= String.valueOf(hasil_1);
                    harga.setText("Rp. " +hasil.toString()+" ,-");

                } else {
                    int kertas_print = biaya_hitam_putih + kertas_80;
                    int jumlah_print = jumlah;

                    int   hasil_1 = print(kertas_print,jumlah_print);
                    String hasil= String.valueOf(hasil_1);
                    harga.setText("Rp. " +hasil.toString()+" ,-");
                }



            } else if (print_1.equals("Berwarna")){

                if(jilid.isChecked() && mika.isChecked()){

                    int kertas_print = biaya_text_berwarna + kertas_80;
                    int jumlah_print = jumlah;

                    int mika = mika_;
                    int jilid = jilid_;

                    int   hasil_1 = hitung_pr_jilid_mika(kertas_print ,jumlah_print, mika, jilid);
                    String hasil= String.valueOf(hasil_1);
                    harga.setText("Rp. " +hasil.toString()+" ,-");

                } else if (jilid.isChecked()) {
                    int kertas_print =  biaya_text_berwarna + kertas_80;
                    int jumlah_print = jumlah;
                    int jilid = jilid_;


                    int   hasil_1 = hitung_pr_jilid(kertas_print,jumlah_print,jilid);
                    String hasil= String.valueOf(hasil_1);
                    harga.setText("Rp. " +hasil.toString()+" ,-");

                } else {
                    int kertas_print = biaya_text_berwarna + kertas_80;
                    int jumlah_print = jumlah;

                    int   hasil_1 = print(kertas_print,jumlah_print);
                    String hasil= String.valueOf(hasil_1);
                    harga.setText("Rp. " +hasil.toString()+" ,-");
                }

            } else if (print_1.equals("Warna Full")){

                if(jilid.isChecked() && mika.isChecked()){

                    int kertas_print = biaya_full_berwarna + kertas_80;
                    int jumlah_print = jumlah;

                    int mika = mika_;
                    int jilid = jilid_;

                    int   hasil_1 = hitung_pr_jilid_mika(kertas_print ,jumlah_print, mika, jilid);
                    String hasil= String.valueOf(hasil_1);
                    harga.setText("Rp. " +hasil.toString()+" ,-");

                } else if (jilid.isChecked()) {
                    int kertas_print =  biaya_full_berwarna + kertas_80;
                    int jumlah_print = jumlah;
                    int jilid = jilid_;


                    int   hasil_1 = hitung_pr_jilid(kertas_print,jumlah_print,jilid);
                    String hasil= String.valueOf(hasil_1);
                    harga.setText("Rp. " +hasil.toString()+" ,-");
                } else {
                    int kertas_print = biaya_full_berwarna + kertas_80;
                    int jumlah_print = jumlah;

                    int   hasil_1 = print(kertas_print,jumlah_print);
                    String hasil= String.valueOf(hasil_1);
                    harga.setText("Rp. " +hasil.toString()+" ,-");
                }
            }
        }
    }

    public int hitung_pr_jilid_mika(int kertas_print , int jumlah_print , int jilid, int mika){
        return (kertas_print * jumlah_print)+jilid+mika;
    }

    public int hitung_pr_jilid(int kertas_print , int jumlah_print , int jilid){
        return (kertas_print * jumlah_print)+jilid;
    }

    public void total(View view) {

        hitung();

    }

    public int print (int kertas_print, int jumlah_print) {

        return kertas_print*jumlah_print;
    }

}
