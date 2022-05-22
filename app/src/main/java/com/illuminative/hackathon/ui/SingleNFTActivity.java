package com.illuminative.hackathon.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;

import com.bumptech.glide.Glide;
import com.illuminative.hackathon.R;
import com.illuminative.hackathon.data.db.AppDatabase;
import com.illuminative.hackathon.data.db.NFT;
import com.illuminative.hackathon.data.db.NFTDAO;
import com.illuminative.hackathon.domain.NFTAdapter;

import java.util.List;


public class SingleNFTActivity extends AppCompatActivity {

    public static final String UPDATE_NFT = "com.illuminative.hackathon.ui.UPDATE_NFT";

    AppDatabase nftDb;

    private @NonNull NFT nft;

    private String collectionText;
    private String priceText;
    private String priceDollarText;
    private String imageUrlText;
    private String titleText;
    private String descriptionText;
    private boolean soldText;

    private ImageView imageUrl;
    private TextView title;
    private TextView price;
    private TextView priceDollar;
    private TextView collection;
    private TextView description;
    private Button updateButton;
    private Button deleteButton;
    private TextView sold;
    private List<NFT> nft_data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.single_nft);
        Intent intent = getIntent();

        nftDb = AppDatabase.getInstance(this);

        imageUrlText = intent.getStringExtra(PreviewActivity.EXTRA_IMAGE_URL);
        titleText = intent.getStringExtra(PreviewActivity.EXTRA_TITLE);
        priceText = intent.getStringExtra(PreviewActivity.EXTRA_PRICE);
        priceDollarText = intent.getStringExtra(PreviewActivity.EXTRA_DOLLAR);
        collectionText = intent.getStringExtra(PreviewActivity.EXTRA_COLLECTION);
        descriptionText = intent.getStringExtra(PreviewActivity.EXTRA_DESCRIPTION);
        nft = (NFT) intent.getSerializableExtra(PreviewActivity.EXTRA_NFT);
        soldText = intent.getBooleanExtra(PreviewActivity.EXTRA_SOLD, false);

        imageUrl = findViewById(R.id.img);
        title = findViewById(R.id.title);
        price = findViewById(R.id.price);
        priceDollar = findViewById(R.id.priceDollar);
        collection = findViewById(R.id.collection);
        description = findViewById(R.id.description);
        updateButton = findViewById(R.id.update);
        deleteButton = findViewById(R.id.delete);
        sold = findViewById(R.id.is_sold);

        setView();

        setUpdateButton(nft);

        setDeleteButton();
    }


    private void setDeleteButton() {
        deleteButton.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(SingleNFTActivity.this);
            builder.setMessage("Are you sure you want to delete the NFT?");
            builder.setTitle(nft.title);
            builder.setCancelable(false);
            Intent intent = new Intent(this, PreviewActivity.class);

            builder
                    .setPositiveButton(
                            "Yes",
                            new DialogInterface
                                    .OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int which)
                                {

                                    nftDb.NFTDao().delete(nft);


                                    startActivity(intent);
                                }

                            });

            builder
                    .setNegativeButton(
                            "No",
                            new DialogInterface
                                    .OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int which)
                                {

                                    // If user click no
                                    // then dialog box is canceled.
                                    dialog.cancel();
                                }
                            });

            AlertDialog alertDialog = builder.create();
            alertDialog.show();


                }
        );


    }

    private void setUpdateButton(@NonNull NFT nft) {
        updateButton.setOnClickListener(v -> {
                    AlertDialog.Builder builder = new AlertDialog.Builder(SingleNFTActivity.this);
                    builder.setMessage("Are you sure you want to update the NFT?");
                    builder.setTitle(nft.title);
                    builder.setCancelable(false);
                    Intent intent = new Intent(this, UpdateActivity.class);
                    intent.putExtra(UPDATE_NFT, nft);


                    builder
                            .setPositiveButton(
                                    "Yes",
                                    new DialogInterface
                                            .OnClickListener() {

                                        @Override
                                        public void onClick(DialogInterface dialog,
                                                            int which)
                                        {


                                            startActivity(intent);
                                        }

                                    });

                    builder
                            .setNegativeButton(
                                    "No",
                                    new DialogInterface
                                            .OnClickListener() {

                                        @Override
                                        public void onClick(DialogInterface dialog,
                                                            int which)
                                        {

                                            // If user click no
                                            // then dialog box is canceled.
                                            dialog.cancel();
                                        }
                                    });

                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();


                }
        );


    }

    private void setView() {
        Glide.with(imageUrl)
                .load(imageUrlText)
                .placeholder(R.mipmap.ic_launcher)
                .into(imageUrl);

        title.setText(String.format("%s", titleText));
        price.setText(String.format("%s", priceText + " ETH"));
        priceDollar.setText(String.format("%s", priceDollarText + " $"));
        collection.setText(String.format("%s", collectionText));
        description.setText(String.format("%s", descriptionText));
        if(soldText){
            sold.setText("SOLD");
        }
    }
}
