package main;

import entity.Player;
import tiles.TileManager;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;

public class GamePanel extends JPanel implements Runnable{
    //character size
    public int originalSpriteSize = 32;
    public final int scale = 2;
    public final int sprite1 = 8;
    public final int sprite2 = 8;
    public final int sprite3 = 8;
    public final int sprite4 = 8;
    public final int spriteSize = originalSpriteSize * scale;

    //tile size
    public final int originalTileSize = 16;
    public final int tileScale = 2;
    public final int tileSize = originalTileSize * tileScale;

    //screen dimensions
    public final int maxScreenCol = 60;
    public final int maxScreenRow = 34;
    public final  int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    //world settings
    public final int maxWorldCol = 62; //change to render map size
    public final int maxWorldRow = 34; //change to render map size
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    //fps

    int fps = 60;
    TileManager tileM = new TileManager(this);
    KeyBinds KeyB = new KeyBinds(); //instantiates binds
    Thread gameThread;
    public Player player = new Player(this,KeyB, spriteSize);
    //set player default pos

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight)); //1920 x 1080
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

        double drawInterval = 1000000000/fps; //1sec/fps 0.00833 secs/~120
        double nextDrawTime = System.nanoTime() + drawInterval;

        while(gameThread != null){
            long currentTime = System.nanoTime();
            long currentTime2 = System.currentTimeMillis();
            update();

            System.out.println("running (:");

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

        tileM.draw(g2);

        player.draw(g2);

        g2.dispose();
    }
}//
