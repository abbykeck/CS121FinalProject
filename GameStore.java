import java.util.*;
import java.io.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GameStore {
	private User user;

	public static void main(String[] args) {
		// System.out.println("Hello world!");
		new GameStore();
	} // end main
	public GameStore() {
		this.loadUserInfo();
		boolean keepGoing = true;
		while (keepGoing) {
			if (user.login()) {
				keepGoing = false;
				user.start();
			} // end if
		} // end while
		this.saveUserInfo();
	} // end constructor
	public void loadUserInfo() {
		try {
			FileInputStream inFile = new FileInputStream("user.dat");
			ObjectInputStream input = new ObjectInputStream(inFile);
			user = (User)input.readObject();
			input.close();
			inFile.close();
		} catch (Exception e) {
			user = new User();
		} // end try
	} // end loadUserInfo
	public void saveUserInfo() {
		try {
			FileOutputStream outFile = new FileOutputStream("user.dat");
			ObjectOutputStream output = new ObjectOutputStream(outFile);
			output.writeObject(user);
			output.close();
			outFile.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} // end try
	} // end saveUserInfo
} // end GameStore
