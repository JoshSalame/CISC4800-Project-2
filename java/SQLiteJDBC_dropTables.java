import java.sql.*;

public class SQLiteJDBC_dropTables {

	public static void main( String args[] ) {
		Connection c = null;
		Statement stmt = null;

		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");

			final int SIZE = args.length;

			String[] toDrop = new String[SIZE];
			//for (int i = 0; i < SIZE; i++) { toDrop[i] = args[i]; }

			stmt = c.createStatement();
			
	        	String sql = "";
			for (int i = 0; i < SIZE; i++) {
				sql = "DROP TABLE " + args[i] + ";";
				System.out.println(sql);
	                        stmt.executeUpdate(sql);
			}
			
			System.out.println("Table(s) dropped successfully.");

			stmt.close();
			c.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
	}
}

