import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Stage {
    Grid grid;
    Player player;
    List<Ghost> ghosts;
    boolean gameOver = false;
    boolean gameWon = false;
    int tickCounter = 0;
    Long startTime;
    Long endTime;
    int ghostSpeed = 15;
    //indicates if power pellet is active
    boolean powerPelletActive = false;
    //remaining ticks for power pellet effect
    int powerPelletTicks = 0;

    //initializes the game stage
    public Stage() {
        grid = new Grid();
        player = new Player(1, 1, grid, this);
        ghosts = new ArrayList<>();
        ghosts.add(new Ghost(18, 1, grid, new Cat(grid.cellAtColRow(18, 1).get())));
        ghosts.add(new Ghost(18, 18, grid, new Dog(grid.cellAtColRow(18, 18).get())));
        startTime = System.currentTimeMillis();
    }

    //activates power pellet effect
    public void activatePowerPellet() {
        powerPelletActive = true;
        powerPelletTicks = 300; //15 seconds at 20ms per tick
    }

    public void tick() {
        if (gameOver || gameWon) {
            if (endTime == null) endTime = System.currentTimeMillis();
            return;
        }

        tickCounter++;
        if (powerPelletActive) {
            powerPelletTicks--;
            if (powerPelletTicks <= 0) {
                powerPelletActive = false;
            }
        } else if (tickCounter % ghostSpeed == 0) {
            for (Ghost ghost : ghosts) {
                ghost.tick(player.getCol(), player.getRow());
                if (ghost.getCol() == player.getCol() && ghost.getRow() == player.getRow()) {
                    gameOver = true;
                }
            }
        }

        if (grid.getTotalCollectibles() == 0) gameWon = true;
    }

    public void paint(Graphics g, Point mousePos) {
        grid.paint(g, mousePos);
        player.paint(g);
        for (Ghost ghost : ghosts) ghost.paint(g);

        g.setColor(java.awt.Color.BLACK);
        g.drawString("Score: " + player.getScore(), 730, 50);

        long now = (gameOver || gameWon) ? endTime : System.currentTimeMillis();
        long elapsedMs = now - startTime;

        int minutes = (int)(elapsedMs / 60000);
        int seconds = (int)((elapsedMs / 1000) % 60);
        int millis = (int)(elapsedMs % 1000);

        String timeString = String.format("%02d:%02d:%03d", minutes, seconds, millis);
        g.drawString("Time: " + timeString, 730, 70);
        g.drawString("Ghost Speed: " + ghostSpeed, 730, 90);

        //draw power pellet status
        if (powerPelletActive) {
            g.drawString("Power Pellet Active!", 730, 110);
        }
        if (gameOver) {
            g.drawString("GAME OVER!", 730, 120);
        } else if (gameWon) {
            g.drawString("YOU WIN!", 730, 120);
        }
    }

    public Player getPlayer() { return player; }

    public boolean isGameOver() { return gameOver; }

    public boolean isGameWon() { return gameWon; }

    public void setGhostSpeed(int speed) {
        if (speed > 0) ghostSpeed = speed;
    }
}