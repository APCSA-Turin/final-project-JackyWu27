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
    final int tileCol = 27;
    final int tileRow = 16;
    final int height = tileRow * displayTile;
    final int width = tileCol * displayTile;

    final int wRow = 41;
    final int wCol = 41;
    final int worldHeight = displayTile * tileSize;
    final int worldWidth = displayTile * tileSize; 

    
    Controls control = new Controls(this);
    Thread gameThread;

    public CollisionCheck check = new CollisionCheck(this);
    TileManager TM = new TileManager(this, check);
    public Ui ui = new Ui(this);
    public Player player = new Player(this, control, TM);
    public boolean unpaused;
    Slime[] enemies = new Slime[10];
    Slime[] savedSlimes = new Slime[10];
    public boolean loadSlimes = false;
    EnemyPositions ePositions = new EnemyPositions(this);

    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;
    int currentFight = 99;

    public GamePanel () {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.black);
        this.addKeyListener(control);
        this.setFocusable(true);
        ePositions.setEnemy();
        unpaused = true;
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
        if (unpaused) {
            player.update();
            for (int s = 0; s < enemies.length; s++) {
                if (!TM.mapName.equals("map1") && !loadSlimes) {
                    if (enemies[s] != null) {
                        savedSlimes[s] = enemies[s];
                        enemies[s] = null;
                    }
                    if (s + 1 == enemies.length) {
                        loadSlimes = true;
                    }
                } else if (TM.mapName.equals("map1") && loadSlimes) {
                    enemies = savedSlimes;
                    loadSlimes = false;
                }
                if (enemies[s] != null) {
                    enemies[s].update();
                }
            }
        } else {
            
        }
    }

    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        if (unpaused) {
            TM.draw(g2);
            for (int i = 0; i < enemies.length; i++) {
                if (enemies[i] != null) {
                    enemies[i].draw(g2);
                }
            }
            if (player.hp > 1) {
                player.draw(g2);
            }
        } else {
            ui.draw(g2);
            if (enemies[currentFight].hp < 1 || player.hp < 1) {
                unpaused = true;
                if (enemies[currentFight].hp < 1) {
                    enemies[currentFight] = null; 
                    player.exp -= 3;
                }
                currentFight = 99;
            }
        }
        g2.dispose();
    }
}
