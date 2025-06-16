package com.example;

import java.io.File;

import javax.imageio.ImageIO;

public class Slime extends Entity{

    private int actionCounter = 0;
    
    public Slime (GamePanel gp) {
        super(gp);
        hp = 15;
        direction = "down";
        speed = 3;
        getImage();
    }

    public void getImage () {
        try {
            up1 = ImageIO.read(new File("JavaAPIProject\\res\\SlimeArt\\SlimeBack1.png"));
            up2 = ImageIO.read(new File("JavaAPIProject\\res\\SlimeArt\\SlimeBack2.png"));
            down1 = ImageIO.read(new File("JavaAPIProject\\res\\SlimeArt\\SlimeFront1.png"));
            down2 = ImageIO.read(new File("JavaAPIProject\\res\\SlimeArt\\SlimeFront2.png"));
            left1 = ImageIO.read(new File("JavaAPIProject\\res\\SlimeArt\\SlimeLeft1.png"));
            left2 = ImageIO.read(new File("JavaAPIProject\\res\\SlimeArt\\SlimeLeft2.png"));
            right1 = ImageIO.read(new File("JavaAPIProject\\res\\SlimeArt\\SlimeRight1.png"));
            right2 = ImageIO.read(new File("JavaAPIProject\\res\\SlimeArt\\SlimeRight2.png"));
            battle = ImageIO.read(new File("JavaAPIProject\\res\\BattleSprites\\SlimeBattle.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setAction () {
        actionCounter ++;

        if (actionCounter > 60) {
            int r = (int) (Math.random() * 4) + 1;
            if (r == 1) {
                direction = "up";
            }
            if (r == 2) {
                direction = "down";
            }
            if (r == 3) {
                direction = "left";
            }
            if (r == 4) {
               direction = "right";
            }
            actionCounter = 0;
        }
    }
}
