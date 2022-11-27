//import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Pawn {
    int x;
    int y;
    static String loosing;
    private static String move;
    static Scanner sc = new Scanner(System.in);

    Pawn(int x, int y){
        this.x = x;
        this.y = y;
    }

    public static void movement(){
        System.out.println("Use \"W A S D\" to move through the board \n Make your move): ");
        System.out.println("To quit the game enter \"quit\"");
        while(!Objects.equals(move, "quit")){
            move = sc.nextLine();
            switch (move) {
                case "W" -> {
                    moveUP();
                    Player.playerDefiner();
                    Board.showMap();
                    movement();
                }
                case "S" -> {
                    moveDown();
                    Player.playerDefiner();
                    Board.showMap();
                    movement();
                }
                case "A" -> {
                    moveLeft();
                    Player.playerDefiner();
                    Board.showMap();
                    movement();
                }
                case "D" -> {
                    moveRight();
                    Player.playerDefiner();
                    Board.showMap();
                    movement();
                }
            }
        }

    }

    public static void moveUP(){
        String upString = Board.boardConf[Player.x - 2][Player.y - 1];
        if(Objects.equals(upString, " ")){
            loosingGame();
        }
        int upNumber = Integer.parseInt(upString);
        int j = Player.x - 1;

        if(j - upNumber < 0){
            loosingGame();
        }
        loosing = Board.boardConf[j - upNumber][Player.y - 1];
        System.out.println(loosing);
        if(Objects.equals(loosing, " ")){
            loosingGame();
        }
        Player.x -= upNumber;
        if(Player.x < 0){
            loosingGame();
        }
        String number;
        for(int i = j - 1; i >= j - upNumber; i--){
            number = Board.boardConf[Player.x - 1][i];
            if(!Objects.equals(number, " ")){
                Player.score = Player.score + Integer.parseInt(number);
            }
        }
        for (int i = j; i >= j - upNumber; i--){
            Board.boardConf[i][Player.y - 1] = " ";
        }
        Player.showScore();
    }

    public static void moveDown(){
        String downString = Board.boardConf[Player.x][Player.y - 1];
        if(Objects.equals(downString, " ")){
            loosingGame();
        }
        int downNumber = Integer.parseInt(downString);
        int j = Player.x - 1;
        System.out.println("Player.x = " + Player.x);
        if(j + downNumber - 1 > Board.ROW_NUMBER){
            loosingGame();
        }
        loosing = Board.boardConf[Player.x + downNumber - 1][Player.y - 1];
        System.out.println("loosing = "+loosing);
        if(Objects.equals(loosing, " ")){
            loosingGame();
        }
        Player.x += downNumber;
        System.out.println("Player.x = " +Player.x);
        System.out.println("downNumber = " + downNumber);
        if (Player.x > Board.ROW_NUMBER){
            loosingGame();
        }
        String number;
        for(int i = j + 1; i <= j + downNumber; i++){
            number = Board.boardConf[Player.x - 1][i];
            if(!Objects.equals(number, " ")){
                Player.score = Player.score + Integer.parseInt(number);
            }        }
        for (int i = j; i <= j + downNumber; i++){
            Board.boardConf[i][Player.y - 1] = " ";
        }
        Player.showScore();
    }

    public static void moveLeft(){
        String leftString = Board.boardConf[Player.x - 1][Player.y - 2];
        if (Objects.equals(leftString, " ")){
            loosingGame();
        }
        int leftNumber = Integer.parseInt(leftString);
        int j = Player.y - 1;
        if(j - leftNumber < 0){
            loosingGame();
        }
        loosing = Board.boardConf[Player.x - 1][Player.y - leftNumber];
        System.out.println(loosing);
        if(Objects.equals(loosing, " ")){
            loosingGame();
        }
        Player.y = Player.y - leftNumber;
        if(Player.y < 0){
            loosingGame();
        }
        String number;
        for(int i = j - 1; i >= j - leftNumber; i--){
            number = Board.boardConf[Player.x - 1][i];
            if(!Objects.equals(number, " ")){
                Player.score = Player.score + Integer.parseInt(number);
            }
        }
        for (int i = j; i >= j - leftNumber; i--){
            Board.boardConf[Player.x - 1][i] = " ";
        }
        Player.showScore();
    }

    public static void moveRight(){
        String rightString = Board.boardConf[Player.x - 1][Player.y];
        if(Objects.equals(rightString, " ")){
            loosingGame();
        }
        int rightNumber = Integer.parseInt(rightString);

        int j = Player.y - 1;
        if(j + rightNumber - 1 > Board.COLUMN_NUMBER){
            loosingGame();
        }
        loosing = Board.boardConf[Player.x - 1][Player.y + rightNumber - 1];
        System.out.println(loosing);
        if(Objects.equals(loosing, " ")){
            loosingGame();
        }
        Player.y = Player.y + rightNumber;
        if(Player.y > Board.COLUMN_NUMBER){
            loosingGame();
        }
        String number;
        for(int i = j + 1; i <= j + rightNumber; i++){
            number = Board.boardConf[Player.x - 1][i];
            if(!Objects.equals(number, " ")){
                Player.score = Player.score + Integer.parseInt(number);
            }        }

        for (int i = j; i <= j + rightNumber; i++){
            Board.boardConf[Player.x - 1][i] = " ";
        }
        Player.showScore();
    }

    public static void loosingGame(){
        System.out.println("You lost the game");
        Application.menu();
    }
}
