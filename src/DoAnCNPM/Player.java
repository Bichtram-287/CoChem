package DoAnCNPM;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private Color color;
    private List<Piece> pieces;

    public Player(String name, Color color) {
        this.name = name;
        this.color = color;
        this.pieces = new ArrayList<>();
    }

	 // UC2:
	 // Thêm quân vào danh sách quản lý của player
	 public void addPiece(Piece p) {
	     pieces.add(p);
	 }
	
	 // UC2:
	 // Reset toàn bộ quân của player
	 // → dùng khi startGame()
	 public void clearPieces() {
	     pieces.clear();
	 }

    public List<Piece> getPieces() {
        return pieces;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }
  
}
