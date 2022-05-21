package com.illuminative.hackathon.data.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;



@Database(entities = {NFT.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract NFTDAO NFTDao();
}
