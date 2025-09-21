public class PowerPelletCell extends PelletCell {
    //initialises power pellet cell with value and collected state
    public PowerPelletCell(int col, int row, Grid grid, int value, boolean collected) {
        super(col, row, grid, value, collected);
        //assign power pellet to collectible field
        collectible = new PowerPellet(value);
        if (collected) {
            collectible.collect();
        }
    }
}