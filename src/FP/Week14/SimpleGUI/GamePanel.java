package FP.Week14.SimpleGUI;

import javax.swing.*;
import java.awt.*;

class GamePanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private TTT game;  // Reference ke game TTT

    // Constructor yang menerima TTT
    // public GamePanel() {
    //     this.game = game;
    // }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(TTT.COLOR_BG);

        // Draw grid lines
        g.setColor(TTT.COLOR_GRID);
        for (int row = 1; row < TTT.ROWS; ++row) {
            g.fillRoundRect(0, TTT.CELL_SIZE * row - TTT.GRID_WIDTH_HALF,
                  TTT.BOARD_WIDTH-1, TTT.GRID_WIDTH, 
                  TTT.GRID_WIDTH, TTT.GRID_WIDTH);
        }
        for (int col = 1; col < TTT.COLS; ++col) {
            g.fillRoundRect(TTT.CELL_SIZE * col - TTT.GRID_WIDTH_HALF, 0,
                  TTT.GRID_WIDTH, TTT.BOARD_HEIGHT-1, 
                  TTT.GRID_WIDTH, TTT.GRID_WIDTH);
        }

        // Draw Seeds
        Graphics2D g2d = (Graphics2D)g;
        g2d.setStroke(new BasicStroke(TTT.SYMBOL_STROKE_WIDTH, 
              BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

        for (int row = 0; row < TTT.ROWS; ++row) {
            for (int col = 0; col < TTT.COLS; ++col) {
                int x1 = col * TTT.CELL_SIZE + TTT.CELL_PADDING;
                int y1 = row * TTT.CELL_SIZE + TTT.CELL_PADDING;
                
                if (game.board[row][col] == TTT.Seed.CROSS) {
                    g2d.setColor(TTT.COLOR_CROSS);
                    int x2 = (col + 1) * TTT.CELL_SIZE - TTT.CELL_PADDING;
                    int y2 = (row + 1) * TTT.CELL_SIZE - TTT.CELL_PADDING;
                    g2d.drawLine(x1, y1, x2, y2);
                    g2d.drawLine(x2, y1, x1, y2);
                } else if (game.board[row][col] == TTT.Seed.NOUGHT) {
                    g2d.setColor(TTT.COLOR_NOUGHT);
                    g2d.drawOval(x1, y1, TTT.SYMBOL_SIZE, TTT.SYMBOL_SIZE);
                }
            }
        }
    }
}