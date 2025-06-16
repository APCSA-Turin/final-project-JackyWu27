package com.example;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controls implements KeyListener {
    public boolean W, S, A, D, defend;
    GamePanel gp;

    public Controls (GamePanel g) {
        gp = g;
    }
    public void keyTyped(KeyEvent e) {}

    public void keyPressed(KeyEvent e) { //detect if pressed
        int code = e.getKeyCode();
        if (gp.player.hp > 1) {
        if (gp.unpaused) {
           
            if (code == KeyEvent.VK_W) {
                W = true;
            }
            if (code == KeyEvent.VK_A) {
                A = true;
            }
            if (code == KeyEvent.VK_S) {
                S = true;
            }
            if (code == KeyEvent.VK_D) {
                D = true;
            } 
        } else {
            if (code == KeyEvent.VK_W) {
                if (gp.ui.Y == 0) {
                    gp.ui.Y = 2;
                }
                gp.ui.Y --;
            }
            if (code == KeyEvent.VK_A) {
                if (gp.ui.X == 0) {
                    gp.ui.X = 2;
                }
                gp.ui.X --;
            }
            if (code == KeyEvent.VK_S) {
                if (gp.ui.Y == 1) {
                    gp.ui.Y = -1;
                }
                gp.ui.Y ++;
            }
            if (code == KeyEvent.VK_D) {
                if (gp.ui.X == 1) {
                    gp.ui.X = -1;
                }
                gp.ui.X ++;
            } 
            if (code == KeyEvent.VK_ENTER) {
                defend = false;
                if (gp.ui.X == 0) {
                    if (gp.ui.Y == 0) {
                        if (!gp.ui.menu.equals("battle")) {
                            gp.ui.menu = "battle"; // opens battle menu
                        } else {
                            gp.enemies[gp.currentFight].hp -= (int) (Math.random() * 5) + 5 + gp.player.lvl;// hit slime for 5-10 physical damage + lvl
                            gp.player.hp -= (int) (Math.random() * 4) + 3; // slime base damage is 3-7
                        }
                    } else {
                        if (gp.ui.menu.equals("battle")) {
                            gp.ui.menu = "magic"; // opens magic menu
                        }
                        
                    }
                } else {
                    if (gp.ui.Y == 0) {
                        if (gp.ui.menu.equals("battle")) {
                            gp.ui.menu = "item"; // opens item menu
                        }
                        
                    } else {
                        if (gp.ui.menu.equals("battle")) {
                            // reduces damage by 3
                            gp.player.hp -= (int) (Math.random() * 4);
                        }
                        
                    }
                }
                
            } 
            
        }
        }
        
    }

    public void keyReleased(KeyEvent e) { //detect if released
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) {
            W = false;
        }
        if (code == KeyEvent.VK_A) {
            A = false;
        }
        if (code == KeyEvent.VK_S) {
            S = false;
        }
        if (code == KeyEvent.VK_D) {
            D = false;
        }
    }
}
