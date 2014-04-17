package game.Lines;

import java.util.ArrayList;
import java.util.List;


public class Color {
  public List<String> colors;
  public Color() {
    colors = new ArrayList<String>();
    colors.add("DC2020"); // red
    colors.add("5A4910"); // brown
    colors.add("D021C4"); // violet
    colors.add("26CEC3"); // blue
    colors.add("121B9F"); // dark_blue
    colors.add("22970B"); // green
    colors.add("FFFF00"); // yellow
  }

  public List<String> getColors() {
    return colors;
  }
 /* RED(0), BROWN(1), VIOLET(2), BLUE(3), DARK_BLUE(4), GREEN(5), YELLOW(6);
  private int value;

  Color(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }*/
}
