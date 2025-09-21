import java.awt.Graphics;
import java.awt.Point;
import java.util.Optional;

public class Grid {
    Cell[][] cells = new Cell[20][20];
    int totalCollectibles = 0;

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

        for (int r = 0; r < 20; r++) {
            for (int c = 0; c < 20; c++) {
                if (layout[r][c] == 1) {
                    cells[c][r] = new WallCell(c, r, this);
                } else {
                    cells[c][r] = new PelletCell(c, r, this, 10, false);
                    totalCollectibles++;
                }
            }
        }

        //set power pellets at specific locations
        cells[1][1] = new PowerPelletCell(1, 1, this, 50, false);
        cells[18][1] = new PowerPelletCell(18, 1, this, 50, false);
        cells[18][18] = new PowerPelletCell(18, 18, this, 50, false);
        cells[1][18] = new PowerPelletCell(1, 18, this, 50, false);
    }

    public void paint(Graphics g, Point mousePos) {
        for (int r = 0; r < 20; r++) {
            for (int c = 0; c < 20; c++) {
                cells[c][r].paint(g, mousePos);
            }
        }
    }

    public Optional<Cell> cellAtColRow(int c, int r) {
        if (c >= 0 && c < 20 && r >= 0 && r < 20) {
            return Optional.of(cells[c][r]);
        }
        return Optional.empty();
    }

    //gets the total number of uncollected collectibles
    public int getTotalCollectibles() {
        return totalCollectibles;
    }

    //decrements the collectible count when one is collected
    public void decrementCollectibles() {
        totalCollectibles--;
    }
}