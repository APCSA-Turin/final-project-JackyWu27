package com.example;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Player extends Entity{
    GamePanel gp;
    Controls con;
    BufferedImage a;

    public Player (GamePanel g, Controls c) {
        gp = g;
        con = c;
        setDefault();
        direction = "down";
        playerImage();
    }
    public void playerImage () {
        try {
            up1 = ImageIO.read(new File("JavaAPIProject\\res\\PlayerArt\\Back1.png"));
            up2 = ImageIO.read(new File("JavaAPIProject\\res\\PlayerArt\\Back2.png"));
            down1 = ImageIO.read(new File("JavaAPIProject\\res\\PlayerArt\\Front1.png"));
            down2 = ImageIO.read(new File("JavaAPIProject\\res\\PlayerArt\\Front2.png"));
            left1 = ImageIO.read(new File("JavaAPIProject\\res\\PlayerArt\\Left1.png"));
            left2 = ImageIO.read(new File("JavaAPIProject\\res\\PlayerArt\\Left2.png"));
            right1 = ImageIO.read(new File("JavaAPIProject\\res\\PlayerArt\\Right1.png"));
            right2 = ImageIO.read(new File("JavaAPIProject\\res\\PlayerArt\\Right2.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void setDefault () {
        x = 100;
        y = 100;
        speed = 4;
    }

    public void update () {
        if (con.W || con.S || con.A || con.D) {
            if (con.W) {
                direction = "up";
                y -= speed;
            } else if (con.S) {
                direction = "down";
                y += speed;
            } else if (con.A) {
                direction = "left";
                x -= speed;
            } else if (con.D) {
                direction = "right";
                x += speed;
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
        } else {
            if (direction.equals("left") || direction.equals("right")) {
                spriteNum = 1;
            }
        }
    }

    public void draw (Graphics2D g2) {
        BufferedImage image = null;
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
        g2.drawImage(image, x, y, gp.displayTile, gp.displayTile, null);
    }
}
