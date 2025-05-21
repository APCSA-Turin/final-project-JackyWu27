package com.example;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;


public class GamePanel extends JPanel implements Runnable{
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
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void run () {
        while (gameThread != null) {
            double interval = 1000000000.0/60;
        double delta = 0;
        int timer = 0;
        int drawCount = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        while (gameThread != null) { 
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / interval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }
            if (timer >= 1000000000) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
        
        }
    }

    public void update () {
        if (con.W) {
            y -= speed;
        } else if (con.S) {
            y += speed;
        } else if (con.A) {
            x -= speed;
        } else if (con.D) {
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
