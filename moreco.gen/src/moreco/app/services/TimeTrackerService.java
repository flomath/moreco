package moreco.app.services;

import javax.ws.rs.*;

/**
 * RestService: TimeTrackerService
 * package: moreco.app.services
 */
@Path("moreco/")
public class TimeTrackerService {

	@Path("getRecordList")
	@GET
	@Produces("application/json")
	public String GetRecordList(String searchParam){
		// Start of user code operation        
		// TODO implement DeleteRecord
        throw new UnsupportedOperationException("Method not yet implemented");
        // End of user code 
	}

	@Path("CreateRecord")
	@POST
	@Produces("application/json")
	public String CreateRecord(Long dateStart, Long dateEnd, String description, String user){
		// Start of user code operation        
		// TODO implement CreateRecord
        throw new UnsupportedOperationException("Method not yet implemented");
        // End of user code 
	}

	@Path("DeleteRecord")
	@GET
	@Produces("application/json")
	public void DeleteRecord(String id){
		// Start of user code operation        
		// TODO implement DeleteRecord
        throw new UnsupportedOperationException("Method not yet implemented");
        // End of user code 
	}

}
