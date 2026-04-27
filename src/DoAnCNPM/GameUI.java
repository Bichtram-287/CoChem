package DoAnCNPM;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GameUI extends JFrame {
    private BoardPanel boardPanel;
    private JLabel statusLabel;
    private JButton resetButton;
    private JLabel timerLabel;

    private GameController controller;
    private Timer timer;
    private int elapsedSeconds = 0;

    public Player player2;
    public Player player1;

    public GameUI() {
        initUI();
    }

    private void initUI() {

        // ===== UC2: tạo player =====
        player1 = new Player("Player 1", Color.BLACK);
        player2 = new Player("Player 2", Color.BLUE);

        // ===== Controller =====
        controller = new GameController(player1, player2);

	     // Khi mở game → trigger UC1 + UC2
	     controller.startGame();

        // ===== Board UI =====
        boardPanel = new BoardPanel(controller, this);

        // ===== Status =====
        statusLabel = new JLabel(
                "Turns: " + controller.getCurrentPlayer().getName(),
                SwingConstants.CENTER);
        
        statusLabel.setFont(new Font("Arial", Font.BOLD, 16));

        // ===== Timer =====
        timerLabel = new JLabel("Time: 00:00");
        timerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        timerLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        // ===== Reset Button =====
        resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> resetGame());

        JPanel topRow = new JPanel(new BorderLayout());
        topRow.add(resetButton, BorderLayout.WEST);
        topRow.add(timerLabel, BorderLayout.EAST);

        JPanel top = new JPanel(new BorderLayout());
        top.setBorder(BorderFactory.createEmptyBorder(20, 15, 5, 15));
        top.add(topRow, BorderLayout.NORTH);
        top.add(statusLabel, BorderLayout.CENTER);

        setLayout(new BorderLayout());
        add(top, BorderLayout.NORTH);
        add(boardPanel, BorderLayout.CENTER);

        setTitle("Board Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        // ===== Timer =====
        setupTimer();
        startTimer();
    }

	 // UC1 + UC2:
	 // Reset về trạng thái ban đầu
    private void resetGame() {
        controller.startGame(); // reset về trạng thái ban đầu
        boardPanel.repaint();

        updateStatus("Turns: " + controller.getCurrentPlayer().getName());
        startTimer();
    }

    public void updateStatus(String text) {
        statusLabel.setText(text);
    }

    // ===== TIMER =====
    private void setupTimer() {
        timer = new Timer(1000, e -> {
            elapsedSeconds++;
            int m = elapsedSeconds / 60;
            int s = elapsedSeconds % 60;
            timerLabel.setText(String.format("Time: %02d:%02d", m, s));
        });
    }

    private void startTimer() {
        elapsedSeconds = 0;
        timerLabel.setText("Time: 00:00");
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GameUI::new);
    }
}
