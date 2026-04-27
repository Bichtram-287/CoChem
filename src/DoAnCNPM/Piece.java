package DoAnCNPM;

public class Piece {
    private int x, y;
    private Player owner;

	 // UC2:
	 // Tạo quân cờ
	 // → gán owner + vị trí ban đầu
	 public Piece(int x, int y, Player owner) {
	     this.x = x;
	     this.y = y;
	     this.owner = owner;
	 }

    public Player getOwner() {
        return owner;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
