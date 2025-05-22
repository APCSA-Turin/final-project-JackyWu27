package com.example;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Player extends Entity{
    GamePanel gp;
    Controls con;

    public Player (GamePanel g, Controls c) {
        gp = g;
        con = c;
        setDefault();
        direction = "down";
        playerImage();
    }

    public void playerImage () {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/PlayerArt/Back1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/PlayerArt/Back2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/PlayerArt/Front1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/PlayerArt/Front2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/PlayerArt/Left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/PlayerArt/Left2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/PlayerArt/Right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/PlayerArt/Right2.png"));
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
    }

    public void draw (Graphics2D g2) {
        BufferedImage image = null;
        switch (direction) {
            case "up":
                image = up1;
                break;
        
            case "down":
                image = down1;
                break;
            case "left":
                image = left1;
                break;
            case "right":
                image = right1;
                break;
        }
        g2.drawImage(image, x, y, gp.displayTile, gp.displayTile, null);
    }
}
