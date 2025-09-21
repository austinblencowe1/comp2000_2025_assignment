import java.awt.Graphics;
import java.util.*;

public class Ghost {

    //current column
    private int col;
    //current row
    private int row;

    //actor sprite (cat or dog)
    private Actor sprite;

    private Grid grid;

    //initialises ghost position and sprite
    public Ghost(int col, int row, Grid grid, Actor sprite) {
        this.col = col;
        this.row = row;
        this.grid = grid;
        this.sprite = sprite;
    }

    //updates ghost position
    public void tick(int playerCol, int playerRow) {
        int[] nextStep = findNextStep(playerCol, playerRow);
        if (nextStep != null) {
            col = nextStep[0];
            row = nextStep[1];
        }
    }

    //bfs to find next move towards player
    private int[] findNextStep(int targetCol, int targetRow) {
        //bfs setup
        boolean[][] visited = new boolean[20][20];
        int[][] prevCol = new int[20][20];
        int[][] prevRow = new int[20][20];

        //initialise prev arrays
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{col, row});
        visited[row][col] = true;

        //directions arrays
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        //bfs loop
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int c = cur[0], r = cur[1];
            if (c == targetCol && r == targetRow) break;

            //explore neighbors
            for (int i = 0; i < 4; i++) {
                int nc = c + dc[i];
                int nr = r + dr[i];

                //check bounds and if visited or wall
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

        //reconstruct path
        if (!visited[targetRow][targetCol]) return null;

        //backtrack to find next step
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

    //paints the ghosts sprite
    public void paint(Graphics g) {
        sprite.setCell(grid.cellAtColRow(col, row).get());
        sprite.paint(g);
    }

    //gets the current column
    public int getCol() { return col; }

    //gets the current row
    public int getRow() { return row; }
}