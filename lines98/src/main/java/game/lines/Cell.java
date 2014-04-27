package game.lines;

public class Cell {
  private int xCoordinate;
  private int yCoordinate;
  private Ball ball;
  private int costWay;
  private double heuristicCostEstimate;
  private int valueWay;

  public Cell(int xCoordinate, int yCoordinate) {
    this.xCoordinate = xCoordinate;
    this.yCoordinate = yCoordinate;
  }

  /**
   * @return the xCoordinate
   */
  public int getxCoordinate() {
    return xCoordinate;
  }

  /**
   * @return the yCoordinate
   */
  public int getyCoordinate() {
    return yCoordinate;
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
