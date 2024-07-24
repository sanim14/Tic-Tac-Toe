import java.util.Scanner;

public class TicTacToe
{
    public static void main (String [] args)
    {
        int column = 0;
        int row = 0;
        char player = 'X';
        boolean turn = true;
        char [][] board = {{' ', '|', ' ', '|', ' '},
                           {'-', '-', '-', '-', '-'},
                           {' ', '|', ' ', '|', ' '},
                           {'-', '-', '-', '-', '-'},
                           {' ', '|', ' ', '|', ' '}};
        Scanner keyboard = new Scanner (System.in);

        while (turn == true)
        {
            displayBoard(board);
            System.out.print(player + " enter the column for your move (0-2): ");
            column = keyboard.nextInt();
            if (column > 2 || column < 0)
            {
                System.out.println("Invalid move");
                continue;
            }
            if (column == 1)
            {
                column += 1;
            }
            else if (column == 2)
            {
                column += 2;
            }
            System.out.print(player + " enter the row for your move (0-2): ");
            row = keyboard.nextInt();
            if (row > 2 || row < 0)
            {
                System.out.println("Invalid move");
                continue;
            }
            if (row == 1)
            {
                row = 2;
            }
            else if (row == 2)
            {
                row = 4;
            }
            if (board [row][column] == switchPlayer(player))
            {
                System.out.println("Invalid move");
                continue;
            }
            board [row][column] = player;
            if (isWinner(board, player) == true)
            {
                displayBoard(board);
                System.out.println(player + " wins!");
                turn = false;
            }
            if (isCat(board) == true)
            {
                displayBoard(board);
                System.out.println("Nobody wins :(");
                turn = false;
            }
            player = switchPlayer(player);
        }

    }

    public static char switchPlayer (char player)
    {
        if (player == 'X')
        {
            player = 'O';
            return player;
        }
        else
        {
            player = 'X';
            return player;
        }
    }

    public static void displayBoard(char[][] board)
    {
        for(int r = 0; r < board.length; r++)
        {
            for(int c = 0; c < board[0].length; c++)
            {
                System.out.print(board[r][c]);
            }

            System.out.print("\n");
        }
    }


    public static boolean isWinner(char[][] board, char player)
    {
        if (board[0][0] == player && board[0][2] == player && board[0][4] == player)
        {
            return true;
        }
        else if (board[2][0] == player && board[2][2] == player && board[2][4] == player)
        {
            return true;
        }
        else if (board[4][0] == player && board[4][2] == player && board[4][4] == player)
        {
            return true;
        }
        else if (board[0][0] == player && board[2][0] == player && board[4][0] == player)
        {
            return true;
        }
        else if (board[0][2] == player && board[2][2] == player && board[4][2] == player)
        {
            return true;
        }
        else if (board[0][4] == player && board[2][4] == player && board[4][4] == player)
        {
            return true;
        }
        else if (board[0][0] == player && board[2][2] == player && board[4][4] == player)
        {
            return true;
        }
        else if (board[0][4] == player && board[2][2] == player && board[4][0] == player)
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    public static boolean isCat(char[][] board)
    {
        if (isWinner(board, 'X') == false && isWinner(board, 'O') == false)
        {
            for(int r = 0; r < board.length; r++)
            {
                for(int c = 0; c < board[0].length; c++)
                {
                       if (board[r][c] == ' ')
                       {
                           return false;
                       }
                }
            }

            return true;
        }

        else
        {
            return false;
        }

    }
}
