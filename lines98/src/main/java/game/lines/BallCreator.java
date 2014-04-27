package game.lines;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BallCreator {
  private Random random;
  private List<Integer> positionsList;
  private Color color;

  public BallCreator() {
    random = new Random();
    positionsList = new ArrayList<Integer>();
    fillPositionsList();
    color = new Color();
  }

  private void fillPositionsList() {
    for (int i = 0; i < Config.X_AMOUNT_CELLS; i++) {
      for (int j = 0; j < Config.Y_AMOUNT_CELLS; j++) {
        positionsList.add(i * 10 + j);
      }
    }
  }

  public void createBalls(Cell [][] cells) {
    for (int i = 0; i < Config.CREATE_AMOUNT_OF_BALLS; i++) {
      createBall(cells);
    }
  }

  public void createBallOnFixedPosition(Cell [][] cells, int x, int y) {
    cells[x][y].setBall(new Ball(color.getColors().get(0)));
  }

  public Cell createBall(Cell [][] cells) {
    int index = random.nextInt(Config.X_AMOUNT_CELLS * Config.Y_AMOUNT_CELLS);
    int xPos = positionsList.get(index) / 10;
    int yPos = positionsList.get(index) % 10;

    int colorIndex = random.nextInt(color.getColors().size());
    cells[xPos][yPos].setBall(new Ball(color.getColors().get(colorIndex)));

    return cells[xPos][yPos];
  }
}
