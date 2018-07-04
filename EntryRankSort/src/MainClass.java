import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainClass {

	public static void main(String[] args) {
		
		//Preload the list of entries:
		List<Entry> entriesList = new ArrayList<>();
		entriesList.add(new Entry(100, "Bob", 97));
		entriesList.add(new Entry(101, "Bill", 98));
		entriesList.add(new Entry(102, "Mary", 99));
		entriesList.add(new Entry(103, "Joe", 99));
		entriesList.add(new Entry(104, "Tim", 100));
		
		
		System.out.println("Original entry list:");
		printEntryList(entriesList);
		
		System.out.println();
		
		System.out.println("Processed entry list:");
		sortAndRankEntries(entriesList);
		printEntryList(entriesList);
	}
	
	public static void printEntryList(final List<Entry> entryList) {		
		for(Entry e : entryList) {
			System.out.println(e.toString());
		}
	}
	
	//You can have a void method, which just modifies the original input
	public static void sortAndRankEntries(List<Entry> entryList) {
		
		//Collections.sort(entryList, Collections.reverseOrder()); //Sort entries in descending order by using compareTo method of Entry class
		
		Collections.sort(entryList, Collections.reverseOrder(new EntryComparator())); //Sort entries in descending order by using EntryComparator class
		
		//List of entries should now be sorted in descending order by the total score
		
		entryList.get(0).setRank(1);  //Set rank of first element to be 1

		int consecutiveTrack = 0; //How many consecutive users have the same score
		Entry prevEntry;
		Entry currentEntry;
		
		for(int i=1; i<entryList.size(); i++) {
			prevEntry = entryList.get(i-1);
			currentEntry = entryList.get(i);
			
			if(prevEntry.getTotalScore() == currentEntry.getTotalScore()) {
				//If scores of entry and previous entry are equal
				consecutiveTrack = consecutiveTrack + 1;
				currentEntry.setRank(prevEntry.getRank());
			} else {
				//If scores of entry and previous entry are not equal
				currentEntry.setRank(prevEntry.getRank() + consecutiveTrack + 1);
				consecutiveTrack = 0;
			}
		}	
	}
	
}
