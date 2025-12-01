import java.util.*;

public class GameLL implements Serializable {
	private GameNode head;
	private static final long serialVersionUID = 1L;
	public GameLL() {
		head = null;
	} // end constructor
	public void add(Game game) {
		GameNode node = new GameNode(game);
		if (this.head == null) {
			head = node;
		} else {
			node.setNext(head);
			head = node;
		} // end if
	} // end add
	public void remove(Game game) {
		GameNode currentNode = head;
		GameNode previous = null;
		while (!(currentNode.getGame().equals(game))) {
			previous = currentNode;
			currentNode = currentNode.getNext();
		} // end while
		previous.setNext(currentNode.getNext());
	} // end remove
	public void printGames() {
		GameNode currentNode = head;
		while (currentNode != null) {
			currentNode.getGame().printGame();
			currentNode = currentNode.getNext();
		} // end while
	} // end printGames
} // end GameLL
