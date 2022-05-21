package com.illuminative.hackathon.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;



@Dao
public interface NFTDAO {

    @Query("SELECT * FROM NFTs")
    LiveData<List<NFT>> getAll();

    @Query("SELECT * FROM NFTs ORDER BY title DESC")
    LiveData<List<NFT>> getAllSortedByTitle();

    @Insert
    void insertNFT(NFT NFT);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertNFTs(List<NFT> NFTs);
}
