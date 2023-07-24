package main;

import entity.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;

public class GamePanel extends JPanel implements Runnable{
    public int originalSpriteSize = 64;
    public final int scale = 2;
    public final int spriteSize = originalSpriteSize * scale;

    final int maxScreenCol = 15;
    final int maxScreenRow = 8;
    final  int screenWidth = spriteSize * maxScreenCol;
    final int screenHeight = spriteSize * maxScreenRow;

    //fps

    int fps = 120;

    KeyBinds KeyB = new KeyBinds(); //instantiates binds
    Thread gameThread;
    Player player = new Player(this,KeyB, spriteSize);
    //set player default pos
    int playerX = 960;
    int playerY = 540;
    int playerSpeed = 6;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight)); //1920 x 1024
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

        double drawInterval = 1000000000/fps; //1sec/fps 0.00833 secs
        double nextDrawTime = System.nanoTime() + drawInterval;

        while(gameThread != null){
            long currentTime = System.nanoTime();
            long currentTime2 = System.currentTimeMillis();
            update();

            repaint();//calls paint component


            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime= remainingTime/1000000;

                if(remainingTime < 0){
                    remainingTime = 0;
                }
                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void update(){
        player.update();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        player.draw(g2);
        g2.dispose();
    }
}//
