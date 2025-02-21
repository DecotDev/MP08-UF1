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
        moveList.add(new Move("Kong Vault", "A jumping move using hands", R.drawable.baseline_directions_run_24, 6, "Vaults", "https://www.youtube.com/watch?v=kongvault", false));
        moveList.add(new Move("Wall Run", "Run on a wall to reach a high point", R.drawable.baseline_directions_run_24, 8, "Climbing", "https://www.youtube.com/watch?v=wallrun", false));
        moveList.add(new Move("Precision Jump", "Jump precisely from one point to another", R.drawable.baseline_directions_run_24, 5, "Jumps", "https://www.youtube.com/watch?v=precisionjump", false));

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
