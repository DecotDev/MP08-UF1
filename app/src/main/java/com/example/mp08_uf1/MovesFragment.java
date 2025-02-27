/*package com.example.mp08_uf1;

import android.content.SharedPreferences;
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
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MovesFragment extends Fragment {

    private MoveViewModel moveViewModel;
    private MoveAdapter adapter;
    private SharedPreferences sharedPreferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_moves, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        moveViewModel = new ViewModelProvider(requireActivity()).get(MoveViewModel.class);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext());

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewMoves);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<Move> filteredMoves = getFilteredMoves();
        adapter = new MoveAdapter(filteredMoves, move -> {
            moveViewModel.selectMove(move);
            Navigation.findNavController(view).navigate(R.id.action_movesFragment_to_moveDetailFragment);
        });

        recyclerView.setAdapter(adapter);
    }

    private List<Move> getFilteredMoves() {
        List<Move> allMoves = moveViewModel.getMoveList().getValue();
        List<Move> filteredMoves = new ArrayList<>();

        boolean showLearnedMoves = sharedPreferences.getBoolean("show_learned_moves", false);
        boolean showMovesToLearn = sharedPreferences.getBoolean("show_moves_to_learn", false);
        int selectedDifficulty = sharedPreferences.getInt("difficulty_filter", 0);

        for (Move move : allMoves) {
            boolean matchesFilter = true;

            // Filter by learned status
            if (showLearnedMoves && !move.isLearned()) {
                matchesFilter = false;
            }

            if (showMovesToLearn && move.isLearned()) {
                matchesFilter = false;
            }

            // Filter by difficulty
            if (selectedDifficulty > 0 && move.getDifficulty() != selectedDifficulty) {
                matchesFilter = false;
            }

            if (matchesFilter) {
                filteredMoves.add(move);
            }
        }

        return filteredMoves;
    }
}
*/


/* OLD CODE*/
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
