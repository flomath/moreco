
// Start of user code imports
package moreco.app.entities;


// End of user code

/**
 * class: Record
 * package: moreco.app.entities
 */
public class Record {

  private Long ID;

  private String Description;

  private Long Start;

  private Long End;

  public User user;

  public Long getID() {
    return this.ID;
  }

  public void setID(Long ID) {
    this.ID = ID;
  }

  public String getDescription() {
    return this.Description;
  }

  public void setDescription(String Description) {
    this.Description = Description;
  }

  public Long getStart() {
    return this.Start;
  }

  public void setStart(Long Start) {
    this.Start = Start;
  }

  public Long getEnd() {
    return this.End;
  }

  public void setEnd(Long End) {
    this.End = End;
  }

  public User getUser() {
    return this.user;
  }

  public void setUser(User user) {
    this.user = user;
  }


}
