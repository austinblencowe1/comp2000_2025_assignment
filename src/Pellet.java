public class Pellet implements Collectible {
    private boolean collected = false;
    private int value;

    public Pellet(int value) {
        this.value = value;
    }

    @Override
    public int getValue() { 
        return value; 
    }

    @Override
    public boolean isCollected() { 
        return collected; 
    }

    @Override
    public void collect() { 
        collected = true; 
    }
}