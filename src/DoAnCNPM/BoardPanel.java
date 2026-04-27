package DoAnCNPM;

import java.awt.*;
import javax.swing.*;

public class BoardPanel extends JPanel {

    private final GameController controller;

    private final int cellSize = 100;
    private final int offset = 50;

    public BoardPanel(GameController controller, GameUI ui) {
        this.controller = controller;

        setPreferredSize(new Dimension(
                cellSize * 4 + offset * 2,
                cellSize * 4 + offset * 2
        ));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // ===== UC1: vẽ bàn cờ =====
        drawBoard(g);

        // ===== UC2: vẽ quân cờ =====
        drawPieces(g);
    }
	
	 // UC1:
	 // Vẽ cấu trúc bàn cờ (grid + đường chéo)
	 private void drawBoard(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));

        // nền
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                g.setColor((r + c) % 2 == 0
                        ? new Color(255, 222, 173)
                        : new Color(222, 184, 135));

                g.fillRect(
                        offset + c * cellSize,
                        offset + r * cellSize,
                        cellSize,
                        cellSize);
            }
        }

        // lưới
        g.setColor(Color.BLACK);
        for (int i = 0; i <= 4; i++) {
            g.drawLine(offset + i * cellSize, offset,
                    offset + i * cellSize, offset + 4 * cellSize);

            g.drawLine(offset, offset + i * cellSize,
                    offset + 4 * cellSize, offset + i * cellSize);
        }

        // đường chéo
        g.drawLine(offset, offset, offset + 2 * cellSize, offset + 2 * cellSize);
        g.drawLine(offset + 2 * cellSize, offset, offset, offset + 2 * cellSize);

        g.drawLine(offset + 2 * cellSize, offset + 2 * cellSize,
                offset + 4 * cellSize, offset + 4 * cellSize);

        g.drawLine(offset + 4 * cellSize, offset + 2 * cellSize,
                offset + 2 * cellSize, offset + 4 * cellSize);

        g.drawLine(offset + 4 * cellSize, offset,
                offset, offset + 4 * cellSize);

        g.drawLine(offset + 2 * cellSize, offset,
                offset + 4 * cellSize, offset + 2 * cellSize);

        g.drawLine(offset, offset + 2 * cellSize,
                offset + 2 * cellSize, offset + 4 * cellSize);
    }

	// UC2:
	// Vẽ quân dựa trên trạng thái Board
	private void drawPieces(Graphics g) {
        Board board = controller.getBoard();

        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {

                Piece piece = board.getPosition(x, y).getPiece();

                if (piece != null) {
                    g.setColor(piece.getOwner().getColor());

                    int px = offset + x * cellSize;
                    int py = offset + y * cellSize;

                    g.fillOval(px - 20, py - 20, 40, 40);
                }
            }
        }
    }
}