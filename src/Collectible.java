//interface for collectible items like pellets
public interface Collectible {
    //gets the value of the collectible
    int getValue();
    //checks if the item has been collected
    boolean isCollected();
    //marks the item as collected
    void collect();
}