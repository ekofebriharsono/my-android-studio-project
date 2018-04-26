package com.example.windows.register.controller;

import com.example.windows.register.Config;
import com.example.windows.register.LugApp;
import com.example.windows.register.R;
import com.example.windows.register.api.UserApi;
import com.example.windows.register.model.OwnCallback;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by m-hasan on 25/07/17.
 */

public class UserController {
    public static void registrasi(String name, String username, String age, String password, final OwnCallback callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.API_URL)
                .build();
        UserApi userApi = retrofit.create(UserApi.class);
        Call<ResponseBody> callResgister = userApi.register(name, username, age, password);
        callResgister.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                callback.onSuccess(LugApp.getContext().getString(R.string.registration_success));
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callback.onSuccess(LugApp.getContext().getString(R.string.network_problem));
            }
        });
    }
}
