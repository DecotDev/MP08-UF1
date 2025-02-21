package com.example.mp08_uf1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class MoveDetailFragment extends Fragment {

    private MoveViewModel moveViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_move_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        moveViewModel = new ViewModelProvider(requireActivity()).get(MoveViewModel.class);

        TextView name = view.findViewById(R.id.detail_move_name);
        TextView description = view.findViewById(R.id.detail_move_description);
        ImageView image = view.findViewById(R.id.detail_move_image);
        TextView difficulty = view.findViewById(R.id.detail_move_difficulty);
        TextView category = view.findViewById(R.id.move_category);


        moveViewModel.getSelectedMove().observe(getViewLifecycleOwner(), move -> {
            name.setText(move.getName());
            description.setText(move.getDescription());
            image.setImageResource(move.getImageResId());
            difficulty.setText("Diffculty: " + String.valueOf(move.getDifficulty()));
            category.setText(move.getCategory());
        });
    }
}
