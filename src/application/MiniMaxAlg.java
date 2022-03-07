/**
 * 
 */
package application;

import java.util.HashSet;
import java.util.Set;

/**
 * @author MarefkeTyler
 * @version 2022.9.2
 * This class runs the necessary calculations for the minimax algorithm
 */
public class MiniMaxAlg {
  /**
   * Minimax algorithm: This algorithm determines the optimal move for the current player, which
   *    assumes that the other player is playing optimally
   * @param manipulatingBoard - a copy of the game board
   * @param xLocation - the last x location placed in the board
   * @param yLocation - the last y location placed in the board
   * @param maximizingPlayer - determines if the current player is maximizing or minimizing
   * @param alpha - the maximizing indicator for alpha-beta pruning
   * @param beta - the minimizing indicator for alpha-beta pruning
   * @return a maximizing or minimizing value
   */
  private static int miniMaxAlg(TicTacToe manipulatingBoard, int xLocation, int yLocation, boolean maximizingPlayer, int alpha, int beta) {
    //Runs method to check if a winner has been determined or the board has been filled
    int winnerOrGameEnd = manipulatingBoard.isWinner(xLocation, yLocation);
    //Returns the static value of the current board state
    if(winnerOrGameEnd >= -1 && winnerOrGameEnd <= 1)
      return winnerOrGameEnd;
    
    Set<Integer> keys = new HashSet<Integer>(manipulatingBoard.getCoordinates().keySet());
    
    //Runs if the current player is maximizing
    if(maximizingPlayer) {
      //Sets the best move to a low count
      int bestMax = -1000;
      
      //Loops through available moves in the board
      for(int i : keys) {
        
        //Sets the maximizing player to be X
        manipulatingBoard.setCurrentPlayer('X');
        Coordinate current = manipulatingBoard.getCoordinates().get(i);
        int tempX = current.getxLocation(), tempY = current.getyLocation();
        manipulatingBoard.placeMarkerInBoard(i, tempX, tempY);
        
        //Runs the minimax alg with minimizing player's turn and saves the maximum result
        bestMax = Math.max(bestMax, miniMaxAlg(manipulatingBoard, tempX, tempY, false, alpha, beta));
        
        //Calculates the new alpha for pruning
        alpha = Math.max(alpha, bestMax);
        
        //removes the last placed marker from the board
        manipulatingBoard.removeMarkerFromBoard(i, tempX, tempY);
        
        //Prunes branches if a better min exists
        if(beta <= alpha)
          break;
      }
      return bestMax;
    }else {
      //Sets the best move to a high count
      int bestMin = 1000;
      
      //Loops through the available moves in the board
      for(int i : keys) {
        
        //Sets the minimizing player to be O
        manipulatingBoard.setCurrentPlayer('O');
        
        //Stores the current coordinate from the available coordinates
        Coordinate current = manipulatingBoard.getCoordinates().get(i);
        int tempX = current.getxLocation(), tempY = current.getyLocation();
        manipulatingBoard.placeMarkerInBoard(i, tempX, tempY);
        
        //Runs the minimax alg with maximizing player's turn and saves the minimum result
        bestMin = Math.min(bestMin, miniMaxAlg(manipulatingBoard, tempX, tempY, true, alpha, beta));
        
        //Calculates the new beta for pruning
        beta = Math.min(beta, bestMin);
        
        //Removes the last placed marker from the board
        manipulatingBoard.removeMarkerFromBoard(i, tempX, tempY);
        
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
  public static int computerMoves(boolean maximizingPlayer, TicTacToe TTT) {
    if(TTT.getNumberOfOpenSlots() == 0)
      return -1;
    TicTacToe manipulatingBoard = new TicTacToe(TTT);
    int best = 0, coordLocation = -1;
    //Sets the value of best based on whether the computer is trying to minimize or maximize
    if(maximizingPlayer)
      best = -1000;
    else
      best = 1000;
    
    Set<Integer> keys = new HashSet<Integer>(manipulatingBoard.getCoordinates().keySet());
    
    //Loops through the possible options for the computer player
    for (int i : keys) {
      //Sets current player to O or X depending on if they are minimizing or maximizing
      if(maximizingPlayer)
        manipulatingBoard.setCurrentPlayer('X');
      else
        manipulatingBoard.setCurrentPlayer('O');

      //Stores the current coordinates to test in the game
      Coordinate current = manipulatingBoard.getCoordinates().get(i);
      int tempX = current.getxLocation(), tempY = current.getyLocation();
      manipulatingBoard.placeMarkerInBoard(i, tempX, tempY);
      
      //Checks if the move is optimal by running through the minimax algorithm
      int miniMaxVal = miniMaxAlg(manipulatingBoard, tempX, tempY, !maximizingPlayer, -1000, 1000);
      
      //Changes players most optimal move based on current move
      if(maximizingPlayer) {
        if(miniMaxVal > best) {
          best = miniMaxVal;
          coordLocation = i;
        }
      }else {
        if(miniMaxVal < best) {
          best = miniMaxVal;
          coordLocation = i;
        }
      }
      
      //Removes marker from board in order to test next marker
      manipulatingBoard.removeMarkerFromBoard(i, tempX, tempY);
    }
    
    //Returns the coordinate location key within the hashmap in order for the computer to make a move
    return coordLocation;
    
    //Prints board the placement for testing purposes
    //System.out.println(TTT);
    //System.out.println(xLocation + " " + yLocation);
  }
}
