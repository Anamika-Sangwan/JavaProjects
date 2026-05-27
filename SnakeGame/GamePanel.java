package SnakeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {
    Timer timer;
    Random rand = new Random();
    public final int GAME_UNITS = 20;
    int[] x = new int[GAME_UNITS];
    int[] y = new int[GAME_UNITS];
    int snakeLength = 1;
    int foodx = rand.nextInt(0, 24) * 25;
    int foody = rand.nextInt(0, 24) * 25;
    char direction = 'R';
    public final int SCREEN_WIDTH = 600;
    public final int SCREEN_HEIGHT = 600;

    public GamePanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.WHITE);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        timer = new Timer(100, this);
        timer.start();
        x[0] = 100;
        y[0] = 100;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        for (int i = 0; i < snakeLength; i++) {
            g.setColor(Color.GREEN);
            // x, y, width, height
            g.fillRect(x[i], y[i], 25, 25);
        }
        g.setColor(Color.RED);
        g.fillRect(foodx, foody, 25, 25);
    }

    public void move() {
        if (x[0] == foodx && y[0] == foody) {
            snakeLength++;
            foodx = rand.nextInt(0, 24) * 25;
            foody = rand.nextInt(0, 24) * 25;
        }
        switch (direction) {
            case 'U':
                if (y[0] == 0)
                    y[0] = 600;
                y[0] -= 25;
                break;
            case 'D':
                if (y[0] == 600)
                    y[0] = 0;
                y[0] += 25;
                break;
            case 'L':
                if (x[0] == 0)
                    x[0] = 600;
                x[0] -= 25;
                break;
            case 'R':
                if (x[0] == 600)
                    x[0] = 0;
                x[0] += 25;
                break;
        }
    }

    public class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_RIGHT:
                    direction = 'R';
                    break;
                case KeyEvent.VK_UP:
                    direction = 'U';
                    break;
                case KeyEvent.VK_DOWN:
                    direction = 'D';
                    break;
                case KeyEvent.VK_LEFT:
                    direction = 'L';
                    break;
            }
        }
    }
}
