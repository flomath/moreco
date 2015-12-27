
// Start of user code imports
package moreco.app.daos;

import moreco.app.entities.Record;
import org.jboss.weld.util.collections.ArraySet;

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
    if(record != null) {
      try {
        DatabaseConnection.getInstance().insert(
                "insert into record (description, start, end, user) values ('" + record.getDescription() + "', '" + record.getStart() + "', '" +
                        record.getEnd() + "', '"+record.getUser().getUsername() + "')"
        );
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    return record;
  }

  public void RemoveRecord(Long id) {
    // Start of user code RemoveRecord
    // TODO implement RemoveRecord
    throw new UnsupportedOperationException("Method not yet implemented");
    // End of user code
  }

  public java.util.Set<Record> GetRecords(String searchParam) {
    java.util.Set<Record> recordSet = new ArraySet<Record>();

    try {

      ResultSet rs = DatabaseConnection.getInstance().query("select * from record");

      while (rs.next()) {
        Record r = new Record();
        r.setDescription(rs.getString("description"));
        r.setID(rs.getLong("id"));
        r.setStart(rs.getLong("start"));
        r.setEnd(rs.getLong("end"));
        recordSet.add(r);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return recordSet;
  }


}
