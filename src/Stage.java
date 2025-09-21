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

    

    //initialises the game stage
    public Stage() {
        grid = new Grid();
        player = new Player(1, 1, grid);
        ghosts = new ArrayList<>();
        ghosts.add(new Ghost(18, 1, grid, new Cat(grid.cellAtColRow(18, 1).get())));
        ghosts.add(new Ghost(18, 18, grid, new Dog(grid.cellAtColRow(18, 18).get())));
        startTime = System.currentTimeMillis();
    }

    //updates game state each tick
    public void tick() {
        //stop updates if game over or won
        if (gameOver || gameWon) {
            if (endTime == null) endTime = System.currentTimeMillis();
            return;
        }

        //increase tick counter and move ghosts based on speed
        tickCounter++;
        if (tickCounter % ghostSpeed == 0) {
            for (Ghost ghost : ghosts) {
                ghost.tick(player.getCol(), player.getRow());
                if (ghost.getCol() == player.getCol() && ghost.getRow() == player.getRow()) {
                    gameOver = true;
                }
            }
        }

        //check if win
        if (grid.getTotalPellets() == 0) gameWon = true;
    }

    //paints the game elements
    public void paint(Graphics g, Point mousePos) {
        grid.paint(g, mousePos);
        player.paint(g);
        for (Ghost ghost : ghosts) ghost.paint(g);

        //draw UI
        g.setColor(java.awt.Color.BLACK);
        g.drawString("Score: " + player.getScore(), 730, 50);

        //draw timer
        long now = (gameOver || gameWon) ? endTime : System.currentTimeMillis();
        long elapsedMs = now - startTime;

        int minutes = (int)(elapsedMs / 60000);
        int seconds = (int)((elapsedMs / 1000) % 60);
        int millis = (int)(elapsedMs % 1000);

        String timeString = String.format("%02d:%02d:%03d", minutes, seconds, millis);
        g.drawString("Time: " + timeString, 730, 70);
        g.drawString("Ghost Speed: " + ghostSpeed, 730, 90);

        //draw game over/win message
        if (gameOver) {
            g.drawString("GAME OVER!", 730, 120);
        } else if (gameWon) {
            g.drawString("YOU WIN!", 730, 120);
        }
    }

    //gets the player object
    public Player getPlayer() { return player; }

    //checks if the game is over
    public boolean isGameOver() { return gameOver; }

    //checks if the game is won
    public boolean isGameWon() { return gameWon; }

    //sets the ghost movement speed
    public void setGhostSpeed(int speed) {
        if (speed > 0) ghostSpeed = speed;
    }
}