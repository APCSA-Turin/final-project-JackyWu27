package com.example;

public class CollisionCheck {
    GamePanel gPanel;
    public boolean win = false;

    public CollisionCheck (GamePanel g) {
        gPanel = g;
    }

    public void check (Entity e) {
        int left = (e.mapX + e.hitbox.x) / gPanel.displayTile;
        int right = (e.mapX + e.hitbox.x + e.hitbox.width) / gPanel.displayTile;
        int top = (e.mapY + e.hitbox.y) / gPanel.displayTile;
        int bottom = (e.mapY + e.hitbox.y + e.hitbox.height) / gPanel.displayTile;

        int tile1;
        int tile2;

        switch (e.direction) {
            case "up":
                top = (e.mapY + e.hitbox.y - e.speed) / gPanel.displayTile;
                tile1 = gPanel.TM.map[top][left];
                tile2 = gPanel.TM.map[top][right];
                if (gPanel.TM.tiles[tile1].tileCollision == true || gPanel.TM.tiles[tile2].tileCollision == true) {
                    e.collision = true;
                }
                if (tile1 == 26 || tile2 == 26) {
                    win = true;
                } else {
                    win = false;
                }
                break;
        
            case "down":
                bottom = (e.mapY + e.hitbox.y + e.hitbox.width + e.speed) / gPanel.displayTile;
                tile1 = gPanel.TM.map[bottom][left];
                tile2 = gPanel.TM.map[bottom][right];
                if (gPanel.TM.tiles[tile1].tileCollision == true || gPanel.TM.tiles[tile2].tileCollision == true) {
                    e.collision = true;
                }
                if (tile1 == 26 || tile2 == 26) {
                    win = true;
                } else {
                    win = false;
                }
                break;
            case "right":
                right = (e.mapX + e.hitbox.x + e.hitbox.width + e.speed) / gPanel.displayTile;
                tile1 = gPanel.TM.map[top][right];
                tile2 = gPanel.TM.map[bottom][right];
                if (gPanel.TM.tiles[tile1].tileCollision == true || gPanel.TM.tiles[tile2].tileCollision == true) {
                    e.collision = true;
                }
                if (tile1 == 26 || tile2 == 26) {
                    win = true;
                } else {
                    win = false;
                }
                break;
        
            case "left":
                left = (e.mapX + e.hitbox.x - e.speed) / gPanel.displayTile;
                tile1 = gPanel.TM.map[top][left];
                tile2 = gPanel.TM.map[bottom][left];
                if (gPanel.TM.tiles[tile1].tileCollision == true || gPanel.TM.tiles[tile2].tileCollision == true) {
                    e.collision = true;
                }
                if (tile1 == 26 || tile2 == 26) {
                    win = true;
                } else {
                    win = false;
                }
                break;
        }
    }
}
