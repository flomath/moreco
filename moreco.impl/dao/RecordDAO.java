
// Start of user code imports
package moreco.app.daos;

import moreco.app.entities.Record;

import java.sql.ResultSet;
import java.sql.SQLException;

// End of user code

/**
 * DAO: RecordDAO
 * package: moreco.app.daos
 */
public class RecordDAO {

  private static RecordDAO _instance;

  private RecordDAO() {}

  public static RecordDAO getInstance() {
    if (_instance == null) {
      _instance = new RecordDAO();
    }

    return _instance;
  }




  public Record AddRecord(Record record) {
    // Start of user code AddRecord
    // TODO implement AddRecord
    throw new UnsupportedOperationException("Method not yet implemented");
    // End of user code
  }

  public void RemoveRecord(Long id) {
    // Start of user code RemoveRecord
    // TODO implement RemoveRecord
    throw new UnsupportedOperationException("Method not yet implemented");
    // End of user code
  }

  public Record GetRecords(String searchParam) {
    Record r = null;

    try {

      ResultSet rs = DatabaseConnection.getInstance().query("select * from record");

      while (rs.next()) {
        r = new Record();
        r.setDescription(rs.getString("description"));
        r.setID(rs.getLong("id"));
        r.setStart(rs.getLong("start"));
        r.setEnd(rs.getLong("end"));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return r;
  }


}
