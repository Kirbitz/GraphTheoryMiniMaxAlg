package application;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TicTacToeTest {

	//TODO
	//Tests need to be rewritten as code has changed
	@Test
	/**
	 * Tests the tictactoe is constructing properly with currentPlayer <- X,
	 * numberOfSlots <- 9, and gameBoard being filled with space chars
	 */
	void testTicTacToe() {
		TicTacToe original = new TicTacToe();
		String expectedBoard = "   |   |   \n-----------\n   |   |   \n-----------\n   |   |   \n\n";

		assertEquals('X', original.getCurrentPlayer());
		assertEquals(9, original.getNumberOfOpenSlots());
		assertEquals(expectedBoard, original.toString());

	}

	@Test
	/**
	 * Checks if the copy constructor copies the current board state from the
	 * original tictactoe board
	 */
	void testTicTacToeCopy() {
		TicTacToe original = new TicTacToe();
		original.placeMarkerInBoard(1, 0);
		original.isWinner(1, 0);

		TicTacToe copy = new TicTacToe(original);
		String expectedBoard = "   | X |   \n-----------\n   |   |   \n-----------\n   |   |   \n\n";

		assertEquals('O', copy.getCurrentPlayer());
		assertEquals(8, copy.getNumberOfOpenSlots());
		assertEquals(expectedBoard, copy.toString());

	}

	@Test
	/**
	 * Tests a single marker being placed into the board 
	 * Tests if the marker was placed 
	 * 		 if the number of spots available updated 
	 * 		 if the board updated with the marker in the correct location
	 */
	void testFirstPlaceMarkerInBoard() {
		TicTacToe original = new TicTacToe();

		String expectedBoard = "   | X |   \n-----------\n   |   |   \n-----------\n   |   |   \n\n";

		assertTrue(original.placeMarkerInBoard(1, 0));
		original.isWinner(1, 0);
		assertEquals(8, original.getNumberOfOpenSlots());
		assertEquals(expectedBoard, original.toString());

	}

	@Test
	/**
	 * Tests invalid placement of markers in the gameBoard 
	 * Tests x < 0 
	 * 		 y < 0 
	 * 		 x > gameBoard.length - 1 
	 * 		 y > gameBoard.length - 1 
	 * 		 the placement of a marker at x, y where a marker already exists
	 */
	void testInvalidPlaceMarkerInBoard() {
		TicTacToe original = new TicTacToe();
		original.placeMarkerInBoard(1, 0);
		original.isWinner(1, 0);

		assertFalse(original.placeMarkerInBoard(-1, 1));
		assertFalse(original.placeMarkerInBoard(0, -1));
		assertFalse(original.placeMarkerInBoard(3, 0));
		assertFalse(original.placeMarkerInBoard(0, 3));
		assertFalse(original.placeMarkerInBoard(1, 0));

	}

	@Test
	/**
	 * Tests two markers being placed into the board
	 * Tests if two markers were placed
	 * 		 if the number of spots available updated
	 * 		 if the board updated with the marker in the correct location
	 */
	void testSecondPlaceMarkerInBoard() {
		TicTacToe original = new TicTacToe();

		String expectedBoard = " O | X |   \n-----------\n   |   |   \n-----------\n   |   |   \n\n";
		assertTrue(original.placeMarkerInBoard(1, 0));
		original.isWinner(1, 0);
		assertTrue(original.placeMarkerInBoard(0, 0));
		original.isWinner(1, 0);
		assertEquals(7, original.getNumberOfOpenSlots());
		assertEquals(expectedBoard, original.toString());
	}

	@Test
	/**
	 * Tests three markers being placed into the board 
	 * Tests if three markers were placed 
	 * 		 if the number of spots available updated 
	 * 		 if the board updated with the marker in the correct location
	 */
	void testThirdPlaceMarkerInBoard() {
		TicTacToe original = new TicTacToe();

		String expectedBoard = " O | X | X \n-----------\n   |   |   \n-----------\n   |   |   \n\n";

		assertTrue(original.placeMarkerInBoard(1, 0));
		original.isWinner(1, 0);
		assertTrue(original.placeMarkerInBoard(0, 0));
		original.isWinner(1, 0);
		assertTrue(original.placeMarkerInBoard(2, 0));
		original.isWinner(1, 0);
		assertEquals(6, original.getNumberOfOpenSlots());
		assertEquals(expectedBoard, original.toString());

	}

	@Test
	/**
	 * Tests four markers being placed into the board 
	 * Tests if four markers were placed 
	 * 		 if the number of spots available updated 
	 * 		 if the board updated with the marker in the correct location
	 */
	void testFourthPlaceMarkerInBoard() {
		TicTacToe original = new TicTacToe();

		String expectedBoard = " O | X | X \n-----------\n   | O |   \n-----------\n   |   |   \n\n";

		assertTrue(original.placeMarkerInBoard(1, 0));
		original.isWinner(1, 0);
		assertTrue(original.placeMarkerInBoard(0, 0));
		original.isWinner(1, 0);
		assertTrue(original.placeMarkerInBoard(2, 0));
		original.isWinner(1, 0);
		assertTrue(original.placeMarkerInBoard(1, 1));
		original.isWinner(1, 0);
		assertEquals(5, original.getNumberOfOpenSlots());
		assertEquals(expectedBoard, original.toString());

	}

	@Test
	/**
	 * Tests five markers being placed into the board
	 * Tests if five markers were placed 
	 * 		 if the number of spots available updated 
	 * 		 if the board updated with the marker in the correct location
	 */
	void testFifthPlaceMarkerInBoard() {
		TicTacToe original = new TicTacToe();

		String expectedBoard = " O | X | X \n-----------\n X | O |   \n-----------\n   |   |   \n\n";

		assertTrue(original.placeMarkerInBoard(1, 0));
		original.isWinner(1, 0);
		assertTrue(original.placeMarkerInBoard(0, 0));
		original.isWinner(1, 0);
		assertTrue(original.placeMarkerInBoard(2, 0));
		original.isWinner(1, 0);
		assertTrue(original.placeMarkerInBoard(1, 1));
		original.isWinner(1, 0);
		assertTrue(original.placeMarkerInBoard(0, 1));
		original.isWinner(1, 0);
		assertEquals(4, original.getNumberOfOpenSlots());
		assertEquals(expectedBoard, original.toString());

	}

	@Test
	/**
	 * Tests six markers being placed into the board 
	 * Tests if six markers were placed 
	 * 		 if the number of spots available updated 
	 * 		 if the board updated with the marker in the correct location
	 */
	void testSixthPlaceMarkerInBoard() {
		TicTacToe original = new TicTacToe();

		String expectedBoard = " O | X | X \n-----------\n X | O |   \n-----------\n   | O |   \n\n";

		assertTrue(original.placeMarkerInBoard(1, 0));
		original.isWinner(1, 0);
		assertTrue(original.placeMarkerInBoard(0, 0));
		original.isWinner(1, 0);
		assertTrue(original.placeMarkerInBoard(2, 0));
		original.isWinner(1, 0);
		assertTrue(original.placeMarkerInBoard(1, 1));
		original.isWinner(1, 0);
		assertTrue(original.placeMarkerInBoard(0, 1));
		original.isWinner(1, 0);
		assertTrue(original.placeMarkerInBoard(1, 2));
		original.isWinner(1, 0);
		assertEquals(3, original.getNumberOfOpenSlots());
		assertEquals(expectedBoard, original.toString());

	}

	@Test
	/**
	 * Tests seven markers being placed into the board 
	 * Tests if seven markers were placed 
	 * 		 if the number of spots available updated 
	 * 		 if the board updated with the marker in the correct location
	 */
	void testSeventhPlaceMarkerInBoard() {
		TicTacToe original = new TicTacToe();

		String expectedBoard = " O | X | X \n-----------\n X | O |   \n-----------\n X | O |   \n\n";

		assertTrue(original.placeMarkerInBoard(1, 0));
		original.isWinner(1, 0);
		assertTrue(original.placeMarkerInBoard(0, 0));
		original.isWinner(1, 0);
		assertTrue(original.placeMarkerInBoard(2, 0));
		original.isWinner(1, 0);
		assertTrue(original.placeMarkerInBoard(1, 1));
		original.isWinner(1, 0);
		assertTrue(original.placeMarkerInBoard(0, 1));
		original.isWinner(1, 0);
		assertTrue(original.placeMarkerInBoard(1, 2));
		original.isWinner(1, 0);
		assertTrue(original.placeMarkerInBoard(0, 2));
		original.isWinner(1, 0);
		assertEquals(2, original.getNumberOfOpenSlots());
		assertEquals(expectedBoard, original.toString());

	}

	@Test
	/**
	 * Tests eight markers being placed into the board 
	 * Tests if eight markers were placed 
	 * 		 if the number of spots available updated 
	 * 		 if the board updated with the marker in the correct location
	 */
	void testEighthPlaceMarkerInBoard() {
		TicTacToe original = new TicTacToe();

		String expectedBoard = " O | X | X \n-----------\n X | O | O \n-----------\n X | O |   \n\n";

		assertTrue(original.placeMarkerInBoard(1, 0));
		original.isWinner(1, 0);
		assertTrue(original.placeMarkerInBoard(0, 0));
		original.isWinner(1, 0);
		assertTrue(original.placeMarkerInBoard(2, 0));
		original.isWinner(1, 0);
		assertTrue(original.placeMarkerInBoard(1, 1));
		original.isWinner(1, 0);
		assertTrue(original.placeMarkerInBoard(0, 1));
		original.isWinner(1, 0);
		assertTrue(original.placeMarkerInBoard(1, 2));
		original.isWinner(1, 0);
		assertTrue(original.placeMarkerInBoard(0, 2));
		original.isWinner(1, 0);
		assertTrue(original.placeMarkerInBoard(2, 1));
		original.isWinner(1, 0);
		assertEquals(1, original.getNumberOfOpenSlots());
		assertEquals(expectedBoard, original.toString());

	}

	@Test
	/**
	 * Tests nine markers being placed into the board 
	 * Tests if nine markers were placed 
	 * 		 if the number of spots available updated 
	 * 		 if the board updated with the marker in the correct location
	 */
	void testEBoardFilled() {
		TicTacToe original = new TicTacToe();

		String expectedBoard = " O | X | X \n-----------\n X | O | O \n-----------\n X | O | X \n\n";

		assertTrue(original.placeMarkerInBoard(1, 0));
		original.isWinner(1, 0);
		assertTrue(original.placeMarkerInBoard(0, 0));
		original.isWinner(1, 0);
		assertTrue(original.placeMarkerInBoard(2, 0));
		original.isWinner(1, 0);
		assertTrue(original.placeMarkerInBoard(1, 1));
		original.isWinner(1, 0);
		assertTrue(original.placeMarkerInBoard(0, 1));
		original.isWinner(1, 0);
		assertTrue(original.placeMarkerInBoard(1, 2));
		original.isWinner(1, 0);
		assertTrue(original.placeMarkerInBoard(0, 2));
		original.isWinner(1, 0);
		assertTrue(original.placeMarkerInBoard(2, 1));
		original.isWinner(1, 0);
		assertTrue(original.placeMarkerInBoard(2, 2));
		assertEquals(0, original.getNumberOfOpenSlots());
		assertEquals(expectedBoard, original.toString());

	}

	@Test
	/**
	 * Tests that the game continues since X and O have not won and the board is not
	 * filled 
	 * Tests the current player is X 
	 * 		 that the in value of char X is returned
	 * 		 the board state of the current game
	 */
	void testContinueGameIsWinner() {
		TicTacToe gameContinue = new TicTacToe();

		String expectedBoard = " O | X | X \n-----------\n   | O |   \n-----------\n   |   |   \n\n";

		gameContinue.placeMarkerInBoard(1, 0);
		assertEquals('O', gameContinue.isWinner(1, 0));
		gameContinue.placeMarkerInBoard(0, 0);
		assertEquals('X', gameContinue.isWinner(0, 0));
		gameContinue.placeMarkerInBoard(2, 0);
		assertEquals('O', gameContinue.isWinner(2, 0));
		gameContinue.placeMarkerInBoard(1, 1);
		assertEquals('X', gameContinue.isWinner(1, 1));

		assertEquals('X', gameContinue.getCurrentPlayer());
		assertEquals(expectedBoard, gameContinue.toString());

	}

	@Test
	/**
	 * Tests that X has won the game through a row and since X is the computer then
	 * 1 will be returned 
	 * Tests the current player is X 
	 * 		 that the value of 1 is returned since X has won 
	 * 		 the board state of the current game
	 */
	void testXIsWinnerRow() {
		TicTacToe gameXRow = new TicTacToe();

		String expectedBoard = " X | X | X \n-----------\n O | O |   \n-----------\n   |   |   \n\n";

		gameXRow.placeMarkerInBoard(1, 0);
		assertEquals('O', gameXRow.isWinner(1, 0));
		gameXRow.placeMarkerInBoard(0, 1);
		assertEquals('X', gameXRow.isWinner(0, 1));
		gameXRow.placeMarkerInBoard(2, 0);
		assertEquals('O', gameXRow.isWinner(2, 0));
		gameXRow.placeMarkerInBoard(1, 1);
		assertEquals('X', gameXRow.isWinner(1, 1));
		gameXRow.placeMarkerInBoard(0, 0);
		assertEquals(1, gameXRow.isWinner(0, 0));

		assertEquals('X', gameXRow.getCurrentPlayer());
		assertEquals(expectedBoard, gameXRow.toString());

	}

	@Test
	/**
	 * Tests that X has won the game through a column and since X is the computer
	 * then 1 will be returned 
	 * Tests the current player is X 
	 * 		 that the value of 1 is returned since X has won 
	 * 		 the board state of the current game
	 */
	void testXIsWinnerCol() {
		TicTacToe gameXCol = new TicTacToe();

		String expectedBoard = " X | O |   \n-----------\n X | O |   \n-----------\n X |   |   \n\n";

		gameXCol.placeMarkerInBoard(0, 1);
		assertEquals('O', gameXCol.isWinner(0, 1));
		gameXCol.placeMarkerInBoard(1, 0);
		assertEquals('X', gameXCol.isWinner(1, 0));
		gameXCol.placeMarkerInBoard(0, 2);
		assertEquals('O', gameXCol.isWinner(0, 2));
		gameXCol.placeMarkerInBoard(1, 1);
		assertEquals('X', gameXCol.isWinner(1, 1));
		gameXCol.placeMarkerInBoard(0, 0);
		assertEquals(1, gameXCol.isWinner(0, 0));

		assertEquals('X', gameXCol.getCurrentPlayer());
		assertEquals(expectedBoard, gameXCol.toString());

	}

	@Test
	/**
	 * Tests that X has won the game through a diagonal and since X is the computer
	 * then 1 will be returned 
	 * Tests the current player is X 
	 * 		 that the value of 1 is returned since X has won 
	 * 		 the board state of the current game
	 */
	void testXIsWinnerDiag() {
		TicTacToe gameXDiag = new TicTacToe();

		String expectedBoard = " X | O |   \n-----------\n O | X |   \n-----------\n   |   | X \n\n";

		gameXDiag.placeMarkerInBoard(1, 1);
		assertEquals('O', gameXDiag.isWinner(1, 1));
		gameXDiag.placeMarkerInBoard(0, 1);
		assertEquals('X', gameXDiag.isWinner(0, 1));
		gameXDiag.placeMarkerInBoard(2, 2);
		assertEquals('O', gameXDiag.isWinner(2, 2));
		gameXDiag.placeMarkerInBoard(1, 0);
		assertEquals('X', gameXDiag.isWinner(1, 0));
		gameXDiag.placeMarkerInBoard(0, 0);
		assertEquals(1, gameXDiag.isWinner(0, 0));

		assertEquals('X', gameXDiag.getCurrentPlayer());
		assertEquals(expectedBoard, gameXDiag.toString());

	}

	@Test
	/**
	 * Tests that X has won the game through a reverse diagonal and since X is the
	 * computer then 1 will be returned 
	 * Tests the current player is X 
	 * 		 that the value of 1 is returned since X has won 
	 * 		 the board state of the current game
	 */
	void testXIsWinnerRevDiag() {
		TicTacToe gameXRevDiag = new TicTacToe();

		String expectedBoard = "   | O | X \n-----------\n O | X |   \n-----------\n X |   |   \n\n";

		gameXRevDiag.placeMarkerInBoard(1, 1);
		assertEquals('O', gameXRevDiag.isWinner(1, 1));
		gameXRevDiag.placeMarkerInBoard(0, 1);
		assertEquals('X', gameXRevDiag.isWinner(0, 1));
		gameXRevDiag.placeMarkerInBoard(0, 2);
		assertEquals('O', gameXRevDiag.isWinner(0, 2));
		gameXRevDiag.placeMarkerInBoard(1, 0);
		assertEquals('X', gameXRevDiag.isWinner(1, 0));
		gameXRevDiag.placeMarkerInBoard(2, 0);
		assertEquals(1, gameXRevDiag.isWinner(2, 0));

		assertEquals('X', gameXRevDiag.getCurrentPlayer());
		assertEquals(expectedBoard, gameXRevDiag.toString());

	}

	@Test
	/**
	 * Tests that O has won the game through a row and since X is the computer then
	 * -1 will be returned 
	 * Tests the current player is O 
	 * 		 that the value of -1 is returned since O has won 
	 * 		 the board state of the current game
	 */
	void testOIsWinnerRow() {
		TicTacToe gameORow = new TicTacToe();

		String expectedBoard = "   | O | X \n-----------\n   | O |   \n-----------\n X | O | X \n\n";

		gameORow.placeMarkerInBoard(2, 0);
		assertEquals('O', gameORow.isWinner(2, 0));
		gameORow.placeMarkerInBoard(1, 0);
		assertEquals('X', gameORow.isWinner(1, 0));
		gameORow.placeMarkerInBoard(0, 2);
		assertEquals('O', gameORow.isWinner(0, 2));
		gameORow.placeMarkerInBoard(1, 1);
		assertEquals('X', gameORow.isWinner(1, 1));
		gameORow.placeMarkerInBoard(2, 2);
		assertEquals('O', gameORow.isWinner(2, 2));
		gameORow.placeMarkerInBoard(1, 2);
		assertEquals(-1, gameORow.isWinner(1, 2));

		assertEquals('O', gameORow.getCurrentPlayer());
		assertEquals(expectedBoard, gameORow.toString());
	}

	@Test
	/**
	 * Tests that O has won the game through a column and since X is the computer
	 * then -1 will be returned 
	 * Tests the current player is O 
	 * 		 that the value of -1 is returned since O has won 
	 * 		 the board state of the current game
	 */
	void testOIsWinnerCol() {
		TicTacToe gameOCol = new TicTacToe();

		String expectedBoard = "   |   | X \n-----------\n O | O | O \n-----------\n X |   | X \n\n";

		gameOCol.placeMarkerInBoard(2, 0);
		assertEquals('O', gameOCol.isWinner(2, 0));
		gameOCol.placeMarkerInBoard(0, 1);
		assertEquals('X', gameOCol.isWinner(0, 1));
		gameOCol.placeMarkerInBoard(0, 2);
		assertEquals('O', gameOCol.isWinner(0, 2));
		gameOCol.placeMarkerInBoard(1, 1);
		assertEquals('X', gameOCol.isWinner(1, 1));
		gameOCol.placeMarkerInBoard(2, 2);
		assertEquals('O', gameOCol.isWinner(2, 2));
		gameOCol.placeMarkerInBoard(2, 1);
		assertEquals(-1, gameOCol.isWinner(2, 1));

		assertEquals('O', gameOCol.getCurrentPlayer());
		assertEquals(expectedBoard, gameOCol.toString());

	}

	@Test
	/**
	 * Tests that O has won the game through a diagonal and since X is the computer
	 * then -1 will be returned 
	 * Tests the current player is O 
	 * 		 that the value of -1 is returned since O has won 
	 * 		 the board state of the current game
	 */
	void testOIsWinnerDiag() {
		TicTacToe gameODiag = new TicTacToe();

		String expectedBoard = " O |   | X \n-----------\n   | O |   \n-----------\n X | X | O \n\n";

		gameODiag.placeMarkerInBoard(2, 0);
		assertEquals('O', gameODiag.isWinner(2, 0));
		gameODiag.placeMarkerInBoard(0, 0);
		assertEquals('X', gameODiag.isWinner(0, 0));
		gameODiag.placeMarkerInBoard(0, 2);
		assertEquals('O', gameODiag.isWinner(0, 2));
		gameODiag.placeMarkerInBoard(1, 1);
		assertEquals('X', gameODiag.isWinner(1, 1));
		gameODiag.placeMarkerInBoard(1, 2);
		assertEquals('O', gameODiag.isWinner(1, 2));
		gameODiag.placeMarkerInBoard(2, 2);
		assertEquals(-1, gameODiag.isWinner(2, 2));

		assertEquals('O', gameODiag.getCurrentPlayer());
		assertEquals(expectedBoard, gameODiag.toString());

	}

	@Test
	/**
	 * Tests that O has won the game through a reverse diagonal and since X is the
	 * computer then -1 will be returned 
	 * Tests the current player is O 
	 * 		 that the value of -1 is returned since O has won 
	 * 		 the board state of the current game
	 */
	void testOIsWinnerRevDiag() {
		TicTacToe gameORevDiag = new TicTacToe();

		String expectedBoard = "   | X | O \n-----------\n   | O |   \n-----------\n O | X | X \n\n";

		gameORevDiag.placeMarkerInBoard(1, 0);
		assertEquals('O', gameORevDiag.isWinner(1, 0));
		gameORevDiag.placeMarkerInBoard(2, 0);
		assertEquals('X', gameORevDiag.isWinner(2, 0));
		gameORevDiag.placeMarkerInBoard(1, 2);
		assertEquals('O', gameORevDiag.isWinner(1, 2));
		gameORevDiag.placeMarkerInBoard(1, 1);
		assertEquals('X', gameORevDiag.isWinner(1, 1));
		gameORevDiag.placeMarkerInBoard(2, 2);
		assertEquals('O', gameORevDiag.isWinner(2, 2));
		gameORevDiag.placeMarkerInBoard(0, 2);
		assertEquals(-1, gameORevDiag.isWinner(0, 2));

		assertEquals('O', gameORevDiag.getCurrentPlayer());
		assertEquals(expectedBoard, gameORevDiag.toString());
	}

	@Test
	/**
	 * Tests that no one has won and the board has been filled 
	 * Tests the current player is O 
	 * 		 that the in value of 0 is returned since no one won and the board is filled
	 * 		 the board state of the current game
	 */
	void testNoWinnerBoardFilled() {
		TicTacToe gameFilled = new TicTacToe();

		String expectedBoard = " O | X | X \n-----------\n X | O | O \n-----------\n O | X | X \n\n";
		gameFilled.placeMarkerInBoard(1, 0);
		assertEquals('O', gameFilled.isWinner(1, 0));
		gameFilled.placeMarkerInBoard(0, 0);
		assertEquals('X', gameFilled.isWinner(0, 0));
		gameFilled.placeMarkerInBoard(2, 0);
		assertEquals('O', gameFilled.isWinner(2, 0));
		gameFilled.placeMarkerInBoard(1, 1);
		assertEquals('X', gameFilled.isWinner(1, 1));
		gameFilled.placeMarkerInBoard(1, 2);
		assertEquals('O', gameFilled.isWinner(1, 2));
		gameFilled.placeMarkerInBoard(2, 1);
		assertEquals('X', gameFilled.isWinner(2, 1));
		gameFilled.placeMarkerInBoard(2, 2);
		assertEquals('O', gameFilled.isWinner(1, 2));
		gameFilled.placeMarkerInBoard(0, 2);
		assertEquals('X', gameFilled.isWinner(2, 2));
		gameFilled.placeMarkerInBoard(0, 1);
		assertEquals(0, gameFilled.isWinner(0, 1));

		assertEquals('X', gameFilled.getCurrentPlayer());
		assertEquals(expectedBoard, gameFilled.toString());
	}

}
