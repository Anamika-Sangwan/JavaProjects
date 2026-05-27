package ProgressBar;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class MyThread extends Thread {
    @Override
    public void run() {
        JFrame frame = new JFrame("Progress Bar Example");
        JProgressBar bar = new JProgressBar(0, 100);
        bar.setValue(0);
        bar.setStringPainted(true);
        frame.add(bar);
        frame.setSize(300, 100);
        frame.setLayout(new java.awt.FlowLayout());
        frame.setVisible(true);
        try {
            for (int i = 0; i <= 100; i++) {
                bar.setValue(i);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
        }
    }
}
