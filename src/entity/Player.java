package entity;

import main.GamePanel;
import main.KeyBinds;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{ //hero
    GamePanel gp;
    KeyBinds KeyB;
    int spriteSize;
    public Player(GamePanel gp, KeyBinds KeyB, int spriteSize) {
        this.spriteSize = spriteSize;
        this.gp = gp;
        this.KeyB = KeyB;

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues (){
        playerX = 960;
        playerY = 540;
        playerSpeed = 6;
        direction = "down";
    }
    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/warrior_up.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/warrior_down.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/warrior_right.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/warrior_left.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void update() {
        if(KeyB.upPressed == true) {
            direction = "up";
            playerY -= playerSpeed;
        }
        else if (KeyB.downPressed == true) {
            direction = "down";
            playerY += playerSpeed;
        }
        else if (KeyB.rightPressed == true) {
            direction = "right";
            playerX += playerSpeed;
        }
        else if (KeyB.leftPressed == true) {
            playerX -= playerSpeed;
            direction = "left";
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
        //g2.setColor(Color.white);
        //g2.fillRect(playerX, playerY, spriteSize, spriteSize);
        BufferedImage image = null;
        switch (direction) {
            case "up":
                image = up1;
                break;
            case "down":
                image = down1;
                break;
            case "right":
                image = right1;
                break;
            case "left":
                image = left1;
                break;
        }
        g2.drawImage(image, playerX, playerY, gp.spriteSize, gp.spriteSize, null);
    }
}
