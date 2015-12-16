
// Start of user code imports
package moreco.app.restservices;


import javax.ws.rs.*;
// End of user code

/**
 * RestService: TimeTrackerService
 * package: moreco.app.restservices
 */
@Path("moreco/")
public class TimeTrackerService {

  @Path("getRecordList")
  @GET
  @Produces("application/json")
  public String GetRecordList(String searchParam) {
    // Start of user code GetRecordList        
    // TODO implement GetRecordList
    throw new UnsupportedOperationException("Method not yet implemented");
    // End of user code 
  }

  @Path("CreateRecord")
  @POST
  @Produces("application/json")
  public String CreateRecord(Long dateStart, Long dateEnd, String description, String user) {
    // Start of user code CreateRecord        
    // TODO implement CreateRecord
    throw new UnsupportedOperationException("Method not yet implemented");
    // End of user code 
  }

  @Path("DeleteRecord")
  @GET
  @Produces("application/json")
  public void DeleteRecord(Long id) {
    // Start of user code DeleteRecord        
    // TODO implement DeleteRecord
    throw new UnsupportedOperationException("Method not yet implemented");
    // End of user code 
  }


}
