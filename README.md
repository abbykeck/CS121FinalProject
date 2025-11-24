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
## User class
## GameLL class
## GameNode class
## Game class
All data is read from JSON
### void printGame()
1. print "Game title: " + title
1. print "Price: $" + salePrice
1. print "Ratings: \"" + steamRatingText + "\" " + steamRatingPercent + "%"
1. print "Game ID:" + steamAppID + "\n"
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
### static void searchByPrice()
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
### static void searchForGame()
1. Game result = new Game();
1. Scanner input = new Scanner(System.in);
1. String userInput = "";
1. print "Enter a game ID: "
1. userInput = input.nextLine();
1. Make a call to the API using userInput as the steamAppID parameter
1. put the returned JSON in result
1. print "Search result:"
1. result.printGame();\
All of these search methods will additionally use the parameter storeID = 1 (to only return games on Steam) to prevent duplicates and also to make sure all results have a steamAppID.
