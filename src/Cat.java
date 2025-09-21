import java.awt.Color;
import java.awt.Polygon;


public class Cat extends Actor {


    //initialises at a given cell
    public Cat(Cell inLoc) {
        super(Color.BLUE);
        this.loc = inLoc;
        rebuildPolygons();
    }

    @Override
    protected void rebuildPolygons() {
        polygons.clear();
        int x = loc.x;
        int y = loc.y;

        //main body 
        Polygon body = new Polygon();
        body.addPoint(x + 5, y + 19);
        body.addPoint(x + 25, y + 19);
        body.addPoint(x + 25, y + 25);
        body.addPoint(x + 5, y + 25);

        //roof 
        Polygon roof = new Polygon();
        roof.addPoint(x + 8, y + 19);
        roof.addPoint(x + 22, y + 19);
        roof.addPoint(x + 18, y + 15);
        roof.addPoint(x + 12, y + 15);

        //left wheel 
        Polygon wheel1 = new Polygon();
        wheel1.addPoint(x + 6, y + 25);
        wheel1.addPoint(x + 10, y + 25);
        wheel1.addPoint(x + 10, y + 28);
        wheel1.addPoint(x + 6, y + 28);

        //right wheel 
        Polygon wheel2 = new Polygon();
        wheel2.addPoint(x + 20, y + 25);
        wheel2.addPoint(x + 24, y + 25);
        wheel2.addPoint(x + 24, y + 28);
        wheel2.addPoint(x + 20, y + 28);

        //red light
        Polygon redLight = new Polygon();
        redLight.addPoint(x + 18, y + 13);
        redLight.addPoint(x + 21, y + 13);
        redLight.addPoint(x + 21, y + 15);
        redLight.addPoint(x + 18, y + 15);

        //blue light
        Polygon blueLight = new Polygon();
        blueLight.addPoint(x + 14, y + 13);
        blueLight.addPoint(x + 17, y + 13);
        blueLight.addPoint(x + 17, y + 15);
        blueLight.addPoint(x + 14, y + 15);

        polygons.add(body);
        polygons.add(roof);
        polygons.add(wheel1);
        polygons.add(wheel2);
        polygons.add(redLight);
        polygons.add(blueLight);
    }

    //assigns colors to each polygon
    @Override
    protected Color getPolygonColor(Polygon polygon) {
        int idx = polygons.indexOf(polygon);
        if (idx == 0) return bodyColor; 
        if (idx == 1) return Color.WHITE;
        if (idx == 2 || idx == 3) return Color.BLACK;
        if (idx == 4) return Color.RED; 
        if (idx == 5) return Color.BLUE; 
        return Color.BLACK;
    }

    //moves to new grid position
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

    //empty tick method 
    @Override
    public void tick() {
    }
}