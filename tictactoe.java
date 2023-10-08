import java.util.Scanner;

public class tictactoe {
    public static void main(String[] args) {

        // creating a board of size 3x3
        char[][] board = new char[3][3];
        // initially all the cells on the board will be empty
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }

        char player = 'X';
        boolean gameOver = false;

        Scanner sc = new Scanner(System.in);

        // moves
        while (!gameOver) {
            // printing board
            printBoard(board);

            System.out.print("Player " + player + " enter: ");
            // getting the coordinates from the player
            int row = sc.nextInt();
            int col = sc.nextInt();

            // check if the cell is empty
            if (board[row][col] == ' ') {
                board[row][col] = player; // place the element
                gameOver = haveWon(board, player);
                if (gameOver) {
                    System.out.println("\nPlayer " + player + " has Won :)");
                } else {
                    player = (player == 'X') ? 'O' : 'X';
                    // if(player == 'X'){
                    // player = 'O';
                    // }else{
                    // player = 'X';
                    // }
                }

            } else {
                System.out.println("Invalid move\nPlease try again!");
            }
        }
        printBoard(board);

    }

    public static void printBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            System.out.print(" | ");
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }

    public static boolean haveWon(char[][] board, char player) {
        // check for rows
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }

        // check for columns
        for (int col = 0; col < board.length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }

        // check for diagonal
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }
}