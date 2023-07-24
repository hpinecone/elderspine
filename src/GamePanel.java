import javax.swing.*;
import javax.swing.plaf.basic.BasicTreeUI;
import java.awt.*;
import java.awt.Color;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements Runnable{
    final int originalSpriteSize = 64;
    final int scale = 3;
    final int spriteSize = originalSpriteSize * scale;

    final int maxScreenCol = 10;
    final int maxScreenRow = 5;
    final  int screenWidth = spriteSize * maxScreenCol;
    final int screenHeight = spriteSize * maxScreenRow;

    KeyBinds KeyB = new KeyBinds(); //instantiates binds
    Thread gameThread;

    //set player default pos
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 8;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.gray);
        this.setDoubleBuffered(true);
        this.addKeyListener(KeyB); //adds user controls
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {
        while(gameThread != null){
            long currentTime = System.nanoTime();
            update();

            repaint();//calls paint component
        }
    }
    public void update(){
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
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.white);
        g2.fillRect(playerX, playerY, spriteSize, spriteSize);
        g2.dispose();
    }
}
