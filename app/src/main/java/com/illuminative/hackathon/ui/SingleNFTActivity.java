package com.illuminative.hackathon.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.illuminative.hackathon.R;
import com.illuminative.hackathon.data.db.NFT;

public class SingleNFTActivity extends AppCompatActivity {
    private NFT nft;
    private String collectionText;
    private String priceText;
    private String imageUrlText;
    private String titleText;

    private ImageView imageUrl;
    private TextView title;
    private TextView price;
    private TextView collection;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.single_nft);
        Intent intent = getIntent();
        //nft = intent.getParcelableExtra(PreviewActivity.EXTRA_NFT);

        imageUrlText = intent.getStringExtra(PreviewActivity.EXTRA_IMAGE_URL);
        titleText = intent.getStringExtra(PreviewActivity.EXTRA_TITLE);
        priceText = intent.getStringExtra(PreviewActivity.EXTRA_PRICE);
        collectionText = intent.getStringExtra(PreviewActivity.EXTRA_COLLECTION);

        /*collectionText = nft.collection;
        priceText = nft.price;
        imageUrlText = nft.imageUrl;
        titleText = nft.title;*/

        imageUrl = findViewById(R.id.img);
        title = findViewById(R.id.title);
        price = findViewById(R.id.price);
        collection = findViewById(R.id.collection);

        setView();
    }

    private void setView() {
        Glide.with(imageUrl)
                .load(imageUrlText)
                .placeholder(R.mipmap.ic_launcher)
                .into(imageUrl);

        title.setText(String.format("%s", titleText));
        price.setText(String.format("%s", priceText));
        collection.setText(String.format("%s", collectionText));
    }
}
