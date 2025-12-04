# GameStore project
Uses CheapShark API to simulate a game store simular to Steam
# UML Diagram
```mermaid
classDiagram
direction LR
class GameStore {
    - User user
    + static void main()
    + GameStore()
    + void saveUserInfo()
    + void loadUserInfo()
}
class User {
    - String userName
    - String PIN
    - double balance
    - GameLL ownedGames
    + static void main()
    + User()
    + User(String userName, String PIN)
    + String getUserName()
    + void setUserName(String userName)
    + String getPIN()
    + void setPIN(String PIN)
    + double getBalance()
    + void setBalance(double balance)
    + String getBalanceString()
    + GameLL getOwnedGames()
    + boolean login()
    + boolean login(String userName, String PIN)
    + void start()
    + String menu()
    + void checkBalance()
    + void addBalance()
    + void searchGames()
    - double getDouble()
    + void buyGame()
}
class Game ["Game (handles API)"]{
    - String internalName
    - String title
    - String metacriticLink
    - String dealID
    - String storeID
    - String gameID
    - String salePrice
    - String normalPrice
    - String isOnSale
    - String savings
    - String metacriticScore
    - String steamRatingText
    - String steamRatingPercent
    - String steamRatingCount
    - String steamAppID
    - int releaseDate
    - int lastChange
    - String dealRating
    - String thumb
    + void printGame()
    + static void searchByTitle()
    + static void searchByRatings()
    + static void searchByPrice()
    + static void searchForGame()
}
class GameLL {
    - GameNode head
    + GameLL()
    + void add(Game game)
    + void remove(Game game)
    + void printGames()
}
class GameNode {
    - Game game
    - GameNode next
    + GameNode()
    + GameNode(Game game)
    + Game getGame()
    + GameNode getNext()
    + void setNext(GameNode next)
}

GameStore o--> User
User o--> GameLL
GameLL o--> GameNode
GameNode o--> Game
```
# Algorithm for GameStore project
## GameStore class
### GameStore() constructor
1. loadUserInfo();
1. user.start();
1. saveUserInfo();
### void saveUserInfo()
Saves the instance of User to user.dat
### void loadUserInfo()
Loads the User object in user.dat and puts it in user
## User class
Implements Serializable
### String getBalanceString()
1. String result = String.format("$%.2f", balance)
1. return result;
### boolean login()
1. String inputUser = "";
1. String inputPIN = "";
1. boolean result = false;
1. Ask the user for a username and put it into inputUser
1. Ask the user for a PIN and put it into inputPIN
1. if (userName.equals(inputUser))
    1. if (PIN.equals(inputPIN))
        1. result = true;
    1. end if
1. end if
1. return result;
### boolean login(String userName, String PIN)
1. if (userName.equals(inputUser))
    1. if (PIN.equals(inputPIN))
        1. result = true;
    1. end if
1. end if
1. return result;
### void start
1. boolean keepGoing = true;
1. String choice = "";
1. while (keepGoing)
    1. choice = this.menu();
    1. if (choice == "0")
        1. keepGoing = false;
    1. else if (choice == "1")
        1. this.checkBalance();
    1. else if (choice == "2")
        1. this.addBalance();
    1. else if (choice == "3")
        1. this.ownedGames.printGames();
    1. else if (choice == "4")
        1. this.searchGames();
    1. else if (choice == "5")
        1. this.buyGame();
    1. else
        1. print "invalid input, please try again"
### String menu()
1. String choice = ""
1. print "User menu"
1. print "0) Exit"
1. print "1) Check balance"
1. print "2) Add to balance"
1. print "3) View owned games"
1. print "4) Search for games"
1. print "5) Buy a game"
1. print "Enter your choice 0-5: "
1. put user input into choice
1. return choice;
### void checkBalance()
### void addBalance()
### void searchGames()
### double getDouble()
### void buyGame()
## GameLL class
Implements Serializable
### void add(Game game)
Adds a new GameNode containing a Game to the beginning of the list
1. GameNode node = new GameNode(game);
1. if (this.head == null)
    1. head = node;
1. else
    1. node.setNext(head);
    1. head = node;
1. end if
### void remove(Game game)
1. GameNode currentNode = head;
1. GameNode previous = null;
1. while currentNode's game doesn't match game
    1. previous = currentNode;
    1. currentNode = currentNode.getNext();
1. end while
1. previous.setNext(currentNode.getNext());
### void printGames()
1. GameNode currentNode = head;
1. while (currentNode != null)
    1. currentNode.getGame().printGame();
    1. currentNode = currentNode.getNext();
1. end while
### static void searchByTitle()
1. ArrayList<Game> games = new ArrayList<Game>();
1. Scanner input = new Scanner(System.in);
1. String userInput = "";
1. print "Enter a game title (not case sensitive): "
1. userInput = input.nextLine();
1. Make a call to the API using userInput as the title parameter
1. fill games with the returned JSON values
1. print "Search results:"
1. for every Game in games
    1. game.printGame()
1. end for
### static void searchByRatings()
1. ArrayList<Game> games = new ArrayList<Game>();
1. Scanner input = new Scanner(System.in);
1. String userInput = "";
1. print "Enter a minimum rating (integer between 0-100): "
1. userInput = input.nextLine();
1. Make a call to the API using userInput as the steamRating parameter
1. fill games with the returned JSON values
1. print "Search results:"
1. for every Game in games
    1. game.printGame()
1. end for
## static void searchByPrice()
This program uses salePrice instead of normalPrice to make this search because CheapShark returns results based on salePrice.
1. ArrayList<Game> games = new ArrayList<Game>();
1. Scanner input = new Scanner(System.in);
1. String minPrice = "";
1. String maxPrice = "";
1. print "Enter a minimum price: "
1. minPrice = input.nextLine()
1. print "Enter a maximum price: "
1. maxPrice = input.nextLine();
1. Make a call to the API using minPrice for the lowerPrice parameter and maxPrice for upperPrice respectively
1. fill games with the returned JSON values
1. print "Search results:"
1. for every Game in games
    1. game.printGame()
1. end for
### static Game searchForGame()
Mostly for buyGame() in the User class
1. Game result = new Game();
1. GameList games = new GameList();
1. Scanner input = new Scanner(System.in);
1. String userInput = "";
1. print "Enter a game ID: "
1. userInput = input.nextLine();
1. Make a call to the API using userInput as the steamAppID parameter (steamAppID is unique for every game so this should only return one game)
1. put the returned JSON in games
1. put the Game from games into result
1. print "Search result:"
1. result.printGame();\
1. return result;
All of these search methods will additionally use the parameter storeID = 1 (to only return games on Steam) to prevent duplicates and also to make sure all results have a steamAppID, as well as pageSize = 10 to make sure the query only returns a maximum of 10 games.
## GameNode class (in GameLL.java)
Implements Serializable\
Acts as a sort of wrapper class between GameLL and Game. Additionally handles API to make an instance of Game. An instance of GameNode contains a Game instance (game), data for the next GameNode (next), and getters and setters for both. Null-parameter constructor sets both game and next to null, single-parameter constructor takes an instance of Game and passes it to game.\
## Game class (in GameLL.java)
Implements Serializable\
Data is read from JSON
### void printGame()
1. print "Game title: " + title
1. print "Price: $" + salePrice
1. print "Ratings: \"" + steamRatingText + "\" " + steamRatingPercent + "%"
1. print "Game ID:" + steamAppID + "\n"
