import java.util.LinkedList;

public class CircularQueue {

	private static void completeCircle(LinkedList<Location> list) {
		Location start = list.getFirst();
		Location end = list.getFirst();
		int balanceCapacity = 0;
		while(start != null) {
			if((end.capacity + balanceCapacity) - end.distance >= 0) {
				balanceCapacity = (end.capacity + balanceCapacity) - end.distance;
				end = end != list.getLast() ? list.get(list.indexOf(end)+1) : list.getFirst();
				if(end == start) {
					System.out.println("Node -> "+list.indexOf(start));
					System.out.println("Node Capacity -> "+start.capacity);
					break;
				}
			} else {
				if(start == list.getLast()) {
					start = null;
				} else {
					start = end = list.get(list.indexOf(start)+1);
					balanceCapacity = 0;	
				}
			}
		}
	}

	public static void main(String args[]) throws Exception {
		Location location1 = new Location(4,6);
		Location location2 = new Location(6,5);
		Location location3 = new Location(7,3);
		Location location4 = new Location(4,5);

		Location location5 = new Location(6,4);
		Location location6 = new Location(3,6);
		Location location7 = new Location(7,3);
		LinkedList<Location> list = new LinkedList<Location>();
		// list.add(0,location1);
		// list.add(1,location2);
		// list.add(2,location3);
		// list.add(3,location4);

		list.add(0,location5);
		list.add(1,location6);
		list.add(2,location7);
		completeCircle(list);
	}
}

class Location {
	int distance;
	int capacity;

	Location(int capacity, int distance) {
		this.distance = distance;
		this.capacity = capacity;
	}
}
