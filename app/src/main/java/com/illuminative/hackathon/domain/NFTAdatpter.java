package com.illuminative.hackathon.domain;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.illuminative.hackathon.R;
import com.illuminative.hackathon.data.db.NFT;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NFTAdatpter extends RecyclerView.Adapter<NFTAdatpter.NFTsViewHolder> {

    private View.OnClickListener onClickListener;
    private List<NFT> nft_data;

    public NFTAdatpter(List<NFT> nfts) {this.nft_data = nfts;}

    @NonNull
    @Override
    public NFTsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_collection_nft, parent, false);
        return new NFTsViewHolder(view);
    }

    @SuppressLint("DefaulLocale")
    @Override
    public void onBindViewHolder(@NonNull NFTsViewHolder holder, int position) {
        return ;
        };


    @Override
    public int getItemCount() {
        return 0;
    }

    public static class NFTsViewHolder extends RecyclerView.ViewHolder{

        final ImageView NFTImageView;
        final TextView NFTTitleTextView;
        final TextView NFTisCollectionTextView;

        public NFTsViewHolder(@NonNull View itemView) {
            super(itemView);

            NFTImageView = itemView.findViewById(R.id.iv_cover);
            NFTTitleTextView = itemView.findViewById(R.id.rv_item_collection_title);
            NFTisCollectionTextView = itemView.findViewById(R.id.rv_item_is_collection);
        }
    }

    @FunctionalInterface
    public interface OnClickListener {
        void onItemClick(NFT item);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = (View.OnClickListener) onClickListener;
    }
}
