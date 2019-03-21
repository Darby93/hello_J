import java.util.ArrayList;
import java.util.List;

public class Hotel {
	List<Room[]> rooms = new ArrayList<Room[]>();
	List<List<Room>> rooms1 = new ArrayList<List<Room>>();
	
	void test() {
		rooms.add(new Room[] {new Room(5)});
		rooms1.add(0, new ArrayList<Room>());
		
		for (int i = 0; i < rooms1.size(); i++) {
			System.out.println(rooms1.get(i).add(new Room(5)));
		}
	}

}
