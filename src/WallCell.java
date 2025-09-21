import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

//represents a wall cell in the grid
public class WallCell extends Cell {
    //constructor initializes wall cell
    public WallCell(int col, int row, Grid grid) {
        super(col, row, grid);
    }

    //paints the wall cell with a dark gray background
    @Override
    public void paint(Graphics g, Point mousePos) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x, y, size, size);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, size, size);
    }
}