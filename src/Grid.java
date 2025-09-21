import java.awt.Graphics;
import java.awt.Point;
import java.util.Optional;

public class Grid {
    Cell[][] cells = new Cell[20][20];

    public Grid() {
        // 0 = empty, 1 = wall
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
                int px = 10 + c * Cell.size;
                int py = 10 + r * Cell.size;
                if (layout[r][c] == 1) {
                    cells[c][r] = new WallCell(px, py);
                } else {
                    //cells[c][r] = new PelletCell(px, py, 10);
                    String type;
                    int rand = (int)(Math.random() * 5);
                    switch (rand) {
                        case 0 -> type = "nut";
                        case 1 -> type = "bolt";
                        case 2 -> type = "turbo";
                        case 3 -> type = "petrol";
                        case 4 -> type = "cash";
                        default -> type = "nut";
                    }
                    cells[c][r] = new PelletCell(px, py, 10, type);
                }
            }
        }

        // player spawn
        cells[1][1] = new Cell(10 + 1 * Cell.size, 10 + 1 * Cell.size);

        // Optional: ghost spawn points
        cells[18][1] = new Cell(10 + 18 * Cell.size, 10 + 1 * Cell.size);
        cells[18][18] = new Cell(10 + 18 * Cell.size, 10 + 18 * Cell.size);
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
}
