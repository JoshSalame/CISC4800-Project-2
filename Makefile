all: SQLiteJDBC_connect.class SQLiteJDBC_create.class SQLiteJDBC_insert.class SQLiteJDBC_select.class SQLiteJDBC_update.class SQLiteJDBC_delete.class

SQLiteJDBC_connect.class: SQLiteJDBC_connect.java
	javac SQLiteJDBC_connect.java;

SQLiteJDBC_create.class: SQLiteJDBC_create.java
	javac SQLiteJDBC_create.java;

SQLiteJDBC_insert.class: SQLiteJDBC_insert.java
	javac SQLiteJDBC_insert.java;

SQLiteJDBC_select.class: SQLiteJDBC_select.java
	javac SQLiteJDBC_select.java;

SQLiteJDBC_update.class: SQLiteJDBC_update.java
	javac SQLiteJDBC_update.java;

SQLiteJDBC_delete.class: SQLiteJDBC_delete.java
	javac SQLiteJDBC_delete.java;

clean:
	rm SQLiteJDBC_connect.class SQLiteJDBC_create.class SQLiteJDBC_insert.class SQLiteJDBC_select.class SQLiteJDBC_update.class SQLiteJDBC_delete.class;
	rm test.db;
