package uom.ict.mdp;

import java.util.Date;

/**
 * Event class. Represents a real life future event.
 */
public class Event implements Comparable<Event> {

	private String name;
	private String description;
	private Date date;
	private EventAgeType ageType;
	private String location;

	/**
	 * Full Constructor
	 *
	 * @param name The event name
	 * @param date The date of the event
	 * @param ageType The EventAgeType enum for the event's age type
	 * @param location The location of the event
	 */
	public Event(String name, Date date, EventAgeType ageType, String location) {
		this.name = name;
		this.date = date;
		this.ageType = ageType;
		this.location = location;
	}

	/**
	 * Copy Constructor
	 *
	 * @param other The other event to copy.
	 */
	public Event(Event other) {
		this.name = new String(other.name);
		this.date = (Date)other.date.clone();
		this.ageType = other.ageType;
		this.location = new String(other.location);
		this.description = new String(this.description);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String desc) {
		this.description = desc;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public EventAgeType getAgeType() {
		return ageType;
	}

	public void setAgeType(EventAgeType ageType) {
		this.ageType = ageType;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public int compareTo(Event other) {
		return this.name.compareTo(other.getName());
	}

	@Override
	public String toString() {
		return name + " @" + date.toString() + ", " + location + " (" + ageType.toString() + ")" +
		"\n" + description;
	}

}
