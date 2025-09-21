public interface Moveable {
    int getCol();
    int getRow();
    void moveTo(int col, int row);
    void tick();
}