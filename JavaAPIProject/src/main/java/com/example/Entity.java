package com.example;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
    public GamePanel gp;
    public int mapX, mapY, speed;

    public BufferedImage up1, up2, down1, down2, right1, right2, left1, left2, battle;  // map sprites and battle
    public String direction; // entity direction

    public int count = 0;
    public int spriteNum = 1;

    public Rectangle hitbox = new Rectangle();
    public boolean collision = false;
    public int hp;
    public int maxHp;

    public void setAction () {}
    public void update () { 
        setAction();
        collision = false;
        gp.check.entityCheck(this);
        gp.check.checkSlime(this, gp.enemies);
        gp.check.checkPlayer(this);
        
        if (!collision) {
                switch (direction) {
                    case "up":
                        mapY -= speed;
                        break;
                
                    case "down":
                        mapY += speed;
                        break;

                    case "left":
                        mapX -= speed;
                        break;
                
                    case "right":
                        mapX += speed;
                        break;
                } 
            }

            count++;
            if (count > 10) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                count = 0;
            }
    }
    public Entity (GamePanel gPanel) {
        gp = gPanel;
        resetHitbox();
    }
    public void draw(Graphics2D g2) { // draws the image onto the gui
        BufferedImage image = null;
        int screenX = mapX - gp.player.mapX + gp.player.screenX;
        int screenY = mapY - gp.player.mapY + gp.player.screenY;

        if (mapX + 3 * gp.tileSize > gp.player.mapX - gp.player.screenX && mapX - gp.tileSize < gp.player.mapX + gp.player.screenX && mapY + 3 * gp.tileSize > gp.player.mapY - gp.player.screenY && mapY - gp.tileSize < gp.player.mapY + gp.player.screenY ) {
            switch (direction) { // changes image based on direction
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
            g2.drawImage(image, screenX, screenY, gp.displayTile, gp.displayTile, null);
        }
    }
    public void resetHitbox () {
        hitbox.x = 8;
        hitbox.y = 24;
        hitbox.width = 28;
        hitbox.height = 16;
    }
}
