import java.util.Scanner;

public class Rules {
    public static void rules(){
        String comeBack;
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                The object of Greed is to erase as much of the screen as possible by moving around in a
                grid of numbers. To move your cursor, simply use your arrow keys or the the 'hjklyubn'
                keys or your numeric keypad. Your location is signified by the @ symbol.
                When you move in a direction, you erase N number of grid squares in that direction, N
                being the first number in that direction. Your score reflects the total number of squares
                eaten.
                Greed will not let you make a move that would have placed you off the grid or over a
                previously eaten square. If no valid moves exist, your game ends.
                Other Greed commands are 'Ctrl-L' to redraw the screen, 'p' to toggle the highlighting of
                the possible moves, and 'q' to quit.
                The only command line option to Greed is '-s' to output the high score file.""");

            System.out.println("Type \"quit\" if you want to come back to menu");
            comeBack = sc.nextLine();
            if (comeBack == "quit") {
                Application.menu();
            }

    }

}
