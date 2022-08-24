package com.interviewpractice.machineCoding.snakeLadder.service;

import com.interviewpractice.machineCoding.snakeLadder.model.Ladder;
import com.interviewpractice.machineCoding.snakeLadder.model.Player;
import com.interviewpractice.machineCoding.snakeLadder.model.Snake;
import com.interviewpractice.machineCoding.snakeLadder.model.SnakeLadderBoard;

import java.util.*;

public class SnakeLadderService {

    private SnakeLadderBoard snakeLadderBoard;
    private int initialPlayerCount;
    private Queue<Player> players;
    private boolean isGameCompleted;

    private static final int DEFAULT_NO_OF_DICE = 1;
    private static final int DEFAULT_SIZE_OF_BOARD = 100;

    public SnakeLadderService(int boardSize) {
        this.snakeLadderBoard = new SnakeLadderBoard(boardSize);
        this.players = new LinkedList<Player>();
    }

    public SnakeLadderService() {
        this(SnakeLadderService.DEFAULT_SIZE_OF_BOARD);
    }

    public void setPlayers(List<Player> players) {
        this.players = new LinkedList<Player>();
        this.initialPlayerCount = players.size();
        Map<String,Integer> playerPiece = new HashMap<>();
        for(Player player :players)
        {
            this.players.add(player);
            playerPiece.put(player.getId(),0);

        }
        snakeLadderBoard.setPlayerRoll(playerPiece);
    }

    public void setSnakes(List<Snake> snakes) {
        snakeLadderBoard.setSnakeList(snakes);
    }

    public void setLadders(List<Ladder> ladders) {
        snakeLadderBoard.setLadderList(ladders);
    }
    private int getNewPositionAfterGoingThroughSnakesAndLadders(int newPosition) {
        int previousPosition;

        do {
            previousPosition = newPosition;
            for (Snake snake : snakeLadderBoard.getSnakeList()) {
                if (snake.getStartPoint() == newPosition) {
                    newPosition = snake.getEndPoint(); // Whenever a piece ends up at a position with the head of the snake, the piece should go down to the position of the tail of that snake.
                }
            }

            for (Ladder ladder : snakeLadderBoard.getLadderList()) {
                if (ladder.getStartPoint() == newPosition) {
                    newPosition = ladder.getEndPoint(); // Whenever a piece ends up at a position with the start of the ladder, the piece should go up to the position of the end of that ladder.
                }
            }
        } while (newPosition != previousPosition); // There could be another snake/ladder at the tail of the snake or the end position of the ladder and the piece should go up/down accordingly.
        return newPosition;
    }

    private void movePlayer(Player player, int positions) {
        int oldPosition = snakeLadderBoard.getPlayerRoll().get(player.getId());
        int newPosition = oldPosition + positions; // Based on the dice value, the player moves their piece forward that number of cells.

        int boardSize = snakeLadderBoard.getSizeOfBoard();

        // Can modify this logic to handle side case when there are multiple dices (Optional requirements)
        if (newPosition > boardSize) {
            newPosition = oldPosition; // After the dice roll, if a piece is supposed to move outside position 100, it does not move.
        } else {
            newPosition = getNewPositionAfterGoingThroughSnakesAndLadders(newPosition);
        }

        snakeLadderBoard.getPlayerRoll().put(player.getId(), newPosition);

        System.out.println(player.getName() + " rolled a " + positions + " and moved from " + oldPosition +" to " + newPosition);
    }

    private int getTotalValueAfterDiceRolls() {
        // Can use noOfDices and setShouldAllowMultipleDiceRollOnSix here to get total value (Optional requirements)
        return DiceService.roll();
    }

    private boolean hasPlayerWon(Player player) {
        // Can change the logic a bit to handle special cases when there are more than one dice (Optional requirements)
        int playerPosition = snakeLadderBoard.getPlayerRoll().get(player.getId());
        int winningPosition = snakeLadderBoard.getSizeOfBoard();
        return playerPosition == winningPosition; // A player wins if it exactly reaches the position 100 and the game ends there.
    }

    private boolean isGameCompleted() {
        // Can use shouldGameContinueTillLastPlayer to change the logic of determining if game is completed (Optional requirements)
        int currentNumberOfPlayers = players.size();
        return currentNumberOfPlayers < initialPlayerCount;
    }

    public void startGame() {
        while (!isGameCompleted()) {
            int totalDiceValue = getTotalValueAfterDiceRolls(); // Each player rolls the dice when their turn comes.
            Player currentPlayer = players.poll();
            movePlayer(currentPlayer, totalDiceValue);
            if (hasPlayerWon(currentPlayer)) {
                System.out.println(currentPlayer.getName() + " wins the game");
                snakeLadderBoard.getPlayerRoll().remove(currentPlayer.getId());
            } else {
                players.add(currentPlayer);
            }
        }
    }

}

