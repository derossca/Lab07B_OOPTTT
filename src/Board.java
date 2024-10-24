import javax.swing.*;
import java.awt.*;

public class Board {
    private TicTacToeTile[][] board = new TicTacToeTile[3][3];

    public Board(JPanel panel) {
        panel.setLayout(new GridLayout(3, 3));
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                board[r][c] = new TicTacToeTile(r, c);
                panel.add(board[r][c]);
            }
        }
    }

    public TicTacToeTile[][] getBoard() {
        return board;
    }
}
