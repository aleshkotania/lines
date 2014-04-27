package task.lines;

import game.lines.Deck;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
  /**
   * Create the test case
   *
   * @param testName name of the test case
   */
  public AppTest(String testName) {
    super(testName);
  }

  /**
   * @return the suite of tests being tested
   */
  public static Test suite() {
    return new TestSuite(AppTest.class);
  }

  /**
   * Rigourous Test :-)
   */
  public void testCreateDeck() {
    Deck deck = new Deck();
    assertTrue(deck.getAmountOfBalls() == 3);
  }

  public void testAmountOfBalls() {
    Deck deck = new Deck();
    assertTrue(deck.getScore() == 0);
    deck.createFixPositionBall(1, 5);
    deck.createFixPositionBall(1, 7);
    deck.createFixPositionBall(3, 0);
    deck.createFixPositionBall(4, 4);
    assertTrue(deck.getAmountOfBalls() == 7);
    deck.click(3, 0);
    deck.click(5, 4);
    //deck.show();
    assertTrue(deck.getScore() == 8);
    assertTrue(deck.getAmountOfBalls() == 4);
    deck.createFixPositionBall(5, 2);
    deck.createFixPositionBall(6, 3);
    deck.createFixPositionBall(5, 5);
    //deck.show();
    assertTrue(deck.getAmountOfBalls() == 7);
    deck.click(5, 5);
  //  deck.show();
    assertTrue(deck.getAmountOfBalls() == 7);
    deck.click(7, 4);
   // deck.show();
    assertTrue(deck.getScore() == 16);
    assertTrue(deck.getAmountOfBalls() == 4);
    deck.click(7, 6);
    assertTrue(deck.getAmountOfBalls() == 4);
    deck.click(1, 6);
    assertTrue(deck.getScore() == 24);
    assertTrue(deck.getAmountOfBalls() == 1);
  }

  public void testExploreWay() {
    Deck deck = new Deck();
    deck.createFixPositionBall(2, 0);
    deck.createFixPositionBall(2, 1);
    deck.createFixPositionBall(2, 2);
    deck.createFixPositionBall(1, 3);
    deck.createFixPositionBall(0, 4);
    assertNull(deck.getDeckExploer().exploreWay(deck.getCells(), 0, 0, 3, 7));
    assertNotNull(deck.getDeckExploer().exploreWay(deck.getCells(), 0, 0, 1, 2));
    deck.createFixPositionBall(3, 5);
    deck.click(0, 4);
    deck.click(3, 6);
    assertNotNull(deck.getDeckExploer().exploreWay(deck.getCells(), 0, 0, 3, 7));
  }
}
