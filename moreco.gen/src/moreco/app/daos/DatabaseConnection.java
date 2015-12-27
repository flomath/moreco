
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

  public Connection conn;
  private Statement statement;

  private DatabaseConnection() {
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
  }

  public static DatabaseConnection getInstance() {
    if (_instance == null) {
      _instance = new DatabaseConnection();
    }

    return _instance;
  }


  public ResultSet query(String query) throws SQLException {
    statement = _instance.conn.createStatement();
    ResultSet res = statement.executeQuery(query);
    return res;
  }

  public void insert(String query) throws SQLException {
    statement = _instance.conn.createStatement();
    int result = statement.executeUpdate(query);
  }


}
