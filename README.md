# CISC4800 Project 2  

### Project Description:  



### Files & Uses:  

- README.md  

- *java*  
  - Makefile -> compiles java files
  - SQLiteJDBC_connect.java -> creates a connection to test.db database  
  - SQLiteJDBC_createTable.java -> create table according to input: [tableName attName attType attName2 attType2 ...]  
  - SQLiteJDBC_delete.java -> deletes selected rows of table: [tableName WHERE attName relationType value attName2 relationType2 value2 ...]. relationType includes =, <, >, etc. WHERE is optional.  
  - SQLiteJDBC_drop.java -> drops selected tables: tableName1 tableName2 ...  
  - SQLiteJDBC_insert.java  -> inserts values into table: [tableName attName attValue attName2 attValue2 ...]  
  - SQLiteJDBC_select.java -> selects/displays selected columns and rows of table: [tableName attName attName2 ... WHERE attName relationType value attName2 relationType2 value2 ...]. relationType includes =, <, >, etc. WHERE is optional.  
  - SQLiteJDBC_update.java -> updates values in table: [tableName attName attValue attName2 attValue2 ... WHERE attName relationType value attName2 relationType2 value2 ...]. relationType includes =, <, >, etc. WHERE is optional.
  - sqlite-jdbc-3.30.1.jar -> used for connections

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
