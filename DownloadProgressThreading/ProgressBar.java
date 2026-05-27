package DownloadProgressThreading;

import javax.swing.*;

public record ProgressBar() {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Button Window");
        JButton button = new JButton("Download");
        frame.add(button);
        frame.setSize(100, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        button.addActionListener(e -> {
            MyThread thread = new MyThread();
            thread.start();
        });
    }
}
