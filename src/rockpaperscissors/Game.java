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
        determineWinner();
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
    
    private void determineWinner() {
        if (playerHand == computerHand){
            winner = "Tie";
            statusMsg = "Replay round " + roundCounter;
            directionMsg = "Make another selection to keep playing";
        } else if (playerHand == "Rock"){
            if (computerHand == "Paper") {
                winner = "Computer";
                statusMsg = "wins round " + roundCounter;
                directionMsg = "Make another selection to keep playing";
                computerScore++;
            } else if (computerHand == "Scissors") {
                winner = "You";
                statusMsg = "won round " + roundCounter;
                directionMsg = "Make another selection to keep playing";
                playerScore++;
            }
        } else if (playerHand == "Paper") {
            if (computerHand == "Rock") {
                winner = "You";
                statusMsg = "won round " + roundCounter;
                directionMsg = "Make another selection to keep playing";
                playerScore++;
            } else if (computerHand == "Scissors") {
                winner = "Computer";
                statusMsg = "wins round " + roundCounter;
                directionMsg = "Make another selection to keep playing";
                computerScore++;
            }
        } else if (playerHand == "Scissors") {
            if (computerHand == "Rock"){
                winner = "Computer";
                statusMsg = "wins round " + roundCounter;
                directionMsg = "Make another selection to keep playing";
                computerScore++;
            } else if (computerHand == "Paper") {
                winner = "You";
                statusMsg = "won round " + roundCounter;
                directionMsg = "Make another selection to keep playing";
                playerScore++;
            }  
        }
    }
    
    public String getWinner() {
        return winner;
    }
    
    public String getRound() {
        return roundMsg;
    }
        
    public String getStatusMsg() {
        return statusMsg;
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
            if (winner != "Tie") {
                roundCounter += 1;
                roundMsg = "Round " + roundCounter;
            }
            
        } else if (roundCounter < gameRounds) {
            gameOver = false;
            if (winner != "Tie") {
                roundCounter += 1;
                roundMsg = "Round " + roundCounter;
            }
        } else if (roundCounter > gameRounds) {
            gameOver = true;
            if (winner != "Tie") {
                roundMsg = "Round " + roundCounter;
                roundCounter += 1;
                endGame();
            }
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
    
    public void endGame(){
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