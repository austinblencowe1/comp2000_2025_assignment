import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;


public abstract class Actor implements Moveable {
    protected List<Polygon> polygons;
    protected Cell loc;
    protected Color bodyColor;

    //constructor initialises actor
    public Actor(Color bodyColor) {
        this.polygons = new ArrayList<>();
        this.bodyColor = bodyColor;
    }

    //paints the actor by drawing its polygons
    public void paint(Graphics g) {
        for (Polygon polygon : polygons) {
            g.setColor(getPolygonColor(polygon));
            g.fillPolygon(polygon);
            g.setColor(Color.BLACK);
            g.drawPolygon(polygon);
        }
    }

    //returns the color for a specific polygon
    protected Color getPolygonColor(Polygon polygon) {
        int idx = polygons.indexOf(polygon);
        if (idx == 0) return bodyColor;
        return Color.BLACK;
    }

    //gets the current cell of the actor
    public Cell getCell() { return loc; }

    //sets the actors cell and rebuilds polygons
    public void setCell(Cell c) {
        this.loc = c;
        rebuildPolygons();
    }

    //rebuilds the actors polygons based on its current cell
    protected abstract void rebuildPolygons();
}