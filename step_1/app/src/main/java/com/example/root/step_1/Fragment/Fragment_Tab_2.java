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
import butterknife.BindView;
import butterknife.ButterKnife;

import com.example.root.step_1.Controller.User_Controller;
import com.example.root.step_1.Model.Own_Call_Back;
import com.example.root.step_1.R;
import com.example.root.step_1.Validation.Validation;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Fragment_Tab_2 extends Fragment {
    private static final String TAB = "tab2fragment";



    private Button btnhitung, reset ;
    private TextView harga, simpan;
    private EditText jumlah_kertas_, catatan_;
    private Spinner jenis_kertas_;
    private CheckBox jilid, mika;
    private FloatingActionButton fab_;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            ButterKnife.bind(getActivity());


        View view = inflater.inflate(R.layout.tab_2,container,false);
        btnhitung = (Button) view.findViewById(R.id.button1);
        harga = (TextView) view.findViewById(R.id.harga);
        simpan = (TextView) view.findViewById(R.id.textView_simpan);
        catatan_ = (EditText) view.findViewById(R.id.Catatan);
        jumlah_kertas_ = (EditText) view.findViewById(R.id.jumlah_fc);
        jenis_kertas_ = (Spinner) view.findViewById(R.id.spinner_kertas);
        reset = (Button) view.findViewById(R.id.reset);
        jilid = (CheckBox) view.findViewById(R.id.checkBox_jilid);
        mika = (CheckBox) view.findViewById(R.id.checkBox_mika);
        fab_ = (FloatingActionButton) view.findViewById(R.id.fab);
        mika.setEnabled(false);
        fab_.setEnabled(false);

        btnhitung.setOnClickListener(new View.OnClickListener() {
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


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
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

    private boolean fieldsValidation() {
        return !Validation.isEmpty(jumlah_kertas_) ;
    }



    private void FotoCopy() {
        //datetime
        Calendar c1 = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("d/M/yyyy h:m:s a");
        String datetime_ = simpleDateFormat.format(c1.getTime());

        String jenis_kertas = jenis_kertas_.getSelectedItem().toString();
        final String jumlah_kertas = jumlah_kertas_.getText().toString().trim();
        String total = harga.getText().toString();
        String catatan = catatan_.getText().toString();
        String tanggal = datetime_.toString();

        final ProgressDialog dialog = new ProgressDialog(getActivity());
        dialog.setTitle("Tunggu Sebentar");
        dialog.setMessage("Menyimpan Data ...");
        dialog.setCancelable(false);
        dialog.show();

        User_Controller.fotocopy(jenis_kertas, jumlah_kertas,total,catatan,tanggal , new Own_Call_Back() {
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

    public void hitung(){
        int fc_ = 150;
        int kertas_70 = 150;
        int kertas_80 = 200;
        int jilid_ = 2000;
        int mika_ = 1000;


        String jenis_kertas_1 = jenis_kertas_.getSelectedItem().toString();
        int kertas_ = Integer.parseInt(jumlah_kertas_.getText().toString());

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

    private void reset() {

        jumlah_kertas_.setText(null);
        harga.setText("Rp. 0 ,-");
        jilid.setChecked(false);
        mika.setChecked(false);
        mika.setEnabled(false);
        catatan_.setText(null);
        fab_.setEnabled(false);
        simpan.setText(null);
        Toast.makeText(getActivity(), "Reset", Toast.LENGTH_LONG).show();

    }

    public void total(View view) {
        hitung();
    }
}
