import java.util.Comparator;

public class EntryComparator implements Comparator<Entry> {

	@Override 
	public int compare(Entry e1, Entry e2) {
		
		if(e1.getTotalScore() < e2.getTotalScore()) {
			return -1;
		} else if(e1.getTotalScore() == e2.getTotalScore()) {
			return 0;
		} else {
			return 1;
		}
	}
}
