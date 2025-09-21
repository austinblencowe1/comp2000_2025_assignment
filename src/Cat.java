import java.awt.Color;
import java.awt.Polygon;

public class Cat extends Actor {
    public Cat(Cell inLoc) {
        this.loc = inLoc;
        rebuildPolygons();
    }

    @Override
    protected void rebuildPolygons() {
        polygons.clear();

        int x = loc.x;
        int y = loc.y;

        // head
        Polygon head = new Polygon();
        head.addPoint(x + 11, y + 10);
        head.addPoint(x + 23, y + 10);
        head.addPoint(x + 26, y + 20);
        head.addPoint(x + 17, y + 25);
        head.addPoint(x + 8, y + 20);
        polygons.add(new ColoredPolygon(head, Color.CYAN));

        // police hat
        Polygon hat = new Polygon();
        hat.addPoint(x + 10, y + 5);
        hat.addPoint(x + 24, y + 5);
        hat.addPoint(x + 22, y + 10);
        hat.addPoint(x + 12, y + 10);
        polygons.add(new ColoredPolygon(hat, Color.BLACK));

        // badge
        Polygon badge = new Polygon();
        badge.addPoint(x + 16, y + 6);
        badge.addPoint(x + 18, y + 6);
        badge.addPoint(x + 18, y + 8);
        badge.addPoint(x + 16, y + 8);
        polygons.add(new ColoredPolygon(badge, Color.YELLOW));

        // eyes
        Polygon eye1 = new Polygon();
        eye1.addPoint(x + 12, y + 12);
        eye1.addPoint(x + 15, y + 12);
        eye1.addPoint(x + 13, y + 14);
        polygons.add(new ColoredPolygon(eye1, Color.WHITE));

        Polygon eye2 = new Polygon();
        eye2.addPoint(x + 22, y + 12);
        eye2.addPoint(x + 19, y + 12);
        eye2.addPoint(x + 21, y + 14);
        polygons.add(new ColoredPolygon(eye2, Color.WHITE));
    }
}
