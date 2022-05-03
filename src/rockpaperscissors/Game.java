package rockpaperscissors;

import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Logan
 */

public class Game {

    private int gameRounds;
    private boolean infiniteRounds;
    private boolean gameOver;
    private String playerHand;
    private String computerHand;
    private int roundCounter;
    private int playerScore;
    private int computerScore;
    private String winner;
    private String statusMsg;
    private String directionMsg;
    private String roundMsg;
    private String playerName;
    

    public void setGameRounds(int oneOrFive) {
        gameRounds = oneOrFive;
        infiniteRounds = false;
        setupNewGame();
    }
    
    public void setInfinite() {
        infiniteRounds = true;
        setupNewGame();
    }
    
    private void setupNewGame() {
        gameOver = false;
        roundCounter = 1;
        computerHand = "???";
        playerHand = "";
        playerScore = 0;
        computerScore = 0;
        winner = "";
        statusMsg = "";
        directionMsg = "Choose Rock, Paper, or Scissors";
        roundMsg = "Round 1";
    }

    public void playRound() {
        setComputerHand();
        setWinner();
        setStatusMsg();
        setRoundMsg();
        setDirectionMsg();
        isGameOver();
    }

    public void setHand(String playerChoice){
        playerHand = playerChoice;
    }
    
    private void setComputerHand() {
        Random rand = new Random();
        int randNum = rand.nextInt(3);
        switch(randNum) {
            case 0:
                computerHand = "Rock";
                break;
            case 1:
                computerHand = "Paper";
                break;
            case 2:
                computerHand = "Scissors";
                break;
            default:
                computerHand = "???";
        }
    }
    
    public String getComputerHand() {
        return computerHand;
    }
    
    private void setWinner() {
        if (playerHand == computerHand){
            winner = "Tie";
        } else if (playerHand == "Rock"){
            if (computerHand == "Paper") {
                winner = "Computer";
                computerScore++;
            } else if (computerHand == "Scissors") {
                winner = "You";
                playerScore++;
            }
        } else if (playerHand == "Paper") {
            if (computerHand == "Rock") {
                winner = "You";
                playerScore++;
            } else if (computerHand == "Scissors") {
                winner = "Computer";
                computerScore++;
            }
        } else if (playerHand == "Scissors") {
            if (computerHand == "Rock"){
                winner = "Computer";
                computerScore++;
            } else if (computerHand == "Paper") {
                winner = "You";
                playerScore++;
            }  
        }
    }
    
    public String getWinner() {
        return winner;
    }
    
    public void setRoundMsg() {
        if (winner != "Tie") {
            roundCounter += 1;
            roundMsg = "Round " + roundCounter;
        } else {
            roundMsg = "Round " + roundCounter;
        }
    }
    
    public String getRoundMsg() {
        return roundMsg;
    }
    
    public void setStatusMsg() {
        if (winner == "Tie") {
            statusMsg = "Replay round " + roundCounter;
        } else if (winner == "You"){
            statusMsg = "won round " + roundCounter;
        } else if (winner == "Computer") {
            statusMsg = "wins round " + roundCounter;
        }
    }
    
    public String getStatusMsg() {
        return statusMsg;
    }
    
    public void setDirectionMsg() {
        if ((roundCounter == 1) && (winner == "")) {
            directionMsg = "Select either Rock, Paper, or Scissors to play";
        } else {
            directionMsg = "Make another selection for Round " + roundCounter;
        }
    }
    
    public String getDirectionMsg(){
        return directionMsg;
    }
    
    public int getPlayerScore() {
        return playerScore;
    }
    
    public int getComputerScore() {
        return computerScore;
    }
            
    private void isGameOver() {
        if (infiniteRounds == true) {
            gameOver = false;
        } else if (roundCounter <= gameRounds) {
            gameOver = false;
        } else {
            endGame();
        }
    }
    
    private void determineGameWinner() {
        if (playerScore == computerScore){
            winner = "Draw";
        } else if (playerScore > computerScore) {
            winner = "You Won!";
        } else {
            winner = "You Lost!";
        }
    }
    
    public void endGame() {
        gameOver = true;
        roundMsg = "Game Over";
        statusMsg = "";
        directionMsg = "";
        determineGameWinner();
    }
    
    public boolean getGameOver() {
        return gameOver;
    }
    
    public void playAgain(){
        setupNewGame();
    }
}