
// Start of user code imports
package moreco.app.entities;


// End of user code

/**
 * class: User
 * package: moreco.app.entities
 */
public class User {

  private Long ID;

  private String Username;

  private String Password;

  public Long getID(){
    return this.ID;
  }

  public void setID(Long ID){
    this.ID = ID;
  }

  public String getUsername(){
    return this.Username;
  }

  public void setUsername(String Username){
    this.Username = Username;
  }

  public String getPassword(){
    return this.Password;
  }

  public void setPassword(String Password){
    this.Password = Password;
  }


}