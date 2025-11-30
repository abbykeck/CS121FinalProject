import java.util.*;
import java.net.*;
import java.io.*;

public class Game {
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
} // end Game
