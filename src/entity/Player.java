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
        playerSpeed = 5;
        direction = "down";
    }
    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/up0.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/up1.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/player/up2.png"));
            up4 = ImageIO.read(getClass().getResourceAsStream("/player/up3.png"));
            up5 = ImageIO.read(getClass().getResourceAsStream("/player/up4.png"));
            up6 = ImageIO.read(getClass().getResourceAsStream("/player/up5.png"));

            down1 = ImageIO.read(getClass().getResourceAsStream("/player/down (1).png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/down (2).png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/player/down (3).png"));
            down4 = ImageIO.read(getClass().getResourceAsStream("/player/down (4).png"));
            down5 = ImageIO.read(getClass().getResourceAsStream("/player/down (5).png"));
            down6 = ImageIO.read(getClass().getResourceAsStream("/player/down (6).png"));

            right1 = ImageIO.read(getClass().getResourceAsStream("/player/right (1).png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/right (2).png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/player/right (3).png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/player/right (4).png"));
            right5 = ImageIO.read(getClass().getResourceAsStream("/player/right (5).png"));
            right6 = ImageIO.read(getClass().getResourceAsStream("/player/right (6).png"));

            left1 = ImageIO.read(getClass().getResourceAsStream("/player/left (1).png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/left (2).png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/player/left (3).png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("/player/left (4).png"));
            left5 = ImageIO.read(getClass().getResourceAsStream("/player/left (5).png"));
            left6 = ImageIO.read(getClass().getResourceAsStream("/player/left (6).png"));

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading player images: " + e.getMessage());
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

        spriteCounter++;
        if(spriteCounter > 8){
            if(spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 3;
            } else if (spriteNum == 3) {
                spriteNum = 4;
            } else if (spriteNum == 4) {
                spriteNum = 5;
            } else if (spriteNum == 5) {
                spriteNum = 6;
            } else if (spriteNum == 6) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
    }
    public void draw(Graphics2D g2) {
        //g2.setColor(Color.white);
        //g2.fillRect(playerX, playerY, spriteSize, spriteSize);
        BufferedImage image = null;
        switch (direction) {
            case "up":
                if(spriteNum == 1)
            {
                image = up1;
            }
                if(spriteNum == 2)
                {
                    image = up2;
                }
                if(spriteNum == 3)
                {
                    image = up3;
                }
                if(spriteNum == 4)
                {
                    image = up4;
                }
                if(spriteNum == 5)
                {
                    image = up5;
                }
                if(spriteNum == 6)
                {
                    image = up6;
                }
                break;
            case "down":
                if(spriteNum == 1)
            {
                image = down1;
            }
                if(spriteNum == 2)
                {
                    image = down2;
                }
                if(spriteNum == 3)
                {
                    image = down3;
                }
                if(spriteNum == 4)
                {
                    image = down4;
                }
                if(spriteNum == 5)
                {
                    image = down5;
                }
                if(spriteNum == 6)
                {
                    image = down6;
                }

                break;
            case "right":
                if(spriteNum == 1) {
                    image = right1;
                }
                if(spriteNum == 2) {
                    image = right2;
                }
                if(spriteNum == 3) {
                    image = right3;
                }
                if(spriteNum == 4) {
                    image = right4;
                }
                if(spriteNum == 5) {
                    image = right5;
                }
                if(spriteNum == 6) {
                    image = right6;
                }
                break;
            case "left":
                if(spriteNum == 1) {
                    image = left1;
                }
                if(spriteNum == 2) {
                    image = left2;
                }
                if(spriteNum == 3) {
                    image = left3;
                }
                if(spriteNum == 4) {
                    image = left4;
                }
                if(spriteNum == 5) {
                    image = left5;
                }
                if(spriteNum == 6) {
                    image = left6;
                }
                break;
        }
        g2.drawImage(image, playerX, playerY, gp.spriteSize, gp.spriteSize, null);
    }
}
