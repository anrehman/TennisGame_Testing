import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TennisGameTest {
	
private static final String LOVE_LOVE = "love - love";

	// Here is the format of the scores: "player1Score - player2Score"
// "love - love"
// "15 - 15"
// "30 - 30"
// "deuce"
// "15 - love", "love - 15"
// "30 - love", "love - 30"
// "40 - love", "love - 40"
// "30 - 15", "15 - 30"
// "40 - 15", "15 - 40"
// "player1 has advantage"
// "player2 has advantage"
// "player1 wins"
// "player2 wins"

	public TennisGame game;
	
	
	public TennisGameTest() {
		game = new TennisGame();
	}
	
	@Before
	public void playTillDeuce() throws TennisGameException {
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
	}
	

	@Test
	public void testTennisGame_Start() {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", LOVE_LOVE, score);		
	}
	
	@Test
	public void testTennisGame_EahcPlayerWin4Points_Score_Deuce() throws TennisGameException {
		//Arrange		
		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "deuce", score);		
	}
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player1WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		//Act
		// This statement should cause an exception
		game.player1Scored();			
	}		
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player2WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		//Act
		// This statement should cause an exception
		game.player2Scored();			
	}
	
	@Test
	public void testTennisGame_Player1Wins() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		//Act
		String score = game.getScore() ;
				
		// Assert
		assertEquals("Player 1 wins test incorrect", "player1 wins", score);				
	}	
	
	
	@Test
	public void testTennisGame_Player2Wins() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		
		// Assert
		assertEquals("Player 2 wins test incorrect", "player2 wins", score);				
	}
	
	@Test
	public void testTennisGame_Player1hasAdvantage() throws TennisGameException {
		//Arrange
		//Act
		game.player1Scored();
		//Act
		String score = game.getScore() ;
				
		// Assert
		assertEquals("Player 1 has advantage test incorrect", "player1 has advantage", score);				
	}	
	
	@Test
	public void testTennisGame_Player2hasAdvantage() throws TennisGameException {
		//Arrange
		//Act
		game.player2Scored();
		//Act
		String score = game.getScore() ;
				
		// Assert
		assertEquals("Player 2 has advantage test incorrect", "player2 has advantage", score);				
	}
	
	@Test
	public void testTennisGame_Player1WinsAfterAdvantage() throws TennisGameException {
		//Arrange
		//Act
		game.player1Scored();
		game.player1Scored();
		//Act
		String score = game.getScore() ;
				
		// Assert
		assertEquals("Player 1 wins after advantage test incorrect", "player1 wins", score);				
	}
	
	@Test
	public void testTennisGame_Player2WinsAfterAdvantage() throws TennisGameException {
		//Arrange
		//Act
		game.player2Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
				
		// Assert
		assertEquals("Player 2 wins after advantage test incorrect", "player2 wins", score);				
	}
	
	@Test
	public void testTennisGame_EachPlayerWin3Points_Score_Deuce() throws TennisGameException {
		//Arrange		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score  incorrect", "deuce", score);		
	}
	
	@Test
	public void testTennisGame_Player1WinsHaving2MorePoints() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player1Scored();
		//Act
		String score = game.getScore() ;
				
		// Assert
		assertEquals("player 1 wins having 2 more points test incorrect", "player1 wins", score);				
	}	
	
	@Test
	public void testTennisGame_Score15_40() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
				
		// Assert
		assertEquals("15 - 40 score incorrect", "15 - 40", score);				
	}	
}
