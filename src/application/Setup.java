package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;

/**
 * Setup class which sets up the Graphic User Interface of the TicTacToe program
 * @author Tyler Marefke, Tiernan Meyer
 * @date 11/10/2021
 * @version 11.10.2021
 */

public class Setup extends BorderPane {
	private AnchorPane startPane, gamePane;
	private Text start, gameText;
	private Font startFont, buttonFont;
	private Button startButton, restart;
	private Button[][] buttonArray = new Button[3][3];
	private Stage window;
	private Scene gameScreen;
	private BorderPane game;
	private char text;
	private String string;
	private TicTacToe TTT;
	private int win;
	private boolean isWin = false;

	
	/*
	 * Sets up the GUI
	 */
	public Setup() {
		window = main.getStage();
		setStartScreen();
		initiateButtonsArray();
		TTT = new TicTacToe();
	}
	
	/*
	 * Sets the start screen up, where the user can choose to start
	 */
	private void setStartScreen() {
		try {
			startPane = new AnchorPane();
			start = new Text("Click the button\nbelow to start");
			startFont = new Font("Courier", 60);
			start.setFont(startFont);
			startButton = new Button("START");
			startButton.setFont(startFont);
			startButton.setOnAction(this::processAction);
			startButton.setStyle("-fx-background-color: white;" + "-fx-border-color: black;"
					+ "-fx-border-width: 10;");
			startPane.getChildren().addAll(start, startButton);
			AnchorPane.setTopAnchor(start, 250.0);
			AnchorPane.setLeftAnchor(start, 250.0);
			AnchorPane.setBottomAnchor(startButton, 150.0);
			AnchorPane.setLeftAnchor(startButton, 320.0);
			setCenter(startPane);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Sets the game screen up, where the user(s) will play TicTacToe
	 */
	private void setGameScreen() {
		try {
			gamePane = new AnchorPane();
			gameText = new Text("");
			gameText.setFont(startFont);
			restart = new Button("Restart");
			restart.setFont(startFont);
			restart.setOnAction(this::processAction);
			restart.setStyle("-fx-background-color: white;" + "-fx-border-color: black;"
					+ "-fx-border-width: 10;");
			restart.setVisible(false);
			gamePane.getChildren().addAll(gameText, restart);
			AnchorPane.setTopAnchor(gameText, 10.0);
			AnchorPane.setLeftAnchor(gameText, 340.0);
			AnchorPane.setBottomAnchor(restart, 10.0);
			AnchorPane.setLeftAnchor(restart, 320.0);
			double heightSpacing = 175.0;
			for (int i = 0; i < 3; i++) {
				double widthSpacing = 175.0;
				for (int j = 0; j < 3; j++) {
					gamePane.getChildren().add(buttonArray[i][j]);
					AnchorPane.setTopAnchor(buttonArray[i][j], heightSpacing);
					AnchorPane.setLeftAnchor(buttonArray[i][j], widthSpacing);
					widthSpacing+=200;
				}
				heightSpacing+=200;
			}
			
			setCenter(gamePane);
			game = new BorderPane(gamePane);
			gameScreen = new Scene(game, 900, 900);
			window.setScene(gameScreen);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/*
	 * Function to create the array of buttons for the TicTacToe board and set their stylings
	 */
	private void initiateButtonsArray() {
		buttonFont = new Font("Courier", 60);
		for(int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				buttonArray[i][j] = new Button();
				buttonArray[i][j].setPrefSize(150, 150);
				buttonArray[i][j].setOnAction(this::processAction);
				buttonArray[i][j].setStyle("-fx-background-color: lightgray;");
				buttonArray[i][j].setFont(buttonFont);
			}
		}
	}
	
	/*
	 * Handles all the button presses
	 */
	private void processAction(ActionEvent event) {
		if (event.getSource() == startButton) {
			setGameScreen();
		}
		if (event.getSource() == restart) {
			restart();
		}
		/*
		 * Checks to see which button was pressed in the game board
		 */
		if (event.getSource() == buttonArray[0][0]) {
			buttonArrayFunction(0,0);
		}
		else if (event.getSource() == buttonArray[0][1]) {
			buttonArrayFunction(0,1);
		}
		else if (event.getSource() == buttonArray[0][2]) {
			buttonArrayFunction(0,2);
		}
		else if (event.getSource() == buttonArray[1][0]) {
			buttonArrayFunction(1,0);
		}
		else if (event.getSource() == buttonArray[1][1]) {
			buttonArrayFunction(1,1);
		}
		else if (event.getSource() == buttonArray[1][2]) {
			buttonArrayFunction(1,2);
		}
		else if (event.getSource() == buttonArray[2][0]) {
			buttonArrayFunction(2,0);
		}
		else if (event.getSource() == buttonArray[2][1]) {
			buttonArrayFunction(2,1);
		}
		else if (event.getSource() == buttonArray[2][2]) {
			buttonArrayFunction(2,2);
		}
	}
	
	/*
	 * Function to communicate with TicTacToe.java in coordination with the GUI TicTacToe board
	 */
	private void buttonArrayFunction(int x, int y) {
		buttonArray[x][y].setDisable(true);
		text = TTT.getCurrentPlayer();
		string = "";
		string += text;
		buttonArray[x][y].setText(string);
		if (text == 'X') {
			buttonArray[x][y].setStyle("-fx-background-color: red;");
		} else {

			buttonArray[x][y].setStyle("-fx-background-color: blue;");
		}
		TTT.placeMarkerInBoard(x, y);
		/*
		 * Check to see if a winner was found
		 */
		win = TTT.isWinner(x, y);
		if (win == 1) {
			gameText.setText("X Wins!");
			isWin = true;
		} else if (win == -1) {
			gameText.setText("O Wins!");
			isWin = true;
		}
		else if (win == 0) {
			gameText.setText("Draw!");
			isWin = true;
		}
		
		TTT.changePlayer();
		
		if(TTT.getCurrentPlayer() == 'X')
			computerMoves(true);
		else
			computerMoves(false);
		
		TTT.changePlayer();
		
		/*
		 * Disables buttons on TicTacToe board and reveals the restart button
		 */
		if (isWin == true) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (buttonArray[i][j].isDisabled() == false) {
						buttonArray[i][j].setDisable(true);
					}
				}
			}
			restart.setVisible(true);
		}
	}
	
	/*
	 * Function to restart the TicTacToe board, re-enabling the buttons and hide the reset button and win text
	 */
	private void restart() {
		TTT = new TicTacToe();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				buttonArray[i][j].setDisable(false);
				buttonArray[i][j].setStyle("-fx-background-color: lightgray;");
				buttonArray[i][j].setText("");
			}
		}
		restart.setVisible(false);
		gameText.setText("");
		isWin = false;
	}
	
	/**
	 * Minimax algorithm: This algorithm determines the optimal move for the current player, which
	 * 		assumes that the other player is playing optimally
	 * @param manipulatingBoard - a copy of the game board
	 * @param xLocation - the last x location placed in the board
	 * @param yLocation - the last y location placed in the board
	 * @param maximizingPlayer - determines if the current player is maximizing or minimizing
	 * @param alpha - the maximizing indicator for alpha-beta pruning
	 * @param beta - the minimizing indicator for alpha-beta pruning
	 * @return a maximizing or minimizing value
	 */
	private int miniMaxAlg(TicTacToe manipulatingBoard, int xLocation, int yLocation, boolean maximizingPlayer, int alpha, int beta) {
		//Runs method to check if a winner has been determined or the board has been filled
		int winnerOrGameEnd = manipulatingBoard.isWinner(xLocation, yLocation);
		//Returns the static value of the current board state
		if(winnerOrGameEnd >= -1 && winnerOrGameEnd <= 1)
			return winnerOrGameEnd;
		
		//Runs if the current player is maximizing
		if(maximizingPlayer) {
			//Sets the best move to a low count
			int bestMax = -1000;
			
			//Loops through available moves in the board
			for(int i = 0; i < manipulatingBoard.getNumberOfOpenSlots(); i++) {
				
				//Sets the maximizing player to be X
				manipulatingBoard.setCurrentPlayer('X');
				Coordinate current = manipulatingBoard.getCoordinates().get(i);
				int tempX = current.getxLocation(), tempY = current.getyLocation();
				manipulatingBoard.placeMarkerInBoard(tempX, tempY);
				
				//Runs the minimax alg with minimizing player's turn and saves the maximum result
				bestMax = Math.max(bestMax, miniMaxAlg(manipulatingBoard, tempX, tempY, false, alpha, beta));
				
				//Calculates the new alpha for pruning
				alpha = Math.max(alpha, bestMax);
				
				//removes the last placed marker from the board
				manipulatingBoard.removeMarkerFromBoard(tempX, tempY, i);
				
				//Prunes branches if a better min exists
				if(beta <= alpha)
					break;
			}
			return bestMax;
		}else {
			//Sets the best move to a high count
			int bestMin = 1000;
			
			//Loops through the available moves in the board
			for(int i = 0; i < manipulatingBoard.getNumberOfOpenSlots(); i++) {
				
				//Sets the minimizing player to be O
				manipulatingBoard.setCurrentPlayer('O');
				
				//Stores the current coordinate from the available coordinates
				Coordinate current = manipulatingBoard.getCoordinates().get(i);
				int tempX = current.getxLocation(), tempY = current.getyLocation();
				manipulatingBoard.placeMarkerInBoard(tempX, tempY);
				
				//Runs the minimax alg with maximizing player's turn and saves the minimum result
				bestMin = Math.min(bestMin, miniMaxAlg(manipulatingBoard, tempX, tempY, true, alpha, beta));
				
				//Calculates the new beta for pruning
				beta = Math.min(beta, bestMin);
				
				//Removes the last placed marker from the board
				manipulatingBoard.removeMarkerFromBoard(tempX, tempY, i);
				
				//Prunes branches if a better max exists
				if(beta <= alpha)
					break;
			}
			return bestMin;
		}
	}
	
	/**
	 * Determines what the most optimal move is for the computer player and places it into the board
	 * @param maximizingPlayer - determines whether the computer is maximizing or not
	 */
	private void computerMoves(boolean maximizingPlayer) {
		TicTacToe manipulatingBoard = new TicTacToe(TTT);
		int xLocation = -1, yLocation = -1, best = 0;
		//Sets the value of best based on whether the computer is trying to minimize or maximize
		if(maximizingPlayer)
			best = -1000;
		else
			best = 1000;
		
		//Loops through the possible options for the computer player
		for (int i = 0; i < manipulatingBoard.getNumberOfOpenSlots(); i++) {
			//Sets current player to O or X depending on if they are minimizing or maximizing
			if(maximizingPlayer)
				manipulatingBoard.setCurrentPlayer('X');
			else
				manipulatingBoard.setCurrentPlayer('O');

			//Stores the current coordinates to test in the game
			Coordinate current = manipulatingBoard.getCoordinates().get(i);
			manipulatingBoard.placeMarkerInBoard(current.getxLocation(), current.getyLocation());
			
			//Checks if the move is optimal by running through the minimax algorithm
			int miniMaxVal = miniMaxAlg(manipulatingBoard, current.getxLocation(), current.getyLocation(), !maximizingPlayer, -1000, 1000);
			
			//Changes players most optimal move based on current move
			if(maximizingPlayer) {
				if(miniMaxVal > best) {
					best = miniMaxVal;
					xLocation = current.getxLocation();
					yLocation = current.getyLocation();
				}
			}else {
				if(miniMaxVal < best) {
					best = miniMaxVal;
					xLocation = current.getxLocation();
					yLocation = current.getyLocation();
				}
			}
			
			//Removes marker from board in order to test next marker
			manipulatingBoard.removeMarkerFromBoard(current.getxLocation(), current.getyLocation(), i);
		}
		
		//Places the best move for the computer into the board
		TTT.placeMarkerInBoard(xLocation, yLocation);
		
		//Prints board the placement for testing purposes
		System.out.println(TTT);
		System.out.println(xLocation + " " + yLocation);
	}
}
