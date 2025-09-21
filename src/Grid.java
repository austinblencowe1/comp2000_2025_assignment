import java.awt.Graphics;
import java.awt.Point;
import java.util.Optional;

public class Grid {
    Cell[][] cells = new Cell[20][20];
    int totalPellets = 0;

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
                    cells[c][r] = new PelletCell(c, r, this, 10);
                    totalPellets++;
                }
            }
        }

        cells[1][1] = new Cell(1, 1, this);
        cells[18][1] = new Cell(18, 1, this);
        cells[18][18] = new Cell(18, 18, this);
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

    public int getTotalPellets() {
        return totalPellets;
    }

    public void decrementPellets() {
        totalPellets--;
    }
}