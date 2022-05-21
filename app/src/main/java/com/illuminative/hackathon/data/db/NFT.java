package com.illuminative.hackathon.data.db;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;



@Entity(tableName = "NFTs")
public class NFT {

    @PrimaryKey(autoGenerate = true)
    public Long id;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "description")
    public String description;

    @ColumnInfo(name = "image_url")
    public String imageUrl;

    @ColumnInfo(name = "price")
    public Double price;

    @ColumnInfo(name = "collection")
    public String collection;

    @ColumnInfo(name = "single_attr")
    public Boolean single_attr;

    @ColumnInfo(name = "sold")
    public Boolean sold;


    public NFT() {
    }

    @Ignore
    public NFT(long id, String title, String description, String imageUrl, Double price, String collection, Boolean single_attr, Boolean sold) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
        this.collection = collection;
        this.single_attr = single_attr;
        this.sold = sold;
    }



    @NonNull
    @Override
    public String toString() {
        return "NFT{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", price=" + price +
                ", collection='" + collection + '\'' +
                ", single_attr=" + single_attr +
                ", sold=" + sold +
                '}';
    }
}