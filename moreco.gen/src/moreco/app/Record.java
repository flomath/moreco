package moreco.app;

import java.sql.Date;


/**
 * class: Record
 * package: moreco.app
 */
public class Record {

	private Long ID;

	private String Description;

	private Date Start;

	private Date End;

	public Long getID(){
		return this.ID;
	}

	public void setID(Long ID){
		this.ID = ID;
	}

	public String getDescription(){
		return this.Description;
	}

	public void setDescription(String Description){
		this.Description = Description;
	}

	public Date getStart(){
		return this.Start;
	}

	public void setStart(Date Start){
		this.Start = Start;
	}

	public Date getEnd(){
		return this.End;
	}

	public void setEnd(Date End){
		this.End = End;
	}

}
