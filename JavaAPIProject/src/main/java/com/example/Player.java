package com.example;

import java.awt.Color;
import java.awt.Graphics2D;

public class Player extends Entity{
    GamePanel gp;
    Controls con;

    public Player (GamePanel g, Controls c) {
        gp = g;
        con = c;
        setDefault();
    }

    public void setDefault () {
        x = 100;
        y = 100;
        speed = 4;
    }

    public void update () {
        if (con.W) {
            y -= speed;
        } else if (con.S) {
            y += speed;
        } else if (con.A) {
            x -= speed;
        } else if (con.D) {
            x += speed;
        }
    }

    public void draw (Graphics2D g2) {
        g2.setColor(Color.white);
        g2.fillRect(x,y,gp.displayTile,gp.displayTile);
    }
}
