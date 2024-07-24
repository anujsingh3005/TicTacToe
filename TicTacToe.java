import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] array = new char[3][3];

        //array define
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = ' ';
            }
        }

        char player = 'X';
        boolean gameover = false;

        System.out.println("Hello");
        System.out.println("Player 1 will be X");
        System.out.println("Player 2 will be O");
        try{
        while(!gameover){
            print_board(array);
            System.out.println("Player " + player + " enter: " );
            System.out.println();
            int i = sc.nextInt();
            int j = sc.nextInt();
            if(array[i][j] == ' '){
                array[i][j] = player;
                gameover = check_won(array, player);
                if(gameover){
                    System.out.println();
                    System.out.println("Player " + player + " have won ");
                    System.out.println();
                }else{
                    if(player== 'X'){
                        player = 'O'; 
                    }else{
                        player = 'X';
                    }
                }

            }else{
                System.out.println("Invalid ");
            }

        }
        
    print_board(array);
    System.out.println();
    System.out.println();
        }
        catch(InputMismatchException e){
            System.out.println("Please Enter only index");
        }
        finally {
            System.out.println();
            System.out.println("Bye");
        }
        

        sc.close();
    }
    public static void print_board(char[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " | ");
            }
            System.out.println();
            System.out.println();
        }
    }
    public static boolean check_won(char[][] array, char player){
        for(int i = 0; i < array.length; i++){
            if(array[i][0] == player && array[i][1] == player && array[i][2] == player){
                return true;
            }
        }
        for(int j = 0; j < array[0].length; j++){
            if(array[0][j] == player && array[1][j] == player && array[2][j ] == player){
                return true;
            }
        }
        if(array[0][0] == player && array[1][1] == player && array[2][2] == player){
            return true;
        }
        if(array[0][2] == player && array[1][1] == player && array[2][0] == player){
            return true;
        }
    return false;
    }

}
