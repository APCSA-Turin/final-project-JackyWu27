package com.example;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Ui {
    GamePanel gp;
    Graphics2D g2;
    Font font;
    public int X;
    public int Y;
    public String menu = "battle";

    public Ui (GamePanel g) {
        gp = g;
        font = new Font("Calibri", Font.PLAIN, 40);
    }

    public void draw (Graphics2D gd) {
        g2 = gd;
        g2.setFont(font);
        g2.setColor(Color.WHITE);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        drawBattle();
    }

    public void drawBattle () {
        g2.setFont(font.deriveFont(Font.BOLD, 96F));
        if (menu.equals("battle")) {
            battleMenu();
        } else if (menu.equals("magic")) {
            magicMenu();
        } else {
            itemMenu();
        }
        
        g2.drawRect((gp.displayTile), (9 * gp.displayTile), 5 * gp.displayTile, 5 * gp.displayTile);
        g2.drawImage(gp.player.battle, (gp.displayTile), (9 * gp.displayTile), 5 * gp.displayTile, 5 * gp.displayTile, null);
        g2.drawImage(gp.enemies[gp.currentFight].battle, (11 * gp.displayTile), (3 * gp.displayTile), 5 * gp.displayTile, 5 * gp.displayTile, null);
        g2.setColor(new Color(35,35,35));
        g2.drawRect((gp.displayTile - 1), (14 * gp.displayTile + 7), gp.displayTile * 5 + 2, 16);
        g2.drawRect((12 * gp.displayTile - 1), (3 * gp.displayTile - 7), gp.displayTile * 3 + 2, 16);

        g2.setColor(new Color(240,0,13));
        g2.fillRect((gp.displayTile), (14 * gp.displayTile + 8), (int) (((double) gp.player.hp / gp.player.maxHp) * (gp.displayTile * 5)), 14);

        g2.setColor(new Color(120,210,245));
        g2.fillRect((12 * gp.displayTile), (3 * gp.displayTile - 6), (gp.displayTile * gp.enemies[gp.currentFight].hp) / 5, 14);

        g2.setColor(Color.WHITE);
        g2.setFont(font.deriveFont(Font.BOLD, 18F));
        g2.drawString(gp.player.hp + "/" + gp.player.maxHp, 3 * gp.displayTile + 4, 14 * gp.displayTile + 12);
    }

    
    public void battleMenu () {
        if (X == 0 && Y == 0) {
            g2.setColor(Color.YELLOW);
        }
        g2.drawString("FIGHT", (gp.tileCol * gp.displayTile) / 3, (12 * gp.displayTile));
        if (X == 0 && Y == 0) {
            g2.setColor(Color.WHITE);
        }

        if (X == 0 && Y == 1) {
            g2.setColor(Color.YELLOW);
        }
        g2.drawString("MAGIC", (gp.tileCol * gp.displayTile) / 3, (14 * gp.displayTile));
        if (X == 0 && Y == 1) {
            g2.setColor(Color.WHITE);
        }

        if (X == 1 && Y == 0) {
            g2.setColor(Color.YELLOW);
        }
        g2.drawString("ITEM", (2 * gp.tileCol * gp.displayTile) / 3, (12 * gp.displayTile));
        if (X == 1 && Y == 0) {
            g2.setColor(Color.WHITE);
        }

        if (X == 1 && Y == 1) {
            g2.setColor(Color.YELLOW);
        }
        g2.drawString("DEFEND", (2 * gp.tileCol * gp.displayTile) / 3, (14 * gp.displayTile));
        if (X == 1 && Y == 1) {
            g2.setColor(Color.WHITE);
        }
    }
    public void magicMenu () {
        if (X == 0 && Y == 0) {
            g2.setColor(Color.YELLOW);
        }
        g2.drawString("EXIT", (gp.tileCol * gp.displayTile) / 3, (12 * gp.displayTile));
        if (X == 0 && Y == 0) {
            g2.setColor(Color.WHITE);
        }

        if (X == 0 && Y == 1) {
            g2.setColor(Color.YELLOW);
        }
        g2.drawString("CHARGE", (gp.tileCol * gp.displayTile) / 3, (14 * gp.displayTile));
        if (X == 0 && Y == 1) {
            g2.setColor(Color.WHITE);
        }

        if (X == 1 && Y == 0) {
            g2.setColor(Color.YELLOW);
        }
        g2.drawString("KINDLE", (2 * gp.tileCol * gp.displayTile) / 3, (12 * gp.displayTile));
        if (X == 1 && Y == 0) {
            g2.setColor(Color.WHITE);
        }

        if (X == 1 && Y == 1) {
            g2.setColor(Color.YELLOW);
        }
        g2.drawString("-----", (2 * gp.tileCol * gp.displayTile) / 3, (14 * gp.displayTile));
        if (X == 1 && Y == 1) {
            g2.setColor(Color.WHITE);
        }

    }
    public void itemMenu () {
        if (X == 0 && Y == 0) {
            g2.setColor(Color.YELLOW);
        }
        g2.drawString("EXIT", (gp.tileCol * gp.displayTile) / 3, (12 * gp.displayTile));
        if (X == 0 && Y == 0) {
            g2.setColor(Color.WHITE);
        }

        if (X == 0 && Y == 1) {
            g2.setColor(Color.YELLOW);
        }
        g2.drawString("-----", (gp.tileCol * gp.displayTile) / 3, (14 * gp.displayTile));
        if (X == 0 && Y == 1) {
            g2.setColor(Color.WHITE);
        }

        if (X == 1 && Y == 0) {
            g2.setColor(Color.YELLOW);
        }
        g2.drawString("-----", (2 * gp.tileCol * gp.displayTile) / 3, (12 * gp.displayTile));
        if (X == 1 && Y == 0) {
            g2.setColor(Color.WHITE);
        }

        if (X == 1 && Y == 1) {
            g2.setColor(Color.YELLOW);
        }
        g2.drawString("-----", (2 * gp.tileCol * gp.displayTile) / 3, (14 * gp.displayTile));
        if (X == 1 && Y == 1) {
            g2.setColor(Color.WHITE);
        }
    }
}
