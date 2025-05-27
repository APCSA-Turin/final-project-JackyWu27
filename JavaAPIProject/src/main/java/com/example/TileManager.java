package com.example;

import java.awt.Graphics2D;
import java.io.File;

import javax.imageio.ImageIO;

public class TileManager {
    GamePanel gp;
    Tile [] tiles;
    int [] ran1 = new int[10];
    int [] ran2 = new int[10];;

    public TileManager (GamePanel g) {
        gp = g;
        tiles = new Tile[2];
        getTileImage();
        for (int c = 0; c < 10; c++) {
            ran1[c] = (int) (Math.random() * 15) + 1;
            ran2[c] = (int) (Math.random() * 15) + 1;
        }
    }

    public void getTileImage() {
        try {
            tiles[0] = new Tile();
            tiles[0].image = ImageIO.read(new File("JavaAPIProject\\res\\TilesArt\\NormalTile.png"));
            tiles[1] = new Tile();
            tiles[1].image = ImageIO.read(new File("JavaAPIProject\\res\\TilesArt\\EdibleTile.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw (Graphics2D g2) {
        for (int c = 0; c < 15; c ++) {
            for (int d = 0; d < 15; d++) {
                if (isFood(c, d)) {
                    g2.drawImage(tiles[1].image, c*48, d*48, gp.displayTile, gp.displayTile, null);
                } else {
                    g2.drawImage(tiles[0].image, c*48, d*48, gp.displayTile, gp.displayTile, null);
                }
            }
        }
    }

    public boolean isFood (int c, int d) {
        for (int a = 0; a < ran1.length; a++) {
            if (c == ran1[a] && d == ran2[a]) {
                return true;
            }
        }
        return false;
    }
}
