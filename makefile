GameStore.class: GameStore.java User.class
	javac -cp gson-2.8.9.jar:. GameStore.java

testUser: User.class
	java -cp gson-2.8.9.jar:. User

User.class: User.java GameLL.class
	javac -cp gson-2.8.9.jar:. User.java

testGameLL: GameLL.class
	java -cp gson-2.8.9.jar:. GameLL

GameLL.class:
	javac -cp gson-2.8.9.jar:. GameLL.java

run: GameStore.class
	java -cp gson-2.8.9.jar:. GameStore

clean:
	rm *.class
	rm user.dat

reset:
	rm user.dat

debug: GameStore.class
	jdb -cp gson-2.8.9.jar:. GameStore
