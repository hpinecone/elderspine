import  javax.swing.JFrame;
public class Main {
    public static int playerHealth;
    public static boolean playerStatus;
    public static int playerPosition;
    public static int gStatus = 1;
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

        if(gStatus == 1){ //game status (change later)
            characterInformation();
            gameStatus();
            System.out.println("a");
            gStatus++;
        }

        else if(gStatus == 2){
            System.out.println("b");
        }
    }

    public static boolean characterInformation(){ //character information alive/dead (change later)
        if(playerHealth >= 0)
        {
            playerStatus = false;
        }

        else{
            playerStatus = true;
        }

        return playerStatus;

    }

    public static int gameStatus(){ //game status start/stop (change later)
        if(playerStatus = false)
        {
        gStatus = 2;
        }

        else {
            gStatus = 1;
        }
        return gStatus;
    }

}