package com.example;

public class CollisionCheck {
    GamePanel gp;
    public boolean win = false;

    public CollisionCheck (GamePanel g) {
        gp = g;
    }

    public void check (Player e) {
        int left = (e.mapX + e.hitbox.x) / gp.displayTile;
        int right = (e.mapX + e.hitbox.x + e.hitbox.width) / gp.displayTile;
        int top = (e.mapY + e.hitbox.y) / gp.displayTile;
        int bottom = (e.mapY + e.hitbox.y + e.hitbox.height) / gp.displayTile;
        int tile1;
        int tile2;

        switch (e.direction) {
            case "up":
                top = (e.mapY + e.hitbox.y - e.speed) / gp.displayTile;
                tile1 = gp.TM.map[top][left];
                tile2 = gp.TM.map[top][right];
                if (gp.TM.tiles[tile1].tileCollision == true || gp.TM.tiles[tile2].tileCollision == true) {
                    e.collision = true;
                }
                if (tile1 == 26 || tile2 == 26) {
                    win = true;
                } else {
                    win = false;
                }
                break;
        
            case "down":
                bottom = (e.mapY + e.hitbox.y + e.hitbox.width + e.speed) / gp.displayTile;
                tile1 = gp.TM.map[bottom][left];
                tile2 = gp.TM.map[bottom][right];
                if (gp.TM.tiles[tile1].tileCollision == true || gp.TM.tiles[tile2].tileCollision == true) {
                    e.collision = true;
                }
                if (tile1 == 26 || tile2 == 26) {
                    win = true;
                } else {
                    win = false;
                }
                break;
            case "right":
                right = (e.mapX + e.hitbox.x + e.hitbox.width + e.speed) / gp.displayTile;
                tile1 = gp.TM.map[top][right];
                tile2 = gp.TM.map[bottom][right];
                if (gp.TM.tiles[tile1].tileCollision == true || gp.TM.tiles[tile2].tileCollision == true) {
                    e.collision = true;
                }
                if (tile1 == 26 || tile2 == 26) {
                    win = true;
                } else {
                    win = false;
                }
                break;
        
            case "left":
                left = (e.mapX + e.hitbox.x - e.speed) / gp.displayTile;
                tile1 = gp.TM.map[top][left];
                tile2 = gp.TM.map[bottom][left];
                if (gp.TM.tiles[tile1].tileCollision == true || gp.TM.tiles[tile2].tileCollision == true) {
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

    public void entityCheck (Entity e) {
        int left = (e.mapX + e.hitbox.x) / gp.displayTile;
        int right = (e.mapX + e.hitbox.x + e.hitbox.width) / gp.displayTile;
        int top = (e.mapY + e.hitbox.y) / gp.displayTile;
        int bottom = (e.mapY + e.hitbox.y + e.hitbox.height) / gp.displayTile;
        int tile1;
        int tile2;

        switch (e.direction) {
            case "up":
                top = (e.mapY + e.hitbox.y - e.speed) / gp.displayTile;
                tile1 = gp.TM.map[top][left];
                tile2 = gp.TM.map[top][right];
                if (gp.TM.tiles[tile1].tileCollision == true || gp.TM.tiles[tile2].tileCollision == true) {
                    e.collision = true;
                }
                break;
        
            case "down":
                bottom = (e.mapY + e.hitbox.y + e.hitbox.width + e.speed) / gp.displayTile;
                tile1 = gp.TM.map[bottom][left];
                tile2 = gp.TM.map[bottom][right];
                if (gp.TM.tiles[tile1].tileCollision == true || gp.TM.tiles[tile2].tileCollision == true) {
                    e.collision = true;
                }
                break;
            case "right":
                right = (e.mapX + e.hitbox.x + e.hitbox.width + e.speed) / gp.displayTile;
                tile1 = gp.TM.map[top][right];
                tile2 = gp.TM.map[bottom][right];
                if (gp.TM.tiles[tile1].tileCollision == true || gp.TM.tiles[tile2].tileCollision == true) {
                    e.collision = true;
                }
                break;
        
            case "left":
                left = (e.mapX + e.hitbox.x - e.speed) / gp.displayTile;
                tile1 = gp.TM.map[top][left];
                tile2 = gp.TM.map[bottom][left];
                if (gp.TM.tiles[tile1].tileCollision == true || gp.TM.tiles[tile2].tileCollision == true) {
                    e.collision = true;
                }
                break;
        }
    }

    public int checkSlime (Entity entity, Entity[] arr) {
        int index = 99;
        for (int c = 0; c < arr.length; c++) {
            if (arr[c] != null && !entity.equals(arr[c])) {
                entity.hitbox.x += entity.mapX;
                entity.hitbox.y += entity.mapY;
                
                arr[c].hitbox.x += arr[c].mapX;
                arr[c].hitbox.y += arr[c].mapY;


                switch (entity.direction) {
                    case "up":
                        entity.hitbox.y -= entity.speed;
                        if (entity.hitbox.intersects(arr[c].hitbox)) {
                            entity.collision = true;
                            index = c;
                            break;
                        }
                
                    case "down":
                        entity.hitbox.y += entity.speed;
                        if (entity.hitbox.intersects(arr[c].hitbox)) {
                            entity.collision = true;
                            index = c;
                            break;
                        }

                    case "left":
                        entity.hitbox.x -= entity.speed;
                        if (entity.hitbox.intersects(arr[c].hitbox)) {
                            entity.collision = true;
                            index = c;
                            break;
                        }
                
                    case "right":
                        entity.hitbox.x += entity.speed;
                        if (entity.hitbox.intersects(arr[c].hitbox)) {
                            entity.collision = true;
                            index = c;
                            break;
                        }
                } 
                entity.resetHitbox();
                arr[c].resetHitbox();
            }
        }
        return index;
    }

    public void checkPlayer (Entity entity) {
                entity.hitbox.x += entity.mapX;
                entity.hitbox.y += entity.mapY;
                
                gp.player.hitbox.x += gp.player.mapX;
                gp.player.hitbox.y += gp.player.mapY;


                switch (entity.direction) {
                    case "up":
                        entity.hitbox.y -= entity.speed;
                        if (entity.hitbox.intersects(gp.player.hitbox)) {
                            entity.collision = true;
                            break;
                        }
                
                    case "down":
                        entity.hitbox.y += entity.speed;
                        if (entity.hitbox.intersects(gp.player.hitbox)) {
                            entity.collision = true;
                            break;
                        }

                    case "left":
                        entity.hitbox.x -= entity.speed;
                        if (entity.hitbox.intersects(gp.player.hitbox)) {
                            entity.collision = true;
                            break;
                        }
                
                    case "right":
                        entity.hitbox.x += entity.speed;
                        if (entity.hitbox.intersects(gp.player.hitbox)) {
                            entity.collision = true;
                            break;
                        }
                } 
                entity.resetHitbox();
                gp.player.resetHitbox();
    }
}
