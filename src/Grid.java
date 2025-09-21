import java.awt.Graphics;
import java.awt.Point;
import java.util.Optional;

//represents the game grid of cells
public class Grid {
    //2d array of cells (20x20)
    Cell[][] cells = new Cell[20][20];
    //total number of uncollected pellets
    int totalPellets = 0;

    //constructor initializes the grid layout
    public Grid() {
        int[][] layout = {
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,0,0,1,0,0,0,0,0,1,0,0,0,1,0,0,0,0,1},
            {1,0,1,0,1,0,1,1,1,0,1,0,1,0,1,0,1,1,0,1},
            {1,0,1,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,1},
            {1,0,1,1,1,1,1,0,1,0,1,0,1,1,1,1,1,0,1,1},
            {1,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,1},
            {1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,0,1,1,0,1},
            {1,0,0,0,1,0,0,0,1,0,0,0,0,0,1,0,0,0,0,1},
            {1,0,1,0,1,1,1,0,1,1,1,1,1,0,1,1,1,1,0,1},
            {1,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1},
            {1,0,1,1,1,1,1,1,1,1,1,0,1,1,1,1,0,1,0,1},
            {1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,1,0,1},
            {1,1,1,0,1,1,1,1,1,0,1,1,1,1,0,1,0,1,0,1},
            {1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,1,1,1,0,1,1,1,1,0,1,1,1,1,1,1,1,0,1},
            {1,0,1,0,1,0,0,0,0,0,0,1,0,0,0,0,0,1,0,1},
            {1,0,0,0,0,0,1,1,1,1,0,0,0,1,1,1,0,0,0,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
        };

        //initialize cells based on layout
        for (int r = 0; r < 20; r++) {
            for (int c = 0; c < 20; c++) {
                if (layout[r][c] == 1) {
                    cells[c][r] = new WallCell(c, r, this);
                } else {
                    cells[c][r] = new PelletCell(c, r, this, 10);
                    totalPellets++;
                }
            }
        }

        //set starting positions as empty pellet cells
        cells[1][1] = new PelletCell(1, 1, this, 10); //player start
        cells[18][1] = new PelletCell(18, 1, this, 10); //ghost 1 start
        cells[18][18] = new PelletCell(18, 18, this, 10); //ghost 2 start
    }

    //paints all cells in the grid
    public void paint(Graphics g, Point mousePos) {
        for (int r = 0; r < 20; r++) {
            for (int c = 0; c < 20; c++) {
                cells[c][r].paint(g, mousePos);
            }
        }
    }

    //gets the cell at a specific column and row
    public Optional<Cell> cellAtColRow(int c, int r) {
        if (c >= 0 && c < 20 && r >= 0 && r < 20) {
            return Optional.of(cells[c][r]);
        }
        return Optional.empty();
    }

    //gets the total number of uncollected pellets
    public int getTotalPellets() {
        return totalPellets;
    }

    //decrements the pellet count when one is collected
    public void decrementPellets() {
        totalPellets--;
    }
}