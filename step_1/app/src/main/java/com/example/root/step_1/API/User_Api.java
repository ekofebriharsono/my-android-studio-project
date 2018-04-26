package com.example.root.step_1.API;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


/**
 * Created by root on 11/12/17.
 */



public interface User_Api {
    @GET("register2.php?operasi=fotocopy")
    Call<ResponseBody> fotocopy(@Query("jenis_kertas") String jenis_kertas,
                                @Query("jumlah_kertas") String jumlah_kertas,
                                @Query("total") String total,
                                @Query("catatan") String catatan,
                                @Query("tanggal") String tanggal);



    @GET("register2.php?operasi=print")
    Call<ResponseBody> print(@Query("jenis_kertas") String jenis_kertas,
                                @Query("jenis_print") String jenis_print,
                                @Query("jumlah_kertas") String jumlah_kertas,
                                @Query("total") String total,
                                @Query("catatan") String catatan,
                                @Query("tanggal") String tanggal);



    /**  @GET("register1.php?operasi=view")
      Call<ResponseBody> getBiodata();

      @GET("register1.php?operasi=get_biodata_by_id&id={id}")
      Call<ResponseBody> getBiodata(@Path("id") String id);

      @GET("register1.php?operasi=update&id={id}&nama={nama}&alamat={alamat}")
      Call<ResponseBody> update(@Path("id") String id,
                                @Path("nama") String nama,
                                @Path("alamat") String alamat);

      @GET("register1.php?operasi=delete&id={id}")
      Call<ResponseBody> delete(@Path("id") String id);
  */
    }
