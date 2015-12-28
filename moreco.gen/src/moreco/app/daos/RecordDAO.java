
// Start of user code imports
package moreco.app.daos;

import moreco.app.entities.Record;
import moreco.app.entities.User;
import org.jboss.weld.util.collections.ArraySet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;

// End of user code

/**
 * DAO: RecordDAO
 * package: moreco.app.daos
 */
public class RecordDAO {

  private static RecordDAO _instance;

  // Start of user code variables
  // End of user code 

  private RecordDAO() {    
    // Start of user code RecordDAO
    // End of user code 
  }

  public static RecordDAO getInstance() {
    if (_instance == null) {
      _instance = new RecordDAO();
    }

    return _instance;
  }




  public Record AddRecord(Record record) {
    // Start of user code AddRecord
    if(record != null) {
      User user = UserDAO.getInstance().GetUser(record.getUser());
      if (user == null) {
        user = UserDAO.getInstance().AddUser(record.getUser());
        record.setUser(user);
      }
      record.setUser(user);

      try {
        PreparedStatement statement = DatabaseConnection.getInstance().insert("insert into record (description, start, end, user) values (?, ?, ?, ?)");
        statement.setString(1, record.getDescription());
        statement.setTimestamp(2, new Timestamp(record.getStart()));
        statement.setTimestamp(3, new Timestamp(record.getEnd()));
        statement.setLong(4, record.getUser().getID());
        long id = statement.executeUpdate();
        record.setID(id);

        statement.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    return record;
    // End of user code 
  }

  public void RemoveRecord(Long id) {
    // Start of user code RemoveRecord        
    // TODO implement RemoveRecord
    throw new UnsupportedOperationException("Method not yet implemented");
    // End of user code 
  }

  public java.util.Set<Record> GetRecords(String searchParam) {
    // Start of user code GetRecords
    java.util.Set<Record> recordSet = new ArraySet<Record>();

    // get all users
    java.util.Set<User> userSet = UserDAO.getInstance().GetUsers();
    HashMap<Long, User> users = new HashMap<Long, User>();
    for (User user : userSet) {
      users.put(user.getID(), user);
    }

    try {
      String query = "select * from record";
      if (searchParam != null) {
        query += " where description = ?";
      }
      PreparedStatement statement = DatabaseConnection.getInstance().query(query);

      if (searchParam != null) {
        statement.setString(1, searchParam);
      }

      ResultSet rs = statement.executeQuery();

      while (rs.next()) {
        Record r = new Record();
        r.setDescription(rs.getString("description"));
        r.setID(rs.getLong("id"));
        r.setStart(rs.getLong("start"));
        r.setEnd(rs.getLong("end"));
        r.setUser(users.get(rs.getLong("user")));
        recordSet.add(r);
      }

      statement.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return recordSet;
    // End of user code 
  }


}
