package com.illuminative.hackathon.data.NFTs;

import android.app.Application;


import androidx.room.Room;

import com.illuminative.hackathon.data.db.AppDatabase;


public class NFTApp extends Application{
    public static AppDatabase DB;

    @Override
    public void onCreate() {
        super.onCreate();
        DB = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "NFT_database")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        DB.NFTDao().insertNFTs(DataStorage.NFTs);
    }
}
