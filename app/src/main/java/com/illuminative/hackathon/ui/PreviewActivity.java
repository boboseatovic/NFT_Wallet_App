package com.illuminative.hackathon.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.illuminative.hackathon.R;
import com.illuminative.hackathon.data.NFTs.DataStorage;
import com.illuminative.hackathon.data.NFTs.NFTApp;
import com.illuminative.hackathon.data.db.NFTDAO;
import com.illuminative.hackathon.domain.NFTAdatpter;

public class PreviewActivity extends AppCompatActivity {

    private FloatingActionButton addButton;
    private RecyclerView rvNFTs;

    private NFTAdatpter nftAdatpter;

    private NFTDAO nftDAO;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.preview_activity);

        setupDatabase();

        setupRecyclerView();

        setupAddNewNFT();
    }

    private void setupRecyclerView() {
        rvNFTs = findViewById(R.id.rv_nft);

        nftAdatpter = new NFTAdatpter(DataStorage.NFTs);
        nftAdatpter.setOnClickListener(nft -> openSingleNFTActivity());

        rvNFTs.setAdapter(nftAdatpter);
    }

    private void openSingleNFTActivity() {
        Intent intent = new Intent(this, SingleNFTActivity.class);
        startActivity(intent);
    }

    @Nullable
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