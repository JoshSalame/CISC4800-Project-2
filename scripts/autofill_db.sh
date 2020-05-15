!#bin/bash

echo -e "Filling database with pre-made data."
cd ../java;

#Compile files
echo -e "Compiling Files"
make;

#Create Tables
echo -e "Creating tables..."
java -classpath ".:sqlite-jdbc-3.30.1.jar" SQLiteJDBC_createTable EMPLOYEES id NUMBER first VARCHAR last VARCHAR salary NUMBER bonus NUMBER
java -classpath ".:sqlite-jdbc-3.30.1.jar" SQLiteJDBC_createTable ADDRESS id NUMBER street VARCHAR city VARCHAR state VARCHAR zip NUMBER

#Insert Data
echo -e "Inserting Data"
#Insert into employee table
java -classpath ".:sqlite-jdbc-3.30.1.jar" SQLiteJDBC_insert EMPLOYEES id 1 first \"John\" last \"Smith\" salary 75000 bonus 3000
java -classpath ".:sqlite-jdbc-3.30.1.jar" SQLiteJDBC_insert EMPLOYEES id 2 first \"Jane\" last \"Doe\" salary 45000 bonus 0
java -classpath ".:sqlite-jdbc-3.30.1.jar" SQLiteJDBC_insert EMPLOYEES id 3 first \"John\" last \"Stamos\" salary 20000 bonus 0
java -classpath ".:sqlite-jdbc-3.30.1.jar" SQLiteJDBC_insert EMPLOYEES id 4 first \"Marissa\" last \"Teren\" salary 90000 bonus 0
java -classpath ".:sqlite-jdbc-3.30.1.jar" SQLiteJDBC_insert EMPLOYEES id 5 first \"Aaron\" last \"Smith\" salary 75000 bonus 5000
java -classpath ".:sqlite-jdbc-3.30.1.jar" SQLiteJDBC_insert EMPLOYEES id 6 first \"Jaslene\" last \"Margareta\" salary 45000 bonus 2000
java -classpath ".:sqlite-jdbc-3.30.1.jar" SQLiteJDBC_insert EMPLOYEES id 7 first \"Isabella\" last \"Green\" salary 50000 bonus 3000
java -classpath ".:sqlite-jdbc-3.30.1.jar" SQLiteJDBC_insert EMPLOYEES id 8 first \"Emma\" last \"Stone\" salary 75000 bonus 0
java -classpath ".:sqlite-jdbc-3.30.1.jar" SQLiteJDBC_insert EMPLOYEES id 9 first \"Soryu\" last \"Holmes\" salary 20000 bonus 3000
java -classpath ".:sqlite-jdbc-3.30.1.jar" SQLiteJDBC_insert EMPLOYEES id 10 first \"Eliza\" last \"Flamel\" salary 102500 bonus 8500
java -classpath ".:sqlite-jdbc-3.30.1.jar" SQLiteJDBC_insert EMPLOYEES id 11 first \"Emma\" last \"Solder\" salary 20000 bonus 0
java -classpath ".:sqlite-jdbc-3.30.1.jar" SQLiteJDBC_insert EMPLOYEES id 12 first \"Mary\" last \"Johnson\" salary 95000 bonus 0
java -classpath ".:sqlite-jdbc-3.30.1.jar" SQLiteJDBC_insert EMPLOYEES id 13 first \"Nathan\" last \"Smith\" salary 45000 bonus 5000
java -classpath ".:sqlite-jdbc-3.30.1.jar" SQLiteJDBC_insert EMPLOYEES id 14 first \"Jane\" last \"Teren\" salary 80000 bonus 2000
java -classpath ".:sqlite-jdbc-3.30.1.jar" SQLiteJDBC_insert EMPLOYEES id 15 first \"Jhari\" last \"Nicholson\" salary 75000 bonus 3500
java -classpath ".:sqlite-jdbc-3.30.1.jar" SQLiteJDBC_insert EMPLOYEES id 16 first \"Taylor\" last \"Swift\" salary 50000 bonus 1000

#Insert into address table
java -classpath ".:sqlite-jdbc-3.30.1.jar" SQLiteJDBC_insert ADDRESS id 1 street \"123_Pennsylvania_Ave\" city \"Brooklyn\" state \"NY\" zip 12345
java -classpath ".:sqlite-jdbc-3.30.1.jar" SQLiteJDBC_insert ADDRESS id 2 street \"456_Madison_Ave\" city \"Brooklyn\" state \"NY\" zip 12245
java -classpath ".:sqlite-jdbc-3.30.1.jar" SQLiteJDBC_insert ADDRESS id 3 street \"789_Gandit_Plaza\" city \"San_Francisco\" state \"California\" zip 11345
java -classpath ".:sqlite-jdbc-3.30.1.jar" SQLiteJDBC_insert ADDRESS id 4 street \"42_West_67th_St\" city \"Chicago\" state \"Illinois\" zip 13245
java -classpath ".:sqlite-jdbc-3.30.1.jar" SQLiteJDBC_insert ADDRESS id 5 street \"1278_Portomon_Ave\" city \"Brooklyn\" state \"NY\" zip 16234
java -classpath ".:sqlite-jdbc-3.30.1.jar" SQLiteJDBC_insert ADDRESS id 6 street \"432_Lamison_Ave\" city \"Brooklyn\" state \"NY\" zip 12736
java -classpath ".:sqlite-jdbc-3.30.1.jar" SQLiteJDBC_insert ADDRESS id 7 street \"354_Corner_Ave\" city \"San_Francisco\" state \"California\" zip 12873
java -classpath ".:sqlite-jdbc-3.30.1.jar" SQLiteJDBC_insert ADDRESS id 8 street \"490_East_End_Ave\" city \"Chicago\" state \"Illinois\" zip 12198
java -classpath ".:sqlite-jdbc-3.30.1.jar" SQLiteJDBC_insert ADDRESS id 9 street \"123_Second_Ave\" city \"Brooklyn\" state \"NY\" zip 14732
java -classpath ".:sqlite-jdbc-3.30.1.jar" SQLiteJDBC_insert ADDRESS id 10 street \"456_Brave_Ave\" city \"Austin\" state \"Texas\" zip 11872
java -classpath ".:sqlite-jdbc-3.30.1.jar" SQLiteJDBC_insert ADDRESS id 11 street \"789_Sequester_Plaza\" city \"San_Francisco\" state \"California\" zip 14378
java -classpath ".:sqlite-jdbc-3.30.1.jar" SQLiteJDBC_insert ADDRESS id 12 street \"42_North_32th_St\" city \"Chicago\" state \"Illinois\" zip 13725
java -classpath ".:sqlite-jdbc-3.30.1.jar" SQLiteJDBC_insert ADDRESS id 13 street \"1278_Green_Ave\" city \"Brooklyn\" state \"NY\" zip 14398
java -classpath ".:sqlite-jdbc-3.30.1.jar" SQLiteJDBC_insert ADDRESS id 14 street \"432_Waterfront_Ave\" city \"New_York\" state \"NY\" zip 28731
java -classpath ".:sqlite-jdbc-3.30.1.jar" SQLiteJDBC_insert ADDRESS id 15 street \"354_Washington_Ave\" city \"San_Francisco\" state \"California\" zip 11821
java -classpath ".:sqlite-jdbc-3.30.1.jar" SQLiteJDBC_insert ADDRESS id 16 street \"490_East_End_Ave\" city \"Chicago\" state \"Illinois\" zip 12387
