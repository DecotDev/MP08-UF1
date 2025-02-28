package com.example.mp08_uf1;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MoveAdapter extends RecyclerView.Adapter<MoveAdapter.MoveViewHolder> {
    private List<Move> moveList;
    private OnMoveClickListener listener;
    private MoveViewModel moveViewModel;

    public interface OnMoveClickListener {
        void onMoveClick(Move move);
    }

    public MoveAdapter(List<Move> moveList, MoveViewModel moveViewModel, OnMoveClickListener listener) {
        this.moveList = moveList;
        this.moveViewModel = moveViewModel; // Assign ViewModel
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
        holder.image.setImageResource(move.getImageResId());

        // Remove previous listener to prevent unexpected behavior
        holder.learned.setOnCheckedChangeListener(null);

        // Set correct state for checkbox
        holder.learned.setChecked(move.isLearned());

        // Set background color based on learned state
        int difficultyColor = getDifficultyColor(holder.itemView.getContext(), move.getDifficulty());
        if (move.isLearned()) {
            holder.itemContainer.setBackground(getGradientDrawable(holder.itemView.getContext(), difficultyColor));
        } else {
            holder.itemContainer.setBackgroundResource(R.drawable.round_slight_grey);
        }

        // Now, set the new listener
        holder.learned.setOnCheckedChangeListener((buttonView, isChecked) -> {
            move.setLearned(isChecked);
            moveViewModel.updateMove(move);

            if (isChecked) {
                holder.itemContainer.setBackground(getGradientDrawable(holder.itemView.getContext(), difficultyColor));
            } else {
                holder.itemContainer.setBackgroundResource(R.drawable.round_slight_grey);
            }
        });
        holder.itemView.setOnClickListener(v -> listener.onMoveClick(move));




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

    private int getDifficultyColor(Context context, int difficulty) {
        if (difficulty <= 1) return ContextCompat.getColor(context, R.color.super_easy);
        else if (difficulty <= 3) return ContextCompat.getColor(context, R.color.easy);
        else if (difficulty <= 5) return ContextCompat.getColor(context, R.color.intermediate);
        else if (difficulty <= 7) return ContextCompat.getColor(context, R.color.advanced);
        else if (difficulty <= 9) return ContextCompat.getColor(context, R.color.pro);
        else return ContextCompat.getColor(context, R.color.demon);
    }

    private Drawable getGradientDrawable(Context context, int endColor) {
        GradientDrawable gradientDrawable = new GradientDrawable(
                GradientDrawable.Orientation.LEFT_RIGHT,
                new int[]{ContextCompat.getColor(context, R.color.slight_grey), endColor}
        );
        gradientDrawable.setCornerRadius(42f); // Optional corner radius
        return gradientDrawable;
    }

    @Override
    public int getItemCount() {
        return moveList.size();
    }

    static class MoveViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView image;
        CheckBox learned;
        TextView difficulty;
        TextView category;
        ConstraintLayout itemContainer; // New reference

        public MoveViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.move_name);
            image = itemView.findViewById(R.id.move_image);
            learned = itemView.findViewById(R.id.move_learned);
            difficulty = itemView.findViewById(R.id.move_difficulty);
            category = itemView.findViewById(R.id.move_category);
            itemContainer = itemView.findViewById(R.id.item_container); // Assign ConstraintLayout
        }
    }
}
