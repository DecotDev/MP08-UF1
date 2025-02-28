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
        moveList.add(new Move("Kong Vault", "A powerful vault where the practitioner jumps forward, placing both hands on the obstacle and tucking the legs underneath to clear it smoothly. It is commonly used for speed and efficiency.", R.drawable.vault, 3, "Vaults", "https://youtube.com/shorts/OTpJOBM4PwM?si=U3HvPOw7hC8nxpvm", false));
        moveList.add(new Move("Kash Vault", "A hybrid move combining elements of a Kong and Dash vault. The athlete initiates with a Kong but transitions mid-air to extend the legs forward like a Dash Vault, creating a stylish and fluid motion.", R.drawable.speed_vault, 7, "Vaults", "https://youtu.be/_Nx5E8_24ro", false));
        moveList.add(new Move("Wall Run", "A fundamental parkour technique where the practitioner runs at a wall at an angle, using momentum to push off the surface and reach a higher point, often used to scale walls or reach ledges.", R.drawable.wall_hold, 5, "Climbing", "https://www.youtube.com/watch?v=wallrun", false));
        moveList.add(new Move("Precision Jump", "A controlled jump requiring accuracy and balance, where the practitioner leaps from one narrow surface to another, often performed on rails, ledges, or small platforms.", R.drawable.preci_jump, 3, "Jumps", "https://youtu.be/9sb4TYNHGio?si=3N76m4OeGjrsc5Dv", false));
        moveList.add(new Move("Splash to Back", "An advanced trick where the athlete jumps against a vertical wall, lands in a controlled squat (splash position), then uses the rebound to perform a backflip, requiring both power and timing.", R.drawable.backflip, 10, "Tricks", "https://www.instagram.com/reel/CzWjG7JNUrj/?utm_source=ig_web_copy_link&igsh=MzRlODBiNWFlZA==", false));
        moveList.add(new Move("Dash Vault", "A dynamic vault where the practitioner hurdles over an obstacle with one hand while extending both legs forward, creating a diving motion before landing smoothly on the other side.", R.drawable.speed_vault, 2, "Vaults", "https://youtu.be/9E-QcfGC0rQ", false));
        moveList.add(new Move("Tic Tac", "A movement used to push off a vertical surface to gain height or change direction. By kicking off the wall with one foot, practitioners can transition to another move or clear obstacles.", R.drawable.wall_hold, 3, "Wall Moves", "https://youtu.be/8VnGI31lp0w", false));
        moveList.add(new Move("Dive Roll", "A safety technique where the practitioner jumps forward, tucks, and rolls upon landing to distribute impact. It is often used after long drops or to recover from high-speed movements.", R.drawable.side, 8, "Safety", "https://youtu.be/GHGUNOrW9RE?si=JCDRx5cvr9chKfUi", false));
        moveList.add(new Move("Lazy Vault", "A relaxed and efficient vault where one hand and one leg are used to clear an obstacle, with the body rotating sideways to land in a controlled position on the other side.", R.drawable.vault, 4, "Vaults", "https://youtu.be/3bLX2VJZMgk?si=MgH3xAnEdan32so6", false));
        moveList.add(new Move("Underbar", "A swinging movement where the practitioner passes through a horizontal bar or a gap by grabbing it and tucking their legs to glide through smoothly.", R.drawable.wall_hold, 1, "Bar Moves", "https://youtu.be/ZKSaCLPsYj0", false));
        moveList.add(new Move("Cat Grab", "A climbing move where the practitioner jumps to a wall and grabs onto a ledge with both hands while placing their feet against the wall for control and balance before pulling up.", R.drawable.wall_hold, 4, "Climbing", "https://youtu.be/4AEr7PB_vPs", false));
        moveList.add(new Move("Speed Vault", "A quick and efficient vault where the practitioner clears an obstacle using one hand while keeping forward momentum, commonly used in fast-paced runs.", R.drawable.speed_vault, 6, "Vaults", "https://youtu.be/ar-pYbemlXw", false));
        moveList.add(new Move("Roll", "A fundamental movement in parkour used to absorb impact from jumps or falls by rolling over the shoulder, reducing stress on the joints and allowing smooth transitions.", R.drawable.side, 7, "Safety", "https://youtu.be/6x-cG9giKXY", false));
        moveList.add(new Move("Palm Spin", "A stylish wall move where the practitioner places both hands on a vertical surface and spins their body around, using momentum to land in a controlled stance.", R.drawable.backflip, 7, "Wall Moves", "https://youtu.be/h0_oyA7FC_o", false));
        moveList.add(new Move("Turn Vault", "A technique where the practitioner vaults over an obstacle while turning mid-air, often used to reposition and land facing the opposite direction.", R.drawable.vault, 4, "Vaults", "https://youtu.be/3tip1pMXBoM", false));
        moveList.add(new Move("Rail Balance", "A precision skill where the practitioner walks or balances along a rail, requiring focus, core stability, and foot control to maintain steady movement.", R.drawable.preci_jump, 4, "Balance", "https://youtu.be/bkdQi110W9I", false));
        moveList.add(new Move("Wall Pop", "A technique where the practitioner jumps against a wall and pushes off with their feet to gain extra height, often used in combination with wall runs.", R.drawable.wall_hold, 6, "Wall Moves", "https://youtu.be/iDVfO6Rodbw", false));
        moveList.add(new Move("Stride", "A movement where the practitioner takes long, leaping steps between obstacles or platforms, maintaining forward momentum and fluidity in motion.", R.drawable.preci_jump, 4, "Jumps", "https://youtu.be/oR9dWnI4tps", false));

        moveListLiveData.setValue(moveList);
    }

    public void updateMove(Move updatedMove) {
        List<Move> currentMoves = moveListLiveData.getValue();
        if (currentMoves != null) {
            for (Move move : currentMoves) {
                if (move.getName().equals(updatedMove.getName())) { // Find the matching move
                    move.setLearned(updatedMove.isLearned());
                    break;
                }
            }
            moveListLiveData.setValue(currentMoves); // Notify observers
        }
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
