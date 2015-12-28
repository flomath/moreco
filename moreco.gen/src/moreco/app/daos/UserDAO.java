
// Start of user code imports
package moreco.app.daos;

import moreco.app.entities.User;
import org.jboss.weld.util.collections.ArraySet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// End of user code

/**
 * DAO: UserDAO
 * package: moreco.app.daos
 */
public class UserDAO {

  private static UserDAO _instance;

  // Start of user code variables
  // End of user code 

  private UserDAO() {    
    // Start of user code UserDAO
    // End of user code 
  }

  public static UserDAO getInstance() {
    if (_instance == null) {
      _instance = new UserDAO();
    }

    return _instance;
  }




  public User AddUser(User user) {
    // Start of user code AddUser        
    if(user != null) {
      try {
        PreparedStatement statement = DatabaseConnection.getInstance().insert("insert into user (username) values (?)");
        statement.setString(1, user.getUsername());
        long id = statement.executeUpdate();

        user.setID(id);

        statement.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    return user;
    // End of user code 
  }

  public java.util.Set<User> GetUsers() {
    // Start of user code GetUsers
    java.util.Set<User> userSet = new ArraySet<User>();

    try {
      PreparedStatement statement = DatabaseConnection.getInstance().query("select * from user");
      ResultSet rs = statement.executeQuery();

      while (rs.next()) {
        User u = new User();
        u.setID(rs.getLong("id"));
        u.setUsername(rs.getString("username"));
        userSet.add(u);
      }

      statement.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return userSet;
    // End of user code 
  }

  public User GetUser(User user) {
    // Start of user code GetUser
    if (user != null) {
      try {
        PreparedStatement statement = DatabaseConnection.getInstance().query("select * from user where username = ?");
        statement.setString(1, user.getUsername());

        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
          user = new User();
          user.setID(rs.getLong("id"));
          user.setUsername(rs.getString("username"));
        }

        statement.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    return user;
    // End of user code 
  }


}
