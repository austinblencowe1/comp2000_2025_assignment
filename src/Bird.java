import java.awt.Color;
import java.awt.Polygon;

public class Bird extends Actor {
    public Bird(Cell inLoc) {
        super(Color.RED);//Set body colour to green
        this.loc = inLoc;
        rebuildPolygons();
    }

    @Override
    protected void rebuildPolygons() {
        polygons.clear();
        int x = loc.x;
        int y = loc.y;

        // Car body
        Polygon body = new Polygon();
        body.addPoint(x + 5, y + 19);
        body.addPoint(x + 25, y + 20);
        body.addPoint(x + 25, y + 25);
        body.addPoint(x + 5, y + 25);

        // Car roof
        Polygon roof = new Polygon();
        roof.addPoint(x + 8, y + 19);
        roof.addPoint(x + 22, y + 20);
        roof.addPoint(x + 18, y + 15);
        roof.addPoint(x + 12, y + 15);

        // Wheels
        Polygon wheel1 = new Polygon();
        wheel1.addPoint(x + 6, y + 25);
        wheel1.addPoint(x + 10, y + 25);
        wheel1.addPoint(x + 10, y + 28);
        wheel1.addPoint(x + 6, y + 28);

        Polygon wheel2 = new Polygon();
        wheel2.addPoint(x + 20, y + 25);
        wheel2.addPoint(x + 24, y + 25);
        wheel2.addPoint(x + 24, y + 28);
        wheel2.addPoint(x + 20, y + 28);

        // Spoiler
        Polygon spoiler = new Polygon();
        spoiler.addPoint(x + 3, y + 15);
        spoiler.addPoint(x + 5, y + 16);
        spoiler.addPoint(x + 5, y + 20);
        spoiler.addPoint(x + 4, y + 20);

        polygons.add(body);
        polygons.add(roof);
        polygons.add(wheel1);
        polygons.add(wheel2);
        polygons.add(spoiler);
    }

    @Override
    protected Color getPolygonColor(Polygon polygon) {
        int idx = polygons.indexOf(polygon);
        if (idx == 0 || idx == 4) return bodyColor;
        if (idx == 1) return Color.WHITE;
        if (idx == 2 || idx == 3) return Color.BLACK;
        return Color.BLACK;
    }

    @Override
    public void moveTo(int col, int row) {
        if (loc != null && loc.grid != null) {
            setCell(loc.grid.cellAtColRow(col, row).get());
        }
    }

    @Override
    public int getCol() { 
        return loc.col; 
    }

    @Override
    public int getRow() { 
        return loc.row; 
    }

    @Override
    public void tick() {}    }
}