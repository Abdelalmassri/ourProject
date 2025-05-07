package com.abdel.mijnproject.network;

import com.abdel.mijnproject.data.entities.User;
import com.abdel.mijnproject.data.entities.User;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MijnProAbdelInterface {





    @GET("mymedapi.php")
    Call<JsonObject>
    LoginRequest(@Query("access_key") String access_key,
                 @Query("loginrequest") String loginrequest,
                 @Query("email") String email,
                 @Query("password") String password
    );


    @POST("mymedapi.php")
    Call<JsonObject> InsertnewUsers(@Body User user);



}
