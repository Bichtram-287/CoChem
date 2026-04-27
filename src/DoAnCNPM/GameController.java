package DoAnCNPM;

public class GameController {
    private Board board;
    private Player player1, player2;
    private Player currentPlayer;

	 // Constructor
	 // → Khởi tạo Board (UC1 - init structure)
	 public GameController(Player p1, Player p2) {
	     this.player1 = p1;
	     this.player2 = p2;
	     this.board = new Board();
	 }

	// ================= UC1 + UC2 MAIN FLOW =================
	// UC Flow tổng:
	// 1. Reset Player
	// 2. Reset Board
	// 3. Init Pieces
	// 4. Set turn
	public void startGame() {

	    // Step 1: Reset Player state (UC2 - chuẩn bị)
	    player1.clearPieces();
	    player2.clearPieces();

	    // Step 2: Reset Board (UC1)
	    board.resetBoard();

	    // Step 3: Create Pieces (UC2)
	    board.initializePieces(player1, player2);

	    // Step 4: Set current turn
	    currentPlayer = player1;
	}
	
    public Board getBoard() {
        return board;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}
