import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TicTacToeTest {

	@Test
	/**
	 * Tests the tictactoe is constructing properly with currentPlayer <- X, numberOfSlots <- 9, and gameBoard being filled with space chars
	 */
	void testTicTacToe() {
		TicTacToe original = new TicTacToe();
		String expectedBoard = "   |   |   \n-----------\n   |   |   \n-----------\n   |   |   \n\n";
		try {
			assertEquals('X', original.getCurrentPlayer());
			assertEquals(9, original.getNumberOfOpenSlots());
			assertEquals(expectedBoard, original.toString());
		}catch(Exception e) {
			fail("Unexpected Error Occured!");
		}
	}

	@Test
	/**
	 * Checks if the copy constructor copies the current board state from the original tictactoe board
	 */
	void testTicTacToeCopy() {
		TicTacToe original = new TicTacToe();
		original.placeMarkerInBoard(1, 0);
		original.isWinner(1, 0, 'X');
		
		TicTacToe copy = new TicTacToe(original);
		String expectedBoard = "   | X |   \n-----------\n   |   |   \n-----------\n   |   |   \n\n";
		try {
			assertEquals('O', copy.getCurrentPlayer());
			assertEquals(8, copy.getNumberOfOpenSlots());
			assertEquals(expectedBoard, copy.toString());
		}catch(Exception e) {
			fail("Unexpected Error Occured!");
		}
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
		try {
			assertTrue(original.placeMarkerInBoard(1, 0));
			original.isWinner(1, 0, 'X');
			assertEquals(8, original.getNumberOfOpenSlots());
			assertEquals(expectedBoard, original.toString());
		}catch(Exception e) {
			fail("Unexpected Error Occured!");
		}
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
		original.isWinner(1, 0, 'X');

		try {
			assertFalse(original.placeMarkerInBoard(-1, 1));
			assertFalse(original.placeMarkerInBoard(0, -1));
			assertFalse(original.placeMarkerInBoard(3, 0));
			assertFalse(original.placeMarkerInBoard(0, 3));
			assertFalse(original.placeMarkerInBoard(1, 0));
		}catch(Exception e) {
			fail("Unexpected Error Occured!");
		}
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
		try {
			assertTrue(original.placeMarkerInBoard(1, 0));
			original.isWinner(1, 0, 'X');
			assertTrue(original.placeMarkerInBoard(0, 0));
			original.isWinner(1, 0, 'X');
			assertEquals(7, original.getNumberOfOpenSlots());
			assertEquals(expectedBoard, original.toString());
		}catch(Exception e) {
			fail("Unexpected Error Occured!");
		}
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
		try {
			assertTrue(original.placeMarkerInBoard(1, 0));
			original.isWinner(1, 0, 'X');
			assertTrue(original.placeMarkerInBoard(0, 0));
			original.isWinner(1, 0, 'X');
			assertTrue(original.placeMarkerInBoard(2, 0));
			original.isWinner(1, 0, 'X');
			assertEquals(6, original.getNumberOfOpenSlots());
			assertEquals(expectedBoard, original.toString());
		}catch(Exception e) {
			fail("Unexpected Error Occured!");
		}
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
		try {
			assertTrue(original.placeMarkerInBoard(1, 0));
			original.isWinner(1, 0, 'X');
			assertTrue(original.placeMarkerInBoard(0, 0));
			original.isWinner(1, 0, 'X');
			assertTrue(original.placeMarkerInBoard(2, 0));
			original.isWinner(1, 0, 'X');
			assertTrue(original.placeMarkerInBoard(1, 1));
			original.isWinner(1, 0, 'X');
			assertEquals(5, original.getNumberOfOpenSlots());
			assertEquals(expectedBoard, original.toString());
		}catch(Exception e) {
			fail("Unexpected Error Occured!");
		}
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
		try {
			assertTrue(original.placeMarkerInBoard(1, 0));
			original.isWinner(1, 0, 'X');
			assertTrue(original.placeMarkerInBoard(0, 0));
			original.isWinner(1, 0, 'X');
			assertTrue(original.placeMarkerInBoard(2, 0));
			original.isWinner(1, 0, 'X');
			assertTrue(original.placeMarkerInBoard(1, 1));
			original.isWinner(1, 0, 'X');
			assertTrue(original.placeMarkerInBoard(0, 1));
			original.isWinner(1, 0, 'X');
			assertEquals(4, original.getNumberOfOpenSlots());
			assertEquals(expectedBoard, original.toString());
		}catch(Exception e) {
			fail("Unexpected Error Occured!");
		}
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
		try {
			assertTrue(original.placeMarkerInBoard(1, 0));
			original.isWinner(1, 0, 'X');
			assertTrue(original.placeMarkerInBoard(0, 0));
			original.isWinner(1, 0, 'X');
			assertTrue(original.placeMarkerInBoard(2, 0));
			original.isWinner(1, 0, 'X');
			assertTrue(original.placeMarkerInBoard(1, 1));
			original.isWinner(1, 0, 'X');
			assertTrue(original.placeMarkerInBoard(0, 1));
			original.isWinner(1, 0, 'X');
			assertTrue(original.placeMarkerInBoard(1, 2));
			original.isWinner(1, 0, 'X');
			assertEquals(3, original.getNumberOfOpenSlots());
			assertEquals(expectedBoard, original.toString());
		}catch(Exception e) {
			fail("Unexpected Error Occured!");
		}
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
		try {
			assertTrue(original.placeMarkerInBoard(1, 0));
			original.isWinner(1, 0, 'X');
			assertTrue(original.placeMarkerInBoard(0, 0));
			original.isWinner(1, 0, 'X');
			assertTrue(original.placeMarkerInBoard(2, 0));
			original.isWinner(1, 0, 'X');
			assertTrue(original.placeMarkerInBoard(1, 1));
			original.isWinner(1, 0, 'X');
			assertTrue(original.placeMarkerInBoard(0, 1));
			original.isWinner(1, 0, 'X');
			assertTrue(original.placeMarkerInBoard(1, 2));
			original.isWinner(1, 0, 'X');
			assertTrue(original.placeMarkerInBoard(0, 2));
			original.isWinner(1, 0, 'X');
			assertEquals(2, original.getNumberOfOpenSlots());
			assertEquals(expectedBoard, original.toString());
		}catch(Exception e) {
			fail("Unexpected Error Occured!");
		}
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
		try {
			assertTrue(original.placeMarkerInBoard(1, 0));
			original.isWinner(1, 0, 'X');
			assertTrue(original.placeMarkerInBoard(0, 0));
			original.isWinner(1, 0, 'X');
			assertTrue(original.placeMarkerInBoard(2, 0));
			original.isWinner(1, 0, 'X');
			assertTrue(original.placeMarkerInBoard(1, 1));
			original.isWinner(1, 0, 'X');
			assertTrue(original.placeMarkerInBoard(0, 1));
			original.isWinner(1, 0, 'X');
			assertTrue(original.placeMarkerInBoard(1, 2));
			original.isWinner(1, 0, 'X');
			assertTrue(original.placeMarkerInBoard(0, 2));
			original.isWinner(1, 0, 'X');
			assertTrue(original.placeMarkerInBoard(2, 1));
			original.isWinner(1, 0, 'X');
			assertEquals(1, original.getNumberOfOpenSlots());
			assertEquals(expectedBoard, original.toString());
		}catch(Exception e) {
			fail("Unexpected Error Occured!");
		}
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
		try {
			assertTrue(original.placeMarkerInBoard(1, 0));
			original.isWinner(1, 0, 'X');
			assertTrue(original.placeMarkerInBoard(0, 0));
			original.isWinner(1, 0, 'X');
			assertTrue(original.placeMarkerInBoard(2, 0));
			original.isWinner(1, 0, 'X');
			assertTrue(original.placeMarkerInBoard(1, 1));
			original.isWinner(1, 0, 'X');
			assertTrue(original.placeMarkerInBoard(0, 1));
			original.isWinner(1, 0, 'X');
			assertTrue(original.placeMarkerInBoard(1, 2));
			original.isWinner(1, 0, 'X');
			assertTrue(original.placeMarkerInBoard(0, 2));
			original.isWinner(1, 0, 'X');
			assertTrue(original.placeMarkerInBoard(2, 1));
			original.isWinner(1, 0, 'X');
			assertTrue(original.placeMarkerInBoard(2, 2));
			assertEquals(0, original.getNumberOfOpenSlots());
			assertEquals(expectedBoard, original.toString());
		}catch(Exception e) {
			fail("Unexpected Error Occured!");
		}
	}

	@Test
	/**
	 * Tests that the game continues since X and O have not won and the board is not filled
	 * Tests the current player is X
	 * 		 that the in value of char X is returned
	 * 		 the board state of the current game
	 */
	void testContinueGameIsWinner() {
		TicTacToe gameContinue = new TicTacToe();
		
		String expectedBoard = " O | X | X \n-----------\n   | O |   \n-----------\n   |   |   \n\n";
		try {
			gameContinue.placeMarkerInBoard(1, 0);
			assertEquals('X', gameContinue.isWinner(1, 0, 'X'));
			gameContinue.placeMarkerInBoard(0, 0);
			assertEquals('X', gameContinue.isWinner(0, 0, 'X'));
			gameContinue.placeMarkerInBoard(2, 0);
			assertEquals('X', gameContinue.isWinner(2, 0, 'X'));
			gameContinue.placeMarkerInBoard(1, 1);
			assertEquals('X', gameContinue.isWinner(1, 1, 'X'));
			
			assertEquals('X', gameContinue.getCurrentPlayer());
			assertEquals(expectedBoard, gameContinue.toString());
		}catch(Exception e) {
			fail("Unexpected Error Occured!");
		}
	}
	
	@Test
	/**
	 * Tests that X has won the game through a row and since X is the computer then 1 will be returned
	 * Tests the current player is X
	 * 		 that the in value of 1 is returned since X has won
	 * 		 the board state of the current game
	 */
	void testXIsWinnerRow() {
		TicTacToe gameXRow = new TicTacToe();
		
		String expectedBoard = " X | X | X \n-----------\n O | O |   \n-----------\n   |   |   \n\n";
		try {
			gameXRow.placeMarkerInBoard(1, 0);
			assertEquals('X', gameXRow.isWinner(1, 0, 'X'));
			gameXRow.placeMarkerInBoard(0, 1);
			assertEquals('X', gameXRow.isWinner(0, 1, 'X'));
			gameXRow.placeMarkerInBoard(2, 0);
			assertEquals('X', gameXRow.isWinner(2, 0, 'X'));
			gameXRow.placeMarkerInBoard(1, 1);
			assertEquals('X', gameXRow.isWinner(1, 1, 'X'));
			gameXRow.placeMarkerInBoard(0, 0);
			assertEquals(1, gameXRow.isWinner(0, 0, 'X'));
			
			assertEquals('X', gameXRow.getCurrentPlayer());
			assertEquals(expectedBoard, gameXRow.toString());
		}catch(Exception e) {
			fail("Unexpected Error Occured!");
		}
	}
	
	@Test
	/**
	 * Tests that X has won the game through a column and since X is the computer then 1 will be returned
	 * Tests the current player is X
	 * 		 that the in value of 1 is returned since X has won
	 * 		 the board state of the current game
	 */
	void testXIsWinnerCol() {
		TicTacToe gameXCol = new TicTacToe();
		
		String expectedBoard = " X | O |   \n-----------\n X | O |   \n-----------\n X |   |   \n\n";
		try {
			gameXCol.placeMarkerInBoard(0, 1);
			assertEquals('X', gameXCol.isWinner(0, 1, 'X'));
			gameXCol.placeMarkerInBoard(1, 0);
			assertEquals('X', gameXCol.isWinner(1, 0, 'X'));
			gameXCol.placeMarkerInBoard(0, 2);
			assertEquals('X', gameXCol.isWinner(0, 2, 'X'));
			gameXCol.placeMarkerInBoard(1, 1);
			assertEquals('X', gameXCol.isWinner(1, 1, 'X'));
			gameXCol.placeMarkerInBoard(0, 0);
			assertEquals(1, gameXCol.isWinner(0, 0, 'X'));
			
			assertEquals('X', gameXCol.getCurrentPlayer());
			assertEquals(expectedBoard, gameXCol.toString());
		}catch(Exception e) {
			fail("Unexpected Error Occured!");
		}
	}
	
	@Test
	/**
	 * Tests that X has won the game through a diagonal and since X is the computer then 1 will be returned
	 * Tests the current player is X
	 * 		 that the in value of 1 is returned since X has won
	 * 		 the board state of the current game
	 */
	void testXIsWinnerDiag() {
		TicTacToe gameXDiag = new TicTacToe();
		
		String expectedBoard = " X | O |   \n-----------\n O | X |   \n-----------\n   |   | X \n\n";
		try {
			gameXDiag.placeMarkerInBoard(1, 1);
			assertEquals('X', gameXDiag.isWinner(1, 1, 'X'));
			gameXDiag.placeMarkerInBoard(0, 1);
			assertEquals('X', gameXDiag.isWinner(0, 1, 'X'));
			gameXDiag.placeMarkerInBoard(2, 2);
			assertEquals('X', gameXDiag.isWinner(2, 2, 'X'));
			gameXDiag.placeMarkerInBoard(1, 0);
			assertEquals('X', gameXDiag.isWinner(1, 0, 'X'));
			gameXDiag.placeMarkerInBoard(0, 0);
			assertEquals(1, gameXDiag.isWinner(0, 0, 'X'));
			
			assertEquals('X', gameXDiag.getCurrentPlayer());
			assertEquals(expectedBoard, gameXDiag.toString());
		}catch(Exception e) {
			fail("Unexpected Error Occured!");
		}
	}
	
	@Test
	/**
	 * Tests that X has won the game through a reverse diagonal and since X is the computer then 1 will be returned
	 * Tests the current player is X
	 * 		 that the in value of 1 is returned since X has won
	 * 		 the board state of the current game
	 */
	void testXIsWinnerRevDiag() {
		TicTacToe gameXRevDiag = new TicTacToe();
		
		String expectedBoard = "   | O | X \n-----------\n O | X |   \n-----------\n X |   |   \n\n";
		try {
			gameXRevDiag.placeMarkerInBoard(1, 1);
			assertEquals('X', gameXRevDiag.isWinner(1, 1, 'X'));
			gameXRevDiag.placeMarkerInBoard(0, 1);
			assertEquals('X', gameXRevDiag.isWinner(0, 1, 'X'));
			gameXRevDiag.placeMarkerInBoard(0, 2);
			assertEquals('X', gameXRevDiag.isWinner(0, 2, 'X'));
			gameXRevDiag.placeMarkerInBoard(1, 0);
			assertEquals('X', gameXRevDiag.isWinner(1, 0, 'X'));
			gameXRevDiag.placeMarkerInBoard(2, 0);
			assertEquals(1, gameXRevDiag.isWinner(2, 0, 'X'));
			
			assertEquals('X', gameXRevDiag.getCurrentPlayer());
			assertEquals(expectedBoard, gameXRevDiag.toString());
		}catch(Exception e) {
			fail("Unexpected Error Occured!");
		}
	}
	
	@Test
	/**
	 * Tests that O has won the game through a row and since X is the computer then -1 will be returned
	 * Tests the current player is O
	 * 		 that the in value of -1 is returned since X has won
	 * 		 the board state of the current game
	 */
	void testOIsWinnerRow() {
		TicTacToe gameORow = new TicTacToe();
		
		String expectedBoard = "   | O | X \n-----------\n   | O |   \n-----------\n X | O | X \n\n";
		try {
			gameORow.placeMarkerInBoard(2, 0);
			assertEquals('X', gameORow.isWinner(2, 0, 'X'));
			gameORow.placeMarkerInBoard(1, 0);
			assertEquals('X', gameORow.isWinner(1, 0, 'X'));
			gameORow.placeMarkerInBoard(0, 2);
			assertEquals('X', gameORow.isWinner(0, 2, 'X'));
			gameORow.placeMarkerInBoard(1, 1);
			assertEquals('X', gameORow.isWinner(1, 1, 'X'));
			gameORow.placeMarkerInBoard(2, 2);
			assertEquals('X', gameORow.isWinner(2, 2, 'X'));
			gameORow.placeMarkerInBoard(1, 2);
			assertEquals(-1, gameORow.isWinner(1, 2, 'X'));
			
			assertEquals('O', gameORow.getCurrentPlayer());
			assertEquals(expectedBoard, gameORow.toString());
		}catch(Exception e) {
			fail("Unexpected Error Occured!");
		}
	}
	
	@Test
	/**
	 * Tests that O has won the game through a column and since X is the computer then -1 will be returned
	 * Tests the current player is O
	 * 		 that the in value of -1 is returned since X has won
	 * 		 the board state of the current game
	 */
	void testOIsWinnerCol() {
		TicTacToe gameOCol = new TicTacToe();
		
		String expectedBoard = "   |   | X \n-----------\n O | O | O \n-----------\n X |   | X \n\n";
		try {
			gameOCol.placeMarkerInBoard(2, 0);
			assertEquals('X', gameOCol.isWinner(2, 0, 'X'));
			gameOCol.placeMarkerInBoard(0, 1);
			assertEquals('X', gameOCol.isWinner(0, 1, 'X'));
			gameOCol.placeMarkerInBoard(0, 2);
			assertEquals('X', gameOCol.isWinner(0, 2, 'X'));
			gameOCol.placeMarkerInBoard(1, 1);
			assertEquals('X', gameOCol.isWinner(1, 1, 'X'));
			gameOCol.placeMarkerInBoard(2, 2);
			assertEquals('X', gameOCol.isWinner(2, 2, 'X'));
			gameOCol.placeMarkerInBoard(2, 1);
			assertEquals(-1, gameOCol.isWinner(2, 1, 'X'));
			
			assertEquals('O', gameOCol.getCurrentPlayer());
			assertEquals(expectedBoard, gameOCol.toString());
		}catch(Exception e) {
			fail("Unexpected Error Occured!");
		}
	}
	
	@Test
	/**
	 * Tests that O has won the game through a diagonal and since X is the computer then -1 will be returned
	 * Tests the current player is O
	 * 		 that the in value of -1 is returned since X has won
	 * 		 the board state of the current game
	 */
	void testOIsWinnerDiag() {
		TicTacToe gameODiag = new TicTacToe();
		
		String expectedBoard = " O |   | X \n-----------\n   | O |   \n-----------\n X | X | O \n\n";
		try {
			gameODiag.placeMarkerInBoard(2, 0);
			assertEquals('X', gameODiag.isWinner(2, 0, 'X'));
			gameODiag.placeMarkerInBoard(0, 0);
			assertEquals('X', gameODiag.isWinner(0, 0, 'X'));
			gameODiag.placeMarkerInBoard(0, 2);
			assertEquals('X', gameODiag.isWinner(0, 2, 'X'));
			gameODiag.placeMarkerInBoard(1, 1);
			assertEquals('X', gameODiag.isWinner(1, 1, 'X'));
			gameODiag.placeMarkerInBoard(1, 2);
			assertEquals('X', gameODiag.isWinner(1, 2, 'X'));
			gameODiag.placeMarkerInBoard(2, 2);
			assertEquals(-1, gameODiag.isWinner(2, 2, 'X'));
			
			assertEquals('O', gameODiag.getCurrentPlayer());
			assertEquals(expectedBoard, gameODiag.toString());
		}catch(Exception e) {
			fail("Unexpected Error Occured!");
		}
	}
	
	@Test
	/**
	 * Tests that O has won the game through a reverse diagonal and since X is the computer then -1 will be returned
	 * Tests the current player is O
	 * 		 that the in value of -1 is returned since X has won
	 * 		 the board state of the current game
	 */
	void testOIsWinnerRevDiag() {
		TicTacToe gameORevDiag = new TicTacToe();
		
		String expectedBoard = "   | X | O \n-----------\n   | O |   \n-----------\n O | X | X \n\n";
		try {
			gameORevDiag.placeMarkerInBoard(1, 0);
			assertEquals('X', gameORevDiag.isWinner(1, 0, 'X'));
			gameORevDiag.placeMarkerInBoard(2, 0);
			assertEquals('X', gameORevDiag.isWinner(2, 0, 'X'));
			gameORevDiag.placeMarkerInBoard(1, 2);
			assertEquals('X', gameORevDiag.isWinner(1, 2, 'X'));
			gameORevDiag.placeMarkerInBoard(1, 1);
			assertEquals('X', gameORevDiag.isWinner(1, 1, 'X'));
			gameORevDiag.placeMarkerInBoard(2, 2);
			assertEquals('X', gameORevDiag.isWinner(2, 2, 'X'));
			gameORevDiag.placeMarkerInBoard(0, 2);
			assertEquals(-1, gameORevDiag.isWinner(0, 2, 'X'));
			
			assertEquals('O', gameORevDiag.getCurrentPlayer());
			assertEquals(expectedBoard, gameORevDiag.toString());
		}catch(Exception e) {
			fail("Unexpected Error Occured!");
		}
	}
	
	@Test
	/**
	 * Tests that no one has won and the board has been filled
	 * Tests the current player is O
	 * 		 that the in value of -1 is returned since X has won
	 * 		 the board state of the current game
	 */
	void testNoWinnerBoardFilled() {
		TicTacToe gameFilled = new TicTacToe();
		
		String expectedBoard = " O | X | X \n-----------\n X | O | O \n-----------\n O | X | X \n\n";
		try {
			gameFilled.placeMarkerInBoard(1, 0);
			assertEquals('X', gameFilled.isWinner(1, 0, 'X'));
			gameFilled.placeMarkerInBoard(0, 0);
			assertEquals('X', gameFilled.isWinner(0, 0, 'X'));
			gameFilled.placeMarkerInBoard(2, 0);
			assertEquals('X', gameFilled.isWinner(2, 0, 'X'));
			gameFilled.placeMarkerInBoard(1, 1);
			assertEquals('X', gameFilled.isWinner(1, 1, 'X'));
			gameFilled.placeMarkerInBoard(1, 2);
			assertEquals('X', gameFilled.isWinner(1, 2, 'X'));
			gameFilled.placeMarkerInBoard(2, 1);
			assertEquals('X', gameFilled.isWinner(2, 1, 'X'));
			gameFilled.placeMarkerInBoard(2, 2);
			assertEquals('X', gameFilled.isWinner(1, 2, 'X'));
			gameFilled.placeMarkerInBoard(0, 2);
			assertEquals('X', gameFilled.isWinner(2, 2, 'X'));
			gameFilled.placeMarkerInBoard(0, 1);
			assertEquals(0, gameFilled.isWinner(0, 1, 'X'));
			
			assertEquals('X', gameFilled.getCurrentPlayer());
			assertEquals(expectedBoard, gameFilled.toString());
		}catch(Exception e) {
			fail("Unexpected Error Occured!");
		}
	}

}
