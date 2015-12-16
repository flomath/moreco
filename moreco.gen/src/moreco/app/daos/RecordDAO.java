
// Start of user code imports
package moreco.app.daos;

import moreco.app.entities.Record;
import moreco.app.daos.RecordDAO;

// End of user code

/**
 * DAO: RecordDAO
 * package: moreco.app.daos
 */
public class RecordDAO {

  private String DB_HOST;

  private String DB_USER;

  private String DB_PASSWORD;

  private String DB_NAME;

  private static RecordDAO Instance;

  public String getDB_HOST(){
    return this.DB_HOST;
  }

  public void setDB_HOST(String DB_HOST){
    this.DB_HOST = DB_HOST;
  }

  public String getDB_USER(){
    return this.DB_USER;
  }

  public void setDB_USER(String DB_USER){
    this.DB_USER = DB_USER;
  }

  public String getDB_PASSWORD(){
    return this.DB_PASSWORD;
  }

  public void setDB_PASSWORD(String DB_PASSWORD){
    this.DB_PASSWORD = DB_PASSWORD;
  }

  public String getDB_NAME(){
    return this.DB_NAME;
  }

  public void setDB_NAME(String DB_NAME){
    this.DB_NAME = DB_NAME;
  }

  public RecordDAO getInstance(){
    return this.Instance;
  }

  public void setInstance(RecordDAO Instance){
    this.Instance = Instance;
  }


  public Record AddRecord(Record record) {
    // Start of user code AddRecord        
    // TODO implement AddRecord
    throw new UnsupportedOperationException("Method not yet implemented");
    // End of user code 
  }

  public void RemoveRecord(Record record) {
    // Start of user code RemoveRecord        
    // TODO implement RemoveRecord
    throw new UnsupportedOperationException("Method not yet implemented");
    // End of user code 
  }

  public static RecordDAO GetInstance() {
    // Start of user code GetInstance        
    // TODO implement GetInstance
    throw new UnsupportedOperationException("Method not yet implemented");
    // End of user code 
  }

  public Record GetRecords(String searchParam) {
    // Start of user code GetRecords        
    // TODO implement GetRecords
    throw new UnsupportedOperationException("Method not yet implemented");
    // End of user code 
  }


}
