
// Start of user code imports
package moreco.app.restservices;


import com.google.gson.Gson;
import moreco.app.daos.RecordDAO;
import moreco.app.entities.Record;
import moreco.app.entities.User;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
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
  public Response GetRecordList(@QueryParam("searchParam") String searchParam) {
    // Start of user code GetRecordList
    Gson gson = new Gson();
    return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Methods", "GET")
            .entity(gson.toJson(RecordDAO.getInstance().GetRecords(searchParam)))
            .build();
    // End of user code
  }

  @Path("CreateRecord")
  @POST
  @Produces("application/json")
  public Response CreateRecord(@FormParam("dateStart") Long dateStart, @FormParam("dateEnd") Long dateEnd, @FormParam("description") String description, @FormParam("user") String user) {
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
    return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Methods", "POST")
            .entity(gson.toJson(RecordDAO.getInstance().AddRecord(r)))
            .build();
    // End of user code
  }

  @Path("DeleteRecord/{id}")
  @GET
  @Produces("application/json")
  public Response DeleteRecord(@PathParam("id") Long id) {
    // Start of user code DeleteRecord
    Long result = RecordDAO.getInstance().RemoveRecord(id);

    Gson gson = new Gson();
    return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Methods", "POST")
            .entity(gson.toJson(result))
            .build();
    // End of user code
  }


}
