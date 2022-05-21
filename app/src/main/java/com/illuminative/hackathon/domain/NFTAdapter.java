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
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NFTAdapter extends RecyclerView.Adapter<NFTAdapter.NFTsViewHolder> {

    private OnClickListener onClickListener;
    private List<NFT> nft_data;

    public NFTAdapter(List<NFT> nfts) {this.nft_data = nfts;}

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



            holder.NFTTitleTextView.setText(String.format("%s", nft.title));

            holder.NFTisCollectionTextView.setText(String.format("%s", nft.collection));

            Glide.with(holder.NFTImageView)
                .load(nft.imageUrl)
                .into(holder.NFTImageView);
        }


    @Override
    public int getItemCount() {
        return nft_data != null ? nft_data.size() : 0;
    }

    public void update(List<NFT> nft_data) {
        DiffUtilCallback diffUtilCallback = new DiffUtilCallback(this.nft_data, nft_data);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffUtilCallback);
        diffResult.dispatchUpdatesTo(this);
        this.nft_data = nft_data;
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
        this.onClickListener = onClickListener;
    }

    public static class DiffUtilCallback extends DiffUtil.Callback {

        private final List<NFT> oldList;
        private final List<NFT> newList;

        public DiffUtilCallback(List<NFT> oldList, List<NFT> newList) {
            this.oldList = oldList;
            this.newList = newList;
        }


        @Override
        public int getOldListSize() {
            return oldList != null ? oldList.size() : 0;
        }

        @Override
        public int getNewListSize() {
            return newList != null ? newList.size() : 0;
        }

        @Override
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            NFT oldItem = oldList.get(oldItemPosition);
            NFT newItem = newList.get(newItemPosition);
            return oldItem.id.equals(newItem.id);
        }

        @Override
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            NFT oldItem = oldList.get(oldItemPosition);
            NFT newItem = newList.get(newItemPosition);
            return oldItem.title.equals(newItem.title)
                    && oldItem.collection.equals(newItem.collection)
                    && oldItem.imageUrl.equals(newItem.imageUrl);
        }
    }
}
