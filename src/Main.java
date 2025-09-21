import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;

public class Main extends JFrame {
    Stage stage;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main window = new Main();
            window.run();
        });
    }

    class Canvas extends JPanel {
        public Canvas() {
            setPreferredSize(new Dimension(1024, 720));
            addKeyListener(stage.getPlayer());
            setFocusable(true);
            requestFocusInWindow();

            String[] speeds = {"Easy", "Medium", "Hard"};
            JComboBox<String> difficultyBox = new JComboBox<>(speeds);
            difficultyBox.setBounds(730, 160, 120, 25);
            difficultyBox.addActionListener(e -> {
                String selected = (String) difficultyBox.getSelectedItem();
                if (selected.contains("Easy")) stage.setGhostSpeed(15);
                else if (selected.contains("Medium")) stage.setGhostSpeed(12);
                else if (selected.contains("Hard")) stage.setGhostSpeed(6);
                Canvas.this.requestFocusInWindow();
            });

            setLayout(null);
            add(difficultyBox);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            stage.paint(g, null);
        }
    }

    private Main() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        stage = new Stage();
        Canvas canvas = new Canvas();
        setContentPane(canvas);
        pack();
        setVisible(true);
        canvas.requestFocusInWindow();
    }

    public void run() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                stage.tick();
                repaint();
            }
        }, 0, 20);
    }
}