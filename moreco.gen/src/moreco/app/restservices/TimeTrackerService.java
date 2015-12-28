
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
    Gson gson = new Gson();
    return gson.toJson(RecordDAO.getInstance().GetRecords(searchParam));
    // End of user code 
  }

  @Path("CreateRecord")
  @POST
  @Produces("application/json")
  public String CreateRecord(@FormParam("dateStart") Long dateStart, @FormParam("dateEnd") Long dateEnd, @FormParam("description") String description, @FormParam("user") String user) {
    // Start of user code CreateRecord        
    Record r = new Record();
    r.setStart(dateStart);
    r.setEnd(dateEnd);
    r.setDescription(description);

    // set user
    User u = new User();
    u.setUsername(user);
    r.setUser(u);

    Gson gson = new Gson();
    return gson.toJson(RecordDAO.getInstance().AddRecord(r));
    // End of user code 
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
