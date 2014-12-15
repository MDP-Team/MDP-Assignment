package uom.ict.mdp;

import java.util.Date;

/**
 * Event class. Represents a real life future event.
 */
public class Events implements Comparable<Events> {

    private int icon;
    private String name;
    private String description;
    private String time;
    private String endTime;
    private EventAgeType ageType;
    private String location;
    private double xCoordinates;
    private double yCoordinates;


    /**
     * Full Constructor WITHOUT Description.
     * Used to show Events necessary
     *
     * @param icon Icon of event
     * @param name The event name
     * @param time The start time of the event
     * @param endTime The time when event finishes
     * @param ageType The EventAgeType enum for the event's age type
     * @param location The location of the event (Street Name)

     *
     */
    public Events(int icon, String name, String location, String time, String endTime, EventAgeType ageType ) {
        this.icon = icon;
        this.name = name;
        this.location = location;
        this.time = time;
        this.endTime= endTime;
        this.ageType = ageType;
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
    public Events(int icon, String name, String description, String time, String endTime, EventAgeType ageType, String location, double xCoor, double yCoor ) {
        this.icon = icon;
        this.name = name;
        this.description = description;
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
    public Events(Events other) {
        this.icon = new Integer(other.icon);
        this.name = new String(other.name);
        this.time = new String (other.time);
        this.endTime = new String (other.endTime);
        this.ageType = other.ageType;
        this.location = new String(other.location);
        this.description = new String(this.description);
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

    public double getxCoordinates() {return xCoordinates;}

    public void setxCoordinates(float xCoordinates) {this.xCoordinates = xCoordinates;}

    public double  getyCoordinates() {return yCoordinates;}

    public void setyCoordinates(float yCoordinates) {this.yCoordinates = yCoordinates;}

    @Override
    public int compareTo(Events other) {
        return this.name.compareTo(other.getName());
    }

    @Override
    public String toString() {
        return name + " @" + time.toString() + ", " + endTime.toString() + ", " + location + " (" + ageType.toString() + ")" +
                "\n" + description;
    }

}
