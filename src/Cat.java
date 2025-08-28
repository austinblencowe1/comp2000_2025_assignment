import java.awt.Color;
import java.awt.Polygon;
import java.util.ArrayList;

public class Cat extends Actor {
  public Cat(Cell inLoc) {
    loc = inLoc;
    color = Color.BLUE;
    polygons = new ArrayList<>();
    
    //head
    Polygon head = new Polygon();
    head.addPoint(loc.x + 8, loc.y + 10);
    head.addPoint(loc.x + 12, loc.y + 5);
    head.addPoint(loc.x + 22, loc.y + 5);
    head.addPoint(loc.x + 26, loc.y + 10);
    head.addPoint(loc.x + 26, loc.y + 20);
    head.addPoint(loc.x + 17, loc.y + 25);
    head.addPoint(loc.x + 8, loc.y + 20);
    
    //left ear
    Polygon ear1 = new Polygon();
    ear1.addPoint(loc.x + 10, loc.y + 5);
    ear1.addPoint(loc.x + 14, loc.y + 2);
    ear1.addPoint(loc.x + 12, loc.y + 10);
    
    //right ear
    Polygon ear2 = new Polygon();
    ear2.addPoint(loc.x + 24, loc.y + 5);
    ear2.addPoint(loc.x + 20, loc.y + 2);
    ear2.addPoint(loc.x + 22, loc.y + 10);
    
    //nose
    Polygon nose = new Polygon();
    nose.addPoint(loc.x + 16, loc.y + 15);
    nose.addPoint(loc.x + 18, loc.y + 15);
    nose.addPoint(loc.x + 17, loc.y + 18);
    
    //left eye
    Polygon eye1 = new Polygon();
    eye1.addPoint(loc.x + 12, loc.y + 12);
    eye1.addPoint(loc.x + 15, loc.y + 12);
    eye1.addPoint(loc.x + 13, loc.y + 15);
    
    //right eye
    Polygon eye2 = new Polygon();
    eye2.addPoint(loc.x + 22, loc.y + 12);
    eye2.addPoint(loc.x + 19, loc.y + 12);
    eye2.addPoint(loc.x + 21, loc.y + 15);

    polygons.add(head);
    polygons.add(ear1);
    polygons.add(ear2);
    polygons.add(nose);
    polygons.add(eye1);
    polygons.add(eye2);
  }
}