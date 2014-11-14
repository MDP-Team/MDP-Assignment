package uom.ict.mdp;

/**
 * Event classification for people ages.
 */
public enum EventAgeType {
	GENERAL("General Audience"),
	ADULT("Adults"),
	CHILD("Children");

	private String friendlyName;
	private EventAgeType(String friendlyName) {
		this.friendlyName = friendlyName;
	}

	@Override
	public String toString() {
		return this.friendlyName;
	}
}
