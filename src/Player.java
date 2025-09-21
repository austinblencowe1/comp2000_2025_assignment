import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//represents the player character
public class Player extends Bird implements KeyListener {
    //current column of the player
    private int col;
    //current row of the player
    private int row;
    //reference to the game grid
    private Grid grid;
    //player's score
    private int score = 0;

    //constructor initializes player position
    public Player(int col, int row, Grid grid) {
        super(grid.cellAtColRow(col, row).get());
        this.col = col;
        this.row = row;
        this.grid = grid;
    }

    //moves the player in a given direction
    private void move(int dc, int dr) {
        int newCol = col + dc;
        int newRow = row + dr;

        if (grid.cellAtColRow(newCol, newRow).isPresent() &&
            !(grid.cellAtColRow(newCol, newRow).get() instanceof WallCell)) {
            col = newCol;
            row = newRow;
            setCell(grid.cellAtColRow(col, row).get());
            Cell current = grid.cellAtColRow(col, row).get();
            if (current instanceof PelletCell pelletCell && pelletCell.hasPellet()) {
                int value = pelletCell.takePellet();
                score += value;
            }
        }
    }

    //increments the player's score
    public void incrementScore(int amount) { score += amount; }

    //gets the current column
    public int getCol() { return col; }

    //gets the current row
    public int getRow() { return row; }

    //gets the player's score
    public int getScore() { return score; }

    //empty tick method for player
    @Override
    public void tick() {
        //no action needed
    }

    //handles key press events for movement
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP -> move(0, -1);
            case KeyEvent.VK_DOWN -> move(0, 1);
            case KeyEvent.VK_LEFT -> move(-1, 0);
            case KeyEvent.VK_RIGHT -> move(1, 0);
        }
    }

    //empty key released handler
    @Override
    public void keyReleased(KeyEvent e) {}

    //empty key typed handler
    @Override
    public void keyTyped(KeyEvent e) {}
}