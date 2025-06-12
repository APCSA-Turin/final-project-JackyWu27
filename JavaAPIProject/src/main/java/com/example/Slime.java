package com.example;

import java.io.File;

import javax.imageio.ImageIO;

public class Slime extends Entity{
    
    public Slime (GamePanel gp) {
        super(gp);
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
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
