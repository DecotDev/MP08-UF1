package com.example.mp08_uf1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MovesFragment extends Fragment {

    private MoveViewModel moveViewModel;
    private MoveAdapter adapter;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_moves, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        moveViewModel = new ViewModelProvider(requireActivity()).get(MoveViewModel.class);
        navController = Navigation.findNavController(view);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewMoves);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new MoveAdapter(moveViewModel.getMoveList().getValue(), move -> {
            moveViewModel.selectMove(move);
            navController.navigate(R.id.action_movesFragment_to_moveDetailFragment);
        });

        recyclerView.setAdapter(adapter);
    }
}
