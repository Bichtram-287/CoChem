package DoAnCNPM;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private Position[][] position = new Position[5][5];

    public Player player1;
    public Player player2;

    // ================= UC1 - CREATE BOARD =================
	 // Constructor
	 // → Trigger UC1 khi tạo Board
	 // → Khởi tạo cấu trúc dữ liệu bàn cờ (5x5 Position)
	 public Board() {
	     initBoard();
	 }
	
	 // UC1 - Step 1:
	 // Khởi tạo ma trận Position
	 // Mỗi ô đại diện 1 điểm trên bàn cờ
	 public void initBoard() {
	     for (int x = 0; x < 5; x++) {
	         for (int y = 0; y < 5; y++) {
	             position[x][y] = new Position(x, y);
	         }
	     }
	 }
	
	 // UC1 - Step 2:
	 // Reset trạng thái bàn cờ
	 // → Tất cả ô không chứa quân
	 public void resetBoard() {
	     for (int x = 0; x < 5; x++) {
	         for (int y = 0; y < 5; y++) {
	             position[x][y].setPiece(null);
	         }
	     }
	 }

	// ================= UC2 - INIT PIECES =================

	// UC2 - Step 3:
	// Khởi tạo quân cờ cho 2 player
	// → Gọi createPiece cho từng vị trí
	public void initializePieces(Player p1, Player p2) {
	    this.player1 = p1;
	    this.player2 = p2;

	    // Player 1 layout
	    for (int col = 0; col < 5; col++)
	        createPiece(p1, col, 0);

	    for (int col = 1; col <= 3; col++)
	        createPiece(p1, col, 1);

	    // Player 2 layout
	    for (int col = 1; col <= 3; col++)
	        createPiece(p2, col, 3);

	    for (int col = 0; col < 5; col++)
	        createPiece(p2, col, 4);
	}

	// UC2 - Step 4:
	// Tạo 1 quân và đặt lên board
	// → Gắn vào Position
	// → Gắn vào Player
	private void createPiece(Player player, int x, int y) {

	    Piece p = new Piece(x, y, player);   // tạo entity
	    position[x][y].setPiece(p);          // đặt lên board
	    player.addPiece(p);                  // thêm vào player
	}
	
    // ================= COMMON =================
    public Position getPosition(int x, int y) {
        return position[x][y];
    }

    public List<Piece> getAllPieces() {
        List<Piece> list = new ArrayList<>();
        for (int x = 0; x < 5; x++)
            for (int y = 0; y < 5; y++)
                if (position[x][y].getPiece() != null)
                    list.add(position[x][y].getPiece());
        return list;
    }

    public int countPieces(Player p) {
        int c = 0;
        for (Piece pc : getAllPieces())
            if (pc.getOwner() == p) c++;
        return c;
    }
}
