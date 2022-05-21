package com.illuminative.hackathon.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.illuminative.hackathon.R;
import com.illuminative.hackathon.data.NFTs.DataStorage;
import com.illuminative.hackathon.data.NFTs.NFTApp;
import com.illuminative.hackathon.data.db.NFT;
import com.illuminative.hackathon.data.db.NFTDAO;
import com.illuminative.hackathon.domain.NFTAdapter;


public class PreviewActivity extends AppCompatActivity {

    public static final String EXTRA_DESCRIPTION = "com.illuminative.hackathon.ui.EXTRA_DESCRIPTION";
    public static final String EXTRA_IMAGE_URL = "com.illuminative.hackathon.ui.EXTRA_IMAGE_URL";
    public static final String EXTRA_TITLE = "com.illuminative.hackathon.ui.EXTRA_TITLE";
    public static final String EXTRA_PRICE = "com.illuminative.hackathon.ui.EXTRA_PRICE";
    public static final String EXTRA_COLLECTION = "com.illuminative.hackathon.ui.EXTRA_COLLECTION";

    private FloatingActionButton addButton;
    private RecyclerView rvNFTs;

    private NFTAdapter nftAdapter;

    private NFTDAO nftDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.preview_activity);
        rvNFTs = findViewById(R.id.rv_nft);
        rvNFTs.setAdapter(nftAdapter);
        setupDatabase();

        setupRecyclerView();

        setupAddNewNFT();
    }

    private void setupRecyclerView() {
        rvNFTs = findViewById(R.id.rv_nft);

        nftAdapter = new NFTAdapter(DataStorage.NFTs);
        nftAdapter.setOnClickListener(nft -> openSingleNFTActivity(nft));

        rvNFTs.setAdapter(nftAdapter);

        nftDAO.getAll().observe(this, nftAdapter::update);
    }

    private void openSingleNFTActivity(@NonNull NFT nft) {
        String imageUrl = nft.imageUrl;
        String title = nft.title;
        String descripton = nft.description;
        String price = nft.price.toString();
        String collection = nft.collection;
        //String sold = nft.sold.toString();

        Intent intent = new Intent(this, SingleNFTActivity.class);
        intent.putExtra(EXTRA_DESCRIPTION, descripton);
        intent.putExtra(EXTRA_IMAGE_URL, imageUrl);
        intent.putExtra(EXTRA_TITLE, title);
        intent.putExtra(EXTRA_PRICE, price);
        intent.putExtra(EXTRA_COLLECTION, collection);
        startActivity(intent);
    }

    private void setupDatabase() {
        nftDAO = NFTApp.DB.NFTDao();
    }

    private void setupAddNewNFT() {
        addButton = findViewById(R.id.fab_add);
        addButton.setOnClickListener(v -> openNewAddNFTActivity());
    }

    private void openNewAddNFTActivity() {
        Intent intent = new Intent(this, CreateNewNFTActivity.class);
        startActivity(intent);
    }


}