package game.Lines;

public class Ball {
  private Color color;
  private boolean isMove;
  private int yPosition;
  private int xPosition;

  public Ball(Color color, int yPosition, int xPosition) {
    this.color = color;
    this.yPosition = yPosition;
    this.xPosition = xPosition;
  }

  /**
   * @return the color of ball.
   */
  public Color getColor() {
    return color;
  }

  /**
   * @return the xPosition
   */
  public int getxPosition() {
    return xPosition;
  }

  /**
   * @param xPosition the xPosition to set
   */
  public void setxPosition(int xPosition) {
    this.xPosition = xPosition;
  }

  /**
   * @return the yPosition
   */
  public int getyPosition() {
    return yPosition;
  }

  /**
   * @param yPosition the yPosition to set
   */
  public void setyPosition(int yPosition) {
    this.yPosition = yPosition;
  }

  /**
   * @return the isMove
   */
  public boolean isMove() {
    return isMove;
  }

  /**
   * @param isMove the isMove to set
   */
  public void setMove(boolean isMove) {
    this.isMove = isMove;
  }
}
