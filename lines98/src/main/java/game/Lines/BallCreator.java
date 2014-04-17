package game.Lines;

import java.util.Random;

public class BallCreator {
  private Cell [][] cells;
  private Random random;
  private int amountOfBals = 3;

  public BallCreator(Cell cells [][]) {
    this.cells = cells;
    random = new Random();
  }

  public boolean checkPosotion(int xCoordinate, int yCoordinate) {
    if (cells[xCoordinate][yCoordinate].getBall() != null) {
      return false;
    } else {
      return true;
    }
  }

  public void createBalls() {
    for (int i = 0; i < amountOfBals; i++) {
      final Ball ball = createBall();
      (cells[ball.getxPosition()][ball.getyPosition()]).setBall(ball);
    }
  }

  public void createBallFixPosition(int x, int y) {
    Ball ball = new Ball(Color.RED, x, y);
    cells[x][y].setBall(ball);
  }

  public Ball createBall() {
    int xPos = random.nextInt(Deck.X_AMOUNT_CELLS);
    int yPos = random.nextInt(Deck.Y_AMOUNT_CELLS);

    while (!checkPosotion(xPos, yPos)) {
       xPos = random.nextInt(Deck.X_AMOUNT_CELLS);
       yPos = random.nextInt(Deck.Y_AMOUNT_CELLS);
    }
    int index = random.nextInt(Color.values().length);

  //  return new Ball(Color.values()[index], yPos, xPos);
    return new Ball(Color.RED, yPos, xPos);
  }
}
