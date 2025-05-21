package com.example;

import javax.swing.JFrame;

public class MainWindow{
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Crappy Roguelike");
        window.setSize(420,420);

        GamePanel GPanel = new GamePanel();
        window.add(GPanel);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
        GPanel.startThread();
    }
}
