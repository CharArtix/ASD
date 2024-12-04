package FP.Week14.SimpleGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TTT extends JFrame {
   // Define named constants for the game board
   public static final int ROWS = 3;  
   public static final int COLS = 3;

   // Define named constants for the drawing graphics
   public static final int CELL_SIZE = 120;
   public static final int BOARD_WIDTH  = CELL_SIZE * COLS;
   public static final int BOARD_HEIGHT = CELL_SIZE * ROWS;
   public static final int GRID_WIDTH = 10;                  
   public static final int GRID_WIDTH_HALF = GRID_WIDTH / 2;
   public static final int CELL_PADDING = CELL_SIZE / 5;
   public static final int SYMBOL_SIZE = CELL_SIZE - CELL_PADDING * 2;
   public static final int SYMBOL_STROKE_WIDTH = 8;

   public static final Color COLOR_BG = Color.WHITE;  
   public static final Color COLOR_BG_STATUS = new Color(216, 216, 216);
   public static final Color COLOR_GRID   = Color.LIGHT_GRAY;  
   public static final Color COLOR_CROSS  = new Color(211, 45, 65);  
   public static final Color COLOR_NOUGHT = new Color(76, 181, 245);
   public static final Font FONT_STATUS = new Font("OCR A Extended", Font.PLAIN, 14);

   // Enum untuk State dan Seed
   public enum State {
      PLAYING, DRAW, CROSS_WON, NOUGHT_WON
   }

   public enum Seed {
      CROSS, NOUGHT, NO_SEED
   }

   // Variabel game
   private State currentState;
   private Seed currentPlayer;
   public Seed[][] board;  // Ubah ke public agar bisa diakses GamePanel

   // UI Components
   private GamePanel gamePanel;
   private JLabel statusBar;

   /** Constructor */
   public TTT() {
      // Initialize the game objects
      board = new Seed[ROWS][COLS];
      newGame();

      // Set up GUI components
      gamePanel = new GamePanel();
      gamePanel.setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));

      // Setup mouse listener
      gamePanel.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            int mouseX = e.getX();
            int mouseY = e.getY();
            int row = mouseY / CELL_SIZE;
            int col = mouseX / CELL_SIZE;

            if (currentState == State.PLAYING) {
               if (row >= 0 && row < ROWS && col >= 0
                     && col < COLS && board[row][col] == Seed.NO_SEED) {
                  currentState = stepGame(currentPlayer, row, col);
                  currentPlayer = (currentPlayer == Seed.CROSS) ? Seed.NOUGHT : Seed.CROSS;
               }
            } else {
               newGame();
            }
            gamePanel.repaint();
         }
      });

      // Setup status bar
      statusBar = new JLabel("       ");
      statusBar.setFont(FONT_STATUS);
      statusBar.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 12));
      statusBar.setOpaque(true);
      statusBar.setBackground(COLOR_BG_STATUS);

      // Set up content pane
      Container cp = getContentPane();
      cp.setLayout(new BorderLayout());
      cp.add(gamePanel, BorderLayout.CENTER);
      cp.add(statusBar, BorderLayout.PAGE_END);

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      pack();
      setTitle("Tic Tac Toe");
      setVisible(true);
   }

   /** Reset game */
   public void newGame() {
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLS; ++col) {
            board[row][col] = Seed.NO_SEED;
         }
      }
      currentPlayer = Seed.CROSS;
      currentState  = State.PLAYING;
   }

   /** Game logic */
   public State stepGame(Seed player, int selectedRow, int selectedCol) {
      board[selectedRow][selectedCol] = player;

      // Cek kondisi menang
      if (board[selectedRow][0] == player && board[selectedRow][1] == player && board[selectedRow][2] == player
          || board[0][selectedCol] == player && board[1][selectedCol] == player && board[2][selectedCol] == player
          || selectedRow == selectedCol && board[0][0] == player && board[1][1] == player && board[2][2] == player
          || selectedRow + selectedCol == 2 && board[0][2] == player && board[1][1] == player && board[2][0] == player) {
         return (player == Seed.CROSS) ? State.CROSS_WON : State.NOUGHT_WON;
      } else {
         // Cek draw
         for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
               if (board[row][col] == Seed.NO_SEED) {
                  return State.PLAYING;
               }
            }
         }
         return State.DRAW;
      }
   }

   // Getter untuk status game
   public State getCurrentState() {
      return currentState;
   }

   public Seed getCurrentPlayer() {
      return currentPlayer;
   }

   /** Main method */
   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            new TTT();
         }
      });
   }
}