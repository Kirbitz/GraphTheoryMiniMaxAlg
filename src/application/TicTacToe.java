package application;

import java.util.HashMap;

/**
 * 
 */

/**
 * TicTacToe class which keeps track of a TicTacToe game board and determines 
 * the winner of the game and if a marker can be placed in the board
 * @author Tyler Marefke, Tiernan Meyer
 * @date 11/7/2021
 * @version 11.7.2021
 */
public class TicTacToe {
	private char[][] gameBoard = new char[3][3];
	private char currentPlayer;
	private int numberOfOpenSlots;
	private HashMap<Integer, Coordinate> coordinates;
	
	/**
	 * Default constructor for the TicTacToe class
	 * current player is set to X, number of open slots is set to 9,
	 * and the game board is filled with blank spaces
	 */
	public TicTacToe() {
		this.currentPlayer = 'X';
		this.numberOfOpenSlots = 9;
		this.coordinates = new HashMap<Integer, Coordinate>();
		for(int i = 0; i < gameBoard.length; i++) {
			for(int j = 0; j < gameBoard[i].length; j++) {
				this.gameBoard[i][j] = ' ';
				this.coordinates.put((3*i) + j, new Coordinate(i, j));
			}
		}
	}

	/**
	 * Copy constructor for the TicTacToe class
	 * Copies the current player, numberOfOpenSlots, and gameBoard from other
	 */
	public TicTacToe(TicTacToe other) {
		this.currentPlayer = other.currentPlayer;
		this.numberOfOpenSlots = other.numberOfOpenSlots;
		this.coordinates = new HashMap<Integer, Coordinate>(new HashMap<Integer, Coordinate>(other.coordinates));
		for(int i = 0; i < gameBoard.length; i++) {
			for(int j = 0; j < gameBoard[i].length; j++) {
				this.gameBoard[i][j] = other.gameBoard[i][j];
			}
		}
	}
	
	/*
	 * Prints commandline data for the hashmap with key and value placements
	 */
	public void printHash() {
	  for(int i : coordinates.keySet()) {
	    System.out.println(i + " " + coordinates.get(i));
	  }
	}
	
	/**
	 * Returns a list of the available coordinates
	 * @return coordinates - the list of available coordinates
	 */
	public HashMap<Integer, Coordinate> getCoordinates() {
		return coordinates;
	}
	
	/**
	 * Returns the gameBoard from tictactoe
	 * @return gameBoard - the current TicTacToe board
	 */
	public char[][] getGameBoard() {
		return gameBoard;
	}
	/**
	 * Returns the currentPlayer in TicTacToe
	 * @return currentPlayer - the current player to play
	 */
	public char getCurrentPlayer() {
		return currentPlayer;
	}
	
	/**
	 * Sets the current player to the passed in value
	 * @param player - the player to set
	 */
	public void setCurrentPlayer(char player) {
		currentPlayer = player;
	}
	/**
	 * Returns the number of available slots on the TicTacToe board
	 * @return numberOfOpenSlots - the number of available slots in the TicTacToe board
	 */
	public int getNumberOfOpenSlots() {
		return numberOfOpenSlots;
	}
	
	/**
	 * Places the marker of the current player into the game board
	 * @return true - if the marker was successfully place, false - if the marker failed to be placed
	 */
	public boolean placeMarkerInBoard(int coordLocation, int xLocation, int yLocation) {
		if(xLocation < 0 || xLocation > gameBoard.length - 1 || yLocation < 0 || yLocation > gameBoard.length - 1 || gameBoard[xLocation][yLocation] != ' ')
			return false;
		else {
			gameBoard[xLocation][yLocation] = currentPlayer;
			numberOfOpenSlots--;
			coordinates.remove(coordLocation);
			return true;
		}
	}
	
	/**
	 * Removes a marker from the board at the x and y location also adds coordinate back into linked list at pos
	 * @param xLocation - the x location to remove from
	 * @param yLocation - the y location to remove from
	 * @param pos - the position to add the coordinate back into
	 * @return if the removal was a success
	 */
	public boolean removeMarkerFromBoard(int coordLocation, int xLocation, int yLocation) {
		if(xLocation < 0 || xLocation > gameBoard.length - 1 || yLocation < 0 || yLocation > gameBoard.length - 1 || gameBoard[xLocation][yLocation] == ' ')
			return false;
		else {
			gameBoard[xLocation][yLocation] = ' ';
			numberOfOpenSlots++;
			coordinates.put(coordLocation, new Coordinate(xLocation, yLocation));
			return true;
		}
	}
	
	/**
	 * Checks if a player has won the TicTacToe game
	 * @param xLocation - the last x location that a marker was placed
	 * @param yLocation - the last y location that a marker was placed
	 * @param minimaxCheck - the check value to see if the minimax won or not
	 * @return 1 - if X won, -1 - if O won, 0 - if the board is filled and no one won, currentPlayer - if the game is not finished
	 */
	public int isWinner(int xLocation, int yLocation) {
		int row = 0, col = 0, diag = 0, rDiag = 0;
		//Loops through the last placed marker location
		for(int i = 0; i < gameBoard.length; i++) {
			//if statements check if the position is equal to the current marker and increments the appropriate value
			if(gameBoard[xLocation][i] == currentPlayer)
				row++;
			if(gameBoard[i][yLocation] == currentPlayer)
				col++;
			if(gameBoard[i][i] == currentPlayer)
				diag++;
			if(gameBoard[gameBoard.length - 1 - i][i] == currentPlayer)
				rDiag++;
		}
		
		//Checks if 3 current player markers are in a row then determines the marker that won
		if(row == gameBoard.length || col == gameBoard.length || diag == gameBoard.length || rDiag == gameBoard.length) {
			//Checks if the minimax alg won or the player won
			if(currentPlayer == 'X')
				return 1;
			else
				return -1;
		}
		
		//Checks if the board is filled
		if(numberOfOpenSlots == 0)
			return 0;
		
		//Returns minimaxCheck to continue the game
		return currentPlayer;
	}
	
	/**
	 * Changes the current player from X to O and O to X
	 */
	public void changePlayer() {
		if(currentPlayer == 'X')
			currentPlayer = 'O';
		else
			currentPlayer = 'X';
	}
	
	/**
	 * Command line form of the board
	 */
	public String toString() {
		String result = "";
		for(int i = 0; i < gameBoard.length; i++) {
			result += " " + gameBoard[i][0] + " ";
			for(int j = 1; j < gameBoard.length; j++) {
				result += "| " + gameBoard[i][j] + " ";
			}
			result += "\n";
			if(i != gameBoard.length - 1)
				for(int k = 0; k < (4 * gameBoard.length) - 1; k++)
					result += "-";
			result += "\n";
		}
		return result;
	}
}
