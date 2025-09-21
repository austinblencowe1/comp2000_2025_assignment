import java.awt.Color;
import java.awt.Polygon;

//represents the player as a bird-shaped car
public class Bird extends Actor {
    //constructor initializes bird at a given cell
    public Bird(Cell inLoc) {
        super(Color.GREEN);
        this.loc = inLoc;
        rebuildPolygons();
    }

    //builds polygons for the bird's car-like appearance
    @Override
    protected void rebuildPolygons() {
        polygons.clear();
        int x = loc.x;
        int y = loc.y;

        //main body polygon
        Polygon body = new Polygon();
        body.addPoint(x + 5, y + 19);
        body.addPoint(x + 25, y + 20);
        body.addPoint(x + 25, y + 25);
        body.addPoint(x + 5, y + 25);

        //roof polygon
        Polygon roof = new Polygon();
        roof.addPoint(x + 8, y + 19);
        roof.addPoint(x + 22, y + 20);
        roof.addPoint(x + 18, y + 15);
        roof.addPoint(x + 12, y + 15);

        //left wheel polygon
        Polygon wheel1 = new Polygon();
        wheel1.addPoint(x + 6, y + 25);
        wheel1.addPoint(x + 10, y + 25);
        wheel1.addPoint(x + 10, y + 28);
        wheel1.addPoint(x + 6, y + 28);

        //right wheel polygon
        Polygon wheel2 = new Polygon();
        wheel2.addPoint(x + 20, y + 25);
        wheel2.addPoint(x + 24, y + 25);
        wheel2.addPoint(x + 24, y + 28);
        wheel2.addPoint(x + 20, y + 28);

        //spoiler polygon
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

    //assigns colors to each polygon
    @Override
    protected Color getPolygonColor(Polygon polygon) {
        if (polygon == polygons.get(0) || polygon == polygons.get(4)) return bodyColor;
        if (polygon == polygons.get(1)) return Color.WHITE;
        return Color.BLACK;
    }

    //moves the bird to a new grid position
    @Override
    public void moveTo(int col, int row) {
        if (loc != null && loc.grid != null) {
            setCell(loc.grid.cellAtColRow(col, row).get());
        }
    }

    //gets the current column
    @Override
    public int getCol() { return loc.col; }

    //gets the current row
    @Override
    public int getRow() { return loc.row; }

    //empty tick method for player
    @Override
    public void tick() {
        //no action needed
    }
}