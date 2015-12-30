
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
      }
      record.setUser(user);

      try {
        PreparedStatement statement = DatabaseConnection.getInstance().insert("insert into record (description, start, end, user) values (?, ?, ?, ?)");
        statement.setString(1, record.getDescription());
        statement.setTimestamp(2, new Timestamp(record.getStart()));
        statement.setTimestamp(3, new Timestamp(record.getEnd()));
        statement.setLong(4, record.getUser().getID());
        statement.executeUpdate();

        ResultSet rs = statement.getGeneratedKeys();
        if (rs.next()) {
          record.setID(rs.getLong(1));
        } else {
          record = null;
        }

        rs.close();
        statement.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    return record;
    // End of user code
  }

  public Long RemoveRecord(Long id) {
    // Start of user code RemoveRecord
    long result = 0;

    if (id > 0) {
      try {
        String query = "delete from record where id = ?";
        PreparedStatement statement = DatabaseConnection.getInstance().query(query);
        statement.setLong(1, id);

        statement.execute();
        result = 1;

        statement.close();
      } catch (SQLException e) {
        e.printStackTrace();
        result = 0;
      }
    }

    return result;
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
        query += " where description LIKE ?";
      }
      PreparedStatement statement = DatabaseConnection.getInstance().query(query);

      if (searchParam != null) {
        statement.setString(1, "%" + searchParam + "%");
      }

      ResultSet rs = statement.executeQuery();

      while (rs.next()) {
        Record r = new Record();
        r.setDescription(rs.getString("description"));
        r.setID(rs.getLong("id"));
        r.setStart(rs.getTimestamp("start").getTime());
        r.setEnd(rs.getTimestamp("end").getTime());
        r.setUser(users.get(rs.getLong("user")));
        recordSet.add(r);
      }

      rs.close();
      statement.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return recordSet;
    // End of user code
  }


}
