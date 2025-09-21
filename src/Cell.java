import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

//base class for grid cells
public class Cell extends Rectangle {

    //size of each cell (35x35 pixels)
    static int size = 35;
    
    int col;
    int row;
    Grid grid;

    //initialises cell position and size
    public Cell(int col, int row, Grid grid) {
        super(10 + col * size, 10 + row * size, size, size);
        this.col = col;
        this.row = row;
        this.grid = grid;
    }

    //paints cell with white background, black border
    public void paint(Graphics g, Point mousePos) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, size, size);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, size, size);
    }

    //checks if a point is in cell
    public boolean contains(Point p) {
        if (p != null) {
            return super.contains(p);
        }
        return false;
    }
}