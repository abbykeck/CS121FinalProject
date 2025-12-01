import java.util.*;

public class GameNode implements Serializable {
	private Game game;
	private GameNode next;
	private static final long serialVersionUID = 1L;

	public GameNode() {
		game = null;
		next = null;
	} // end null-parameter constructor
	public GameNode(Game game) {
		this.game = game;
		next = null;
	} // end single-parameter constructor
	public Game getGame() {
		return game;
	} // end getGame
	public void setGame(Game game) {
		this.game = game;
	} // end setGame
	public GameNode getNext() {
		return next;
	} // end getNext
	public void setNext(GameNode next) {
		this.next = next;
	} // end setNext
} // end GameNode
