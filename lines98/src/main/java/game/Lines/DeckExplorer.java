package game.Lines;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DeckExplorer {
  private Cell cells[][];
  private final int distance = 10;
  private final int minWinAmount = 3;
  private int topIndex;
  private int bottomIndex;
  private int leftIndex;
  private int rightIndex;

  public DeckExplorer(Cell cells[][]) {
    this.cells = cells;
  }

  public boolean checkWinBalls(Cell cell) {
    if (celectRow(cell, 0) || celectRow(cell, 1) || celectRow(cell, 2) || celectRow(cell, 3)) {
      return true;
    }
   // celectRow(cell, 0);
  //  celectRow(cell, 1);
  // celectRow(cell, 2);
  //  celectRow(cell, 3);
    return false;
  }

  private boolean celectRow(Cell cell, int index) {
    boolean isWin = false;
    List<Cell> rowList = new ArrayList<Cell>();
    rowList.add(cell);
    topIndex = cell.getxCoordinate();
    bottomIndex = cell.getxCoordinate();
    rightIndex = cell.getyCoordinate();
    leftIndex = cell.getyCoordinate();

    incrementElements(index, 0);
    incrementElements(index, 1);

    if (index != 3) {
      while (rightIndex < Deck.X_AMOUNT_CELLS && topIndex < Deck.Y_AMOUNT_CELLS
          && cells[topIndex][rightIndex].getBall() != null
          && cells[topIndex][rightIndex].getBall().getColor() == cell.getBall().getColor()) {
        rowList.add(cells[topIndex][rightIndex]);
        incrementElements(index, 0);
      }
      while (leftIndex >= 0 && bottomIndex >= 0 && cells[bottomIndex][leftIndex].getBall() != null
          && cells[bottomIndex][leftIndex].getBall().getColor() == cell.getBall().getColor()) {
        rowList.add(cells[bottomIndex][leftIndex]);
        incrementElements(index, 1);
      }
    } else {
      while (leftIndex >= 0 && topIndex < Deck.Y_AMOUNT_CELLS && cells[topIndex][leftIndex].getBall() != null
          && cells[topIndex][leftIndex].getBall().getColor() == cell.getBall().getColor()) {
        rowList.add(cells[topIndex][leftIndex]);
        incrementElements(index, 0);
      }
      while (rightIndex < Deck.X_AMOUNT_CELLS && bottomIndex >= 0 && cells[bottomIndex][rightIndex].getBall() != null
          && cells[bottomIndex][rightIndex].getBall().getColor() == cell.getBall().getColor()) {
        rowList.add(cells[bottomIndex][rightIndex]);
        incrementElements(index, 1);
      }
    }

    if (rowList.size() >= minWinAmount) {
      for (Cell tempCell : rowList) {
        System.out.println("Check    " + tempCell.getxCoordinate() + "   " + tempCell.getyCoordinate());
        cells[tempCell.getxCoordinate()][tempCell.getyCoordinate()].deleteBall();
      }
      isWin = true;
    }

    return isWin;
  }

  private void incrementElements(int index, int variant) {
    if (variant == 0) {
      switch (index) {
        case 0:
          rightIndex++;
          break;
        case 1:
          topIndex++;
          break;
        case 2:
          topIndex++;
          rightIndex++;
          break;
        case 3:
          topIndex++;
          leftIndex--;
          break;
        default:
          break;
      }
    } else {
      switch (index) {
        case 0:
          leftIndex--;
          break;
        case 1:
          bottomIndex--;
          break;
        case 2:
          bottomIndex--;
          leftIndex--;
          break;
        case 3:
          rightIndex++;
          bottomIndex--;
          break;
        default:
          break;
      }
    }
  }

  private List<Cell> neighbors(Cell cell) {
    List<Cell> neighbors = new ArrayList<Cell>();

    if (cell.getxCoordinate() + 1 < Deck.X_AMOUNT_CELLS
        && cells[cell.getxCoordinate() + 1][cell.getyCoordinate()].getBall() == null) {
      neighbors.add(cells[cell.getxCoordinate() + 1][cell.getyCoordinate()]);
    }
    if (cell.getxCoordinate() - 1 >= 0 && cells[cell.getxCoordinate() - 1][cell.getyCoordinate()].getBall() == null) {
      neighbors.add(cells[cell.getxCoordinate() - 1][cell.getyCoordinate()]);
    }
    if (cell.getyCoordinate() + 1 < Deck.Y_AMOUNT_CELLS
        && cells[cell.getxCoordinate()][cell.getyCoordinate() + 1].getBall() == null) {
      neighbors.add(cells[cell.getxCoordinate()][cell.getyCoordinate() + 1]);
    }
    if (cell.getyCoordinate() - 1 >= 0 && cells[cell.getxCoordinate()][cell.getyCoordinate() - 1].getBall() == null) {
      neighbors.add(cells[cell.getxCoordinate()][cell.getyCoordinate() - 1]);
    }

    return neighbors;
  }

  public double heruisticCostEstimate(int xStart, int yStart, int xGoal, int yGoal) {
    return Math.sqrt(Math.pow((xGoal - xStart), 2) + Math.pow((yGoal - yStart), 2));
  }

  public List<Cell> exploreWay(int xStart, int yStart, int xGoal, int yGoal) { // A* alogoritm
    List<Cell> openset = new ArrayList<Cell>(); // will explore
    List<Cell> closeset = new ArrayList<Cell>(); // was explored
    int tentativeScore;
    boolean tentetiveIsBetter;
    List<Cell> pathMap = new ArrayList<Cell>();
    openset.add(cells[xStart][yStart]);
    cells[xStart][yStart].setCostWay(0);
    cells[xStart][yStart].setHeuristicCostEstimate(heruisticCostEstimate(xStart, yStart, xGoal, yGoal));
    cells[xStart][yStart].setValueWay((int) (cells[xStart][yStart].getHeuristicCostEstimate() + cells[xStart][yStart]
        .getCostWay()));

    while (openset.size() != 0) {
      Cell cell = Collections.min(openset, new Comparator<Cell>() {

        public int compare(Cell o1, Cell o2) {
          return ((Integer) o1.getValueWay()).compareTo(o2.getValueWay());
        }
      });

      if (cell.getxCoordinate() == xGoal && cell.getyCoordinate() == yGoal) {
        return pathMap;
      }

      openset.remove(cell);
      closeset.add(cell);
      for (Cell neightbourCell : neighbors(cell)) {
        if (closeset.contains(neightbourCell)) {
          continue;
        }
        tentativeScore = cell.getCostWay() + distance;

        if (!openset.contains(neightbourCell)) {
          openset.add(neightbourCell);
          tentetiveIsBetter = true;
        } else {
          if (tentativeScore < neightbourCell.getCostWay()) {
            tentetiveIsBetter = true;
          } else
            tentetiveIsBetter = false;
        }

        if (tentetiveIsBetter) {
          pathMap.add(cell);
          neightbourCell.setCostWay(tentativeScore);
          neightbourCell.setHeuristicCostEstimate(heruisticCostEstimate(neightbourCell.getxCoordinate(),
              neightbourCell.getyCoordinate(), xGoal, yGoal));
          neightbourCell.setValueWay((int) (neightbourCell.getCostWay() + neightbourCell.getHeuristicCostEstimate()));
        }
      }
    }

    return null;
  }
}
