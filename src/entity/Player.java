package entity;

import main.GamePanel;
import main.KeyBinds;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{ //hero
    GamePanel gp;
    KeyBinds KeyB;

    public final int screenX;
    public final int screenY;

    int spriteSize;

    //player status/settings
    private boolean canDash = true;
    private long lastDashTime = 0L;

    public Player(GamePanel gp, KeyBinds KeyB, int spriteSize) {
        this.spriteSize = spriteSize;
        this.gp = gp;
        this.KeyB = KeyB;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues (){
        worldX = gp.tileSize * 60;
        worldY = gp.tileSize * 34;
        playerHealth = 120;
        playerSpeed = 5;
        direction = "up";
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
            worldY -= playerSpeed;
        }
        else if (KeyB.downPressed == true) {
            direction = "down";
            worldY += playerSpeed;
        }
        else if (KeyB.rightPressed == true) {
            direction = "right";
            worldX += playerSpeed;
        }
        else if (KeyB.leftPressed == true) {
            worldX -= playerSpeed;
            direction = "left";
        }

        //Diagonal movement
        //Horizontal movement
        if (KeyB.leftPressed) {
            worldX -= playerSpeed;
        } else if (KeyB.rightPressed) {
            worldX += playerSpeed;
        }

        // Vertical movement
        if (KeyB.upPressed) {
            worldY -= playerSpeed;
        } else if (KeyB.downPressed) {
            worldY += playerSpeed;
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

            //abilities
            //dash
            if(KeyB.ePressed && canDash) {
                long currentTime = System.currentTimeMillis();

                if (currentTime - lastDashTime >= 1000) {
                    lastDashTime = currentTime;

                    float dashSpeed = 250;
                    switch (direction) {
                        case "up":
                            worldY -= dashSpeed;
                            break;
                        case "down":
                            worldY += dashSpeed;
                            break;
                        case "right":
                            worldX += dashSpeed;
                            break;
                        case "left":
                            worldX -= dashSpeed;
                            break;
                    }
                    canDash = false;
                }
            }
        }
        if(!canDash){
            long currentTime = System.currentTimeMillis();
            if(currentTime - lastDashTime >= 100){
             canDash = true;
            }
        }
    }

    public void draw(Graphics2D g2) {
        //g2.setColor(Color.white);
        //g2.fillRect(worldX, worldY, spriteSize, spriteSize);
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
        g2.drawImage(image, screenX, screenY, gp.spriteSize, gp.spriteSize, null);
    }
}
