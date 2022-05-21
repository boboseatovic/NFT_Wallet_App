package com.illuminative.hackathon.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.illuminative.hackathon.R;

public class PreviewActivity extends AppCompatActivity {

    FloatingActionButton addButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.preview_activity);

        setupAddNewNFT();
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