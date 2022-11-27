import java.util.Objects;

public class Computer {
    static int scoreComputer;
    static int xComputer;
    static int yComputer;
    static boolean movingUp;
    static boolean movingDown;
    static boolean movingLeft;
    static boolean movingRight;
    static int upNumber;
    static int downNumber;
    static int leftNumber;
    static int rightNumber;
    static int computerChoice;
    static String emptyUpMove;
    static String emptyDownMove;
    static String emptyLeftMove;
    static String emptyRightMove;
    static String upString;
    static String downString;
    static String leftString;
    static String rightString;

    public static void computerDefiner(){
        Board.boardConf[xComputer - 1][yComputer - 1] = "$";
        System.out.println("Computer is shown by \"$\" sign");
    }

    public static void showComputerScore(){
        System.out.println("Computer's score is " + scoreComputer);
    }

    public static void computerRandomPos(){
        Computer.xComputer = 1 +  (int) (Math.random() * Board.ROW_NUMBER);
        Computer.yComputer = 1 + (int) (Math.random() * Board.COLUMN_NUMBER);
    }

    public static void computerLoosingGame(){
        System.out.println("Computer lost the game");
        Application.menu();
    }

    public static void computerMove(){
        movingUp = false;
        movingDown = false;
        movingLeft = false;
        movingRight = false;
        computerNextMove();

        if(movingUp && !movingDown && !movingLeft && !movingRight){
            computerMoveUP();
        } else if(!movingUp && movingDown && !movingLeft && !movingRight){
            computerMoveDown();
        } else if (!movingUp && !movingDown && movingLeft && !movingRight){
            computerMoveLeft();
        } else if(!movingUp && !movingDown && !movingLeft && movingRight){
            computerMoveRight();
        } else if (movingUp && movingDown && !movingLeft && !movingRight){
            computerChoice = 1 + (int) (Math.random() * 2);
            if(computerChoice == 1){
                computerMoveUP();
            } else {
                computerMoveDown();
            }
        } else if(movingUp && !movingDown && movingLeft && !movingRight){
            computerChoice = 1 + (int) (Math.random() * 2);
            if(computerChoice == 1){
                computerMoveUP();
            } else {
                computerMoveLeft();
            }
        } else if(movingUp && !movingDown && !movingLeft){
            computerChoice = 1 + (int) (Math.random() * 2);
            if(computerChoice == 1){
                computerMoveUP();
            } else {
                computerMoveRight();
            }
        }
        else if(!movingUp && movingDown && movingLeft && !movingRight){
            computerChoice = 1 + (int) (Math.random() * 2);
            if(computerChoice == 1){
                computerMoveDown();
            } else {
                computerMoveLeft();
            }
        } else if(!movingUp && movingDown && !movingLeft && movingRight){
            computerChoice = 1 + (int) (Math.random() * 2);
            if(computerChoice == 1){
                computerMoveDown();
            } else {
                computerMoveRight();
            }
        } else if(!movingUp && !movingDown && movingLeft && movingRight){
            computerChoice = 1 + (int) (Math.random() * 2);
            if(computerChoice == 1){
                computerMoveLeft();
            } else {
                computerMoveRight();
            }
        } else if(movingUp && movingDown && movingLeft && !movingRight){
            computerChoice = 1 + (int) (Math.random() * 3);
            if(computerChoice == 1){
                computerMoveUP();
            } else if (computerChoice == 2){
                computerMoveDown();
            } else {
                computerMoveLeft();
            }
        }else if(movingUp && movingDown && !movingLeft && movingRight){
            computerChoice = 1 + (int) (Math.random() * 3);
            if(computerChoice == 1){
                computerMoveUP();
            } else if (computerChoice == 2){
                computerMoveDown();
            } else {
                computerMoveRight();
            }
        }else if(movingUp && !movingDown && movingLeft && movingRight){
            computerChoice = 1 + (int) (Math.random() * 3);
            if(computerChoice == 1){
                computerMoveUP();
            } else if (computerChoice == 2){
                computerMoveLeft();
            } else {
                computerMoveRight();
            }
        }else if(!movingUp && movingDown && movingLeft && movingRight){
            computerChoice = 1 + (int) (Math.random() * 3);
            if(computerChoice == 1){
                computerMoveDown();
            } else if (computerChoice == 2){
                computerMoveLeft();
            } else {
                computerMoveRight();
            }
        }else if(movingUp && movingDown && movingLeft && movingRight){
            computerChoice = 1 + (int) (Math.random() * 4);
            if(computerChoice == 1){
                computerMoveUP();
            } else if (computerChoice == 2){
                computerMoveDown();
            } else if (computerChoice == 3){
                computerMoveLeft();
            } else {
                computerMoveRight();
            }
        } else {
            computerLoosingGame();
        }

    }

    public static void computerNextMove(){

// checking existence of neighbours

        if (!(xComputer - 2 < 0)){ // there isn't top number
            upString = Board.boardConf[xComputer - 2][yComputer - 1];
            movingUp = true;
        } else {
            movingUp = false;
        }

        if(!(xComputer > Board.ROW_NUMBER - 1)){ // there isn't down number
            downString = Board.boardConf[xComputer][yComputer - 1];
            movingDown = true;
        } else {
            movingDown = false;
        }

        if(!(yComputer - 2 < 0)){ // there isn't left number
            leftString = Board.boardConf[xComputer - 1][yComputer - 2];
            movingLeft = true;
        } else {
            movingLeft = false;
        }

        if(!(yComputer > Board.COLUMN_NUMBER - 1)){ // there isn't right number
            rightString = Board.boardConf[xComputer - 1][yComputer];
            movingRight = true;
        } else {
            movingRight = false;
        }

// checking if neighbours strings are empty and parsing them

        if(!Objects.equals(upString, " ") && movingUp){
            movingUp = true;
            upNumber = Integer.parseInt(upString);
        } else {
            movingUp = false;
        }
        if(!Objects.equals(downString, " ") && movingDown){
            movingDown = true;
            downNumber = Integer.parseInt(downString);
        } else {
            movingDown = false;
        }
        if(!Objects.equals(leftString, " ") && movingLeft){
            movingLeft = true;
            leftNumber = Integer.parseInt(leftString);
        } else {
            movingLeft = false;
        }
        if(!Objects.equals(rightString, " ") && movingRight){
            movingRight = true;
            rightNumber = Integer.parseInt(rightString);
        } else {
            movingRight = false;
        }

//checking if move is available

        if (!(xComputer - upNumber - 1 < 0) && movingUp){ // moving out of the map to the top
            emptyUpMove = Board.boardConf[xComputer - upNumber - 1][yComputer - 1];
        } else {
            movingUp = false;
        }

        if(!(xComputer + downNumber - 1 > Board.ROW_NUMBER) && movingDown){ // moving out of the map to the bottom
            emptyDownMove = Board.boardConf[xComputer - 1 + downNumber][yComputer];
        } else {
            movingDown = false;
        }

        if(!(yComputer - leftNumber - 1 < 0) && movingLeft){ // moving out of the map to the left border
            emptyLeftMove = Board.boardConf[xComputer - 1][yComputer - leftNumber - 1];
        } else {
            movingLeft = false;
        }

        if(!(yComputer + rightNumber - 1 > Board.COLUMN_NUMBER) && movingRight){ // moving out of the map to the right border
            emptyRightMove = Board.boardConf[xComputer][yComputer + rightNumber - 1];
        } else {
            movingRight = false;
        }


        if(!Objects.equals(emptyUpMove, " ") && movingUp){
            movingUp = true;
        } else {
            movingUp = false;
        }
        if(!Objects.equals(emptyDownMove, " ") && movingDown){
            movingDown = true;
        } else {
            movingDown = false;
        }
        if(!Objects.equals(emptyLeftMove, " ") && movingLeft){
            movingLeft = true;
        } else {
            movingLeft = false;
        }
        if(!Objects.equals(emptyRightMove, " ") && movingRight){
            movingRight = true;
        } else {
            movingRight = false;
        }

    }

    public static void computerMoveUP(){
        int posX = xComputer - 1;
        xComputer -= upNumber;
        String number;
        for(int i = posX - 1; i >= posX - upNumber; i--){
            number = Board.boardConf[xComputer - 1][i];
            if(!Objects.equals(number, " ") || !Objects.equals(number, "@")){
                scoreComputer = scoreComputer + Integer.parseInt(number);
            }
        }
        for (int i = posX; i >= posX - upNumber; i--){
            Board.boardConf[i][yComputer - 1] = " ";
        }
        showComputerScore();
    }

    public static void computerMoveDown(){
        int posX = xComputer - 1;
        xComputer += downNumber;
        String number;
        for(int i = posX + 1; i <= posX + downNumber; i++){
            number = Board.boardConf[xComputer - 1][i];
            if(!Objects.equals(number, " ") || !Objects.equals(number, "@")){
                scoreComputer = scoreComputer + Integer.parseInt(number);
            }        }
        for (int i = posX; i <= posX + downNumber; i++){
            Board.boardConf[i][yComputer - 1] = " ";
        }
        showComputerScore();
    }

    public static void computerMoveLeft(){
        int posY = yComputer - 1;
        yComputer = yComputer - leftNumber;
        String number;
        for(int i = posY - 1; i >= posY - leftNumber; i--){
            number = Board.boardConf[xComputer - 1][i];
            if(!Objects.equals(number, " ") || !Objects.equals(number, "@")){
                scoreComputer = scoreComputer + Integer.parseInt(number);
            }
        }
        for (int i = posY; i >= posY - leftNumber; i--){
            Board.boardConf[xComputer - 1][i] = " ";
        }
        showComputerScore();
    }

    public static void computerMoveRight(){
        int posY = yComputer - 1;
        yComputer = yComputer + rightNumber;
        String number;
        for(int i = posY + 1; i <= posY + rightNumber; i++){
            number = Board.boardConf[xComputer - 1][i];
            if(!Objects.equals(number, " ") || !Objects.equals(number, "@")){
                scoreComputer = scoreComputer + Integer.parseInt(number);
            }
        }

        for (int i = posY; i <= posY + rightNumber; i++){
            Board.boardConf[xComputer - 1][i] = " ";
        }
        showComputerScore();
    }

}
