import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Start {

    private static final String DBURL = "jdbc:mysql://localhost:3306/newdb";
    private static final String USER = "developer";
    private static final String PASSWORD = "passwordhere";

    public static void main(String[] args) {
        Connection connection = null;
        try {

            // create a connection to the database
            connection = DriverManager.getConnection(DBURL, USER, PASSWORD);
            Statement statement = connection.createStatement();

            statement.executeUpdate("ALTER TABLE students ADD country varchar(30);");
            System.out.println("Country column has been added to students table");

            statement.executeUpdate("UPDATE students SET country = 'Italy' WHERE student_id = 1");
            statement.executeUpdate("UPDATE students SET country = 'Italy' WHERE student_id = 2");
            statement.executeUpdate("UPDATE students SET country = 'Germany' WHERE student_id = 3");
            statement.executeUpdate("UPDATE students SET country = 'Germany' WHERE student_id = 4");
            System.out.println("Students have been updated for country");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}