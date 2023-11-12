import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * "ResultSet result =  executeQuery(String SQL)" - returns a ResultSet object. 
 * Use this method when you expect to get a result set, as you would with a SELECT statement.
 * Can be used with SELECT, INSERT, UPDATE, or DELETE statment.
 * 
 * "int result = executeUpdate(String SQL)" - returns the number of rows affected by the execution of the SQL statement. 
 * Use this method to execute SQL statements, for which you expect to get a number of rows affected - for example, 
 * an INSERT, UPDATE, or DELETE statement.
 * 
 * "boolean result = execute(String SQL)" - Returns a boolean value of true if a ResultSet object can be retrieved; otherwise, 
 * it returns false. Use this method to execute SQL DDL statements or when you need to use the truly dynamic SQL.
 */

public class App {

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
		
		/* CONNECTION TO MySQL DB
		 * String jdbcUrl = "jdbc:postgresql://<hostAddress>:<port>/<dbName>";
		 * String username = "username";
		 * String password = "password";
		*/		
		
		/* CONNECTION TO MySQL DB
		 * String jdbcUrl = "jdbc:mysql://<hostAddress>:<port>/<dbName>";
		 * String username = "username";
		 * String password = "password";
		*/		
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/sakila";
		String username = "root";
		String password = "javau7";
		
		
		/* OUTPUT
		 * Result: true
		 */
		executeSELECT(jdbcUrl, username, password);
		// <OR>
		boolean isSelectTrue = executeSELECT(jdbcUrl, username, password);
		System.out.println("Result: " + isSelectTrue);
		
		
		/* OUTPUT
		 * Result: false
		 */
		executeUPDATE(jdbcUrl, username, password);
		// <OR>
		boolean isSelectFalse = executeUPDATE(jdbcUrl, username, password);
		System.out.println("Result: " + isSelectFalse);
		
		
		/* OUTPUT
		 * Rows updated: 1
		 * IF NO ROWS WERE UPDATED OUTPUT
		 * Rows updated: 0
		 */
		executeUpdate(jdbcUrl, username, password);
		// <OR>
		int updatedRowCount = executeUpdate(jdbcUrl, username, password);
		System.out.println("Rows updated: " + updatedRowCount);

		
		/* OUTPUT 
		 * Movie info: <--- 
		 * title: ALIEN CENTER 
		 * length: 46 min.
		 */
		executeQuerySUBQUERY(jdbcUrl, username, password);

		
		/* OUTPUT 
		 * Special Features Counter: <--- 
		 * Spacial Features: Deleted Scenes,
		 * Behind the Scenes Count: 71
		 */
		executeQueryGROUPBY(jdbcUrl, username, password);

		
		/* OUTPUT 
		 * Rent info: <--- 
		 * First name: PENNY 
		 * Last name: NEAL Movie 
		 * title: ACE GOLDFINGER
		 */
		executeQueryJOIN(jdbcUrl, username, password);

		
		/* OUTPUT 
		 * Movie info: <--- 
		 * title: AFRICAN EGG 
		 * description: A Fast-Paced Documentary of a Pastry Chef And a Dentist who must Pursue a Forensic
		 * Psychologist in The Gulf of Mexico 
		 * length: 130 min. 
		 * year: 2006 y. rating: G
		 */
		executeQuerySELECT(jdbcUrl, username, password);

	}
	
	private static boolean executeSELECT(String jdbcUrl, String username, String password) {
	    boolean result = false;

		try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password)){
		    String query = String.format("SELECT %s, %s " 
						+ "FROM sakila.film " 
						+ "WHERE length < (SELECT AVG(%s) FROM sakila.film) "
						+ "GROUP BY %s, %s " 
						+ "ORDER BY %s ASC " 
						+ "LIMIT 1;",
						TITLE, LENGTH, LENGTH, TITLE, LENGTH, LENGTH);
		    
            Statement statement = conn.createStatement(); // Create a statement for executing SQL queries.

            result = statement.execute(query); // Execute the provided SQL query and store the result.
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return result; // Return the boolean result indicating the success of the SQL query execution.
	}
	
	
	private static boolean executeUPDATE(String jdbcUrl, String username, String password) {
	    boolean result = false;

		try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password)){
		    String query = String.format("UPDATE sakila.film "
		                                + "SET %s=\"ACE GOLDFINGER SECOND\" "
		                                + "WHERE %s=\"ACE GOLDFINGER SECOND\";",
		                                TITLE, TITLE);
		    
            Statement statement = conn.createStatement(); // Create a statement for executing SQL queries.

            result = statement.execute(query); // Execute the provided SQL query and store the result.
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return result; // Return the boolean result indicating the success of the SQL query execution.
	}
	
	
	private static int executeUpdate(String jdbcUrl, String username, String password) {
		int result = 0;

		try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password)){
		    String query = String.format("UPDATE sakila.film "
		                                + "SET %s=\"ACE GOLDFINGER SECOND\" "
		                                + "WHERE %s=\"ACE GOLDFINGER SECOND\";",
		                                TITLE, TITLE);
		    
		    Statement statement = conn.createStatement(); // Create a statement for executing SQL queries.
		    
		    result = statement.executeUpdate(query); // Execute the SQL update query and store the number of affected rows in 'result'.
		    
		} catch (SQLException e) {
		    e.printStackTrace();
		}

		return result; // Return the number of rows affected by the SQL update query.

	}

	private static void executeQuerySUBQUERY(String jdbcUrl, String username, String password) {
		try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password)) {

			String query = String.format("SELECT %s, %s " 
							+ "FROM sakila.film " 
							+ "WHERE length < (SELECT AVG(%s) FROM sakila.film) "
							+ "GROUP BY %s, %s " 
							+ "ORDER BY %s ASC " 
							+ "LIMIT 1;",
							TITLE, LENGTH, LENGTH, TITLE, LENGTH, LENGTH);

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(query);

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

	private static void executeQueryGROUPBY(String jdbcUrl, String username, String password) {
		try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password)) {

			String query = String.format("SELECT %s, COUNT(%s) " 
							+ "FROM sakila.film " 
							+ "GROUP BY %s " 
							+ "HAVING COUNT(%s) > 70 "
							+ "ORDER BY COUNT(%s) ASC " 
							+ "LIMIT 1;",
							SPECIAL_FEATURES, SPECIAL_FEATURES, 
							SPECIAL_FEATURES, SPECIAL_FEATURES, 
							SPECIAL_FEATURES);

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(query);

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

	private static void executeQueryJOIN(String jdbcUrl, String username, String password) {
		// Try to establish a database connection
		try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password)) {

			// SQL query to select customer and movie information
			String query = String.format("SELECT %s, %s, %s " 
							+ "FROM sakila.customer "
							+ "INNER JOIN rental ON customer.customer_id = rental.customer_id "
							+ "INNER JOIN inventory ON rental.inventory_id = inventory.inventory_id "
							+ "INNER JOIN film ON inventory.film_id = film.film_id " 
							+ "LIMIT 1;",
							CUSTOMER_FIRST_NAME, CUSTOMER_LAST_NAME, FILM_TITLE);

			// Create a statement for executing the SQL query
			Statement statement = conn.createStatement();

			// Execute the SQL query and retrieve the result set
			ResultSet result = statement.executeQuery(query);

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

	private static void executeQuerySELECT(String jdbcUrl, String username, String password) {
		// Try to establish a database connection
		try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password)) {

			// SQL query to select movie information
			String query = String.format("SELECT %s, %s, %s, %s, %s " 
							+ "FROM film " 
							+ "LIMIT 1", 
							TITLE, DESCRIPTION, LENGTH, REALESE_YEAR, RATING);

			// Create a statement for executing the SQL query
			Statement statement = conn.createStatement();

			// Execute the SQL query and retrieve the result set
			ResultSet result = statement.executeQuery(query);

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
