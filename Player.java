public class Player {
    public static int score;
    public static int x;
    public static int y;

    public static void playerDefiner(){
        Board.boardConf[x - 1][y - 1] = "@";
        System.out.println("Player is shown by \"@\" sign");
    }

    public static void showScore(){
        System.out.println("Your score is " + score);
    }

    public static void playerRandomPos(){
        Player.x = 1 +  (int) (Math.random() * Board.ROW_NUMBER);
        Player.y = 1 + (int) (Math.random() * Board.COLUMN_NUMBER);
    }

}
