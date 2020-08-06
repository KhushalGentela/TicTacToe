package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static char[][] board = new char[3][3];
  static int ctr=0;
    static boolean b = true;
    static char x = '-';


    public static void main(String[] args) {
        // write your code here
       //char[][] board = new char[3][3];
        char ch = '1';
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                board[i][j] = ch++;
            }
        }


       dispBoard(board);
       Scanner scanner= new Scanner(System.in);
       System.out.println("Do you want to start the game y/n");
       String answer= scanner.next();
       if(answer.equals("y")){
           game();
       }
       else{
           System.out.println("Thank you");
       }

    }
        public static void dispBoard(char[][] board){

                for (int i = 0; i < board.length; i++) {
                    for (int j = 0; j < board[i].length; j++) {
                        if (j == board[i].length - 1) System.out.print(board[i][j]);
                        else System.out.print( board[i][j] + " | ");
                    }
                    System.out.println();
                }




                System.out.println();


            }
            public static void game(){
                Scanner s= new Scanner(System.in);
                Scanner sc= new Scanner(System.in);


                char Player1 = '-';
                char Player2 = '-';
                char player1spot = '-';
               char player2spot = '-';
             ;
                boolean first = true;


                   System.out.println("Player 1 please choose your character - X or O");
                   String Player1char = s.next();
                   Player1 = Player1char.charAt(0);
                   if (Player1 == 'X' || Player1 == 'x') {
                       Player2 = 'O';

                   } else {
                       Player2 = 'X';
                   }
                   System.out.println("Player1 character = " + Player1);
                   System.out.println("Player2 character = " + Player2);
                   System.out.println("");
                   dispBoard(board);

                   logic(first, player1spot, player2spot, Player1, Player2, sc);






        }
        public static void logic(boolean f, int player1, int player2, char player10, char player20, Scanner scanner){
            while(ctr<=9){
                if (f == true) {
                    System.out.println("Player 1, please choose the number with which you will replace your character");
                    player1 = scanner.next().charAt(0);
                    f = false;


                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            if (board[i][j] == player1 && board[i][j] != 'X' && board[i][j] != 'O') {
                                board[i][j] = player10;
                                dispBoard(board);
                                ctr++;

                            }
                        }
                    }
                }
                check();
                if(ctr>=9){
                    System.out.println("The game is a tie");
                    restart();
                    break;
                }


                if (f == false){
                    System.out.println("Player 2, please choose the number with which you will replace your character");
                    player2 = scanner.next().charAt(0);


                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            if(board[i][j]==player2 && board[i][j] != 'X' && board[i][j] != 'O'){
                                board[i][j]= player20;
                                dispBoard(board);
                                f = true;
                                ctr++;

                            }

                        }
                    }

                }
                check();



            }
        }
        public static void check (){
        boolean c= false;
            if(board[0][0] == 'X' && board[1][0] == 'X' && board[2][0]== 'X' ||
                    board[0][0] == 'X' && board[1][1] == 'X' && board[2][2]== 'X'||
                    board[0][0] == 'X' && board[0][1] == 'X' && board[0][2]== 'X' ||
                    board[0][2] == 'X' && board[1][1] == 'X' && board[2][0]== 'X' ||
                    board[0][2] == 'X' && board[1][2] == 'X' && board[2][2]== 'X' ||
                    board[0][1] == 'X' && board[1][1] == 'X' && board[1][2]== 'X' ||
                    board[1][0] == 'X' && board[1][1] == 'X' && board[1][2]== 'X' ||
                    board[2][0] == 'X' && board[2][1] == 'X' && board[2][2]== 'X'){
                System.out.println("Player 1 has won");
                c=true;
                restart();
                ctr=10;

            }else if(board[0][0] == 'O' && board[1][0] == 'O' && board[2][0]== 'O' ||
                    board[0][0] == 'O' && board[1][1] == 'O' && board[2][2]== 'O'||
                    board[0][0] == 'O' && board[0][1] == 'O' && board[0][2]== 'O' ||
                    board[0][2] == 'O' && board[1][2] == 'O' && board[2][2]== 'O' ||
                    board[0][1] == 'O' && board[1][1] == 'O' && board[1][2]== 'O' ||
                    board[1][0] == 'O' && board[1][1] == 'O' && board[1][2]== 'O' ||
                    board[0][2] == 'O' && board[1][1] == 'O' && board[2][0]== 'O' ||
                    board[2][0] == 'O' && board[2][1] == 'O' && board[2][2]== 'O'){
                System.out.println("Player 2 has won");
                c=true;
                restart();
                ctr=10;
            }




        }






    private static void main() {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Do you want to start the game y/n");
        char ch = '1';
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                board[i][j] = ch++;
            }
        }

        String answer= scanner.next();
        if(answer.equals("y")){
            game();
            dispBoard(board);
        }
        else{
            System.out.println("Thank you");
        }
    }
    public static void restart(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to play again y/n");
        String play = scanner.next();
        if(play.equalsIgnoreCase("y")){
            main();
            //dispBoard(board);
        }else{

            System.out.println("Thank you for playing");
        }

    }

}


