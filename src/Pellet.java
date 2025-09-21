public class Pellet {
    private boolean collected = false;

    public Pellet() {
        
    }

    public boolean isCollected() {
        return collected;
    }

    public void collect() {
        collected = true;
    }
}
