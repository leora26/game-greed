import java.util.Objects;
import java.util.Scanner;

public class Application {
    static Scanner sc = new Scanner(System.in);
    public static String positionChoice;

    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        Player.score = 0;
        int choice = -1;
        Scanner sc = new Scanner(System.in);
        while(choice != 0){
            System.out.println("Menu: \n 1. Start game(1) \n 2. View Leadeboard(2) \n 3. Rules(3) \n 4. Command(4) \n 5. Quit the game(0)");
            System.out.print("Your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> startGame();
//                case 2 -> viewLeaderboard();
                case 3 -> Rules.rules();
                case 0 -> System.out.println("You have quited the game :(");
            }
        }

    }

    public static void startGame(){
        System.out.println("Hello player! Please enter your name");
        String name = sc.nextLine();
        System.out.println("Nice to meet you " + name);
        int counter = 0;
        while (counter != 2){
            System.out.println("Do you want to choose your position(Otherwise we will give you a random one)? If yes type \"y\"(or \"n\" if you don't want to)");
            positionChoice = sc.nextLine();
            counter = 0;
            if (Objects.equals(positionChoice, "y")) {
                System.out.println("Enter the line: ");
                Player.x = sc.nextInt();
                System.out.println("Enter the column: ");
                Player.y = sc.nextInt();
                if (Player.x > Board.ROW_NUMBER || Player.x < 0) {
                    System.out.println("You have entered wrong value of rows. The max number is " + Board.ROW_NUMBER);
                } else {
                    counter++;}
                if (Player.y > Board.COLUMN_NUMBER || Player.y < 0) {
                    System.out.println("You have entered wrong value of columns. The max number is " + Board.COLUMN_NUMBER);
                } else {
                    counter++;}
            } else if (Objects.equals(positionChoice, "n")) {
                Player.playerRandomPos();
                counter += 2;
            }
        }

        System.out.println("Here is the map");
        Board.boardFilling();
        Player.playerDefiner();
        Board.showMap();
        Pawn.movement();
    }


}
