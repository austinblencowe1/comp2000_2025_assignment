import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class PelletCell extends Cell {
    private Pellet pellet;

    public PelletCell(int col, int row, Grid grid, int value) {
        super(col, row, grid);
        pellet = new Pellet(value);
    }

    public boolean hasPellet() 
    { 
        return !pellet.isCollected(); 
    }

    public int takePellet() {
        if (hasPellet()) {
            int value = pellet.getValue();
            pellet.collect();
            grid.decrementPellets();
            return value;
        }
        return 0;
    }

    @Override
    public void paint(Graphics g, Point mousePos) {
        g.setColor(contains(mousePos) ? Color.GRAY : Color.WHITE);
        g.fillRect(x, y, size, size);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, size, size);

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