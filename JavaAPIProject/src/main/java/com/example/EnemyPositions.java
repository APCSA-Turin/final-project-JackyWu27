package com.example;

public class EnemyPositions {
    GamePanel gp;
    public EnemyPositions (GamePanel g) {
        gp = g;
    }
    public void setObject() {

    }
    public void setEnemy() {
        gp.enemies[0] = new Slime(gp);
        gp.enemies[0].mapX = gp.displayTile * 36;
        gp.enemies[0].mapY = gp.displayTile * 34;

        gp.enemies[1] = new Slime(gp);
        gp.enemies[1].mapX = gp.displayTile * 34;
        gp.enemies[1].mapY = gp.displayTile * 34;

        gp.enemies[2] = new Slime(gp);
        gp.enemies[2].mapX = gp.displayTile * 32;
        gp.enemies[2].mapY = gp.displayTile * 34;

        gp.enemies[3] = new Slime(gp);
        gp.enemies[3].mapX = gp.displayTile * 30;
        gp.enemies[3].mapY = gp.displayTile * 34;

        gp.enemies[4] = new Slime(gp);
        gp.enemies[4].mapX = gp.displayTile * 34;
        gp.enemies[4].mapY = gp.displayTile * 32;

        gp.enemies[5] = new Slime(gp);
        gp.enemies[5].mapX = gp.displayTile * 32;
        gp.enemies[5].mapY = gp.displayTile * 32;
    }
}
