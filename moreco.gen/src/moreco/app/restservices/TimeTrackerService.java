
// Start of user code imports
package moreco.app.restservices;


import javax.ws.rs.*;
// End of user code

/**
 * RestService: TimeTrackerService
 * package: moreco.app.restservices
 */
@Path("moreco")
public class TimeTrackerService {

  @Path("GetRecordList")
  @GET
  @Produces("application/json")
  public String GetRecordList(@QueryParam("searchParam") String searchParam) {
    // Start of user code GetRecordList        
    // TODO implement GetRecordList
    return "test";
    //throw new UnsupportedOperationException("Method not yet implemented");
    // End of user code 
  }

  @Path("CreateRecord")
  @POST
  @Produces("application/json")
  public String CreateRecord(@QueryParam("dateStart") Long dateStart, @QueryParam("dateEnd") Long dateEnd, @QueryParam("description") String description, @QueryParam("user") String user) {
    // Start of user code CreateRecord        
    // TODO implement CreateRecord
    throw new UnsupportedOperationException("Method not yet implemented");
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
