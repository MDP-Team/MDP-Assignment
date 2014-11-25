package uom.ict.mdp;

import java.util.Date;

/**
 * Created by Charlene on 25/11/2014.

	This class will hold the list of ALL the events found around Malta, for e.g. Notte Biancha, Zejt iz-Zejtun.....

 */
public class ListOfActivities {

	private String eName;
	private Date eDate;
	private Date eStartTime;
	private String eLocation;
	private float eEntranceFeeAdult;
	private float eEntranceFeeChild;


	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public Date geteDate() {
		return eDate;
	}

	public void seteDate(Date eDate) {
		this.eDate = eDate;
	}

	public Date geteStartTime() {
		return eStartTime;
	}

	public void seteStartTime(Date eStartTime) {
		this.eStartTime = eStartTime;
	}

	public String geteLocation() {
		return eLocation;
	}

	public void seteLocation(String eLocation) {
		this.eLocation = eLocation;
	}

	public float geteEntranceFeeAdult() {
		return eEntranceFeeAdult;
	}

	public void seteEntranceFeeAdult(float eEntranceFeeAdult) {
		this.eEntranceFeeAdult = eEntranceFeeAdult;
	}

	public float geteEntranceFeeChild() {
		return eEntranceFeeChild;
	}

	public void seteEntranceFeeChild(float eEntranceFeeChild) {
		this.eEntranceFeeChild = eEntranceFeeChild;
	}

}
