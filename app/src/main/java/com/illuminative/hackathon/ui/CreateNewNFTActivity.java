package com.illuminative.hackathon.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.illuminative.hackathon.R;

public class CreateNewNFTActivity extends AppCompatActivity {

    private Button buttonAddNFT;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.create_new_activity);

        setUpAddNFT();
    }

    private void setUpAddNFT() {
        buttonAddNFT = findViewById(R.id.add_nft_button);
        buttonAddNFT.setOnClickListener(v -> openNewAddPhotoActivity());
    }

    private void openNewAddPhotoActivity() {
        Intent intent = new Intent(this, NFTCameraActivity.class);
        startActivity(intent);
    }
}