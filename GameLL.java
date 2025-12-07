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
		/*
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
		*/
		System.out.println("Search by title\n");
		GameLL.searchByTitle();
		System.out.println("Search by ratings\n");
		GameLL.searchByRatings();
		System.out.println("Search by price range\n");
		GameLL.searchByPrice();
		System.out.println("Search for game\n");
		Game c = GameLL.searchForGame();
	} // end main
	public GameLL() {
		this.head = null;
	} // end constructor
	public GameLL(String JSON) {
		GameList games = new GameList();
		games = GameLL.parseJSON(JSON);
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
        public static String readStringFromURL(String query){
                // From https://github.com/twopiharris/BSU-CS121/tree/main/data_API
                // adapted from https://alvinalexander.com/blog/post/java/how-open-read-url-java-url-class-example-code/
                String result = "";
                try {
                        URL url = new URL(query);
                        InputStreamReader iReader = new InputStreamReader(url.openStream());
                        BufferedReader reader = new BufferedReader(iReader);
                        String line;
                        while ((line = reader.readLine()) != null){
                                result += line + "\n";
                        } // end while
                        reader.close();
                        iReader.close();
                } catch (IOException e){
                        System.out.println(e.getMessage());
                } // end try
                return result;
        } // end readStringFromURL
        public static GameList parseJSON(String jsonString){
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
		String json = "";
		String url = "https://www.cheapshark.com/api/1.0/deals?storeID=1&pageSize=10&title=" + userInput;
                System.out.println("Search results:\n");
                try {
                        /*
			File file = new File("title.txt");
                        Scanner inputFile = new Scanner(file);
                        while (inputFile.hasNext()) {
                                json += inputFile.nextLine();
                        }
                        inputFile.close();
			*/
			json = GameLL.readStringFromURL(url);
                        games = parseJSON(json);
                        for (Game game : games.getGames()) {
                                game.printGame();
                        } // end for
                } catch (Exception e) {
                        System.out.println(e.getMessage());
                } //end try
	} // end searchByTitle
        public static void searchByRatings() {
		GameList games = new GameList();
                Scanner input = new Scanner(System.in);
                String userInput = "";
                System.out.print("Enter a minimum rating (integer between 0-100): ");
                userInput = input.nextLine();
		String json = "";
		String url = "https://www.cheapshark.com/api/1.0/deals?storeID=1&pageSize=10&steamRating=" + userInput;
                System.out.println("Search results:\n");
		try {
                       	/*
		       	File file = new File("ratings.txt");
                        Scanner inputFile = new Scanner(file);
                        while (inputFile.hasNext()) {
                                json += inputFile.nextLine();
                        }
                        inputFile.close();
			*/
			json = GameLL.readStringFromURL(url);
			games = parseJSON(json);
                	for (Game game : games.getGames()) {
                        	game.printGame();
                	} // end for
                } catch (Exception e) {
                        System.out.println(e.getMessage());
                } // end try
	} // end searchByRatings
        public static void searchByPrice() {
		GameList games = new GameList();
                Scanner input = new Scanner(System.in);
                String minPrice = "";
		String maxPrice = "";
                System.out.print("Enter a minimum price: ");
                minPrice = input.nextLine();
		System.out.print("Enter a maximum price: ");
		maxPrice = input.nextLine();
		String json = "";
		String url = "https://www.cheapshark.com/api/1.0/deals?storeID=1&pageSize=10&lowerPrice=" + minPrice + "&upperPrice=" + maxPrice;
                System.out.println("Search results:\n");
		try {
			json = GameLL.readStringFromURL(url);
                        games = parseJSON(json);
                        for (Game game : games.getGames()) {
                                game.printGame();
                        } // end for
                } catch (Exception e) {
                        System.out.println(e.getMessage());
                } // end try
	} // end searchByPrice
        public static Game searchForGame() {
		Game result = new Game();
		GameList games = new GameList();
		Scanner input = new Scanner(System.in);
		String userInput = "";
		System.out.print("Enter the game ID: ");
		userInput = input.nextLine();
		String json = "";
		String url = "https://www.cheapshark.com/api/1.0/deals?storeID=1&pageSize=10&steamAppID=" + userInput;
                System.out.println("Search result:\n");
                try {
                        /*
			File file = new File("game.txt");
                        Scanner inputFile = new Scanner(file);
                        while (inputFile.hasNext()) {
                                json += inputFile.nextLine();
                        }
                        inputFile.close();
			*/
			json = GameLL.readStringFromURL(url);
                        games = parseJSON(json);
                        for (Game game : games.getGames()) {
				result = game;
                        } // end for
			result.printGame();
                } catch (Exception e) {
                        System.out.println(e.getMessage());
                } // end try
		return result;
	} // end searchForGame
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
	} // end getGames
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
	public double getPrice() {
		double result = 0.0;
		try {
			result = Double.parseDouble(this.salePrice);
		} catch (Exception e) {
			System.out.println("Oops! If you're seeing this, either there was an issue with the API or I made a mistake here.");
			System.out.println(e.getMessage());
		} // end try
		return result;
	} // end getPrice
	public boolean equals(Game other) {
		boolean isEqual = true;
		if (!(this.title.equals(other.title))) {
			isEqual = false;
		} else if (!(this.salePrice.equals(other.salePrice))) {
			isEqual = false;
		} else if (!(this.steamRatingPercent.equals(other.steamRatingPercent))) {
			isEqual = false;
		} else if (!(this.steamAppID.equals(other.steamAppID))) {
			isEqual = false;
		}
		return isEqual;
	} // end equals
} // end game
