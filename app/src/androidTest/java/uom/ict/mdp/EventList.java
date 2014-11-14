package uom.ict.mdp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

/**
 * List of events. Inherits from EventList
 */
public class EventList extends ArrayList<Event> {

	/**
	 * Calculates and returns the last position of the last event that is due in the next 15
	 * minutes. This can be used to identify where a separator is to be shown in the event list.
	 *
	 * @todo Need to test, and confirm how future date creation is done.
	 *
	 * @return The index where the events that are due in the next 15 minutes end.
	 */
	public int getUpcomingEvents() {
		int i = 0;
		Date fifteenMinutesFromNow = new Date();
		fifteenMinutesFromNow.setTime((new Date()).getTime() + (15 * 60 * 1000));
		for (Event e: this) {
			if (e.getDate().after(fifteenMinutesFromNow)) {
				break;
			}
			i++;
		}
		return i;
	}

	/**
	 * Sorts the list by event times
	 */
	public void sortByTime() {
		Collections.sort(this, new EventTimeComparator());
	}

	/**
	 * Sorts the list by event names
	 */
	public void sortByName() {
		// This will use the compareTo() method in the Event class, since it
		// implements the Comparable interface.
		Collections.sort(this);
	}

	/**
	 * Sorts the list showing adult events first, child events second.
	 */
	public void sortByAgeType() {
		Collections.sort(this, new EventAgeTypeComparator());
	}


	/**
	 * Comparator for Events according to their event time.
	 */
	private static class EventTimeComparator implements Comparator<Event> {
		@Override
		public int compare(Event event, Event event2) {
			// Transfer comparing task to the compareTo method of the Date class
			return event.getDate().compareTo(event2.getDate());
		}
	}

	/**
	 * Comparator for Events according to their targetted age type.
	 */
	private static class EventAgeTypeComparator implements Comparator<Event> {
		@Override
		public int compare(Event event, Event event2) {
			// Get the enum ordinals
			int ordinal1 = event.getAgeType().ordinal();
			int ordinal2 = event2.getAgeType().ordinal();
			// Return 1 if first is greater than second, -1 if smaller, 0 if equal.
			if (ordinal1 > ordinal2) return 1;
			else if (ordinal1 < ordinal2) return -1;
			else return 0;
		}
	}

}
