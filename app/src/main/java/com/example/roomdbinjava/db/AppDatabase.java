package com.example.roomdbinjava.db;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract UserDao userDao();

    public static synchronized AppDatabase getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "note_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }
}
