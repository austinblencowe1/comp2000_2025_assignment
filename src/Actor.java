import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

//abstract base class for game actors (player, ghosts)
public abstract class Actor implements Moveable {
    //list of polygons defining the actor's shape
    protected List<Polygon> polygons;
    //current cell location of the actor
    protected Cell loc;
    //main body color of the actor
    protected Color bodyColor;

    //constructor initializes actor with a body color
    public Actor(Color bodyColor) {
        this.polygons = new ArrayList<>();
        this.bodyColor = bodyColor;
    }

    //paints the actor's polygons with appropriate colors
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

    //sets the actor's cell and rebuilds polygons
    public void setCell(Cell c) {
        this.loc = c;
        rebuildPolygons();
    }

    //rebuilds the actor's polygons based on its current cell
    protected abstract void rebuildPolygons();
}