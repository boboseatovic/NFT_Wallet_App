package com.illuminative.hackathon.data.db;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.List;

@Database(entities = NFT.class, exportSchema=false, version=1)
public abstract class AppDatabase extends RoomDatabase{
    private static final String DB_NAME="nft_db";
    private static AppDatabase instance;
    public static synchronized AppDatabase getInstance(Context context){
        if(instance == null){
            instance= Room.databaseBuilder(context,
                    AppDatabase.class,
                    DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
    public abstract NFTDAO NFTDao();
}