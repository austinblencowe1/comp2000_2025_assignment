import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class PelletCell extends Cell {
    
    //protected to allow subclass access
    protected Collectible collectible;

    //initialises pellet cell with a collectible and collected state
    public PelletCell(int col, int row, Grid grid, int value, boolean collected) {
        super(col, row, grid);
        collectible = new Pellet(value);
        if (collected) {
            collectible.collect();
        }
    }

    public boolean hasCollectible() { return !collectible.isCollected(); }

    //collects the collectible and returns its value
    public int takeCollectible() {
        if (hasCollectible()) {
            int value = collectible.getValue();
            collectible.collect();
            grid.decrementCollectibles();
            return value;
        }
        return 0;
    }

    //paints the cell and collectible if present
    @Override
    public void paint(Graphics g, Point mousePos) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, size, size);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, size, size);

        if (hasCollectible()) {
            int cx = x + size / 2;
            int cy = y + size / 2;
            int r = (collectible instanceof PowerPellet) ? 10 : 6;
            g.setColor((collectible instanceof PowerPellet) ? Color.YELLOW : Color.ORANGE);
            g.fillOval(cx - r / 2, cy - r / 2, r, r);
            g.setColor(Color.BLACK);
            g.drawOval(cx - r / 2, cy - r / 2, r, r);
        }
    }
}