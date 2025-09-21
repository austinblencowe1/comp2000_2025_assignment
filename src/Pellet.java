public class Pellet implements Collectible {
    private boolean collected = false;
    private int value;

    //initialises pellet with a value
    public Pellet(int value) {
        this.value = value;
    }

    //gets the pellet's value
    @Override
    public int getValue() { return value; }

    //checks if the pellet is collected
    @Override
    public boolean isCollected() { return collected; }

    //marks the pellet as collected
    @Override
    public void collect() { collected = true; }
}