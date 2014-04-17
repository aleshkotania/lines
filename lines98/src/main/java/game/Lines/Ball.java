package game.Lines;

public class Ball {
  private String color;
  private boolean isMove;

  public Ball(String color) {
    this.color = color;
  }

  /**
   * @return the color of ball.
   */
  public String getColor() {
    return color;
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
