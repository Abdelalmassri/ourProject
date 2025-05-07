package com.abdel.mijnproject.data.database;

import android.content.Context;


import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.abdel.mijnproject.data.dao.UserDao;
import com.abdel.mijnproject.data.entities.User;
import com.abdel.mijnproject.data.dao.UserDao;
import com.abdel.mijnproject.data.entities.User;

@Database(entities = {User.class}, version =2 , exportSchema = false )
public abstract class AppDatabase extends  RoomDatabase {

    public abstract UserDao userDao();

    private static volatile AppDatabase instance;

    public static AppDatabase getINSTANCE(Context context){
        if(instance==null){
            synchronized (AppDatabase.class){
                if(instance==null){
                    instance= Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,"mijnpro_database")
                            .build();
                }
            }
        }
        return instance;
    }
}
