import java.sql.*;

public class SQLiteJDBC_createTable {

	public static void main( String args[] ) {
		Connection c = null;
		Statement stmt = null;

		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");

			final int SIZE = args.length;

	                String tableName = args[0];
	                String[] attributeNames = new String[SIZE/2];
	                String[] attributeTypes = new String[SIZE/2];
	
	                //fill arrays with names and types. Start from 1 to exclude tableName arg.
	                for(int i = 1; i < SIZE/2 + 1; i++) {
	                        attributeNames[i-1] = args[(i*2)-1];
	           	        attributeTypes[i-1] = args[i*2];
			}

			stmt = c.createStatement();
			
			//create statement based on tableName, attribute names and types.
	        	String sql = "CREATE TABLE " + tableName + "(";;

			//insert first to prevent ending comma
			sql = sql + attributeNames[0] + " " + attributeTypes[0];
			for(int i = 1; i < SIZE/2; i++) {
				sql = sql + ", " + attributeNames[i] + " " + attributeTypes[i];
			}
			sql = sql + ");";
			
			//print executing sql statement
			System.out.println(sql);

        		stmt.executeUpdate(sql);
			stmt.close();
			c.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
		System.out.println("Table created successfully");
	}
}
