package game.lines;

import java.util.Formatter;
import java.util.List;

public class Deck {
  private Cell prevCell;
  private int amountOFBalls; // for JUnit test
  private Cell[][] cells;
  private BallCreator ballCreator;
  private DeckExplorer deckExplorer;

  public Deck() {
    cells = new Cell[Config.X_AMOUNT_CELLS][Config.Y_AMOUNT_CELLS];
    fillCells();
    ballCreator = new BallCreator();
    deckExplorer = new DeckExplorer();
    prevCell = null;

    ballCreator.createBallOnFixedPosition(cells, 0, 0);
    ballCreator.createBallOnFixedPosition(cells, 3, 4);
    ballCreator.createBallOnFixedPosition(cells, 7, 6);
  }

  public void createFixPositionBall(int x, int y) {
    ballCreator.createBallOnFixedPosition(cells, x, y);
  }

  public void click(int xCoordinate, int yCoordinate) {
    if (prevCell == null) { // 0
      prevCell = cells[xCoordinate][yCoordinate];
      if (prevCell.getBall() != null)
        prevCell.getBall().setMove(true);
    }
    if (cells[xCoordinate][yCoordinate].getBall() != null && prevCell.getBall() != null && !prevCell.getBall().isMove()) { // 2
      System.out.println("V2  " + xCoordinate + "   " + yCoordinate);
      prevCell = cells[xCoordinate][yCoordinate];
      prevCell.getBall().setMove(true);
    }
    if (cells[xCoordinate][yCoordinate].getBall() != null && prevCell.getBall() != null && prevCell.getBall().isMove()) { // 4
      System.out.println("V4  " + xCoordinate + "   " + yCoordinate);
      prevCell = cells[xCoordinate][yCoordinate];
      prevCell.getBall().setMove(true);
      System.out.println(prevCell.getBall());
    }
    if (cells[xCoordinate][yCoordinate].getBall() == null && prevCell.getBall() != null && prevCell.getBall().isMove()) { // 3
      System.out.println("V3  "  + xCoordinate + "   " + yCoordinate);
      if (deckExplorer.exploreWay(cells, prevCell.getxCoordinate(), prevCell.getyCoordinate(), xCoordinate, yCoordinate) == null) {
        return;
      }
      cells[xCoordinate][yCoordinate].setBall(prevCell.getBall());
      cells[prevCell.getxCoordinate()][prevCell.getyCoordinate()].deleteBall();
      prevCell = cells[xCoordinate][yCoordinate];

      if (!deckExplorer.checkWinBalls(cells, cells[xCoordinate][yCoordinate])) {
        for (int i = 0; i < Config.CREATE_AMOUNT_OF_BALLS; i++) {
          Cell temppCell = ballCreator.createBall(cells);
          deckExplorer.checkWinBalls(cells, cells[temppCell.getxCoordinate()][temppCell.getyCoordinate()]);
          System.out.println("New ball coordinates   " + temppCell.getxCoordinate() + "   " + temppCell.getyCoordinate());
        }
      } else {
        prevCell = null;
      }

    }
  }

  public void show() { // only for me
    Formatter formatter = new Formatter();
    System.out.println(formatter.format("%1s %15s %15s %15s %15s %15s %15s %15s %15s %15s", "", "  0 ", "  1 ", "  2 ",
        "  3 ", "  4 ", "  5 ", "  6 ", "  7 ", "  8 "));

    for (int i = 0; i < Config.X_AMOUNT_CELLS; i++) {
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
      System.out.println(prevCell);
    }
  }

  public DeckExplorer getDeckExploer() {
    return deckExplorer;
  }

  public Cell[][] getCells() {  // for JUnit test. To testExploreWay
    return cells;
  }

  private void fillCells() {
    for (int i = 0; i < Config.X_AMOUNT_CELLS; i++) {
      for (int j = 0; j < Config.Y_AMOUNT_CELLS; j++) {
        final Cell cell = new Cell(i, j);
        cells[i][j] = cell;
      }
    }
  }

  public int getAmountOfBalls() { // only for Jnit test
    amountOFBalls = 0;
    for (int i = 0; i < Config.X_AMOUNT_CELLS; i++) {
      for (int j = 0; j < Config.Y_AMOUNT_CELLS; j++) {
        if (cells[i][j].getBall() != null) {
          amountOFBalls++;
        }
      }
    }
    return amountOFBalls;
  }

  public int getScore() {
    return deckExplorer.getScore();
  }
}
