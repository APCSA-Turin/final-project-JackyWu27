package com.example;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;


public class GamePanel extends JPanel implements Runnable{
    final int tileSize = 16;
    final int scale = 3;
    final int displayTile = scale * tileSize;
    final int tileCol = 27;
    final int tileRow = 16;
    final int height = tileRow * displayTile;
    final int width = tileCol * displayTile;

    final int wRow = 41;
    final int wCol = 41;
    final int worldHeight = displayTile * tileSize;
    final int worldWidth = displayTile * tileSize; 

    
    Controls control = new Controls();
    Thread gameThread;
    public CollisionCheck check = new CollisionCheck(this);
    TileManager TM = new TileManager(this, check);
    public Player player = new Player(this, control);

    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel () {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(width, height));
        this.addKeyListener(control);
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
        player.update();
    }

    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        TM.draw(g2);
        player.draw(g2);
        g2.dispose();
    }
}
