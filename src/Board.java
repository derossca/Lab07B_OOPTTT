import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board {
    private static final int ROW = 3;
    private static final int COL = 3;
    private String[][] board;

    public Board() {
        board = new String[ROW][COL];
        clearBoard();
    }

    public void clearBoard() {
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                board[r][c] = " ";
            }
        }
    }

    public boolean makeMove(int row, int col, String symbol) {
        if (board[row][col].equals(" ")) {
            board[row][col] = symbol;
            return true;
        }
        return false;
    }

    public boolean checkWin() {
        return (isColWin() || isRowWin() || isDiagonalWin());
    }

    public boolean checkTie() {
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                if (board[row][col].equals(" ")) return false;
            }
        }
        return true;
    }

    private boolean isColWin() {
        for (int col = 0; col < COL; col++) {
            if (board[0][col].equals(board[1][col]) && board[1][col].equals(board[2][col]) && !board[0][col].equals(" ")) {
                return true;
            }
        }
        return false;
    }

    private boolean isRowWin() {
        for (int row = 0; row < ROW; row++) {
            if (board[row][0].equals(board[row][1]) && board[row][1].equals(board[row][2]) && !board[row][0].equals(" ")) {
                return true;
            }
        }
        return false;
    }

    private boolean isDiagonalWin() {
        if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && !board[0][0].equals(" ")) {
            return true;
        }
        if (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]) && !board[0][2].equals(" ")) {
            return true;
        }
        return false;
    }

    public String[][] getBoard() {
        return board;
    }
}
