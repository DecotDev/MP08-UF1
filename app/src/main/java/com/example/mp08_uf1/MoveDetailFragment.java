package com.example.mp08_uf1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
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

        Button videoButton = view.findViewById(R.id.move_video_button);
        videoButton.setOnClickListener(v -> {
            Move selectedMove = moveViewModel.getSelectedMove().getValue();
            if (selectedMove != null) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(selectedMove.getVideoUrl()));
                startActivity(intent);
            }
        });


        CheckBox learnedCheckBox = view.findViewById(R.id.move_learned);

        moveViewModel.getSelectedMove().observe(getViewLifecycleOwner(), move -> {
            if (move != null) {
                name.setText(move.getName());
                description.setText(move.getDescription());
                image.setImageResource(move.getImageResId());
                difficulty.setText("Difficulty: " + move.getDifficulty());
                category.setText(move.getCategory());
                learnedCheckBox.setChecked(move.isLearned());
            }
        });

        learnedCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Move selectedMove = moveViewModel.getSelectedMove().getValue();
            if (selectedMove != null) {
                selectedMove.setLearned(isChecked);
                moveViewModel.updateMove(selectedMove); // Update ViewModel
            }
        });
    }
}
