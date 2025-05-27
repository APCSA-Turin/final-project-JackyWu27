package com.example;

import javax.swing.*;

public class MainWindow{
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setTitle("Crappy Roguelike");
        window.setSize(1280,720);

        GamePanel GPanel = new GamePanel();
        window.add(GPanel);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
        GPanel.startThread();
    }
}
