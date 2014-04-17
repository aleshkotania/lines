package game.Lines;

import java.util.Formatter;
import java.util.List;

public class Deck {
  public static final int X_AMOUNT_CELLS = 9;
  public static final int Y_AMOUNT_CELLS = 9;
  private Cell prevCell;
  // private int score;
  private Cell[][] cells;
  private BallCreator ballCreator;
  private DeckExplorer deckExplorer;

  public Deck() {
    cells = new Cell[X_AMOUNT_CELLS][Y_AMOUNT_CELLS];
    fillCells();
    ballCreator = new BallCreator(cells);
    deckExplorer = new DeckExplorer(cells);
    prevCell = null;

    ballCreator.createBallFixPosition(0, 0);
    ballCreator.createBallFixPosition(3, 4);
    ballCreator.createBallFixPosition(7, 6);
   // ballCreator.createBalls();
  //  ballCreator.createBalls();
  //  ballCreator.createBalls();
  //  ballCreator.createBalls();
  //  ballCreator.createBalls();
  //  ballCreator.createBalls();
   // ballCreator.createBalls();
  }

  public void createFixPositionBall(int x, int y) {
    ballCreator.createBallFixPosition(x, y);
  }

  public Cell isAnyBallMove() {
    return null;
  }

  public void click(int xCoordinate, int yCoordinate) {
    if (prevCell == null) { // 0
      prevCell = cells[xCoordinate][yCoordinate];
      if (prevCell.getBall() != null)
        prevCell.getBall().setMove(true);
    }
    if (cells[xCoordinate][yCoordinate].getBall() != null && prevCell.getBall() != null && !prevCell.getBall().isMove()) { // 2
      System.out.println("V 2  " + xCoordinate + "   " + yCoordinate);
      prevCell = cells[xCoordinate][yCoordinate];
      prevCell.getBall().setMove(true);
    }
    if (cells[xCoordinate][yCoordinate].getBall() != null && prevCell.getBall() != null && prevCell.getBall().isMove()) { // 4
      System.out.println("V 4  " + xCoordinate + "   " + yCoordinate);
      prevCell = cells[xCoordinate][yCoordinate];
      prevCell.getBall().setMove(true);
      System.out.println(prevCell.getBall());
    }
    if (cells[xCoordinate][yCoordinate].getBall() == null && prevCell.getBall() != null &&prevCell.getBall().isMove()) { // 3
      System.out.println("V 3  "  + xCoordinate + "   " + yCoordinate);
      if (deckExplorer.exploreWay(prevCell.getxCoordinate(), prevCell.getyCoordinate(), xCoordinate, yCoordinate) == null) {
        return;
      }
      cells[xCoordinate][yCoordinate].setBall(prevCell.getBall());
      System.out.println("BAll       " + cells[xCoordinate][yCoordinate].getBall());
      cells[prevCell.getxCoordinate()][prevCell.getyCoordinate()].deleteBall();
      prevCell = cells[xCoordinate][yCoordinate];
      System.out.println("BAll       " + cells[xCoordinate][yCoordinate].getBall());

      if (!deckExplorer.checkWinBalls(cells[xCoordinate][yCoordinate])) {
        for (int i = 0; i < 3; i++) {
          final Ball ball = ballCreator.createBall();
          cells[ball.getxPosition()][ball.getyPosition()].setBall(ball);
          deckExplorer.checkWinBalls(cells[ball.getxPosition()][ball.getyPosition()]);
          System.out.println("New ball coordinates   " + ball.getxPosition() + "   " + ball.getyPosition());
        }
      }

    }
  }

  public void show() {
    Formatter formatter = new Formatter();
    System.out.println(formatter.format("%1s %15s %15s %15s %15s %15s %15s %15s %15s %15s", "", "  0 ", "  1 ", "  2 ",
        "  3 ", "  4 ", "  5 ", "  6 ", "  7 ", "  8 "));

    for (int i = 0; i < X_AMOUNT_CELLS; i++) {
      formatter = new Formatter();
      final String name0 = cells[i][0].getBall() != null ? cells[i][0].getBall().getColor().toString() : "null";
      final String name1 = cells[i][1].getBall() != null ? cells[i][1].getBall().getColor().toString() : "null";
      final String name2 = cells[i][2].getBall() != null ? cells[i][2].getBall().getColor().toString() : "null";
      final String name3 = cells[i][3].getBall() != null ? cells[i][3].getBall().getColor().toString() : "null";
      final String name4 = cells[i][4].getBall() != null ? cells[i][4].getBall().getColor().toString() : "null";
      final String name5 = cells[i][5].getBall() != null ? cells[i][5].getBall().getColor().toString() : "null";
      final String name6 = cells[i][6].getBall() != null ? cells[i][6].getBall().getColor().toString() : "null";
      final String name7 = cells[i][7].getBall() != null ? cells[i][7].getBall().getColor().toString() : "null";
      final String name8 = cells[i][8].getBall() != null ? cells[i][8].getBall().getColor().toString() : "null";

      System.out.println(formatter.format("%1s %15s %15s %15s %15s %15s %15s %15s %15s %15s", i, name0, name1, name2,
          name3, name4, name5, name6, name7, name8));
    }

    if (prevCell != null && prevCell.getBall() != null) {
      System.out.println(prevCell.getBall().isMove());
    } else {
      System.out.println("null");
    }

    // deckExplorer.checkWinBalls();
    // System.out.println(deckExplorer.exploreWay(1, 1, 8, 3));
  }

  public DeckExplorer getDeckExploer() {
    return deckExplorer;
  }

  private void fillCells() {
    for (int i = 0; i < X_AMOUNT_CELLS; i++) {
      for (int j = 0; j < Y_AMOUNT_CELLS; j++) {
        final Cell cell = new Cell(i, j);
        cells[i][j] = cell;
      }
    }
  }
}
