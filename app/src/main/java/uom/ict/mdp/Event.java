package uom.ict.mdp;

import java.util.Date;

/**
 * Event class. Represents a real life future event.
 */
public class Event implements Comparable<Event> {

    private String id;
    private int icon;
    private String name;
    private String description;
	private String category;
    private String time;
    private String endTime;
    private EventAgeType ageType;
    private String location;
    private float xCoordinates;
    private float yCoordinates;
	private String mainEventID;


	/**
	 * Default Contructor
	 */
	public Event() {
		this(null, R.drawable.ziguzajg, "", "", "", "", "15:30", "17:00", EventAgeType.ADULT, 0, 0);
	}

    /**
     * Full Constructor WITHOUT Description.
     * Used to show Events necessary
     */
    public Event(String id, int icon, String name, String location, String time, String endTime, EventAgeType ageType, float xCoor, float yCoor) {
		this(id , icon, name, "", location, time, endTime, ageType, xCoor, yCoor);
    }

    /**
     *  Full Constructor WITH Description and location coordinates
     * @param icon Icon of event
     * @param name The event name
     * @param description Description of the Event
     * @param time The start time of the event
     * @param endTime The time when event finishes
     * @param ageType The EventAgeType enum for the event's age type
     * @param location The location of the event
     * @param xCoor The x-coordinates on the map
     * @param yCoor The y-coordinates on the map
     *
     */
    public Event(String id, int icon, String name, String description, String location, String time, String endTime, EventAgeType ageType, float xCoor, float yCoor) {
        this(id , icon, name, description, "", location, time, endTime, ageType, xCoor, yCoor);
    }

	/**
	 *  Full Constructor WITH Description and location coordinates
	 * @param icon Icon of event
	 * @param name The event name
	 * @param description Description of the Event
	 * @param time The start time of the event
	 * @param endTime The time when event finishes
	 * @param ageType The EventAgeType enum for the event's age type
	 * @param location The location of the event
	 * @param xCoor The x-coordinates on the map
	 * @param yCoor The y-coordinates on the map
	 *
	 */
	public Event(String id, int icon, String name, String description, String category, String location, String time, String endTime, EventAgeType ageType, float xCoor, float yCoor) {
		this.id = id;
		this.icon = icon;
		this.name = name;
		this.description = description;
		this.category = category;
		this.time = time;
		this.endTime = endTime;
		this.ageType = ageType;
		this.location = location;
		this.xCoordinates = xCoor;
		this.yCoordinates = yCoor;
	}

    /**
     * Copy Constructor
     *
     * @param other The other event to copy.
     */
    public Event(Event other) {
        this.id = new String(other.id);
        this.icon = new Integer(other.icon);
        this.name = new String(other.name);
        this.time = new String (other.time);
		this.category = new String(other.category);
        this.endTime = new String (other.endTime);
        this.ageType = other.ageType;
        this.location = new String(other.location);
        this.description = new String(other.description);
        this.xCoordinates = new Float(other.xCoordinates);
        this.yCoordinates = new Float(other.yCoordinates);
    }

	public String getMainEventId() {
		return mainEventID;
	}

	public void setMainEventId(String id) {
		this.mainEventID = id;
	}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIcon() { return icon; }

    public void setIcon(int icon) { this.icon = icon; }

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

    public String getTime() { return time; }

    public void setTime(String time) {this.time = time;}

    public String getEndTime() {return endTime;}

    public void setEndTime(String endTime) {this.endTime = endTime;}

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

    public float getxCoordinates() {return xCoordinates;}

    public void setxCoordinates(float xCoordinates) {this.xCoordinates = xCoordinates;}

    public float  getyCoordinates() {return yCoordinates;}

    public void setyCoordinates(float yCoordinates) {this.yCoordinates = yCoordinates;}

	public String getCategory() { return this.category; }

	public void setCategory(String category) { this.category = category; }

	public long getTimeMillis() {
		int colon = time.indexOf(':');
		int hours = Integer.parseInt( time.substring(0, colon) );
		if (hours == 0) hours = 24;
		int mins = Integer.parseInt( time.substring(colon+1) );
		return ((hours * 60) + mins) * 60 * 1000;
	}

	public Date getTimeDate() {
		Date date = new Date();
		date.setTime(getTimeMillis());
		return date;
	}

    @Override
    public int compareTo(Event other) {
        return this.name.compareTo(other.getName());
    }

    @Override
    public String toString() {
        return name + " @" + time.toString() + ", " + endTime.toString() + ", " + location + " (" + ageType.toString() + ")" +
                "\n" + description;
    }

}
