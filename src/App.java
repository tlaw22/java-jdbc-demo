import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/employees_database?";
        try {
            // Establish the connection object
            Connection connection = DriverManager.getConnection(url, "root", "yourPasswordHere");
            // Create a statement object to execute the SQL statement.
            Statement statement = connection.createStatement();
            // Execute the SQL statement to send to the server.
            ResultSet resultsSet = statement.executeQuery("SELECT * FROM employees_tbl");
            // Process the result set.
            int total = 0;
            while (resultsSet.next()) {
                System.out.println(resultsSet.getString("name"));
                total += resultsSet.getInt("salary");
                
            }
            System.out.println(total);

        } catch (SQLException e) {
            System.out.println("Unable to connect to the database");
            e.printStackTrace();
        }
    }
}
