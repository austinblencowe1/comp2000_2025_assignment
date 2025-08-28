import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Stage {
  Grid grid;
  List<Actor> actors;

  public Stage() {
    grid = new Grid();
    actors = new ArrayList<>();
    actors.add(new Cat(grid.cellAtColRow(0, 0).orElseThrow()));
    actors.add(new Dog(grid.cellAtColRow(0, 15).orElseThrow()));
    actors.add(new Bird(grid.cellAtColRow(12, 9).orElseThrow()));
  }

  public void paint(Graphics g, Point mouseLoc) {
    grid.paint(g, mouseLoc);
    for (Actor actor : actors) {
      actor.paint(g);
    }



    Optional<Cell> cell = grid.cellAtPoint(mouseLoc);
    if (cell.isPresent()) {
      Cell c = cell.get();
      int col = (c.x - 10) / Cell.size;
      int row = (c.y - 10) / Cell.size;
      
      String cellType = "Empty Cell";
      for (Actor actor : actors) {
        if (actor.loc == c) {
          cellType = actor.getClass().getSimpleName();
          break;
        }
      }
      g.setColor(java.awt.Color.BLACK);
      g.drawString("Cell Type: " + cellType, 730, 50);
      g.drawString("Column: " + col, 730, 70);
      g.drawString("Row: " + row, 730, 90);
    }
  }
}