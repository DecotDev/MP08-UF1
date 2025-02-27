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
        moveList.add(new Move("Kong Vault", "A jumping move using hands", R.drawable.vault, 3, "Vaults", "https://www.youtube.com/watch?v=kongvault", false));
        moveList.add(new Move("Kash Vault", "A mix between a Kong and Dash vault", R.drawable.speed_vault, 7, "Vaults", "https://www.youtube.com/watch?v=kashvault", false));
        moveList.add(new Move("Wall Run", "Run on a wall to reach a high point", R.drawable.wall_hold, 5, "Climbing", "https://www.youtube.com/watch?v=wallrun", false));
        moveList.add(new Move("Precision Jump", "Jump precisely from one point to another", R.drawable.preci_jump, 3, "Jumps", "https://www.youtube.com/watch?v=precisionjump", false));
        moveList.add(new Move("Splash to Back", "Jump on a vertical wall, land with a splash and backflip from it", R.drawable.backflip, 10 ,"Tricks","https://www.instagram.com/reel/CzWjG7JNUrj/?utm_source=ig_web_copy_link&igsh=MzRlODBiNWFlZA==", false));
        moveList.add(new Move("Dash Vault", "A vault using one hand and legs extended forward", R.drawable.speed_vault, 2, "Vaults", "https://www.youtube.com/watch?v=dashvault", false));
        moveList.add(new Move("Tic Tac", "Push off a wall to change direction or gain height", R.drawable.wall_hold, 3, "Wall Moves", "https://www.youtube.com/watch?v=tictac", false));
        moveList.add(new Move("Dive Roll", "A roll performed after a dive", R.drawable.side, 8, "Safety", "https://www.youtube.com/watch?v=diveroll", false));
        moveList.add(new Move("Lazy Vault", "A smooth vault using one hand and one leg", R.drawable.vault, 4, "Vaults", "https://www.youtube.com/watch?v=lazyvault", false));
        moveList.add(new Move("Underbar", "Swing through a bar or gap", R.drawable.wall_hold, 1, "Bar Moves", "https://www.youtube.com/watch?v=underbar", false));
        moveList.add(new Move("Cat Grab", "Jump to a wall and grab onto a ledge", R.drawable.wall_hold, 4, "Climbing", "https://www.youtube.com/watch?v=catgrab", false));
        moveList.add(new Move("Speed Vault", "A fast one-handed vault over an obstacle", R.drawable.speed_vault, 6, "Vaults", "https://www.youtube.com/watch?v=speedvault", false));
        moveList.add(new Move("Roll", "A forward roll to absorb impact", R.drawable.side, 7, "Safety", "https://www.youtube.com/watch?v=parkourroll", false));
        moveList.add(new Move("Palm Spin", "Spin on a wall using hands for support", R.drawable.backflip, 7, "Wall Moves", "https://www.youtube.com/watch?v=palmspin", false));
        moveList.add(new Move("Turn Vault", "Vault over an obstacle while turning mid-air", R.drawable.vault, 4, "Vaults", "https://www.youtube.com/watch?v=turnvault", false));
        moveList.add(new Move("Rail Balance", "Walking or balancing on a rail", R.drawable.preci_jump, 4, "Balance", "https://www.youtube.com/watch?v=railbalance", false));
        moveList.add(new Move("Wall Pop", "Push off a wall to gain height", R.drawable.wall_hold, 6, "Wall Moves", "https://www.youtube.com/watch?v=wallpop", false));
        moveList.add(new Move("Stride", "Leaping from one point to another using long steps", R.drawable.preci_jump, 4, "Jumps", "https://www.youtube.com/watch?v=stride", false));

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
