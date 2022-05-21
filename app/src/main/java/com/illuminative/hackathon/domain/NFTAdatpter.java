package com.illuminative.hackathon.domain;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.illuminative.hackathon.R;
import com.illuminative.hackathon.data.db.NFT;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NFTAdatpter extends RecyclerView.Adapter<NFTAdatpter.NFTsViewHolder> {

    private OnClickListener onClickListener;
    private List<NFT> nft_data;

    public NFTAdatpter(List<NFT> nfts) {this.nft_data = nfts;}

    @NonNull
    @Override
    public NFTsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_collection_nft, parent, false);
        return new NFTsViewHolder(view);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(@NonNull NFTsViewHolder holder, int position) {
            NFT nft = nft_data.get(position);

            holder.itemView.setOnClickListener(v -> {
                if (onClickListener != null) onClickListener.onItemClick(nft);
            });

            Glide.with(holder.NFTImageView)
                .load(nft.imageUrl)
                .into(holder.NFTImageView);

            holder.NFTTitleTextView.setText(String.format("%s", nft.title));

            if (nft.collection != null) {
                holder.NFTisCollectionTextView.setText(nft.collection);
            } else {
                holder.NFTisCollectionTextView.setText("No");
            }

        };


    @Override
    public int getItemCount() {
        return nft_data != null ? nft_data.size() : 0;
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
        public void onItemClick(NFT item);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}
