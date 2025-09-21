import java.awt.Color;
import java.awt.Polygon;

public class Bird extends Actor {
    public Bird(Cell inLoc) {
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
        body.addPoint(x + 5,  y + 19);
        body.addPoint(x + 25, y + 20);
        body.addPoint(x + 25, y + 25);
        body.addPoint(x + 5,  y + 25);
        polygons.add(new ColoredPolygon(body, Color.GRAY));

        // Car roof 
        Polygon roof = new Polygon();
        roof.addPoint(x + 8,  y + 19);
        roof.addPoint(x + 22, y + 20);
        roof.addPoint(x + 18, y + 15);
        roof.addPoint(x + 12, y + 15);
        polygons.add(new ColoredPolygon(roof, Color.WHITE));

        // Left wheel 
        Polygon wheel1 = new Polygon();
        wheel1.addPoint(x + 6,  y + 25);
        wheel1.addPoint(x + 10, y + 25);
        wheel1.addPoint(x + 10, y + 28);
        wheel1.addPoint(x + 6,  y + 28);
        polygons.add(new ColoredPolygon(wheel1, Color.BLACK));

        // Right wheel 
        Polygon wheel2 = new Polygon();
        wheel2.addPoint(x + 20, y + 25);
        wheel2.addPoint(x + 24, y + 25);
        wheel2.addPoint(x + 24, y + 28);
        wheel2.addPoint(x + 20, y + 28);
        polygons.add(new ColoredPolygon(wheel2, Color.BLACK));

        // Rear Spoiler 
        Polygon spoiler = new Polygon();
        spoiler.addPoint(x + 3, y + 15);
        spoiler.addPoint(x + 5, y + 16);
        spoiler.addPoint(x + 5, y + 20);
        spoiler.addPoint(x + 4, y + 20);
        polygons.add(new ColoredPolygon(spoiler, Color.GRAY));
    }
}
