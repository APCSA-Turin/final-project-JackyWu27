package com.example;

import java.awt.image.BufferedImage;

public class Entity {
    public int x, y, speed;

    public static BufferedImage up1, up2, down1, down2, right1, right2, left1, left2;  // player images
    public String direction; // player direction

    public int count = 0;
    public int spriteNum = 1;
}
