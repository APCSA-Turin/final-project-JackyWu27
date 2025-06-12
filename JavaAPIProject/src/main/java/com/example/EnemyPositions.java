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
        gp.enemies[0].mapX = gp.tileSize * 21;
        gp.enemies[0].mapY = gp.tileSize * 19;
    }
}
