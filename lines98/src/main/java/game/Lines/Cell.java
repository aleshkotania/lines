package game.Lines;

public class Cell {
  private int xCoordinate;
  private int yCoordinate;
  private Ball ball;
  private int costWay;
  private double heuristicCostEstimate;
  private int valueWay;

  public Cell(int xCoordinate, int yCoordinate) {
    this.setxCoordinate(xCoordinate);
    this.setyCoordinate(yCoordinate);
  }

  /**
   * @return the xCoordinate
   */
  public int getxCoordinate() {
    return xCoordinate;
  }

  /**
   * @param xCoordinate the xCoordinate to set
   */
  private void setxCoordinate(int xCoordinate) {
    this.xCoordinate = xCoordinate;
  }

  /**
   * @return the yCoordinate
   */
  public int getyCoordinate() {
    return yCoordinate;
  }

  /**
   * @param yCoordinate the yCoordinate to set
   */
  private void setyCoordinate(int yCoordinate) {
    this.yCoordinate = yCoordinate;
  }

  /**
   * @return the ball
   */
  public Ball getBall() {
    return ball;
  }

  /**
   * @param ball the ball to set
   */
  public void setBall(Ball ball) {
    this.ball = ball;
  }

  /**
   * @return the costWay
   */
  public int getCostWay() {
    return costWay;
  }

  /**
   * @param costWay the costWay to set
   */
  public void setCostWay(int costWay) {
    this.costWay = costWay;
  }

  /**
   * @return the heuristicCostEstimate
   */
  public double getHeuristicCostEstimate() {
    return heuristicCostEstimate;
  }

  /**
   * @param heuristicCostEstimate the heuristicCostEstimate to set
   */
  public void setHeuristicCostEstimate(double heuristicCostEstimate) {
    this.heuristicCostEstimate = heuristicCostEstimate;
  }

  /**
   * @return the valueWay
   */
  public int getValueWay() {
    return valueWay;
  }

  /**
   * @param valueWay the valueWay to set
   */
  public void setValueWay(int valueWay) {
    this.valueWay = valueWay;
  }

  public void deleteBall() {
    ball = null;
  }
}
