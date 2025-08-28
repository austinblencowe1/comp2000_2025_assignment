import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

public abstract class Actor {
  List<Polygon> polygons;
  Cell loc;
  Color color;

  public Actor() {
    polygons = new ArrayList<>();
  }

  public void paint(Graphics g) {
    g.setColor(color);
    for (Polygon polygon : polygons) {
      g.fillPolygon(polygon);
    }
    g.setColor(Color.BLACK);
    for (Polygon polygon : polygons) {
      g.drawPolygon(polygon);
    }
  }
}