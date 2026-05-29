package DownloadProgressThreading;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import java.util.*;

public class MyThread extends Thread {
    @Override
    public void run() {
        JFrame frame = new JFrame("Progress Bar Example");
        JProgressBar bar = new JProgressBar(0, 100);
        Random rand = new Random();
        bar.setValue(0);
        bar.setStringPainted(true);
        frame.add(bar);
        frame.setSize(300, 100);
        frame.setLayout(new java.awt.FlowLayout());
        frame.setVisible(true);
        int t = 0;
        try {
            for (int i = 0; i <= 100; i++) {
                bar.setValue(i);
                t = rand.nextInt(0, 1000);
                Thread.sleep(t);
            }
        } catch (Exception e) {
        }
    }
}
