package entity;

import main.GamePanel;
import main.KeyBinds;

import java.awt.*;

public class Player extends Entity{ //hero
    GamePanel gp;
    KeyBinds KeyB;
    int spriteSize;
    public Player(GamePanel gp, KeyBinds KeyB, int spriteSize) {
        this.spriteSize = spriteSize;
        this.gp = gp;
        this.KeyB = KeyB;

        setDefaultValues();
    }
    public void setDefaultValues (){
        playerX = 960;
        playerY = 540;
        playerSpeed = 6;
    }
    public void update() {
        if(KeyB.upPressed == true) {
            playerY -= playerSpeed;
        }
        else if (KeyB.downPressed == true) {
            playerY += playerSpeed;
        }
        else if (KeyB.rightPressed == true) {
            playerX += playerSpeed;
        }
        else if (KeyB.leftPressed == true) {
            playerX -= playerSpeed;
        }
        if (KeyB.leftPressed) {
            playerX -= playerSpeed;
        } else if (KeyB.rightPressed) {
            playerX += playerSpeed;
        }

        // Vertical movement
        if (KeyB.upPressed) {
            playerY -= playerSpeed;
        } else if (KeyB.downPressed) {
            playerY += playerSpeed;
        }
    }
    public void draw(Graphics2D g2) {
        g2.setColor(Color.white);
        g2.fillRect(playerX, playerY, spriteSize, spriteSize);
    } //
}
