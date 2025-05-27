package com.example;

public class CollisionCheck {
    GamePanel gPanel;

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
                tile1 = gPanel.TM.map[left][top];
                tile2 = gPanel.TM.map[right][top];
                if (gPanel.TM.tiles[tile1].tileCollision == true || gPanel.TM.tiles[tile2].tileCollision == true) {
                    e.collision = true;
                }
                break;
        
            case "down":

                break;
            case "right":
                
                break;
        
            case "left":

                break;
        }
    }
}
