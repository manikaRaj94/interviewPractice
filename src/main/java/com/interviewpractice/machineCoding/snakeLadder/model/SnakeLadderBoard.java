package com.interviewpractice.machineCoding.snakeLadder.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnakeLadderBoard {

    private int sizeOfBoard;
    private List<Snake> snakeList;
    private List<Ladder> ladderList;
    private Map<String,Integer> playerRoll;

    public SnakeLadderBoard(int sizeOfBoard) {
        this.sizeOfBoard = sizeOfBoard;
        this.snakeList = new ArrayList<>();
        this.ladderList = new ArrayList<>();
        this.playerRoll = new HashMap<>();
    }

    public int getSizeOfBoard() {
        return sizeOfBoard;
    }

    public void setSizeOfBoard(int sizeOfBoard) {
        this.sizeOfBoard = sizeOfBoard;
    }

    public List<Snake> getSnakeList() {
        return snakeList;
    }

    public void setSnakeList(List<Snake> snakeList) {
        this.snakeList = snakeList;
    }

    public List<Ladder> getLadderList() {
        return ladderList;
    }

    public void setLadderList(List<Ladder> ladderList) {
        this.ladderList = ladderList;
    }

    public Map<String, Integer> getPlayerRoll() {
        return playerRoll;
    }

    public void setPlayerRoll(Map<String, Integer> playerRoll) {
        this.playerRoll = playerRoll;
    }
}
