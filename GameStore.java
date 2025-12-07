import java.util.*;
import java.io.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GameStore {
	private User user;

	public static void main(String[] args) {
		System.out.println("Hello world!");
	} // end main
	public GameStore() {
		user = new User();
		user.start();
	} // end constructor
	public void loadUserInfo() {} // end loadUserInfo
	public void saveUserInfo() {} // end saveUserInfo
} // end GameStore
