package com.example;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
    public GamePanel gp;
    public int mapX, mapY, speed;

    public static BufferedImage up1, up2, down1, down2, right1, right2, left1, left2;  // player images
    public String direction; // player direction

    public int count = 0;
    public int spriteNum = 1;

    public Rectangle hitbox;
    public boolean collision = false;
    public Entity (GamePanel gPanel) {
        gp = gPanel;
    }
    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        int screenX = mapX - gp.player.mapX + gp.player.screenX;
        int screenY = mapY - gp.player.mapY + gp.player.screenY;

        if (mapX + gp.tileSize > gp.player.mapX - gp.player.screenX && mapX - gp.tileSize < gp.player.mapX + gp.player.screenX && mapY + gp.tileSize > gp.player.mapY - gp.player.screenY && mapY - gp.tileSize < gp.player.mapY + gp.player.screenY ) {
            switch (direction) {
            case "up":
                if (spriteNum == 1) {
                    image = up1; 
                }
                if (spriteNum == 2) {
                    image = up2; 
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down1; 
                }
                if (spriteNum == 2) {
                    image = down2; 
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1; 
                }
                if (spriteNum == 2) {
                    image = left2; 
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1; 
                }
                if (spriteNum == 2) {
                    image = right2; 
                }
                break;
        }
            g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        }
    }
}
