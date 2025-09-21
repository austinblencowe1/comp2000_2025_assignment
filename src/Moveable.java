public interface Moveable {
    //gets the current column
    int getCol();
    //gets the current row
    int getRow();
    //moves the object to a new position
    void moveTo(int col, int row);
    //updates the object each game tick
    void tick();
}