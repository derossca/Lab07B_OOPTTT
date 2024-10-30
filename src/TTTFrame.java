import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TTTFrame extends JFrame {
    private static final int ROW = 3;
    private static final int COL = 3;
    private TicTacToeTile[][] gameTiles = new TicTacToeTile[ROW][COL];
    private Player currentPlayer;
    private Game game;

    public TTTFrame() {
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createCenterFrame();
        setLayout(new BorderLayout());
        createGameBoard();
        resetGame();
        setVisible(true);
    }

    private void createGameBoard() {
        ActionListener tileListener = new TileListener();
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(ROW, COL));

        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                TicTacToeTile gameTile = new TicTacToeTile(r, c);
                gameTiles[r][c] = gameTile;
                gameTile.addActionListener(tileListener);
                buttonPanel.add(gameTile);
            }
        }

        JButton quitBtn = new JButton("Quit");
        quitBtn.setFont(new Font("Arial", Font.BOLD, 22));
        quitBtn.addActionListener(e -> System.exit(0));

        add(buttonPanel, BorderLayout.CENTER);
        add(quitBtn, BorderLayout.SOUTH);
    }

    private class TileListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            TicTacToeTile tile = (TicTacToeTile) e.getSource();
            if (game.makeMove(tile.getRow(), tile.getCol())) {
                tile.setText(currentPlayer.getSymbol());
                if (game.checkWin()) {
                    JOptionPane.showMessageDialog(null, currentPlayer.getSymbol() + " wins!");
                    resetGame();
                } else if (game.checkTie()) {
                    JOptionPane.showMessageDialog(null, "It's a tie!");
                    resetGame();
                }
                switchPlayer();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid move! Choose another tile.");
            }
        }
    }

    public void resetGame() {
        game = new Game();
        currentPlayer = new PlayerX(); // Default starting player
        game.setCurrentPlayer(currentPlayer); // Set initial player in Game
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                gameTiles[r][c].setText("");
            }
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer instanceof PlayerX) ? new PlayerO() : new PlayerX();
        game.setCurrentPlayer(currentPlayer); // Update current player in Game
    }

    private void createCenterFrame() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        setSize(screenSize.width * 3 / 4, screenSize.height * 3 / 4);
        setLocation(screenSize.width / 8, screenSize.height / 8);
    }
}
