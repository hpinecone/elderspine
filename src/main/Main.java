package main;

import  javax.swing.JFrame;
public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame(); //jframe start
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //makes the game closable
        window.setResizable(true); //resizable

        GamePanel gamePanel = new GamePanel(); //instantates the game panel class
        window.add(gamePanel);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true); //jframe end

        gamePanel.startGameThread(); //calls start operation

    }
}