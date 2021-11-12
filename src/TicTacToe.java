/**
 * 
 */

/**
 * TicTacToe class which keeps track of a tictactoe game board and determines 
 * the winner of the game and if a marker can be placed in the board
 * @author Tyler Marefke, Tiernan Meyer
 * @date 11/7/2021
 * @version 11.7.2021
 */
public class TicTacToe {
	private char[][] gameBoard = new char[3][3];
	private char currentPlayer;
	private int numberOfOpenSlots;
	
	
	/**
	 * Default constructor for the TicTacToe class
	 * current player is set to X, number of open slots is set to 9,
	 * and the game board is filled with blank spaces
	 */
	public TicTacToe() {
		this.currentPlayer = 'X';
		this.numberOfOpenSlots = 9;
		for(int i = 0; i < gameBoard.length; i++) {
			for(int j = 0; j < gameBoard[i].length; j++) {
				this.gameBoard[i][j] = ' ';
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
		for(int i = 0; i < gameBoard.length; i++) {
			for(int j = 0; j < gameBoard[i].length; j++) {
				this.gameBoard[i][j] = other.gameBoard[i][j];
			}
		}
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
	public boolean placeMarkerInBoard(int xLocation, int yLocation) {
		if(xLocation < 0 || xLocation > gameBoard.length - 1 || yLocation < 0 || yLocation > gameBoard.length - 1 || gameBoard[yLocation][xLocation] != ' ')
			return false;
		else {
			gameBoard[yLocation][xLocation] = currentPlayer;
			numberOfOpenSlots--;
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
			if(gameBoard[yLocation][i] == currentPlayer)
				row++;
			if(gameBoard[i][xLocation] == currentPlayer)
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
		
		//Changes the marker from X to O and O to X
		if(currentPlayer == 'X')
			currentPlayer = 'O';
		else
			currentPlayer = 'X';
		
		//Returns minimaxCheck to continue the game
		return currentPlayer;
	}
	
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
