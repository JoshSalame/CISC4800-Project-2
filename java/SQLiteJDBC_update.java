import java.sql.*;
import java.util.Scanner;

public class SQLiteJDBC_update {
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

                        String[] attributes = new String[SIZE/2];
			String[] values = new String[SIZE/2];

			//if has where statement, declare and allocate arrays to hold input
			boolean hasWhere = false;

			//use attributeSize to keep track of args placement.
			int attributeSize = 0, valueSize = 0;

			//took an args that will be nulled, so we'll save that last one for later
			String tempArg = "";
                        while(cmdArgs.hasNext() && !hasWhere) {
				attributes[attributeSize] = cmdArgs.next();
				values[valueSize] = cmdArgs.next();
				attributeSize++;
				valueSize++;
				//detect WHERE clause
				if(attributes[attributeSize - 1].equalsIgnoreCase("WHERE") || values[valueSize - 1].equalsIgnoreCase("WHERE")) {
                                        hasWhere = true;
                                        //last attribute is WHERE, hence we delete it
                                        attributes[attributeSize - 1] = null;
                                        attributeSize--;
					tempArg = values[valueSize - 1];
					values[valueSize - 1] = null;
                                        valueSize--;
                                }
                        }

			String sql = "UPDATE " + tableName + " SET ";

			//insert first attribute name and value to prevent an ending comma
			sql = sql + attributes[0] + " = " + values[0];

			//insert other attributes and values
			for(int i = 1; (i < attributeSize) && (i < valueSize); i++) {
				sql = sql + ", " + attributes[i] + " = " + values[i]; 
			}

			System.out.println("inserted att and values");

//			for(String att : attributes) System.out.print(att + "\t");
//			for(String val : values) System.out.print(val + "\t");


			//if conditions exist, insert first condition for formatting
			if(hasWhere) {
				sql = sql + " WHERE ";
				sql = sql + tempArg + " " + cmdArgs.next() + " " + cmdArgs.next();
				System.out.println("inserted first condition");
				while(cmdArgs.hasNext()) {
					sql = sql + " " + cmdArgs.next() + " " + cmdArgs.next() + " " + cmdArgs.next() + " " + cmdArgs.next();
				}
			}

			sql = sql + ";";

			//print executing sql statement
                        System.out.println(sql + "\n");

			stmt.executeUpdate(sql);

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
