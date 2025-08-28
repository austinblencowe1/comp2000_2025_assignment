import java.awt.Color;
import java.awt.Polygon;
import java.util.ArrayList;

public class Dog extends Actor {
  public Dog(Cell inLoc) {
    loc = inLoc;
    color = Color.YELLOW;
    polygons = new ArrayList<>();
    
    //head
    Polygon head = new Polygon();
    head.addPoint(loc.x + 7, loc.y + 8);
    head.addPoint(loc.x + 27, loc.y + 8);
    head.addPoint(loc.x + 27, loc.y + 22);
    head.addPoint(loc.x + 7, loc.y + 22);
    
    //left ear
    Polygon ear1 = new Polygon();
    ear1.addPoint(loc.x + 7, loc.y + 8);
    ear1.addPoint(loc.x + 12, loc.y + 8);
    ear1.addPoint(loc.x + 10, loc.y + 15);
    ear1.addPoint(loc.x + 5, loc.y + 15);
    
    //right ear
    Polygon ear2 = new Polygon();
    ear2.addPoint(loc.x + 27, loc.y + 8);
    ear2.addPoint(loc.x + 22, loc.y + 8);
    ear2.addPoint(loc.x + 24, loc.y + 15);
    ear2.addPoint(loc.x + 29, loc.y + 15);
    
    //nose
    Polygon snout = new Polygon();
    snout.addPoint(loc.x + 13, loc.y + 22);
    snout.addPoint(loc.x + 21, loc.y + 22);
    snout.addPoint(loc.x + 21, loc.y + 28);
    snout.addPoint(loc.x + 13, loc.y + 28);
    
    //left eye
    Polygon eye1 = new Polygon();
    eye1.addPoint(loc.x + 10, loc.y + 12);
    eye1.addPoint(loc.x + 13, loc.y + 12);
    eye1.addPoint(loc.x + 13, loc.y + 15);
    eye1.addPoint(loc.x + 10, loc.y + 15);
    
    //right eye
    Polygon eye2 = new Polygon();
    eye2.addPoint(loc.x + 24, loc.y + 12);
    eye2.addPoint(loc.x + 21, loc.y + 12);
    eye2.addPoint(loc.x + 21, loc.y + 15);
    eye2.addPoint(loc.x + 24, loc.y + 15);

    polygons.add(head);
    polygons.add(ear1);
    polygons.add(ear2);
    polygons.add(snout);
    polygons.add(eye1);
    polygons.add(eye2);
  }
}