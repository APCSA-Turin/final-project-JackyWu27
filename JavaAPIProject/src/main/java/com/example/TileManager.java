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
        tiles = new Tile[23];
        map = new int[gp.wCol][gp.wRow];
        getTileImage();
        load("map1");
    }

    public void getTileImage() {
        try {
            tiles[0] = new Tile();
            tiles[0].image = ImageIO.read(new File("JavaAPIProject\\res\\TilesArt\\NormalTile.png"));
            tiles[1] = new Tile();
            tiles[1].image = ImageIO.read(new File("JavaAPIProject\\res\\TilesArt\\NormalTile.png"));
            tiles[2] = new Tile();
            tiles[2].image = ImageIO.read(new File("JavaAPIProject\\res\\TilesArt\\EdibleTile.png"));
            tiles[3] = new Tile();
            tiles[3].image = ImageIO.read(new File("JavaAPIProject\\res\\WallArt\\Wall.png"));
            tiles[3].tileCollision = true;
            tiles[4] = new Tile();
            tiles[4].image = ImageIO.read(new File("JavaAPIProject\\res\\WallArt\\WallHorizontal.png"));
            tiles[4].tileCollision = true;
            tiles[5] = new Tile();
            tiles[5].image = ImageIO.read(new File("JavaAPIProject\\res\\WallArt\\WallVertical.png"));
            tiles[5].tileCollision = true;
            tiles[6] = new Tile();
            tiles[6].image = ImageIO.read(new File("JavaAPIProject\\res\\WallArt\\WallUp.png"));
            tiles[6].tileCollision = true;
            tiles[7] = new Tile();
            tiles[7].image = ImageIO.read(new File("JavaAPIProject\\res\\WallArt\\WallDown.png"));
            tiles[7].tileCollision = true;
            tiles[8] = new Tile();
            tiles[8].image = ImageIO.read(new File("JavaAPIProject\\res\\WallArt\\WallLeft.png"));
            tiles[8].tileCollision = true;
            tiles[9] = new Tile();
            tiles[9].image = ImageIO.read(new File("JavaAPIProject\\res\\WallArt\\WallRight.png"));
            tiles[9].tileCollision = true;
            tiles[10] = new Tile();
            tiles[10].image = ImageIO.read(new File("JavaAPIProject\\res\\WallArt\\WallTopLeft1.png"));
            tiles[10].tileCollision = true;
            tiles[11] = new Tile();
            tiles[11].image = ImageIO.read(new File("JavaAPIProject\\res\\WallArt\\WallTopRight1.png"));
            tiles[11].tileCollision = true;
            tiles[12] = new Tile();
            tiles[12].image = ImageIO.read(new File("JavaAPIProject\\res\\WallArt\\WallBottomLeft1.png"));
            tiles[12].tileCollision = true;
            tiles[13] = new Tile();
            tiles[13].image = ImageIO.read(new File("JavaAPIProject\\res\\WallArt\\WallBottomRight1.png"));
            tiles[13].tileCollision = true;
            tiles[14] = new Tile();
            tiles[14].image = ImageIO.read(new File("JavaAPIProject\\res\\WallArt\\WallTopLeft2.png"));
            tiles[14].tileCollision = true;
            tiles[15] = new Tile();
            tiles[15].image = ImageIO.read(new File("JavaAPIProject\\res\\WallArt\\WallTopRight2.png"));
            tiles[15].tileCollision = true;
            tiles[16] = new Tile();
            tiles[16].image = ImageIO.read(new File("JavaAPIProject\\res\\WallArt\\WallBottomLeft2.png"));
            tiles[16].tileCollision = true;
            tiles[17] = new Tile();
            tiles[17].image = ImageIO.read(new File("JavaAPIProject\\res\\WallArt\\WallBottomRight2.png"));
            tiles[17].tileCollision = true;
            tiles[18] = new Tile();
            tiles[18].image = ImageIO.read(new File("JavaAPIProject\\res\\WallArt\\WallOpenUp.png"));
            tiles[18].tileCollision = true;
            tiles[19] = new Tile();
            tiles[19].image = ImageIO.read(new File("JavaAPIProject\\res\\WallArt\\WallOpenDown.png"));
            tiles[19].tileCollision = true;
            tiles[20] = new Tile();
            tiles[20].image = ImageIO.read(new File("JavaAPIProject\\res\\WallArt\\WallOpenLeft.png"));
            tiles[20].tileCollision = true;
            tiles[21] = new Tile();
            tiles[21].image = ImageIO.read(new File("JavaAPIProject\\res\\WallArt\\WallOpenRight.png"));
            tiles[21].tileCollision = true;
            tiles[22] = new Tile();
            tiles[22].image = ImageIO.read(new File("JavaAPIProject\\res\\WallArt\\Barrier.png"));
            tiles[22].tileCollision = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw (Graphics2D g2) { // If it's 1, then normal tile. If it's a 2, it is a edible tile. If it's a 3, then wall.
        for (int c = 0; c < gp.wRow; c ++) {
            for (int d = 0; d < gp.wCol; d++) {
                int screenX = (d * gp.displayTile) - gp.player.mapX + gp.player.screenX;
                int screenY = (c * gp.displayTile) - gp.player.mapY + gp.player.screenY;
                if (map[c][d] == 0) { // if it's a 0, then randomize between a normal and edible tile
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
