import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

//represents a cell containing a pellet
public class PelletCell extends Cell {
    //pellet in this cell
    private Pellet pellet;

    //initialises pellet cell with value
    public PelletCell(int col, int row, Grid grid, int value, boolean collected) {
        super(col, row, grid);
        pellet = new Pellet(value);
        if (collected) {
            pellet.collect();
        }
    }

    //checks if the cell has an uncollected pellet
    public boolean hasPellet() { return !pellet.isCollected(); }

    //collects the pellet and returns its value
    public int takePellet() {
        if (hasPellet()) {
            int value = pellet.getValue();
            pellet.collect();
            grid.decrementPellets();
            return value;
        }
        return 0;
    }

    //paints the pellet cell
    @Override
    public void paint(Graphics g, Point mousePos) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, size, size);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, size, size);

        //draw pellet if not collected
        if (hasPellet()) {
            int cx = x + size / 2;
            int cy = y + size / 2;
            int r = 6;
            g.setColor(Color.ORANGE);
            g.fillOval(cx - r / 2, cy - r / 2, r, r);
            g.setColor(Color.BLACK);
            g.drawOval(cx - r / 2, cy - r / 2, r, r);
        }
    }
}