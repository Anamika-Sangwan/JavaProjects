package SnakeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {
    Timer timer;
    Random rand = new Random();
    int snakeLength = 1;
    char direction = 'R';
    public final int UNIT_SIZE = 25;
    public final int SCREEN_WIDTH = 600;
    public final int SCREEN_HEIGHT = 600;
    public final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / (UNIT_SIZE * UNIT_SIZE);
    int foodx = rand.nextInt(0, SCREEN_WIDTH / UNIT_SIZE) * 25;
    int foody = rand.nextInt(0, SCREEN_WIDTH / UNIT_SIZE) * 25;
    int[] x = new int[GAME_UNITS];
    int[] y = new int[GAME_UNITS];

    public GamePanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.WHITE);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        x[0] = 100;
        y[0] = 100;
        timer = new Timer(100, this);
        timer.start();
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
            g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
        }
        g.setColor(Color.RED);
        g.fillRect(foodx, foody, UNIT_SIZE, UNIT_SIZE);
        g.drawString("Score: " + (snakeLength - 1), 250, 250);
    }

    public void move() {
        System.out.println(snakeLength);
        for (int i = snakeLength - 1; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        switch (direction) {
            case 'U':
                y[0] -= UNIT_SIZE;
                if (y[0] < 0)
                    y[0] = SCREEN_HEIGHT - UNIT_SIZE;
                break;
            case 'D':
                y[0] += UNIT_SIZE;
                if (y[0] >= SCREEN_HEIGHT)
                    y[0] = 0;
                break;
            case 'L':
                x[0] -= UNIT_SIZE;
                if (x[0] < 0)
                    x[0] = SCREEN_WIDTH - UNIT_SIZE;
                break;
            case 'R':
                x[0] += UNIT_SIZE;
                if (x[0] >= SCREEN_WIDTH)
                    x[0] = 0;
                break;
        }
        if (x[0] == foodx && y[0] == foody) {
            if (snakeLength < GAME_UNITS)
                snakeLength++;
            foodx = rand.nextInt(0, SCREEN_WIDTH / UNIT_SIZE) * 25;
            foody = rand.nextInt(0, SCREEN_WIDTH / UNIT_SIZE) * 25;
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
