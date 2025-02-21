package com.example.mp08_uf1;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class MoveViewModel extends ViewModel {
    private final MutableLiveData<List<Move>> moveListLiveData = new MutableLiveData<>();
    private final MutableLiveData<Move> selectedMove = new MutableLiveData<>();

    public MoveViewModel() {
        List<Move> moveList = new ArrayList<>();
        moveList.add(new Move("Kong Vault", "A jumping move using hands", R.drawable.baseline_directions_run_24, 3, "Vaults", "https://www.youtube.com/watch?v=kongvault", false));
        moveList.add(new Move("Wall Run", "Run on a wall to reach a high point", R.drawable.baseline_directions_run_24, 5, "Climbing", "https://www.youtube.com/watch?v=wallrun", false));
        moveList.add(new Move("Precision Jump", "Jump precisely from one point to another", R.drawable.baseline_directions_run_24, 3, "Jumps", "https://www.youtube.com/watch?v=precisionjump", false));
        moveList.add(new Move("Dash Vault", "A vault using one hand and legs extended forward", R.drawable.baseline_directions_run_24, 2, "Vaults", "https://www.youtube.com/watch?v=dashvault", false));
        moveList.add(new Move("Tic Tac", "Push off a wall to change direction or gain height", R.drawable.baseline_directions_run_24, 3, "Wall Moves", "https://www.youtube.com/watch?v=tictac", false));
        moveList.add(new Move("Lazy Vault", "A smooth vault using one hand and one leg", R.drawable.baseline_directions_run_24, 4, "Vaults", "https://www.youtube.com/watch?v=lazyvault", false));
        moveList.add(new Move("Underbar", "Swing through a bar or gap", R.drawable.baseline_directions_run_24, 1, "Bar Moves", "https://www.youtube.com/watch?v=underbar", false));
        moveList.add(new Move("Cat Grab", "Jump to a wall and grab onto a ledge", R.drawable.baseline_directions_run_24, 4, "Climbing", "https://www.youtube.com/watch?v=catgrab", false));
        moveList.add(new Move("Speed Vault", "A fast one-handed vault over an obstacle", R.drawable.baseline_directions_run_24, 6, "Vaults", "https://www.youtube.com/watch?v=speedvault", false));
        moveList.add(new Move("Roll", "A forward roll to absorb impact", R.drawable.baseline_directions_run_24, 7, "Safety", "https://www.youtube.com/watch?v=parkourroll", false));
        moveList.add(new Move("Palm Spin", "Spin on a wall using hands for support", R.drawable.baseline_directions_run_24, 7, "Wall Moves", "https://www.youtube.com/watch?v=palmspin", false));
        moveList.add(new Move("Wall Climb", "Climb up a tall wall with momentum", R.drawable.baseline_directions_run_24, 4, "Climbing", "https://www.youtube.com/watch?v=wallclimb", false));
        moveList.add(new Move("Turn Vault", "Vault over an obstacle while turning mid-air", R.drawable.baseline_directions_run_24, 4, "Vaults", "https://www.youtube.com/watch?v=turnvault", false));
        moveList.add(new Move("Kash Vault", "A mix between a Kong and Dash vault", R.drawable.baseline_directions_run_24, 7, "Vaults", "https://www.youtube.com/watch?v=kashvault", false));
        moveList.add(new Move("Rail Balance", "Walking or balancing on a rail", R.drawable.baseline_directions_run_24, 4, "Balance", "https://www.youtube.com/watch?v=railbalance", false));
        moveList.add(new Move("Dive Roll", "A roll performed after a dive", R.drawable.baseline_directions_run_24, 8, "Safety", "https://www.youtube.com/watch?v=diveroll", false));
        moveList.add(new Move("Wall Pop", "Push off a wall to gain height", R.drawable.baseline_directions_run_24, 6, "Wall Moves", "https://www.youtube.com/watch?v=wallpop", false));
        moveList.add(new Move("Stride", "Leaping from one point to another using long steps", R.drawable.baseline_directions_run_24, 4, "Jumps", "https://www.youtube.com/watch?v=stride", false));

        moveListLiveData.setValue(moveList);
    }

    public LiveData<List<Move>> getMoveList() {
        return moveListLiveData;
    }

    public void selectMove(Move move) {
        selectedMove.setValue(move);
    }

    public LiveData<Move> getSelectedMove() {
        return selectedMove;
    }
}
