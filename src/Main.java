import java.awt.*;
import javax.swing.*;

public class Main extends JFrame {
    Stage stage = new Stage();

    public static void main(String[] args) {
        Main window = new Main();
        window.run();
    }

    class Canvas extends JPanel {
        public Canvas() {
            setPreferredSize(new Dimension(1024, 720));
            addKeyListener(stage.getPlayer());
            setFocusable(true);
            requestFocusInWindow();

            // Difficulty dropdown
            String[] speeds = {"Easy", "Medium", "Hard"};
            JComboBox<String> difficultyBox = new JComboBox<>(speeds);
            difficultyBox.setBounds(730, 160, 120, 25);
            difficultyBox.addActionListener(e -> {
                String selected = (String) difficultyBox.getSelectedItem();
                if (selected.contains("Easy")) stage.setGhostSpeed(15);
                else if (selected.contains("Medium")) stage.setGhostSpeed(12);
                else if (selected.contains("Hard")) stage.setGhostSpeed(6);

                // Refocus panel so arrow keys continue to work
                Canvas.this.requestFocusInWindow();
            });

            setLayout(null); // absolute positioning
            add(difficultyBox);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            stage.paint(g, new Point(0, 0));
        }
    }

    private Main() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas canvas = new Canvas();
        setContentPane(canvas);
        pack();
        setVisible(true);
        canvas.requestFocusInWindow();
    }

    public void run() {
        while (true) {
            stage.tick();
            repaint();
            try { Thread.sleep(20); } catch (Exception e) {}
        }
    }
}
