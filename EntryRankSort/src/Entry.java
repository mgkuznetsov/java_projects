
public class Entry implements Comparable<Entry> {

	private int index;
	private String name;
	private int totalScore;
	private int rank; //if rank is -1, it means it's not calculated yet
	
	public Entry(final int index, final String name, final int totalScore) {
		this.index = index;
		this.name = name;
		this.totalScore = totalScore;
		this.rank = -1;
	}
	
	public int getTotalScore() {
		return totalScore;
	}
	
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public int getRank() {
		return rank;
	}
	
	@Override
	public String toString() {
		return "Entry: " + this.index + ", Name: " + this.name + ", Score: "+ this.totalScore + ", Rank: " + this.rank;
	}
	
	@Override
	public int compareTo(Entry otherEntry) {
				
		if(this.getTotalScore() < otherEntry.getTotalScore()) {
			return -1;
		} else if(this.getTotalScore() == otherEntry.getTotalScore()) {
			return 0;
		} else {
			return 1;
		}
	}
	
	//If we did not parametrize the class with Entry, we would need to do this:
//	@Override
//	public int compareTo(Object otherEntryObject) {
//		
//		final Entry otherEntry = (Entry)otherEntryObject;
//		
//		if(this.getTotalScore() < otherEntry.getTotalScore()) {
//			return -1;
//		} else if(this.getTotalScore() == otherEntry.getTotalScore()) {
//			return 0;
//		} else {
//			return 1;
//		}
//	}
	
}
