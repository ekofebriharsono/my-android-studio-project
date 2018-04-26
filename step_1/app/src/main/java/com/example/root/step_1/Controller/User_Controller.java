package com.example.root.step_1.Controller;

/**
 * Created by root on 11/12/17.
 */


import com.example.root.step_1.API.User_Api;
import com.example.root.step_1.Activity.MainActivity;
import com.example.root.step_1.Apps.Apps;
import com.example.root.step_1.Config.Config;
import com.example.root.step_1.Fragment.Fragment_Tab_2;
import com.example.root.step_1.Model.Own_Call_Back;
import com.example.root.step_1.R;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import android.widget.Toast;


public class User_Controller {
    public static void fotocopy(String jenis_kertas, String jumlah_kertas, String total, String catatan, String tanggal, final Own_Call_Back callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.API_URL)
                .build();
        User_Api userApi = retrofit.create(User_Api.class);
        Call<ResponseBody> callResgister = userApi.fotocopy(jenis_kertas, jumlah_kertas, total, catatan, tanggal);
        callResgister.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                callback.onSuccess(Apps.getContext().getString(R.string.registration_success));
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callback.onSuccess(Apps.getContext().getString(R.string.network_problem));
            }
        });
    }


    public static void print(String jenis_kertas,String jenis_print, String jumlah_kertas, String total, String catatan, String tanggal, final Own_Call_Back callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.API_URL)
                .build();
        User_Api userApi = retrofit.create(User_Api.class);
        Call<ResponseBody> callResgister = userApi.print(jenis_kertas, jenis_print, jumlah_kertas, total, catatan, tanggal);
        callResgister.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                callback.onSuccess(Apps.getContext().getString(R.string.registration_success));
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callback.onSuccess(Apps.getContext().getString(R.string.network_problem));
            }
        });
    }
}
