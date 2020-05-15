import java.sql.*;
import java.util.Scanner;

public class SQLiteJDBC_select {
	public static void main( String args[] ) {
		Connection c = null;
		Statement stmt = null;

		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");
			c.setAutoCommit(false);

			stmt = c.createStatement();
			
			final int SIZE = args.length;

			String cmdArgsString = args[0];
			for(int i = 1; i < SIZE; i++) {
				cmdArgsString = cmdArgsString + " " + args[i];
			}

			//used to remove boundary logic for args;
			Scanner cmdArgs = new Scanner(cmdArgsString);
			Scanner cmdArgs2 = new Scanner(cmdArgsString);			
                        
			String tableName = cmdArgs.next();

                        String[] attributes = new String[SIZE-1];
                        
			//if has where statement, declare and allocate arrays to hold input
			boolean hasWhere = false;

			//use attributeSize to keep track of args placement.
			int attributeSize = 0;
                        while(cmdArgs.hasNext() && !hasWhere) {
				attributes[attributeSize] = cmdArgs.next();
				attributeSize++;

				if(attributes[attributeSize - 1].equalsIgnoreCase("WHERE")) {
                                        hasWhere = true;
					//last attribute is WHERE, hence we delete it
					attributes[attributeSize - 1] = null;
					attributeSize--;
                                }				
                        }

			String sql = "SELECT ";

			//insert first attribute name to prevent an ending comma
			sql = sql + attributes[0];

			//insert other attribute names
			for(int i = 1; i < attributeSize; i++) {
				sql = sql + ", " + attributes[i]; 
			}

			sql = sql + " FROM " + tableName;

			//if conditions exist, insert first condition for formatting
			if(hasWhere) {
				sql = sql + " WHERE ";
				sql = sql + cmdArgs.next() + " " + cmdArgs.next() + " " + cmdArgs.next();
				while(cmdArgs.hasNext()) {
					sql = sql + " " + cmdArgs.next() + " " + cmdArgs.next() + " " + cmdArgs.next() + " " + cmdArgs.next();
				}
			}

			sql = sql + ";";

			//print executing sql statement
                        System.out.println(sql + "\n");
		
			for(int i = 0; i < attributeSize; i++) { System.out.print(attributes[i] + "\t"); }
			System.out.println();

			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
   			while (rs.next()) {
       				for (int i = 1; i <= columnsNumber; i++) {
           				String columnValue = rs.getString(i);
           				System.out.print(columnValue + "\t");
       				}
       				System.out.println("");
   			}
      			rs.close();

			stmt.close();
			c.commit();
			c.close();
		}
		catch (Exception e) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
	}
}
