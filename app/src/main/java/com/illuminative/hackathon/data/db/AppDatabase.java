package com.illuminative.hackathon.data.db;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {NFT.class}, version = 1)

public abstract class AppDatabase extends RoomDatabase {

    public abstract @NonNull NFTDAO NFTDao();
}
