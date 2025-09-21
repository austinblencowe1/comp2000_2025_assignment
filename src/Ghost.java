import java.awt.Graphics;
import java.util.*;

public class Ghost {
    private int col, row;
    private Actor sprite; // Cat or Dog
    private Grid grid;

    public Ghost(int col, int row, Grid grid, Actor sprite) {
        this.col = col;
        this.row = row;
        this.grid = grid;
        this.sprite = sprite;
    }

    public void tick(int playerCol, int playerRow) {
        int[] nextStep = findNextStep(playerCol, playerRow);
        if (nextStep != null) {
            col = nextStep[0];
            row = nextStep[1];
        }
    }

    private int[] findNextStep(int targetCol, int targetRow) {
        boolean[][] visited = new boolean[20][20];
        int[][] prevCol = new int[20][20];
        int[][] prevRow = new int[20][20];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{col, row});
        visited[row][col] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int c = cur[0], r = cur[1];
            if (c == targetCol && r == targetRow) break;

            for (int i = 0; i < 4; i++) {
                int nc = c + dc[i];
                int nr = r + dr[i];

                if (nc >= 0 && nc < 20 && nr >= 0 && nr < 20 &&
                    !visited[nr][nc] &&
                    !(grid.cellAtColRow(nc, nr).get() instanceof WallCell)) {
                    queue.add(new int[]{nc, nr});
                    visited[nr][nc] = true;
                    prevCol[nr][nc] = c;
                    prevRow[nr][nc] = r;
                }
            }
        }

        if (!visited[targetRow][targetCol]) {
            return null;
        }

        int c = targetCol;
        int r = targetRow;
        while (prevCol[r][c] != col || prevRow[r][c] != row) {
            int tempC = prevCol[r][c];
            int tempR = prevRow[r][c];
            c = tempC;
            r = tempR;
        }
        return new int[]{c, r};
    }

    public void paint(Graphics g) {
        sprite.setCell(grid.cellAtColRow(col, row).get());
        sprite.paint(g);
    }

    public int getCol() { 
        return col; 
    }
    
    public int getRow() { 
        return row; 
    }
}