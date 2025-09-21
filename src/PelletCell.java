import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class PelletCell extends Cell {
    private int pelletValue; // 0 = no pellet
    private String type;     // type of collectible

    public PelletCell(int x, int y, int value, String type) {
        super(x, y);
        this.pelletValue = value;
        this.type = type;
    }    

    public boolean hasPellet() {
        return pelletValue > 0;
    }

    public int takePellet() {
        int value = pelletValue;
        pelletValue = 0; // collected
        return value;
    }

    @Override
    public void paint(Graphics g, Point mousePos) {
        if (contains(mousePos)) g.setColor(Color.GRAY);
        else g.setColor(Color.WHITE);

        g.fillRect(x, y, size, size);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, size, size);

        if (hasPellet()) {
            int cx = x + size/2;
            int cy = y + size/2;
            int r = 6;

            switch (type.toLowerCase()) {
                case "nut":
                    g.setColor(new Color(169, 169, 169)); // gray
                    g.fillOval(cx - r/2, cy - r/2, r, r);
                    g.setColor(Color.BLACK);
                    g.drawOval(cx - r/2, cy - r/2, r, r);
                    break;

                case "bolt":
                    g.setColor(Color.DARK_GRAY);
                    g.fillRect(cx - r/2, cy - r/2, r, r);
                    g.setColor(Color.BLACK);
                    g.drawRect(cx - r/2, cy - r/2, r, r);
                    break;

                case "turbo":
                    g.setColor(Color.RED);
                    g.fillOval(cx - r/2, cy - r/2, r, r);
                    break;

                case "petrol":
                    g.setColor(Color.RED);
                    int w = 8;
                    int h = 12;
                    int cx2 = x + size / 2;
                    int cy2 = y + size / 2;

                    // main body
                    g.fillRect(cx2 - w/2, cy2 - h/2, w, h);

                    // cap
                    g.fillRect(cx2, cy2 - h/2 - 2, 3, 2);

                    // handle on top-left corner
                    g.fillRect(cx2 - w/2 - 1, cy2 - h/2, 3, h/4);

                    g.setColor(Color.BLACK);
                    g.drawRect(cx2 - w/2, cy2 - h/2, w, h);
                    g.drawRect(cx2, cy2 - h/2 - 2, 3, 2); // outline cap
                    g.drawRect(cx2 - w/2 - 1, cy2 - h/2, 3, h/4); // outline handle
                    break;



                case "cash":
                    g.setColor(Color.YELLOW);
                    g.fillRect(cx - r/2, cy - r/2, r, r);
                    g.setColor(Color.BLACK);
                    g.drawString("$", cx - 3, cy + 4);
                    break;

                default:
                    g.setColor(Color.ORANGE); // fallback
                    g.fillOval(cx - r/2, cy - r/2, r, r);
                    break;
            }
        }
    }
}
