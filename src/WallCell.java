import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class WallCell extends Cell {
  public WallCell(int x, int y) {
    super(x, y);
  }

  @Override
  public void paint(Graphics g, Point mousePos) {
    g.setColor(Color.DARK_GRAY);
    g.fillRect(x, y, size, size);
    g.setColor(Color.BLACK);
    g.drawRect(x, y, size, size);
  }
}
