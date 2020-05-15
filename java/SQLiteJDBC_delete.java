import java.sql.*;
import java.util.Scanner;

public class SQLiteJDBC_delete {
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
                        
			String tableName = cmdArgs.next();

			String sql = "DELETE FROM " + tableName;

			//if WHERE exists, it will be the second argument
                        if(cmdArgs.hasNext()) {
				//skip WHERE argument
				cmdArgs.next();
      				sql = sql + " WHERE ";
				sql = sql + cmdArgs.next() + " " + cmdArgs.next() + " " + cmdArgs.next();
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

