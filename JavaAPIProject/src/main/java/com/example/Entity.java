package com.example;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
    public int mapX, mapY, speed;

    public static BufferedImage up1, up2, down1, down2, right1, right2, left1, left2;  // player images
    public String direction; // player direction

    public int count = 0;
    public int spriteNum = 1;

    public Rectangle hitbox;
    public boolean collision = false;
}
