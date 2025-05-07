package com.abdel.mijnproject.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MijnProDatabaseRetrofit {

    //   private static final String BASE_URL = "http://medreminder.wuaze.com/Api/";

    private static final String BASE_URL = "https://app.everydayintradaytips.com/Mymed/Api/";

    //   private static final String BASE_URL = "https://dummyjson.com/";

    //  private static final String BASE_URL = "http://medreminder.wuaze.com/Mymed/Api/";



    private static volatile Retrofit retrofit;

    public static Retrofit getINSTANCE(){
        if(retrofit==null){
            synchronized (MijnProAbdelInterface.class){
                Gson gson = new GsonBuilder()
                        .create();
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();
            }
        }
        return retrofit;
    }

    public static MijnProAbdelInterface getMijnProApiInterface() {
        return getINSTANCE().create(MijnProAbdelInterface.class);
    }
}
