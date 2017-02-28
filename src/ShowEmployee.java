/**
 * Peter Laskai
 * Employee DB: Creating a database full of employeer information
 * Due 12/10/14
 */
import java.sql.*;   // Needed for JDBC classes

/**
 * This program demonstrates how to issue an SQL
 * SELECT statement to a database using JDBC.
 */

public class ShowEmployee
{
	public static void main(String[] args)
	{
		// Create a named constant for the URL.
		// NOTE: This value is specific for Java DB.
		final String DB_URL = "jdbc:derby:EmployeeDB";

		try
		{
			// Create a connection to the database.
			Connection conn = DriverManager.getConnection(DB_URL);

			// Create a statement object.
			Statement stmt = conn.createStatement();
			String sqlStatement =
					"SELECT * Employee Information";

			// Send the statement to the DBMS.
			ResultSet result = stmt.executeQuery(sqlStatement);

			// Display a header for the listing.
			System.out.println("Employee Information");
			System.out.println("------------------------------------------");

			// Display the contents of the result set.
			// The result set will have three columns.
			while (result.next())
			{
				System.out.println(result.getString("Description") +
						result.getString("EmpID") +
						result.getString("Posistion")+
						result.getDouble("Salary"));
			}

			// Close the connection
			conn.close();
		}
		catch(Exception ex)
		{
			System.out.println("ERROR: " + ex.getMessage());
		}
	}
}

/*
PsuedoCode:
	1.0 import database for JDBC classes
	2.0 in CreateEmployeeDB.java create URL for Employee DB
	3.0 Form Table in buildEmployeeTable method
	4.0 or dropTable method if Table already exists.
	5.0 add employee info including:
							Name
							EmployeeID
							Posistion
							Salary
	6.0 or add to dropTable the same information
	7.0 go to ShowEmploye.java which will intiate constructing the table
	8.0 for table with given exception ex if caught
	9.0 end
 */