package moreco.app;

import java.sql.Date;

/**
 * class: User
 * package: moreco.app
 */
public class User {

	public long ID;

	private String Username;

	private String Password;

	public long getID(){
		return this.ID;
	}

	public void setID(long ID){
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
