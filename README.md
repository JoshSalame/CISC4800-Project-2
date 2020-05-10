# CISC4800 Project 2  

### Project Description:  



### Files & Uses:  

- README.md  

- *java* [c = complete, i = incomplete, p = partially complete]
  - [c] Makefile -> compiles java files. use [make clean] to remove .class files as well as test.db file.
  - [c] SQLiteJDBC_connect.java -> creates a connection to test.db database (unnecessary)  
  - [c] SQLiteJDBC_createTable.java -> create table according to input: [tableName attName attType attName2 attType2 ...]  
  - [i] SQLiteJDBC_delete.java -> deletes selected rows of table: [tableName WHERE attName relationType value attName2 relationType2 value2 ...]. relationType includes =, <, >, etc. WHERE is optional.  
  - [c] SQLiteJDBC_dropTables.java -> drops selected tables: [tableName1 tableName2 ...]. If given 0 arguments, does nothing and exits normally.
  - [c] SQLiteJDBC_insert.java  -> inserts values into table: [tableName attName attValue attName2 attValue2 ...]  
  - [i] SQLiteJDBC_select.java -> selects/displays selected columns and rows of table: [tableName attName attName2 ... WHERE attName relationType value attName2 relationType2 value2 ...]. relationType includes =, <, >, etc. WHERE is optional.  
  - [i] SQLiteJDBC_update.java -> updates values in table: [tableName attName attValue attName2 attValue2 ... WHERE attName relationType value attName2 relationType2 value2 ...]. relationType includes =, <, >, etc. WHERE is optional.
  - [c] sqlite-jdbc-3.30.1.jar -> used for connections

- *scripts*  
  - autofill_db.sh
  - call_db_function
  - call_db_function_createTable.sh    
  - call_db_function_delete.sh  
  - call_db_function_drop.sh   
  - call_db_function_help.sh  
  - call_db_function_insert.sh  
  - call_db_function_select.sh  
  - call_db_function_update.sh  

### Instructions to assemble and run:  
1. cd java/
2. make
3. either:
  - create tables, insert, select, update, and delete as you like. Some functions like group by, order by, aggregate functions, etc not available.  
  - use autofilled tables: [cd ..; cd scripts; ./autofill_db.sh;]. This will create a couple basic tables to play around with using insert, select, update, and delete. Drop and create are still available of course. 
