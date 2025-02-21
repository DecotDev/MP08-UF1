package com.example.mp08_uf1;

public class Move {
    private String name;
    private String description;
    private int imageResId;
    private int difficulty;
    private String category;
    private String videoUrl;
    private boolean learned;

    public Move(String name, String description, int imageResId, int difficulty, String category, String videoUrl, boolean learned) {
        this.name = name;
        this.description = description;
        this.imageResId = imageResId;
        this.difficulty = difficulty;
        this.category = category;
        this.videoUrl = videoUrl;
        this.learned = learned;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public int getImageResId() {
        return imageResId;
    }
    public int getDifficulty() {
        return difficulty;
    }
    public String getCategory() {
        return category;
    }
    public String getVideoUrl() {
        return videoUrl;
    }
    public boolean isLearned() {
        return learned;
    }

    public void setLearned(boolean learned) {
        this.learned = learned;
    }
}