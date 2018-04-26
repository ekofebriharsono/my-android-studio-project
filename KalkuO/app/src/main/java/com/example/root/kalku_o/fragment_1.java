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
     * Created by Maseko on 11/1/17.
     */

    public class fragment_1 extends Fragment {
        private static final String TAB = "tab1fragment";

        private Button hitung, reset;
        private EditText jumlah_print;
        private Spinner print, kertas;
        private TextView harga;
        private CheckBox jilid, mika;


        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.tab1,container,false);
            hitung = (Button) view.findViewById(R.id.button1);
            reset = (Button) view.findViewById(R.id.reset);
            jumlah_print = (EditText) view.findViewById(R.id.jumlah_print);
            print  = (Spinner) view.findViewById(R.id.spinner_print);
            kertas  = (Spinner) view.findViewById(R.id.spinner_kertas);
            harga = (TextView) view.findViewById(R.id.harga);
            jilid = (CheckBox) view.findViewById(R.id.checkBox_jilid);
            mika = (CheckBox) view.findViewById(R.id.checkBox_mika);
            mika.setEnabled(false);

            hitung.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(jumlah_print.length()==0 ){
                    Toast.makeText(getActivity(),"Harap Masukkan jumlah Kertas",Toast.LENGTH_LONG).show();
                    }
                   else {
                        coba(view);
                    }
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

            reset.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    reset(view);
                }
            });

            return view;
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
            int jumlah = Integer.parseInt(jumlah_print.getText().toString());

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

        public void coba(View view) {

            hitung();
            Toast.makeText(getActivity(), "Sukses", Toast.LENGTH_LONG).show();
        }

        public int print (int kertas_print, int jumlah_print) {

            return kertas_print*jumlah_print;
        }

        public void reset(View view) {

            jumlah_print.setText(null);
            harga.setText("Rp. 0 ,-");
            jilid.setChecked(false);
            mika.setChecked(false);
            mika.setEnabled(false);
            Toast.makeText(getActivity(), "Reset", Toast.LENGTH_LONG).show();

        }
    }
