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
        holder.description.setText(move.getDescription());
        holder.image.setImageResource(move.getImageResId());
        holder.learned.setChecked(move.isLearned());

        holder.itemView.setOnClickListener(v -> listener.onMoveClick(move));
    }

    @Override
    public int getItemCount() {
        return moveList.size();
    }

    static class MoveViewHolder extends RecyclerView.ViewHolder {
        TextView name, description;
        ImageView image;
        CheckBox learned;

        public MoveViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.move_name);
            description = itemView.findViewById(R.id.move_description);
            image = itemView.findViewById(R.id.move_image);
            learned = itemView.findViewById(R.id.move_learned);
        }
    }
}
