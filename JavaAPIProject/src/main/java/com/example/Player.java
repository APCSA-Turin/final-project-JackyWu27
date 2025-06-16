package com.example;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Player extends Entity {
    Controls con;
    BufferedImage a;
    TileManager tm;

    public int exp; // how much exp until next level up
    public int req; // how much exp until next level up not counting the amount you have
    public int lvl; // increases hp and damage
    public final int screenX;
    public final int screenY;

    public Player (GamePanel g, Controls c, TileManager t) {
        super(g);
        hp = 25;
        maxHp = hp;
        exp = 1;
        req = 1;
        lvl = 0;
        con = c;
        tm = t;
        screenX = gp.width / 2 - (gp.displayTile / 2);
        screenY = gp.height / 2 - (gp.displayTile / 2);

        hitbox = new Rectangle();
        hitbox.x = 8;
        hitbox.y = 24;
        hitbox.width = 28;
        hitbox.height = 16;

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
            battle = ImageIO.read(new File("JavaAPIProject\\res\\BattleSprites\\BattlePlayer.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void setDefault () {
        mapX = 21 * gp.displayTile;
        mapY = 21 * gp.displayTile;
        speed = 6;
    }

    public void changeMaps (String m) {
        if (m.equals("map1")) {
            mapX = 2 * gp.displayTile;
            mapY = 7 * gp.displayTile;
        } else if (m.equals("win1")) {
            mapX = 38 * gp.displayTile;
            mapY = 7 * gp.displayTile;
        } else if (m.equals("backrooms")) {
            setDefault();
        }

    }

    public void update () {
        if(exp < 1) {
            lvl ++;
            req += 1 + lvl;
            exp = req;
            maxHp += 5;
            hp = maxHp;
        }
        if (tm.position) {
            changeMaps(tm.mapName);
            tm.position = false;
        }
        if (con.W || con.S || con.A || con.D) {
            if (con.W) {
                direction = "up";
            } else if (con.S) {
                direction = "down";
            } else if (con.A) {
                direction = "left";
            } else if (con.D) {
                direction = "right";
            }

            collision = false;
            gp.check.check(this);

            int enemyCollision  = gp.check.checkSlime(this, gp.enemies);
            enemyContact(enemyCollision);

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
        } else {
            if (direction.equals("left") || direction.equals("right")) {
                spriteNum = 1;
            }
        }
    }

    public void enemyContact (int c) {
        if (c != 99) {
            gp.unpaused = false;
            gp.currentFight = c;
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
        g2.drawImage(image, screenX, screenY, gp.displayTile, gp.displayTile, null);
    }
}
