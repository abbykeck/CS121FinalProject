testGameNode: GameNode.class
	java -cp gson-2.8.9.jar:. GameNode

GameNode.class:
	javac -cp gson-2.8.9.jar:. GameNode.java
