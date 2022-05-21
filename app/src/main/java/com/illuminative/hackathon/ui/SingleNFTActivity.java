package com.illuminative.hackathon.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.illuminative.hackathon.R;


public class SingleNFTActivity extends AppCompatActivity {
    private String collectionText;
    private String priceText;
    private String imageUrlText;
    private String titleText;
    private String descriptionText;

    private ImageView imageUrl;
    private TextView title;
    private TextView price;
    private TextView collection;
    private TextView description;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.single_nft);
        Intent intent = getIntent();

        imageUrlText = intent.getStringExtra(PreviewActivity.EXTRA_IMAGE_URL);
        titleText = intent.getStringExtra(PreviewActivity.EXTRA_TITLE);
        priceText = intent.getStringExtra(PreviewActivity.EXTRA_PRICE);
        collectionText = intent.getStringExtra(PreviewActivity.EXTRA_COLLECTION);
        descriptionText = intent.getStringExtra(PreviewActivity.EXTRA_DESCRIPTION);

        imageUrl = findViewById(R.id.img);
        title = findViewById(R.id.title);
        price = findViewById(R.id.price);
        collection = findViewById(R.id.collection);
        description = findViewById(R.id.description);

        setView();
    }

    private void setView() {
        Glide.with(imageUrl)
                .load(imageUrlText)
                .placeholder(R.mipmap.ic_launcher)
                .into(imageUrl);

        title.setText(String.format("%s", titleText));
        price.setText(String.format("%s", priceText + " ETH"));
        collection.setText(String.format("%s", "Collection: " + collectionText));
        description.setText(String.format("%s", descriptionText));
    }
}
