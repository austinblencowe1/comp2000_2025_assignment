import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

public abstract class Actor {
    static class ColoredPolygon {
        Polygon polygon;
        Color color;

        ColoredPolygon(Polygon polygon, Color color) {
            this.polygon = polygon;
            this.color = color;
        }
    }

    List<ColoredPolygon> polygons;
    Cell loc;

    public Actor() {
        polygons = new ArrayList<>();
    }

    public void paint(Graphics g) {
        for (ColoredPolygon cp : polygons) {
            g.setColor(cp.color);
            g.fillPolygon(cp.polygon);
            g.setColor(Color.BLACK); // outline in black
            g.drawPolygon(cp.polygon);
        }
    }

    public Cell getCell() { return loc; }

    public void setCell(Cell c) {
        this.loc = c;
        rebuildPolygons();
    }

    // rebuild when loc changes
    protected abstract void rebuildPolygons();
}
