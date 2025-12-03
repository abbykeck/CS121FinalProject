import java.util.*;
import java.net.*;
import java.io.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GameLL implements Serializable {
	private GameNode head;
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		System.out.println("Hello world!");
		String json = "";
		try {
			File file = new File("game.txt");
			Scanner input = new Scanner(file);
			while (input.hasNext()) {
				json += input.nextLine();
			}
			input.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		// System.out.println("JSON:\n" + json);
		GameLL gameslist = new GameLL(json);
		gameslist.printGames();
	} // end main
	public GameLL() {
		this.head = null;
	} // end constructor
	public GameLL(String JSON) {
		GameList games = new GameList();
		games = parseJSON(JSON);
		for (Game game : games.getGames()) {
			this.add(game);
		} // end for
	} // end constructor with String JSON param
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
	/*
        public String readStringFromURL(String query){
                // From https://github.com/twopiharris/BSU-CS121/tree/main/data_API
                // adapted from https://alvinalexander.com/blog/post/java/how-open-read-url-java-url-class-example-code/
                // start with a blank String we will build up line by line
                String result = "";
                // networking is dangerous... An IOException handler is necessary
                try {
                        // create a url object based on the query
                        URL url = new URL(query);
                        // create readers to simplify input
                        InputStreamReader iReader = new InputStreamReader(url.openStream());
                        BufferedReader reader = new BufferedReader(iReader);
                        // step through input one line at a time
                        String line;
                        while ((line = reader.readLine()) != null){
                                result += line + "\n";
                        } // end while
                        // close the readers
                        reader.close();
                        iReader.close();
                } catch (IOException e){
                        // warn on exception
                        System.out.println("something went wrong");
                } // end try
                return result;
        } // end readString
        */
        public GameList parseJSON(String jsonString){
                // Adapted from https://github.com/twopiharris/BSU-CS121/tree/main/data_API
                GameList result;
		jsonString = "{itemList:" + jsonString + "}";
                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();
                result = gson.fromJson(jsonString, GameList.class);
                return result;
        } // end parseJson
        public static void searchByTitle() {
		GameList games = new GameList();
		Scanner input = new Scanner(System.in);
		String userInput = "";
		System.out.print("Enter a game title (not case sensitive): ");
		userInput = input.nextLine();
		System.out.println("Search results:");
	} // end searchByTitle
        public static void searchByRatings() {
		GameList games = new GameList();
                Scanner input = new Scanner(System.in);
                String userInput = "";
                System.out.print("Enter a minimum rating (integer between 0-100): ");
                userInput = input.nextLine();
                System.out.println("Search results:");
	} // end searchByRatings
        public static void searchByPrice() {
		GameList games = new GameList();
                Scanner input = new Scanner(System.in);
                String userInput = "";
                System.out.print("Enter a minimum price: ");
                userInput = input.nextLine();
                System.out.println("Search results:");
	} // end searchByPrice
        public static void searchForGame() {} // end searchForGame
} // end GameLL
class GameNode implements Serializable {
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
class GameList implements Serializable {
	private ArrayList<Game> itemList;
	public ArrayList<Game> getGames() {
		return itemList;
	}
} // end GameList
class Game implements Serializable {
        private String internalName;
        private String title;
        private String metacriticLink;
        private String dealID;
        private String storeID;
        private String gameID;
        private String salePrice;
        private String normalPrice;
        private String isOnSale;
        private String savings;
        private String metacriticScore;
        private String steamRatingText;
        private String steamRatingPercent;
        private String steamRatingCount;
        private String steamAppID;
        private int releaseDate;
        private int lastChange;
        private String dealRating;
        private String thumb;

        public void printGame() {
                System.out.println("Game title: " + title);
                System.out.println("Price: $" + salePrice);
                System.out.println("Ratings: \"" + steamRatingText + "\" " + steamRatingPercent + "%");
                System.out.println("Game ID: " + steamAppID);
                for (int i = 0; i < 30; i++) {
                        System.out.print("_");
                } // end for
		System.out.println();
        } // end printGame
} // end game
