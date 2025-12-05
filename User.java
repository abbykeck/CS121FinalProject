import java.util.*;
import java.io.*;

public class User implements Serializable {
	String userName;
	String PIN;
	double balance;
	GameLL ownedGames;
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		System.out.println("Hello world!");
		User a = new User();
		if (a.login()) {
			System.out.println("Username: " + a.getUserName());
			System.out.println("PIN: " + a.getPIN());
			System.out.println("Balance: " + a.getBalanceString());
		} else {
			System.out.println("Login failed, please try again");
		} // end if
	} // end main
	public User() {
		this.userName = "username";
		this.PIN = "0000";
		this.balance = 0.0;
		this.ownedGames = new GameLL();
	} // end null-parameter constructor

	public User(String userName, String PIN) {
		this.userName = userName;
		this.PIN = PIN;
		this.balance = 0.0;
		this.ownedGames = new GameLL();
	} // end one-parameter constructor
	public String getUserName() {
		return this.userName;
	} // end getUserName
	public void setUserName(String userName) {
		this.userName = userName;
	} // end setUserName
	public String getPIN() {
		return this.PIN;
	} // end getPIN
	public void setPIN(String PIN) {
		this.PIN = PIN;
	} // end setPIN
	public double getBalance() {
		return balance;
	} // end getBalance
	public String getBalanceString() {
		String result = String.format("$%.2f", balance);
		return result;
	} // end getBalanceString
	public GameLL getOwnedGames() {
		return ownedGames;
	} // end getOwnedGames
	public boolean login() {
		Scanner input = new Scanner(System.in);
		String inputName = "";
		String inputPIN = "";
		boolean result = false;
		System.out.print("Enter your username: ");
		inputName = input.nextLine();
		System.out.print("Enter your PIN: ");
		inputPIN = input.nextLine();
		if (userName.equals(inputName)) {
			if (PIN.equals(inputPIN)) {
				result = true;
			} // end if
		} // end if
		return result;
	} // end login
	public boolean login(String userName, String PIN) {
		boolean result = false;
		if (this.userName.equals(userName)) {
                        if (this.PIN.equals(PIN)) {
                                result = true;
                        } // end if
                } // end if
                return result;
	} // end two-parameter login
	public void start() {} // end start
	public String menu() {
		Scanner input = new Scanner(System.in);
		String choice = "";
		System.out.println("User Menu\n");
		System.out.println("0) Exit");
		System.out.println("1) Check balance");
		System.out.println("2) Add to balance");
		System.out.println("3) View owned games");
		System.out.println("4) Search for games");
		System.out.println("5) Buy a game");
		System.out.print("Enter your choice 0-5: ");
		choice = input.nextLine();
		return choice;
	} // end menu
	/*
	public void checkBalance() {} // end checkBalance
	public void addBalance() {} // end addBalance
	private double getDouble() {} // end getDouble
	public void searchGames() {} // end searchGames
	public void buyGame() {} // end buyGame
	*/
} // end User
