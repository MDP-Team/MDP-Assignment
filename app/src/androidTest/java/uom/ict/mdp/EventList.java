package uom.ict.mdp;

import java.util.ArrayList;

/**
 * List of events. Inherits from EventList
 */
public class EventList extends ArrayList<Event> {

	/**
	 * Sorts the list by event times
	 */
	public void sortByTime() {}

	/**
	 * Sorts the list by event names
	 */
	public void sortByName() {}

	/**
	 * Sorts the list showing adult events first, child events second.
	 */
	public void sortByAgeType() {}

}
