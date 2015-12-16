package moreco.app;



/**
 * class: User
 * package: moreco.app
 */
public class User {

	public Long ID;

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
