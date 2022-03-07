package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.text.Font;

import javafx.event.ActionEvent;

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
	private Button xButton, oButton, xRestart, oRestart;
	private Button[][] buttonArray = new Button[3][3];
	private Stage window;
	private Scene gameScreen;
	private BorderPane game;
	private char text;
	private String string;
	private TicTacToe TTT;
	
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
			start = new Text("Choose your turn\nbelow to start");
			startFont = new Font("Courier", 60);
			start.setFont(startFont);
			xButton = new Button("X");
			xButton.setFont(startFont);
			xButton.setOnAction(this::processAction);
			xButton.setStyle("-fx-background-color: white;" + "-fx-border-color: black;"
					+ "-fx-border-width: 10;");
			oButton = new Button("O");
			oButton.setFont(startFont);
			oButton.setOnAction(this::processAction);
			oButton.setStyle("-fx-background-color: white;" + "-fx-border-color: black;"
					+ "-fx-border-width: 10;");
			startPane.getChildren().addAll(start, xButton, oButton);
			AnchorPane.setTopAnchor(start, 250.0);
			AnchorPane.setLeftAnchor(start, 250.0);
			AnchorPane.setBottomAnchor(xButton, 100.0);
			AnchorPane.setBottomAnchor(oButton, 100.0);
			AnchorPane.setLeftAnchor(xButton, 250.0);
			AnchorPane.setRightAnchor(oButton, 250.0);
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
			xRestart = new Button("Restart as X");
			xRestart.setFont(startFont);
			xRestart.setOnAction(this::processAction);
			xRestart.setStyle("-fx-background-color: white;" + "-fx-border-color: black;"
					+ "-fx-border-width: 10;");
			xRestart.setVisible(false);
			oRestart = new Button("Restart as O");
			oRestart.setFont(startFont);
			oRestart.setOnAction(this::processAction);
			oRestart.setStyle("-fx-background-color: white;" + "-fx-border-color: black;"
					+ "-fx-border-width: 10;");
			oRestart.setVisible(false);
			gamePane.getChildren().addAll(gameText, xRestart, oRestart);
			AnchorPane.setTopAnchor(gameText, 10.0);
			AnchorPane.setLeftAnchor(gameText, 340.0);
			AnchorPane.setBottomAnchor(xRestart, 10.0);
			AnchorPane.setLeftAnchor(xRestart, 25.0);
			AnchorPane.setBottomAnchor(oRestart, 10.0);
			AnchorPane.setRightAnchor(oRestart, 25.0);
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
		if (event.getSource() == xButton) {
			setGameScreen();
		}
		if (event.getSource() == oButton) {
			setGameScreen();
			int coordLocation = MiniMaxAlg.computerMoves(true, TTT);
			placeMarkerInGUIBoard(coordLocation);
		}
		if (event.getSource() == xRestart) {
			restart();
		}
		if (event.getSource() == oRestart) {
			restart();
			int coordLocation = MiniMaxAlg.computerMoves(true, TTT);
			placeMarkerInGUIBoard(coordLocation);
		}
		/*
		 * Checks to see which button was pressed in the game board
		 */
		for (int i = 0; i < 3; i++) {
      for(int j = 0; j < 3; j++) {
        if(event.getSource() == buttonArray[i][j])
          buttonArrayFunction(i, j);
      }
    }
	}
	
	/*
	 * Function to communicate with TicTacToe.java in coordination with the GUI TicTacToe board
	 */
	private void buttonArrayFunction(int x, int y) {
		
		placeMarkerInGUIBoard(((3*x) + y));
		
		int coordLocation = -1;
		
		if(TTT.getCurrentPlayer() == 'X')
			coordLocation = MiniMaxAlg.computerMoves(true, TTT);
		else
			coordLocation = MiniMaxAlg.computerMoves(false, TTT);
		placeMarkerInGUIBoard(coordLocation);
	}
	
	/**
	 * Places the X or O marker within the GUI interface of the TicTacToe board
	 * @param xLocation
	 * @param yLocation
	 */
	public void placeMarkerInGUIBoard(int coordLocation) {
	  if(coordLocation == -1)
	    return;
	  int xLocation = TTT.getCoordinates().get(coordLocation).getxLocation();
	  int yLocation = TTT.getCoordinates().get(coordLocation).getyLocation();
	  buttonArray[xLocation][yLocation].setDisable(true);
    text = TTT.getCurrentPlayer();
    string = "";
    string += text;
    buttonArray[xLocation][yLocation].setText(string);
    if (text == 'X') {
      buttonArray[xLocation][yLocation].setStyle("-fx-background-color: red;");
    } else {

      buttonArray[xLocation][yLocation].setStyle("-fx-background-color: blue;");
    }
    TTT.placeMarkerInBoard(coordLocation, xLocation, yLocation);
    /*
     * Check to see if a winner was found
     */
    int win = TTT.isWinner(xLocation, yLocation);
    if (win == 1) {
      gameText.setText("X Wins!");
    } else if (win == -1) {
      gameText.setText("O Wins!");
    }
    else if (win == 0) {
      gameText.setText("Draw!");
    }
    
    TTT.changePlayer();
    
    /*
     * Disables buttons on TicTacToe board and reveals the restart button
     */
    if (win >= -1 && win <= 1) {
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          if (!buttonArray[i][j].isDisabled()) {
            buttonArray[i][j].setDisable(true);
          }
        }
      }
      xRestart.setVisible(true);
      oRestart.setVisible(true);
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
		xRestart.setVisible(false);
		oRestart.setVisible(false);
		gameText.setText("");
	}
}
