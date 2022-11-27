public class Computer {
    public static int scoreComputer;
    public static int xComputer;
    public static int yComputer;

    public static void computerDefiner(){
        Board.boardConf[xComputer - 1][yComputer - 1] = "$";
        System.out.println("Player is shown by \"@\" sign");
    }

    public static void showComputerScore(){
        System.out.println("Your score is " + scoreComputer);
    }

    public static void computerRandomPos(){
        Player.x = 1 +  (int) (Math.random() * Board.ROW_NUMBER);
        Player.y = 1 + (int) (Math.random() * Board.COLUMN_NUMBER);
    }
}
