import javax.swing.*;

public class Game {
    private Board board;
    private Player currentPlayer;

    public Game() {
        board = new Board();
    }

    public void clearBoard() {
        board.clearBoard();
    }

    public boolean makeMove(int row, int col) {
        return board.makeMove(row, col, currentPlayer.getSymbol());
    }

    public boolean checkWin() {
        return board.checkWin();
    }

    public boolean checkTie() {
        return board.checkTie();
    }

    public void setCurrentPlayer(Player player) {
        this.currentPlayer = player;
    }
}
