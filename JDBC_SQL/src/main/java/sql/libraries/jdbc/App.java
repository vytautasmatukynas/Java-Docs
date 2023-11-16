package sql.libraries.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Statement - interface accepts strings as SQL queries. 
 * It is VURNERABLE to SQL injection.
 * 
 * PreparedStatement - extends the Statement interface. It has methods to bind various 
 * object types, including files and arrays.
 * It PROTECTS against SQL injection.
 * 
 * Statement for DDL queries and PreparedStatement for DML queries.
 * 
 * DDL - stands for Data Definition Language and refers to SQL commands used to create, modify, and delete 
 * database structures such as tables, indexes, and views. 
 * 
 * DML - stands for Data Manipulation Language and 
 * refers to SQL commands used to insert, update, and delete data within a database.
 * 
 * "executeQuery"
 * "ResultSet result = executeQuery(String SQL)" - returns a ResultSet object. 
 * Use this method when you expect to get a result set, as you would with a SELECT statement.
 * Can be used with SELECT, INSERT, UPDATE, or DELETE statment.
 * 
 * "executeUpdate"
 * "int result = executeUpdate(String SQL)" - returns the number of rows affected by the execution of the SQL statement. 
 * Use this method to execute SQL statements, for which you expect to get a number of rows affected - for example, 
 * an INSERT, UPDATE, or DELETE statement.
 * 
 * "execute"
 * "boolean result = execute(String SQL)" - Returns a boolean value of true if a ResultSet object can be retrieved; otherwise, 
 * it returns false. Use this method to execute SQL DDL statements or when you need to use the truly dynamic SQL.
 */

public class App {

	/* CONNECTION TO PostgreSQL DB
	 * String jdbcUrl = "jdbc:postgresql://<hostAddress>:<port>/<dbName>";
	 * String username = "username";
	 * String password = "password";
	*/		
	
	/* CONNECTION TO MySQL DB
	 * String jdbcUrl = "jdbc:mysql://<hostAddress>:<port>/<dbName>";
	 * String username = "username";
	 * String password = "password";
	*/	
	public static final String JDBC_URL = "jdbc:mysql://localhost:3306/sakila";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "javau7";

	// Constants for column names
	public static final String TITLE = "title";
	public static final String DESCRIPTION = "description";
	public static final String LENGTH = "length";
	public static final String REALESE_YEAR = "release_year";
	public static final String RATING = "rating";
	public static final String SPECIAL_FEATURES = "special_features";

	public static final String CUSTOMER_FIRST_NAME = "customer.first_name";
	public static final String CUSTOMER_LAST_NAME = "customer.last_name";
	public static final String FILM_TITLE = "film.title";

	public static void main(String[] args) {
		
		/* OUTPUT
		 * Result: true
		 */
		executeSELECT();
		// <OR>
		boolean isSelectTrue = executeSELECT();
		System.out.println("Result: " + isSelectTrue);
		
		
		/* OUTPUT
		 * Result: false
		 */
		executeUPDATE();
		// <OR>
		boolean isSelectFalse = executeUPDATE();
		System.out.println("Result: " + isSelectFalse);
		
		
		/* OUTPUT
		 * Rows updated: 1 (or number of rows that were updated/deleted/created)
		 * IF NO ROWS WERE UPDATED OUTPUT
		 * Rows updated: 0
		 */
		executeUpdateUPDATE();
		// <OR>
		int updatedRowCount = executeUpdateUPDATE();
		System.out.println("Rows updated: " + updatedRowCount);

		
		/* OUTPUT 
		 * Movie info: <--- 
		 * title: ALIEN CENTER 
		 * length: 46 min.
		 */
		executeQuerySUBQUERY();

		
		/* OUTPUT 
		 * Special Features Counter: <--- 
		 * Spacial Features: Deleted Scenes,
		 * Behind the Scenes Count: 71
		 */
		executeQueryGROUPBY();

		
		/* OUTPUT 
		 * Rent info: <--- 
		 * First name: PENNY 
		 * Last name: NEAL Movie 
		 * title: ACE GOLDFINGER
		 */
		executeQueryJOIN();

		
		/* OUTPUT 
		 * Movie info: <--- 
		 * title: AFRICAN EGG 
		 * description: A Fast-Paced Documentary of a Pastry Chef And a Dentist who must Pursue a Forensic
		 * Psychologist in The Gulf of Mexico 
		 * length: 130 min. 
		 * year: 2006 y. rating: G
		 */
		executeQuerySELECT();
		
	}
	
	private static boolean executeSELECT() {
	    boolean result = false;
	    
	    String query = String.format("SELECT %s, %s " 
									+ "FROM sakila.film " 
									+ "WHERE length < (SELECT AVG(%s) FROM sakila.film) "
									+ "GROUP BY %s, %s " 
									+ "ORDER BY %s ASC " 
									+ "LIMIT 1;",
									TITLE, LENGTH, LENGTH, TITLE, LENGTH, LENGTH);

		try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)){

            PreparedStatement statement = conn.prepareStatement(query); // Create a statement for executing SQL queries.

            result = statement.execute(query); // Execute the provided SQL query and store the result.
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return result; // Return the boolean result indicating the success of the SQL query execution.
	}
	
	private static boolean executeUPDATE() {
	    boolean result = false;

	    String query = String.format("UPDATE sakila.film "
					                + "SET %s=\"ACE GOLDFINGER SECOND\" "
					                + "WHERE %s=\"ACE GOLDFINGER SECOND\";",
					                TITLE, TITLE);
	    
		try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)){

            PreparedStatement statement = conn.prepareStatement(query); // Create a statement for executing SQL queries.

            result = statement.execute(query); // Execute the provided SQL query and store the result.
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return result; // Return the boolean result indicating the success of the SQL query execution.
	}
	
	private static int executeUpdateUPDATE() {
		int result = 0;
		
	    String query = String.format("UPDATE sakila.film "
					                + "SET %s=\"ACE GOLDFINGER SECOND\" "
					                + "WHERE %s=\"ACE GOLDFINGER SECOND\";",
					                TITLE, TITLE);

		try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)){

            PreparedStatement statement = conn.prepareStatement(query); // Create a statement for executing SQL queries.

            result = statement.executeUpdate(query); // Execute the provided SQL query and store the result.
		    
		} catch (SQLException e) {
		    e.printStackTrace();
		}

		return result; // Return the number of rows affected by the SQL update query.
	}

	private static void executeQuerySUBQUERY() {
		String query = String.format("SELECT %s, %s " 
									+ "FROM sakila.film " 
									+ "WHERE length < (SELECT AVG(%s) FROM sakila.film) "
									+ "GROUP BY %s, %s " 
									+ "ORDER BY %s ASC " 
									+ "LIMIT 1;",
									TITLE, LENGTH, LENGTH, TITLE, LENGTH, LENGTH);
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
				// Create a statement for executing the SQL query
				PreparedStatement statement = conn.prepareStatement(query);
				// Execute the SQL query and retrieve the result set
				ResultSet result = statement.executeQuery()) {

			while (result.next()) {
				String title = result.getString(TITLE);
				int length = result.getInt(LENGTH);

				System.out.format("\nMovie info: <---\n" 
								+ "title: %s\n" 
								+ "length: %s min.\n", 
								title, length);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void executeQueryGROUPBY() {
		String query = String.format("SELECT DISTINCT %s, COUNT(%s) " 
									+ "FROM sakila.film " 
									+ "GROUP BY %s " 
									+ "HAVING COUNT(%s) > 70 "
									+ "ORDER BY COUNT(%s) ASC " 
									+ "LIMIT 1;",
									SPECIAL_FEATURES, SPECIAL_FEATURES, 
									SPECIAL_FEATURES, SPECIAL_FEATURES, 
									SPECIAL_FEATURES);
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
				// Create a statement for executing the SQL query
				PreparedStatement statement = conn.prepareStatement(query);
				// Execute the SQL query and retrieve the result set
				ResultSet result = statement.executeQuery()) {

			while (result.next()) {
				String special_features = result.getString(SPECIAL_FEATURES).replace(",", ", ");
				int count = result.getInt("COUNT(" + SPECIAL_FEATURES + ")");

				System.out.format("\nSpecial Features Counter: <---\n" 
								+ "Special Features: %s\n" 
								+ "Count: %s\n",
								special_features, count);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void executeQueryJOIN() {
		// SQL query to select customer and movie information
		String query = String.format("SELECT %s, %s, %s " 
									+ "FROM sakila.customer "
									+ "INNER JOIN rental ON customer.customer_id = rental.customer_id "
									+ "INNER JOIN inventory ON rental.inventory_id = inventory.inventory_id "
									+ "INNER JOIN film ON inventory.film_id = film.film_id " 
									+ "LIMIT 1;",
									CUSTOMER_FIRST_NAME, CUSTOMER_LAST_NAME, FILM_TITLE);
		
		// Try to establish a database connection
		try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
				// Create a statement for executing the SQL query
				PreparedStatement statement = conn.prepareStatement(query);
				// Execute the SQL query and retrieve the result set
				ResultSet result = statement.executeQuery()) {
			
			// Loop through the result set and print customer and movie information
			while (result.next()) {
				String name = result.getString(CUSTOMER_FIRST_NAME); // Get the customer's first name
				String lastName = result.getString(CUSTOMER_LAST_NAME); // Get the customer's last name
				String title = result.getString(FILM_TITLE); // Get the movie title

				System.out.format("\nRent info: <---\n" 
								+ "First name: %s\n" 
								+ "Last name: %s\n" 
								+ "Movie title: %s\n",
								name, lastName, title);
			}

		} catch (SQLException e) {
			// Handle any database-related exceptions
			e.printStackTrace();
		}
	}

	private static void executeQuerySELECT() {
		// SQL query to select movie information
		String query = String.format("SELECT %s, %s, %s, %s, %s " 
									+ "FROM film " 
									+ "LIMIT 1", 
									TITLE, DESCRIPTION, LENGTH, REALESE_YEAR, RATING);
		
		// Try to establish a database connection
		try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
				// Create a statement for executing the SQL query
				PreparedStatement statement = conn.prepareStatement(query);
				// Execute the SQL query and retrieve the result set
				ResultSet result = statement.executeQuery()) {

			// Loop through the result set and print movie information
			while (result.next()) {
				String title = result.getString(TITLE); // Get the movie title
				String description = result.getString(DESCRIPTION); // Get the movie description
				int length = result.getInt(LENGTH); // Get the movie length
				int releaseYear = result.getInt(REALESE_YEAR); // Get the release year
				String rating = result.getString(RATING); // Get the movie rating

				System.out.format("\nMovie info: <---\n" 
								+ "title: %s\n" 
								+ "description: %s\n" 
								+ "length: %s\n"
								+ "year: %s\n" 
								+ "rating: %s\n", 
								title, description, length, releaseYear, rating);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
