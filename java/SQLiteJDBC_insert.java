import java.sql.*;

public class SQLiteJDBC_insert {

	public static void main( String args[] ) {
		Connection c = null;
		Statement stmt = null;

		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");
			c.setAutoCommit(false);

			stmt = c.createStatement();
			
			final int SIZE = args.length;

                        String tableName = args[0];
                        String[] attributes = new String[SIZE/2];
                        String[] values = new String[SIZE/2];

                        //fill arrays with attributes and their corresponding values. Start from 1 to exclude tableName arg.
                        for(int i = 1; i < SIZE/2 + 1; i++) {
                                attributes[i-1] = args[(i*2)-1];
                                values[i-1] = args[i*2];
                        }

			String sql = "INSERT INTO " + tableName + " (";

			//insert first attribute name to prevent an ending comma
			sql = sql + attributes[0];

			//insert other attribute names
			for(int i = 1; i < SIZE/2; i++) {
				sql = sql + ", " + attributes[i]; 
			}

			//insert first value 
			sql = sql + ") VALUES (" + values[0];

			//insert other values
			for(int i = 1; i < SIZE/2; i++) {
				sql = sql + ", " + values[i];
			}

			sql = sql + ");";

			//print executing sql statement
			System.out.println(sql);

			stmt.executeUpdate(sql);

			stmt.close();
			c.commit();
			c.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
		System.out.println("Records created successfully");
	}
}
