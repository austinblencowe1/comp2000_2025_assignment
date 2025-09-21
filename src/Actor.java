import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

public abstract class Actor implements Moveable {
    protected List<Polygon> polygons;
    protected Cell loc;
    protected Color bodyColor;

    public Actor(Color bodyColor) {
        this.polygons = new ArrayList<>();
        this.bodyColor = bodyColor; // Initialize body color
    }

    public void paint(Graphics g) {
        for (Polygon polygon : polygons) {
            g.setColor(getPolygonColor(polygon));
            g.fillPolygon(polygon);
            g.setColor(Color.BLACK);
            g.drawPolygon(polygon);
        }
    }

    protected Color getPolygonColor(Polygon polygon) {
        int idx = polygons.indexOf(polygon);
        if (idx == 0) return bodyColor; // Body uses the specified color
        return Color.BLACK; // Default for other polygons, overridden in subclasses
    }

    public Cell getCell() { 
        return loc; 
    }

    public void setCell(Cell c) {
        this.loc = c;
        rebuildPolygons();
    }

    protected abstract void rebuildPolygons();
}