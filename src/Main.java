import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;

//main class for the game window
public class Main extends JFrame {
    //game stage containing grid and actors
    Stage stage;

    //main method to launch the game
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main window = new Main();
            window.run();
        });
    }

    //canvas class for rendering the game
    class Canvas extends JPanel {
        //constructor sets up canvas and ui
        public Canvas() {
            setPreferredSize(new Dimension(1024, 720));
            addKeyListener(stage.getPlayer());
            setFocusable(true);
            requestFocusInWindow();

            //difficulty selection dropdown
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

        //paints the game stage
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            stage.paint(g, null);
        }
    }

    //constructor initializes the game window
    private Main() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        stage = new Stage();
        Canvas canvas = new Canvas();
        setContentPane(canvas);
        pack();
        setVisible(true);
        canvas.requestFocusInWindow();
    }

    //starts the game loop
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