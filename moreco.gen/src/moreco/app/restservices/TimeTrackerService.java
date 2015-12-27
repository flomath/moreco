
// Start of user code imports
package moreco.app.restservices;


import com.google.gson.Gson;
import moreco.app.daos.RecordDAO;
import moreco.app.entities.Record;
import moreco.app.entities.User;

import javax.ws.rs.*;
// End of user code

/**
 * RestService: TimeTrackerService
 * package: moreco.app.restservices
 */
@Path("moreco/api/")
public class TimeTrackerService {

  @Path("GetRecordList")
  @GET
  @Produces("application/json")
  public String GetRecordList(@QueryParam("searchParam") String searchParam) {
    // Start of user code GetRecordList        
    // TODO implement GetRecordList

    RecordDAO records = RecordDAO.getInstance();
    Gson gson = new Gson();

    return gson.toJson(records.GetRecords(""));

    //throw new UnsupportedOperationException("Method not yet implemented");
    // End of user code 
  }

  @Path("CreateRecord")
  @GET
  @Produces("application/json")
  public String CreateRecord(@QueryParam("dateStart") Long dateStart, @QueryParam("dateEnd") Long dateEnd, @QueryParam("description") String description, @QueryParam("user") String user) {

    Record r = new Record();
    r.setStart(dateStart);
    r.setEnd(dateEnd);
    r.setDescription(description);

    // TODO !
    User u = new User();
    u.setUsername(user);
    r.setUser(u);

    RecordDAO records = RecordDAO.getInstance();

    Gson gson = new Gson();
    return gson.toJson(records.AddRecord(r));
  }

  @Path("DeleteRecord/{id}")
  @GET
  @Produces("application/json")
  public void DeleteRecord(@PathParam("id") Long id) {
    // Start of user code DeleteRecord        
    // TODO implement DeleteRecord
    throw new UnsupportedOperationException("Method not yet implemented");
    // End of user code 
  }


}
