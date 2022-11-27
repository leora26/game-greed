public class Board {
    public static final int ROW_NUMBER = 10;
    public static final int COLUMN_NUMBER = 100;

    static String[][] boardConf = new String[ROW_NUMBER][COLUMN_NUMBER];

    public static void boardFilling(){
        for(int i = 0; i < ROW_NUMBER; i++){
            for(int j = 0; j < COLUMN_NUMBER; j++){
                boardConf[i][j] = String.valueOf((int) (Math.random() * 9 + 1));
            }
        }
    }

    public static void showMap(){
        for(int i = 0; i < ROW_NUMBER; i++){
            for(int j = 0; j < COLUMN_NUMBER; j++){
                System.out.print(boardConf[i][j]);
            }
            System.out.println();
        }
    }
}
