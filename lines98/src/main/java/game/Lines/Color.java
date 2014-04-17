package game.Lines;

public enum Color {
  RED(0), BROWN(1), VIOLET(2), BLUE(3), DARK_BLUE(4), GREEN(5), YELLOW(6);
  private int value;

  Color(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
