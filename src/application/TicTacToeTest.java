package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TicTacToeTest {

  @Test
  /**
   * Tests the tictactoe is constructing properly with currentPlayer <- X,
   * numberOfSlots <- 9, and gameBoard being filled with space chars
   */
  void testTicTacToe() {
    TicTacToe original = new TicTacToe();
    String expectedBoard = "   |   |   \n-----------\n   |   |   \n-----------\n   |   |   \n\n";
    String coords = "{0=(0, 0), 1=(0, 1), 2=(0, 2), 3=(1, 0), 4=(1, 1), 5=(1, 2), 6=(2, 0), 7=(2, 1), 8=(2, 2)}";

    assertEquals('X', original.getCurrentPlayer());
    assertEquals(9, original.getNumberOfOpenSlots());
    assertEquals(coords, original.getCoordinates().toString());
    assertEquals(expectedBoard, original.toString());

  }

  @Test
  /**
   * Checks if the copy constructor copies the current board state from the
   * original tictactoe board
   */

  void testTicTacToeCopy() {
    TicTacToe original = new TicTacToe();
    original.placeMarkerInBoard(1, 0, 1);
    original.changePlayer();

    TicTacToe copy = new TicTacToe(original);
    String expectedBoard = "   | X |   \n-----------\n   |   |   \n-----------\n   |   |   \n\n";
    String coords = "{0=(0, 0), 2=(0, 2), 3=(1, 0), 4=(1, 1), 5=(1, 2), 6=(2, 0), 7=(2, 1), 8=(2, 2)}";

    assertEquals('O', copy.getCurrentPlayer());
    assertEquals(8, copy.getNumberOfOpenSlots());
    assertEquals(coords, copy.getCoordinates().toString());
    assertEquals(expectedBoard, copy.toString());

  }

  @Test
  /**
   * Tests a single marker being placed into the board 
   * Tests if the marker was placed if the number of spots available updated if the board updated with the
   * marker in the correct location
   */

  void testFirstPlaceMarkerInBoard() {
    TicTacToe original = new TicTacToe();

    String expectedBoard = "   | X |   \n-----------\n   |   |   \n-----------\n   |   |   \n\n";
    String coords = "{0=(0, 0), 2=(0, 2), 3=(1, 0), 4=(1, 1), 5=(1, 2), 6=(2, 0), 7=(2, 1), 8=(2, 2)}";

    assertTrue(original.placeMarkerInBoard(1, 0, 1));
    original.changePlayer();
    assertEquals(8, original.getNumberOfOpenSlots());
    assertEquals(coords, original.getCoordinates().toString());
    assertEquals(expectedBoard, original.toString());

  }

  @Test
  /**
   * Tests invalid placement of markers in the gameBoard Tests x < 0 y < 0 x >
   * gameBoard.length - 1 y > gameBoard.length - 1 the placement of a marker at x,
   * y where a marker already exists
   */
  void testInvalidPlaceMarkerInBoard() {
    TicTacToe original = new TicTacToe();
    original.placeMarkerInBoard(1, 0, 1);
    original.changePlayer();

    assertFalse(original.placeMarkerInBoard(0, -1, 1));
    assertFalse(original.placeMarkerInBoard(8, 0, -1));
    assertFalse(original.placeMarkerInBoard(22, 3, 0));
    assertFalse(original.placeMarkerInBoard(-30, 0, 3));
    assertFalse(original.placeMarkerInBoard(1, 0, 1));

  }

  @Test
  /**
   * Tests two markers being placed into the board Tests if two markers were
   * placed if the number of spots available updated if the board updated with the
   * marker in the correct location
   */
  void testSecondPlaceMarkerInBoard() {
    TicTacToe original = new TicTacToe();

    String expectedBoard = " O | X |   \n-----------\n   |   |   \n-----------\n   |   |   \n\n";
    String coords = "{2=(0, 2), 3=(1, 0), 4=(1, 1), 5=(1, 2), 6=(2, 0), 7=(2, 1), 8=(2, 2)}";
    
    assertTrue(original.placeMarkerInBoard(1, 0, 1));
    original.changePlayer();
    assertTrue(original.placeMarkerInBoard(0, 0, 0));
    assertEquals(7, original.getNumberOfOpenSlots());
    assertEquals(coords, original.getCoordinates().toString());
    assertEquals(expectedBoard, original.toString());
  }

  @Test
  /**
   * Tests three markers being placed into the board Tests if three markers were
   * placed if the number of spots available updated if the board updated with the
   * marker in the correct location
   */

  void testThirdPlaceMarkerInBoard() {
    TicTacToe original = new TicTacToe();

    String expectedBoard = " O | X | X \n-----------\n   |   |   \n-----------\n   |   |   \n\n";
    String coords = "{3=(1, 0), 4=(1, 1), 5=(1, 2), 6=(2, 0), 7=(2, 1), 8=(2, 2)}";

    assertTrue(original.placeMarkerInBoard(1, 0, 1));
    assertTrue(original.placeMarkerInBoard(2, 0, 2));
    original.changePlayer();
    assertTrue(original.placeMarkerInBoard(0, 0, 0));
    assertEquals(6, original.getNumberOfOpenSlots());
    assertEquals(coords, original.getCoordinates().toString());
    assertEquals(expectedBoard, original.toString());

  }

  @Test
  /**
   * Tests four markers being placed into the board Tests if four markers were
   * placed if the number of spots available updated if the board updated with the
   * marker in the correct location
   */

  void testFourthPlaceMarkerInBoard() {
    TicTacToe original = new TicTacToe();

    String expectedBoard = " O | X | X \n-----------\n   | O |   \n-----------\n   |   |   \n\n";
    String coords = "{3=(1, 0), 5=(1, 2), 6=(2, 0), 7=(2, 1), 8=(2, 2)}";

    assertTrue(original.placeMarkerInBoard(1, 0, 1));
    assertTrue(original.placeMarkerInBoard(2, 0, 2));
    original.changePlayer();
    assertTrue(original.placeMarkerInBoard(0, 0, 0));
    assertTrue(original.placeMarkerInBoard(4, 1, 1));
    assertEquals(5, original.getNumberOfOpenSlots());
    assertEquals(coords, original.getCoordinates().toString());
    assertEquals(expectedBoard, original.toString());

  }

  @Test
  /**
   * Tests five markers being placed into the board Tests if five markers were
   * placed if the number of spots available updated if the board updated with the
   * marker in the correct location
   */

  void testFifthPlaceMarkerInBoard() {
    TicTacToe original = new TicTacToe();

    String expectedBoard = " O | X | X \n-----------\n X | O |   \n-----------\n   |   |   \n\n";
    String coords = "{5=(1, 2), 6=(2, 0), 7=(2, 1), 8=(2, 2)}";

    assertTrue(original.placeMarkerInBoard(1, 0, 1));
    assertTrue(original.placeMarkerInBoard(2, 0, 2));
    assertTrue(original.placeMarkerInBoard(3, 1, 0));
    original.changePlayer();
    assertTrue(original.placeMarkerInBoard(0, 0, 0));
    assertTrue(original.placeMarkerInBoard(4, 1, 1));
    assertEquals(4, original.getNumberOfOpenSlots());
    assertEquals(coords, original.getCoordinates().toString());
    assertEquals(expectedBoard, original.toString());

  }

  @Test
  /**
   * Tests six markers being placed into the board Tests if six markers were
   * placed if the number of spots available updated if the board updated with the
   * marker in the correct location
   */
  void testSixthPlaceMarkerInBoard() {
    TicTacToe original = new TicTacToe();

    String expectedBoard = " O | X | X \n-----------\n X | O |   \n-----------\n   | O |   \n\n";
    String coords = "{5=(1, 2), 6=(2, 0), 8=(2, 2)}";

    assertTrue(original.placeMarkerInBoard(1, 0, 1));
    assertTrue(original.placeMarkerInBoard(2, 0, 2));
    assertTrue(original.placeMarkerInBoard(3, 1, 0));
    original.changePlayer();
    assertTrue(original.placeMarkerInBoard(0, 0, 0));
    assertTrue(original.placeMarkerInBoard(4, 1, 1));
    assertTrue(original.placeMarkerInBoard(7, 2, 1));
    assertEquals(3, original.getNumberOfOpenSlots());
    assertEquals(coords, original.getCoordinates().toString());
    assertEquals(expectedBoard, original.toString());

  }

  @Test
  /**
   * Tests seven markers being placed into the board Tests if seven markers were
   * placed if the number of spots available updated if the board updated with the
   * marker in the correct location
   */
  void testSeventhPlaceMarkerInBoard() {
    TicTacToe original = new TicTacToe();

    String expectedBoard = " O | X | X \n-----------\n X | O |   \n-----------\n X | O |   \n\n";
    String coords = "{5=(1, 2), 8=(2, 2)}";

    assertTrue(original.placeMarkerInBoard(1, 0, 1));
    assertTrue(original.placeMarkerInBoard(2, 0, 2));
    assertTrue(original.placeMarkerInBoard(3, 1, 0));
    assertTrue(original.placeMarkerInBoard(6, 2, 0));
    original.changePlayer();
    assertTrue(original.placeMarkerInBoard(0, 0, 0));
    assertTrue(original.placeMarkerInBoard(4, 1, 1));
    assertTrue(original.placeMarkerInBoard(7, 2, 1));
    assertEquals(2, original.getNumberOfOpenSlots());
    assertEquals(coords, original.getCoordinates().toString());
    assertEquals(expectedBoard, original.toString());

  }

  @Test
  /**
   * Tests eight markers being placed into the board Tests if eight markers were
   * placed if the number of spots available updated if the board updated with the
   * marker in the correct location
   */

  void testEighthPlaceMarkerInBoard() {
    TicTacToe original = new TicTacToe();

    String expectedBoard = " O | X | X \n-----------\n X | O | O \n-----------\n X | O |   \n\n";
    String coords = "{8=(2, 2)}";

    assertTrue(original.placeMarkerInBoard(1, 0, 1));
    assertTrue(original.placeMarkerInBoard(2, 0, 2));
    assertTrue(original.placeMarkerInBoard(3, 1, 0));
    assertTrue(original.placeMarkerInBoard(6, 2, 0));
    original.changePlayer();
    assertTrue(original.placeMarkerInBoard(0, 0, 0));
    assertTrue(original.placeMarkerInBoard(4, 1, 1));
    assertTrue(original.placeMarkerInBoard(7, 2, 1));
    assertTrue(original.placeMarkerInBoard(5, 1, 2));
    assertEquals(1, original.getNumberOfOpenSlots());
    assertEquals(coords, original.getCoordinates().toString());
    assertEquals(expectedBoard, original.toString());

  }

  @Test
  /**
   * Tests nine markers being placed into the board Tests if nine markers were
   * placed if the number of spots available updated if the board updated with the
   * marker in the correct location
   */

  void testBoardFilled() {
    TicTacToe original = new TicTacToe();

    String expectedBoard = " O | X | X \n-----------\n X | O | O \n-----------\n X | O | X \n\n";
    String coords = "{}";

    assertTrue(original.placeMarkerInBoard(1, 0, 1));
    assertTrue(original.placeMarkerInBoard(2, 0, 2));
    assertTrue(original.placeMarkerInBoard(3, 1, 0));
    assertTrue(original.placeMarkerInBoard(6, 2, 0));
    assertTrue(original.placeMarkerInBoard(8, 2, 2));
    original.changePlayer();
    assertTrue(original.placeMarkerInBoard(0, 0, 0));
    assertTrue(original.placeMarkerInBoard(4, 1, 1));
    assertTrue(original.placeMarkerInBoard(7, 2, 1));
    assertTrue(original.placeMarkerInBoard(5, 1, 2));
    assertEquals(0, original.getNumberOfOpenSlots());
    assertEquals(coords, original.getCoordinates().toString());
    assertEquals(expectedBoard, original.toString());

  }

  @Test
  /**
   * Tests that the game continues since X and O have not won and the board is not
   * filled Tests the current player is X that the in value of char X is returned
   * the board state of the current game
   */
  void testContinueGameIsWinner() {
    TicTacToe gameContinue = new TicTacToe();
    String expectedBoard = " O | X | X \n-----------\n   | O |   \n-----------\n   |   |   \n\n";

    gameContinue.placeMarkerInBoard(1, 0, 1);
    gameContinue.changePlayer();
    assertEquals('O', gameContinue.isWinner(1, 0));
    gameContinue.placeMarkerInBoard(0, 0, 0);
    gameContinue.changePlayer();
    assertEquals('X', gameContinue.isWinner(0, 0));
    gameContinue.placeMarkerInBoard(2, 0, 2);
    gameContinue.changePlayer();
    assertEquals('O', gameContinue.isWinner(2, 0));
    gameContinue.placeMarkerInBoard(4, 1, 1);
    gameContinue.changePlayer();
    assertEquals('X', gameContinue.isWinner(1, 1));

    assertEquals('X', gameContinue.getCurrentPlayer());
    assertEquals(expectedBoard, gameContinue.toString());

  }

  @Test
  /**
   * Tests that X has won the game through a row and since X is the computer then
   * 1 will be returned Tests the current player is X that the value of 1 is
   * returned since X has won the board state of the current game
   */
  void testXIsWinnerRow() {
    TicTacToe gameXRow = new TicTacToe();

    String expectedBoard = " X | X | X \n-----------\n   |   |   \n-----------\n   |   |   \n\n";

    gameXRow.placeMarkerInBoard(1, 0, 1);
    gameXRow.placeMarkerInBoard(2, 0, 2);
    gameXRow.placeMarkerInBoard(0, 0, 0);
    
    assertEquals(1, gameXRow.isWinner(0, 0));
    assertEquals(expectedBoard, gameXRow.toString());

  }

  @Test
  /**
   * Tests that X has won the game through a column and since X is the computer
   * then 1 will be returned Tests the current player is X that the value of 1 is
   * returned since X has won the board state of the current game
   */

  void testXIsWinnerCol() {
    TicTacToe gameXCol = new TicTacToe();

    String expectedBoard = " X |   |   \n-----------\n X |   |   \n-----------\n X |   |   \n\n";

    gameXCol.placeMarkerInBoard(3, 1, 0);
    gameXCol.placeMarkerInBoard(0, 0, 0);
    gameXCol.placeMarkerInBoard(6, 2, 0);
    
    assertEquals(1, gameXCol.isWinner(2, 0));
    assertEquals(expectedBoard, gameXCol.toString());

  }

  @Test
  /**
   * Tests that X has won the game through a diagonal and since X is the computer
   * then 1 will be returned Tests the current player is X that the value of 1 is
   * returned since X has won the board state of the current game
   */
  void testXIsWinnerDiag() {
    TicTacToe gameXDiag = new TicTacToe();

    String expectedBoard = " X |   |   \n-----------\n   | X |   \n-----------\n   |   | X \n\n";

    gameXDiag.placeMarkerInBoard(4, 1, 1);
    gameXDiag.placeMarkerInBoard(8, 2, 2);
    gameXDiag.placeMarkerInBoard(0, 0, 0);
    
    assertEquals(1, gameXDiag.isWinner(0, 0));
    assertEquals(expectedBoard, gameXDiag.toString());

  }

  @Test
  /**
   * Tests that X has won the game through a reverse diagonal and since X is the
   * computer then 1 will be returned Tests the current player is X that the value
   * of 1 is returned since X has won the board state of the current game
   */
  void testXIsWinnerRevDiag() {
    TicTacToe gameXRevDiag = new TicTacToe();

    String expectedBoard = "   |   | X \n-----------\n   | X |   \n-----------\n X |   |   \n\n";

    gameXRevDiag.placeMarkerInBoard(4, 1, 1);
    gameXRevDiag.placeMarkerInBoard(3, 0, 2);
    gameXRevDiag.placeMarkerInBoard(6, 2, 0);
    
    assertEquals(1, gameXRevDiag.isWinner(2, 0));
    assertEquals(expectedBoard, gameXRevDiag.toString());

  }

  @Test
  /**
   * Tests that O has won the game through a row and since X is the computer then
   * -1 will be returned Tests the current player is O that the value of -1 is
   * returned since O has won the board state of the current game
   */
  void testOIsWinnerRow() {
    TicTacToe gameORow = new TicTacToe();

    String expectedBoard = "   | O |   \n-----------\n   | O |   \n-----------\n   | O |   \n\n";

    gameORow.changePlayer();
    gameORow.placeMarkerInBoard(1, 0, 1);
    gameORow.placeMarkerInBoard(4, 1, 1);
    gameORow.placeMarkerInBoard(7, 2, 1);
    
    assertEquals(-1, gameORow.isWinner(2, 1));
    assertEquals(expectedBoard, gameORow.toString());
  }

  @Test
  /**
   * Tests that O has won the game through a column and since X is the computer
   * then -1 will be returned Tests the current player is O that the value of -1
   * is returned since O has won the board state of the current game
   */
  void testOIsWinnerCol() {
    TicTacToe gameOCol = new TicTacToe();

    String expectedBoard = "   |   |   \n-----------\n O | O | O \n-----------\n   |   |   \n\n";

    gameOCol.changePlayer();
    gameOCol.placeMarkerInBoard(3, 1, 0);
    gameOCol.placeMarkerInBoard(5, 1, 2);
    gameOCol.placeMarkerInBoard(4, 1, 1);
    
    assertEquals(-1, gameOCol.isWinner(1, 1));
    assertEquals(expectedBoard, gameOCol.toString());

  }

  @Test
  /**
   * Tests that O has won the game through a diagonal and since X is the computer
   * then -1 will be returned Tests the current player is O that the value of -1
   * is returned since O has won the board state of the current game
   */
  void testOIsWinnerDiag() {
    TicTacToe gameODiag = new TicTacToe();

    String expectedBoard = " O |   |   \n-----------\n   | O |   \n-----------\n   |   | O \n\n";

    gameODiag.changePlayer();
    gameODiag.placeMarkerInBoard(0, 0, 0);
    gameODiag.placeMarkerInBoard(8, 2, 2);
    gameODiag.placeMarkerInBoard(4, 1, 1);
    
    assertEquals(-1, gameODiag.isWinner(2, 2));
    assertEquals(expectedBoard, gameODiag.toString());

  }

  @Test
  /**
   * Tests that O has won the game through a reverse diagonal and since X is the
   * computer then -1 will be returned Tests the current player is O that the
   * value of -1 is returned since O has won the board state of the current game
   */
  void testOIsWinnerRevDiag() {
    TicTacToe gameORevDiag = new TicTacToe();

    String expectedBoard = "   |   | O \n-----------\n   | O |   \n-----------\n O |   |   \n\n";

    gameORevDiag.changePlayer();
    gameORevDiag.placeMarkerInBoard(2, 0, 2);
    gameORevDiag.placeMarkerInBoard(6, 2, 0);
    gameORevDiag.placeMarkerInBoard(4, 1, 1);
    
    assertEquals(-1, gameORevDiag.isWinner(0, 2));
    assertEquals(expectedBoard, gameORevDiag.toString());
  }

  @Test
  /**
   * Tests that no one has won and the board has been filled Tests the current
   * player is O that the in value of 0 is returned since no one won and the board
   * is filled the board state of the current game
   */
  void testNoWinnerBoardFilled() {
    TicTacToe gameFilled = new TicTacToe();

    String expectedBoard = " O | X | X \n-----------\n X | O | O \n-----------\n O | X | X \n\n";
    
    gameFilled.placeMarkerInBoard(1, 0, 1);
    gameFilled.placeMarkerInBoard(2, 0, 2);
    gameFilled.placeMarkerInBoard(3, 1, 0);
    gameFilled.placeMarkerInBoard(7, 2, 1);
    gameFilled.placeMarkerInBoard(8, 2, 2);
    gameFilled.changePlayer();
    gameFilled.placeMarkerInBoard(0, 0, 0);
    gameFilled.placeMarkerInBoard(4, 1, 1);
    gameFilled.placeMarkerInBoard(5, 1, 2);
    gameFilled.placeMarkerInBoard(6, 2, 0);
    
    assertEquals(0, gameFilled.isWinner(0, 1));
    assertEquals(expectedBoard, gameFilled.toString());
  }
  
  @Test
  /**
   * Tests switching of the current player for forced switch to either O or X if invalid input is entered
   */
  void testForcePlayerSwap() {
    TicTacToe playerSwap = new TicTacToe();
    
    assertEquals('X', playerSwap.getCurrentPlayer());
    playerSwap.setCurrentPlayer('O');
    assertEquals('O', playerSwap.getCurrentPlayer());
    playerSwap.setCurrentPlayer('X');
    assertEquals('X', playerSwap.getCurrentPlayer());
    playerSwap.setCurrentPlayer('O');
    assertEquals('O', playerSwap.getCurrentPlayer());
    playerSwap.setCurrentPlayer('G');
    assertEquals('X', playerSwap.getCurrentPlayer());
  }

  @Test
  /**
   * Tests the removal of a X marker from the game board
   */
  void testRemoveXMarkerInBoard() {
    TicTacToe original = new TicTacToe();

    String expectedBoard = "   |   |   \n-----------\n   |   |   \n-----------\n   |   |   \n\n";
    String coords = "{0=(0, 0), 1=(0, 1), 2=(0, 2), 3=(1, 0), 4=(1, 1), 5=(1, 2), 6=(2, 0), 7=(2, 1), 8=(2, 2)}";
    
    assertTrue(original.placeMarkerInBoard(1, 0, 1));
    assertTrue(original.removeMarkerFromBoard(1, 0, 1));
    assertEquals(9, original.getNumberOfOpenSlots());
    assertEquals(coords, original.getCoordinates().toString());
    assertEquals(expectedBoard, original.toString());
  }
  
  @Test
  /**
   * Tests the removal of an O marker from the game board
   */
  void testRemoveOMarkerInBoard() {
    TicTacToe original = new TicTacToe();

    String expectedBoard = "   | X |   \n-----------\n   |   |   \n-----------\n   |   |   \n\n";
    String coords = "{0=(0, 0), 2=(0, 2), 3=(1, 0), 4=(1, 1), 5=(1, 2), 6=(2, 0), 7=(2, 1), 8=(2, 2)}";
    
    assertTrue(original.placeMarkerInBoard(1, 0, 1));
    original.changePlayer();
    assertTrue(original.placeMarkerInBoard(0, 0, 0));
    assertTrue(original.removeMarkerFromBoard(0, 0, 0));
    assertEquals(8, original.getNumberOfOpenSlots());
    assertEquals(coords, original.getCoordinates().toString());
    assertEquals(expectedBoard, original.toString());
  }
}
