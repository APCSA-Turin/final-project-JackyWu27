package com.example;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controls implements KeyListener {
    public boolean W, S, A, D;

    public void keyTyped(KeyEvent e) {}

    public void keyPressed(KeyEvent e) { //detect if pressed
        int code = e.getKeyCode();
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
