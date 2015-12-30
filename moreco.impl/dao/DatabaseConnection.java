
// Start of user code imports
package moreco.app.daos;


import java.sql.*;
// End of user code

/**
 * DAO: DatabaseConnection
 * package: moreco.app.daos
 */
public class DatabaseConnection {

  private static DatabaseConnection _instance;

  // Start of user code variables
  private Connection conn;
  private Statement statement;
  // End of user code

  private DatabaseConnection() {
    // Start of user code DatabaseConnection
    String url= "jdbc:mysql://localhost:3306/";
    String dbName = "moreco";
    String driver = "com.mysql.jdbc.Driver";
    String userName = "root";
    String password = "";
    try {
      Class.forName(driver).newInstance();
      this.conn = (Connection)DriverManager.getConnection(url+dbName,userName,password);
    }
    catch (Exception sqle) {
      sqle.printStackTrace();
    }
    // End of user code
  }

  public static DatabaseConnection getInstance() {
    if (_instance == null) {
      _instance = new DatabaseConnection();
    }

    return _instance;
  }


  public PreparedStatement query(String query) throws SQLException {
    // Start of user code query
    PreparedStatement statement = _instance.conn.prepareStatement(query, Statement.KEEP_CURRENT_RESULT);
    return statement;
    // End of user code
  }

  public PreparedStatement insert(String query) throws SQLException {
    // Start of user code insert
    PreparedStatement statement = _instance.conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
    return statement;
    // End of user code
  }


}
