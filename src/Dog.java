import java.awt.Color;
import java.awt.Polygon;

public class Dog extends Actor {
    public Dog(Cell inLoc) {
        this.loc = inLoc;
        rebuildPolygons();
    }

    @Override
    protected void rebuildPolygons() {
        polygons.clear();

        int x = loc.x;
        int y = loc.y;

        // Body (yellow)
        Polygon body = new Polygon();
        body.addPoint(x + 7,  y + 8);
        body.addPoint(x + 27, y + 8);
        body.addPoint(x + 27, y + 22);
        body.addPoint(x + 7,  y + 22);
        polygons.add(new ColoredPolygon(body, Color.YELLOW));

        // Left leg (yellow)
        Polygon leg1 = new Polygon();
        leg1.addPoint(x + 7,  y + 8);
        leg1.addPoint(x + 12, y + 8);
        leg1.addPoint(x + 10, y + 15);
        leg1.addPoint(x + 5,  y + 15);
        polygons.add(new ColoredPolygon(leg1, Color.YELLOW));

        // Right leg (yellow)
        Polygon leg2 = new Polygon();
        leg2.addPoint(x + 27, y + 8);
        leg2.addPoint(x + 22, y + 8);
        leg2.addPoint(x + 24, y + 15);
        leg2.addPoint(x + 29, y + 15);
        polygons.add(new ColoredPolygon(leg2, Color.YELLOW));

        // Tail (yellow)
        Polygon tail = new Polygon();
        tail.addPoint(x + 13, y + 22);
        tail.addPoint(x + 21, y + 22);
        tail.addPoint(x + 21, y + 28);
        tail.addPoint(x + 13, y + 28);
        polygons.add(new ColoredPolygon(tail, Color.YELLOW));

        // Eye 1 (white)
        Polygon eye1 = new Polygon();
        eye1.addPoint(x + 10, y + 12);
        eye1.addPoint(x + 13, y + 12);
        eye1.addPoint(x + 13, y + 15);
        eye1.addPoint(x + 10, y + 15);
        polygons.add(new ColoredPolygon(eye1, Color.WHITE));

        // Eye 2 (white)
        Polygon eye2 = new Polygon();
        eye2.addPoint(x + 24, y + 12);
        eye2.addPoint(x + 21, y + 12);
        eye2.addPoint(x + 21, y + 15);
        eye2.addPoint(x + 24, y + 15);
        polygons.add(new ColoredPolygon(eye2, Color.WHITE));
    }
}
