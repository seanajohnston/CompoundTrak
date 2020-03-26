# CompoundTrak

## Intro

This is a solution to a coding challenge. CompoundTrak is designed to run on the linux command line. It offers the user a read-eval-print-loop. For storage and queries, SQLite is utilized in the back end. The SQLite JDBC .jar file is included here and is the only requirment to utilize the database. This challenge did not require a CLI nor database functionality, as it couldv'e been solved with a single class and an instance based data structure. However, I chose this opportunity to practise some OOP and its associated principles suchs as extensibility, reusability, interfaces, etc.

## Compiling and running

At the command line, jave files are compiled by command

```
javac *.java
```
The program begins from the main method of the CompoundTrak class and the SQLite jar must be included in the classpath. Run the program with command

```
java -classpath .:sqlite-jdbc-3.30.1.jar CompoundTrak
```
Then, enter the command "help" for a list of commands provided by CompoundTrak.

## Back End

If one wishes to incorporate the backend only in a program, the DataManager, Connect and DbBuilder classes are the only required. The DataManager contains the functions required for the challenge. 

## Known Issue

CompoundTrak creates the database and its tables the first time it runs. The next times it runs, CompoundTrak will throw SQL errors because it is trying to create tables already present in the database. This error can simply be ignored and the program will function as normal. A simple fix checks when the ctrak.db file and tables are previously created. 
