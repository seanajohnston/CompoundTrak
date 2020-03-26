 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
/**
 *
 * @author sqlitetutorial.net
 *
 * @modified by Sean Johnston
 *
 */
public class Connect {
     /**
     * Connect to a sample database
     */
    public static Connection getConnection() {
	DbBuilder.build();
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:ctrak.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

	return conn;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        getConnection();
    }
}
