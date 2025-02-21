package com.example.mp08_uf1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MoveAdapter extends RecyclerView.Adapter<MoveAdapter.MoveViewHolder> {
    private List<Move> moveList;
    private OnMoveClickListener listener;

    public interface OnMoveClickListener {
        void onMoveClick(Move move);
    }

    public MoveAdapter(List<Move> moveList, OnMoveClickListener listener) {
        this.moveList = moveList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MoveViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_move, parent, false);
        return new MoveViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoveViewHolder holder, int position) {
        Move move = moveList.get(position);
        holder.name.setText(move.getName());
        //holder.description.setText(move.getDescription());
        holder.image.setImageResource(move.getImageResId());
        holder.learned.setChecked(move.isLearned());

        int difficulty = move.getDifficulty();
        if (move.getDifficulty() <=1 ) {
            holder.difficulty.setText(R.string.super_easy);
            holder.difficulty.setTextAppearance(R.style.SuperEasy);
        } else if (move.getDifficulty() <= 3) {
            holder.difficulty.setText(R.string.easy);
            holder.difficulty.setTextAppearance(R.style.EasyStyle);
        } else if (move.getDifficulty() <= 5) {
            holder.difficulty.setText(R.string.intermediate);
            holder.difficulty.setTextAppearance(R.style.Intermediate);
        } else if (move.getDifficulty() <= 7) {
            holder.difficulty.setText(R.string.advanced);
            holder.difficulty.setTextAppearance(R.style.Advanced);
        } else if (move.getDifficulty() <= 9) {
            holder.difficulty.setText(R.string.parkour_professional);
            holder.difficulty.setTextAppearance(R.style.Pro);
        }
        else if (move.getDifficulty() == 10) {
            holder.difficulty.setText(R.string.urban_demon);
            holder.difficulty.setTextAppearance(R.style.Demon);
        }
        holder.category.setText(move.getCategory());

        holder.itemView.setOnClickListener(v -> listener.onMoveClick(move));
    }

    @Override
    public int getItemCount() {
        return moveList.size();
    }

    static class MoveViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        //TextView description;
        ImageView image;
        CheckBox learned;
        TextView difficulty;
        TextView category;

        public MoveViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.move_name);
            //description = itemView.findViewById(R.id.move_description);
            image = itemView.findViewById(R.id.move_image);
            learned = itemView.findViewById(R.id.move_learned);
            difficulty = itemView.findViewById(R.id.move_difficulty);
            category = itemView.findViewById(R.id.move_category);
        }
    }
}
