//represents a collectible pellet
public class Pellet implements Collectible {
    //indicates if the pellet is collected
    private boolean collected = false;
    //value of the pellet
    private int value;

    //constructor initializes pellet with a value
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