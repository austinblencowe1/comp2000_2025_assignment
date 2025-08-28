import java.awt.Color;
import java.awt.Polygon;
import java.util.ArrayList;

public class Bird extends Actor {
  public Bird(Cell inLoc) {
    loc = inLoc;
    color = Color.GREEN;
    polygons = new ArrayList<>();
    
    //body
    Polygon body = new Polygon();
    body.addPoint(loc.x + 12, loc.y + 10);
    body.addPoint(loc.x + 22, loc.y + 10);
    body.addPoint(loc.x + 24, loc.y + 15);
    body.addPoint(loc.x + 22, loc.y + 20);
    body.addPoint(loc.x + 12, loc.y + 20);
    body.addPoint(loc.x + 10, loc.y + 15);
    
    //left wing 
    Polygon wing1 = new Polygon();
    wing1.addPoint(loc.x + 10, loc.y + 12);
    wing1.addPoint(loc.x + 5, loc.y + 8);
    wing1.addPoint(loc.x + 5, loc.y + 18);
    wing1.addPoint(loc.x + 10, loc.y + 15);
    
    //right wing 
    Polygon wing2 = new Polygon();
    wing2.addPoint(loc.x + 24, loc.y + 12);
    wing2.addPoint(loc.x + 29, loc.y + 8);
    wing2.addPoint(loc.x + 29, loc.y + 18);
    wing2.addPoint(loc.x + 24, loc.y + 15);
    
    //beak
    Polygon beak = new Polygon();
    beak.addPoint(loc.x + 22, loc.y + 13);
    beak.addPoint(loc.x + 27, loc.y + 15);
    beak.addPoint(loc.x + 22, loc.y + 17);
    
    //eye
    Polygon eye = new Polygon();
    eye.addPoint(loc.x + 18, loc.y + 12);
    eye.addPoint(loc.x + 20, loc.y + 12);
    eye.addPoint(loc.x + 19, loc.y + 15);

    polygons.add(body);
    polygons.add(wing1);
    polygons.add(wing2);
    polygons.add(beak);
    polygons.add(eye);
  }
}