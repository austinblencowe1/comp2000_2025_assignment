public interface Moveable {
  // attempt to move dx,dy measured in cell offsets (e.g., -1,0, +1,0)
  boolean tryMove(int dx, int dy);
}
