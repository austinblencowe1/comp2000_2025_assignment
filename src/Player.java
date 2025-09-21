import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends Bird implements KeyListener {
    private int col;
    private int row;
    private Grid grid;
    private int score = 0;
    private Stage stage;

    //initializes player with position and stage reference
    public Player(int col, int row, Grid grid, Stage stage) {
        super(grid.cellAtColRow(col, row).get());
        this.col = col;
        this.row = row;
        this.grid = grid;
        this.stage = stage;
    }

    private void move(int dc, int dr) {
        int newCol = col + dc;
        int newRow = row + dr;

        if (grid.cellAtColRow(newCol, newRow).isPresent() &&
            !(grid.cellAtColRow(newCol, newRow).get() instanceof WallCell)) {
            col = newCol;
            row = newRow;
            setCell(grid.cellAtColRow(col, row).get());
            Cell current = grid.cellAtColRow(col, row).get();
            if (current instanceof PelletCell pelletCell && pelletCell.hasCollectible()) {
                int value = pelletCell.takeCollectible();
                score += value;
                if (current instanceof PowerPelletCell) {
                    stage.activatePowerPellet();
                }
            }
        }
    }

    public void incrementScore(int amount) { score += amount; }

    public int getCol() { return col; }

    public int getRow() { return row; }

    public int getScore() { return score; }

    @Override
    public void tick() {}

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP -> move(0, -1);
            case KeyEvent.VK_DOWN -> move(0, 1);
            case KeyEvent.VK_LEFT -> move(-1, 0);
            case KeyEvent.VK_RIGHT -> move(1, 0);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}