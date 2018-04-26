package com.example.windows.register.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by m-hasan on 25/07/17.
 */

public interface UserApi {
    @GET("register1.php?operasi=insert")
    Call<ResponseBody> register(@Query("name") String name,
                                @Query("username") String username,
                                @Query("age") String age,
                                @Query("password") String password);

    @GET("register1.php?operasi=view")
    Call<ResponseBody> getBiodata();

    @GET("register1.php?operasi=get_biodata_by_id&id={id}")
    Call<ResponseBody> getBiodata(@Path("id") String id);

    @GET("register1.php?operasi=update&id={id}&nama={nama}&alamat={alamat}")
    Call<ResponseBody> update(@Path("id") String id,
                              @Path("nama") String nama,
                              @Path("alamat") String alamat);

    @GET("register1.php?operasi=delete&id={id}")
    Call<ResponseBody> delete(@Path("id") String id);
}
