package com.example;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.imageio.ImageIO;

public class TileManager {
    GamePanel gp;
    Tile [] tiles;
    int [][] map;

    public TileManager (GamePanel g) {
        gp = g;
        tiles = new Tile[3];
        map = new int[gp.wCol][gp.wRow];
        getTileImage();
        load("map1");
    }

    public void getTileImage() {
        try {
            tiles[0] = new Tile();
            tiles[0].image = ImageIO.read(new File("JavaAPIProject\\res\\TilesArt\\NormalTile.png"));
            tiles[1] = new Tile();
            tiles[1].image = ImageIO.read(new File("JavaAPIProject\\res\\TilesArt\\EdibleTile.png"));
            tiles[2] = new Tile();
            tiles[2].image = ImageIO.read(new File("JavaAPIProject\\res\\WallArt\\wall.png"));
            tiles[2].tileCollision = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw (Graphics2D g2) { // If it's 0, then normal tile. If it's a 1, it is a edible tile. If it's a 2, then wall.
        for (int c = 0; c < gp.wRow; c ++) {
            for (int d = 0; d < gp.wCol; d++) {
                int screenX = (d * gp.displayTile) - gp.player.mapX + gp.player.screenX;
                int screenY = (c * gp.displayTile) - gp.player.mapY + gp.player.screenY;
                if (map[c][d] == 3) { // if it's a 3, then randomize between a normal and edible tile
                    if ((int) (Math.random() * 10) != 0) { // It has a 90% chance of being a normal tile
                        map[c][d] = 0;
                    } else {
                        map[c][d] = 1;
                    }
                }
                if ((d * gp.displayTile) + gp.displayTile > (gp.player.mapX - gp.player.screenX) && (d * gp.displayTile) - gp.displayTile < (gp.player.mapX + gp.player.screenX) && (c * gp.displayTile) + gp.displayTile > (gp.player.mapY - gp.player.screenY) && (c * gp.displayTile) - gp.displayTile < (gp.player.mapY + gp.player.screenY)) {
                    g2.drawImage(tiles[map[c][d]].image, screenX, screenY, gp.displayTile, gp.displayTile, null);
                }
            }
        }
    }

    public void load (String m) {
        try {
            BufferedReader b = new BufferedReader(new FileReader("JavaAPIProject\\res\\MapTextFiles\\" + m + ".txt"));
            for (int h = 0; h < gp.wRow; h++) {
                String l = b.readLine();
                for (int w = 0; w < gp.wCol; w++) {
                    String nums []  = l.split(" ");
                    int n = Integer.parseInt(nums[w]);
                    map[h][w] = n;
                }
            }
            b.close();
        } catch (Exception e) {
            
        }
    }
}
