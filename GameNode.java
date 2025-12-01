import java.util.*;
import java.net.*;
import java.io.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GameNode implements Serializable {
	private Game game;
	private GameNode next;
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		System.out.println("Hello world");
		String game = "";
		try {
			File file = new File("game.txt");
			Scanner input = new Scanner(file);
			while (input.hasNext()) {
				game += input.nextLine();
			}
			input.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		GameNode node = new GameNode(game);
		node.getGame().printGame();
	} // end main
	public GameNode() {
		game = null;
		next = null;
	} // end null-parameter constructor
	public GameNode(String JSON) {
		game = parseJSON(JSON);
		next = null;
	} // end constructor from JSON string
	/*
	public GameNode(String URL) {
		String gameString = readStringFromURL(URL);
		game = parseJSON(gameString);
		next = null;
	} // end constructor from URL
	*/
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
  	public Game parseJSON(String jsonString){
		// Adapted from https://github.com/twopiharris/BSU-CS121/tree/main/data_API
		Game result;
    		GsonBuilder builder = new GsonBuilder();
    		Gson gson = builder.create();
    		result = gson.fromJson(jsonString, Game.class);
		return result;
  	} // end parseJson
	public static void searchByTitle() {} // end searchByTitle
        public static void searchByRatings() {} // end searchByRatings
        public static void searchByPrice() {} // end searchByPrice
        public static void searchForGame() {} // end searchForGame
} // end GameNode

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

	private static final long SerialVersionUID = 1L;

        public void printGame() {
                System.out.println("Game title: " + title);
                System.out.println("Price: $" + salePrice);
                System.out.println("Ratings: \"" + steamRatingText + "\" " + steamRatingPercent + "%");
                System.out.println("Game ID: " + steamAppID + "\n");
                for (int i = 0; i < 30; i++) {
                        System.out.print("_");
                } // end for
                System.out.println();
        } // end printGame

        public static void searchByTitle() {} // end searchByTitle
        public static void searchByRatings() {} // end searchByRatings
        public static void searchByPrice() {} // end searchByPrice
        public static void searchForGame() {} // end searchForGame
} // end game
