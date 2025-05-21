package com.example;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;


public class GamePanel extends JPanel {
    final int tileSize = 16;
    final int scale = 3;
    final int displayTile = scale * tileSize;
    final int tileCol = 16;
    final int tileRow = 12;
    final int height = tileRow * displayTile;
    final int width = tileCol * displayTile;

    Thread gameThread;
    Controls con;

    int x = 100;
    int y = 100;
    int speed = 4;
    public GamePanel () {
        this.setDoubleBuffered(true);
        this.setBackground(Color.GRAY);
        this.setPreferredSize(new Dimension(width, height));
        this.addKeyListener(con);
        this.setFocusable(true);
    }

    public void startThread () {
        gameThread = new Thread(this.getName());
        gameThread.start();
    }

    public void run () {
        double interval = 1/60;
        double nextTime = System.nanoTime() + interval;
        while (gameThread != null) { 
            update();
            repaint();

            
            System.out.println("Game running...");
        }
        
    }

    public void update () {
        if (con.W) {
            y -= speed;
        }
        if (con.S) {
            y += speed;
        }
        if (con.A) {
            x -= speed;
        }
        if (con.D) {
            x += speed;
        }
    }

    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.white);
        g2.fillRect(x,y,displayTile,displayTile);
        g2.dispose();
    }
}
