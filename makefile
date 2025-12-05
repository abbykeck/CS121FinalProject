testUser: User.class
	java User

User.class: User.java GameLL.class
	javac User.java

testGameLL: GameLL.class
	java -cp gson-2.8.9.jar:. GameLL

GameLL.class:
	javac -cp gson-2.8.9.jar:. GameLL.java

clean:
	rm *.class
