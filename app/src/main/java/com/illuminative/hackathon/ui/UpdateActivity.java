package com.illuminative.hackathon.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputEditText;
import com.illuminative.hackathon.R;
import com.illuminative.hackathon.data.db.AppDatabase;
import com.illuminative.hackathon.data.db.NFT;

public class UpdateActivity extends AppCompatActivity {

    private @NonNull NFT nft = new NFT();
    Intent intent = getIntent();

    AppDatabase nftDb = AppDatabase.getInstance(this);

    private ImageView updateImageNFT;

    private Button updateImage;
    private Button updateNFT;

    private TextInputEditText updateTitle;
    private TextInputEditText updateDescription;
    private TextInputEditText updatePrice;
    private TextInputEditText updateCollection;

    private CheckBox updateSold;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.update_activity);

        nft = (NFT) intent.getSerializableExtra(SingleNFTActivity.UPDATE_NFT);

        setView();
    }

    private void setView() {

        updateImageNFT = findViewById(R.id.update_photo);
        updateImage = findViewById(R.id.update_image);
        updateNFT = findViewById(R.id.update_nft_button);
        updateTitle = findViewById(R.id.update_title);
        updateDescription = findViewById(R.id.update_image_description);
        updatePrice = findViewById(R.id.update_new_nft_price_label);
        updateCollection = findViewById(R.id.password_update_text);

        Glide.with(updateImageNFT)
                .load(nft.imageUrl)
                .placeholder(R.mipmap.ic_launcher)
                .into(updateImageNFT);

        updateTitle.setText(nft.title);
        updateDescription.setText(nft.description);
        updatePrice.setText(nft.price.toString());
        updateCollection.setText(nft.collection);

    }
}
