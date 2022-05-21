package com.illuminative.hackathon.data.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NFTDAO {

    @Query("SELECT * FROM NFTs")
    List<NFT> getAll();

    @Query("SELECT * FROM NFTs ORDER BY title DESC")
    List<NFT> getAllSortedByTitle();

    @Insert
    void insertNFT(NFT NFT);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertNFTs(List<NFT> NFTs);

    @Delete
    void delete(NFT nft);

}
