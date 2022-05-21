package com.illuminative.hackathon.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.illuminative.hackathon.R;
import com.illuminative.hackathon.data.NFTs.DataStorage;
import com.illuminative.hackathon.data.NFTs.NFTApp;
import com.illuminative.hackathon.data.db.NFT;
import com.illuminative.hackathon.data.db.NFTDAO;
import com.illuminative.hackathon.domain.NFTAdapter;

import java.util.List;

public class PreviewActivity extends AppCompatActivity {

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
        nftAdapter.setOnClickListener(nft -> openSingleNFTActivity());

        rvNFTs.setAdapter(nftAdapter);

        nftDAO.getAll().observe(this, nftAdapter::update);
    }

    private void openSingleNFTActivity() {
        Intent intent = new Intent(this, SingleNFTActivity.class);
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