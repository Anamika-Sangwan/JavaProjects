package SnakeGame;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class snakeGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(new GamePanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
