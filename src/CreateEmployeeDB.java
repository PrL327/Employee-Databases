import java.sql.*;   // Needed for JDBC classes
/**
 * Peter Laskai
 * Employee DB, uses a database to store employeer information.
 */
public class CreateEmployeeDB
{
   public static void main(String[] args)
   {
      // Create a named constant for the URL.
      // NOTE: This value is specific for Java DB.
      final String DB_URL = "jdbc:derby:EmployeeDB;create=true";

      try
      {
         // Create a connection to the database.
         Connection conn =
                DriverManager.getConnection(DB_URL);

			// If the DB already exists, drop the tables.
			dropTables(conn);

			// Build the Coffee table.
			buildEmployeeTable(conn);


         // Close the connection.
         conn.close();
      }
      catch (Exception ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
   }

	/**
	 * The dropTables method drops any existing
	 * in case the database already exists.
	 */
	public static void dropTables(Connection conn)
	{
		System.out.println("Checking for existing tables.");

		try
		{
			// Get a Statement object.
			Statement stmt  = conn.createStatement();;

			try
			{
	         // Drop the UnpaidOrder table.
	         stmt.execute("DROP TABLE Employee");
				System.out.println("Employee table dropped.");
			}
			catch(SQLException ex)
			{
				// No need to report an error.
				// The table simply did not exist.
			}
		}
  		catch(SQLException ex)
		{
	      System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	/**
	 * The buildEmployeeTable method creates the
	 * Employee table and adds some rows to it.
	 */
	public static void buildEmployeeTable(Connection conn)
	{
		try
		{
         // Get a Statement object.
         Statement stmt = conn.createStatement();

			// Create the table.
			stmt.execute("CREATE TABLE Employee (" +
   				       "Description CHAR(25), " +
                      "EmpID CHAR(10) NOT NULL PRIMARY KEY, " +
                      "Posisition CHAR(10), " +
                      "Salary double)");

			// Insert row #1.
			stmt.execute("INSERT INTO Employee VALUES ( " +
                      "'John Johnson', " +
                      "'1234', " +
                      "Manager"
                      + "11.50)" );

			// Insert row #1.
			stmt.execute("INSERT INTO Employee VALUES ( " +
                      "'Jane Janeson', " +
                      "'123456', " +
                      "Accountant"
                      + "11.50"
                      + " )");

			// Insert row #2.
			stmt.execute("INSERT INTO Employee VALUES ( " +
                      "'Bob Bobson', " +
                      "'12347', " +
                      "Vice President"
                      + "23.50)");

			// Insert row #3.
			stmt.execute("INSERT INTO Employee VALUES ( " +
                      "David Davidson, " +
                      "4321', " +
                      "Bus Boy "
                      + "7.50)");

			// Insert row #4.
			stmt.execute("INSERT INTO Employee VALUES ( " +
                      "Buzz Killington, " +
                      "5321', " +
                      "General Manager "
                      + "11.50)" );

			// Insert row #5.
			stmt.execute("INSERT INTO Employee VALUES ( " +
                      "Gabe Fuzz, " +
                      "6574', " +
                      "Director"
                      + "12.50)");

		

			System.out.println("Employee table created.");
		}
		catch (SQLException ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
	}


}