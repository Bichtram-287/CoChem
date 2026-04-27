package DoAnCNPM;

public class Position {
    private int x, y;
    private Piece piece;

	 // UC1:
	 // Constructor tạo ô trên board
	 public Position(int x, int y) {
	     this.x = x;
	     this.y = y;
	 }
	
	 // UC1 + UC2:
	 // - UC1: set null khi reset board
	 // - UC2: set piece khi đặt quân
	 public void setPiece(Piece piece) {
	     this.piece = piece;
	 }

    public boolean isEmpty() {
        return piece == null;
    }

    public Piece getPiece() {
        return piece;
    }
}
