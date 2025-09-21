import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends Bird implements KeyListener {
    private int col, row;
    private Grid grid;
    private int score = 0;

    public Player(int col, int row, Grid grid) {
        super(grid.cellAtColRow(col, row).get());
        this.col = col;
        this.row = row;
        this.grid = grid;
    }

    private void move(int dc, int dr) {
    int newCol = col + dc;
    int newRow = row + dr;

    // check bounds & wall collision
    if (grid.cellAtColRow(newCol, newRow).isPresent() &&
        !(grid.cellAtColRow(newCol, newRow).get() instanceof WallCell)) {

        col = newCol;
        row = newRow;

        // update the Actor/Bird polygon positions
        setCell(grid.cellAtColRow(col, row).get());

        // **collect pellet if present**
        Cell current = grid.cellAtColRow(col, row).get();
        if (current instanceof PelletCell pelletCell && pelletCell.hasPellet()) {
            int value = pelletCell.takePellet();   // get pellet value
            score += value;                        // increment player score
        }
    }
}


    public void incrementScore(int amount) { score += amount; }

    public int getCol() { return col; }
    public int getRow() { return row; }
    public int getScore() { return score; }

    // KeyListener methods
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP -> move(0, -1);
            case KeyEvent.VK_DOWN -> move(0, 1);
            case KeyEvent.VK_LEFT -> move(-1, 0);
            case KeyEvent.VK_RIGHT -> move(1, 0);
        }
    }

    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
}
