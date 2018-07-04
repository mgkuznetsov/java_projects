import java.util.HashMap;

/**
 * Least Recently Used Cache
 * The cache holds a specific number of entries.
 * Remove the entry that was last accessed.
 * @author Admin
 *
 */
public class LRU<K, V> {
	
	private HashMap<K, Entry> hashMap = new HashMap<>();
	private int maxSize; //Maximum number of entries before the oldest entry needs to be cleared
	private Entry head;
	private Entry tail;
	
	public LRU(int maxSize) {
		this.maxSize = maxSize;
		head=null;
		tail=null;
	}
	
	private void checkAndPurgeOldestEntry() {
		if(hashMap.size() > maxSize) {
			Entry entryToRemove = tail;
			Entry tailParent = tail.prevEntry;
			//Set Tail's parent to be the new tail:
			entryToRemove.prevEntry = null;
			tail = tailParent;
			
			hashMap.remove(entryToRemove.key); //Remove entry from hashMap
		}
	}
	
	public V put(K key, V value) {
		//Make entry the new head:
		Entry newEntry = new Entry(key, value, null, head);
		
		if(hashMap.size() > 0) {
			head.prevEntry = newEntry;
		}
		
		head = newEntry;
		
		V returnVal = hashMap.put(key, head).value; //Add to hashmap
		checkAndPurgeOldestEntry(); //Remove oldest entry if necessary
		
		return returnVal;
	}
	
	public V get(K key) {
		Entry returnEntry = hashMap.get(key);		
		
		//If entry was found, make it the latest entry
		if(returnEntry != null) {
			Entry returnEntryParent = returnEntry.prevEntry;
			Entry returnEntryChild = returnEntry.nextEntry;
			returnEntryParent.nextEntry = returnEntryChild;
			returnEntryChild.prevEntry = returnEntryParent;
			
			returnEntry.prevEntry = null;
			returnEntry.nextEntry = head;
			head = returnEntry;
		}
		
		return returnEntry.value;
	}
	
	public boolean remove(K key) {
		
		if(hashMap.size() == 0) {
			return false; //Map is empty
		}
		
		Entry entryToBeRemoved = hashMap.get(key);
		if(entryToBeRemoved == null) {
			return false; //entry was not in map
		}
		
		hashMap.remove(key, entryToBeRemoved); //Remove from hashMap
		
		//Remove from doubly-linked list
		if(entryToBeRemoved == head) {
			head = entryToBeRemoved.nextEntry;
			head.prevEntry = null;
		} else if(entryToBeRemoved == tail){
			tail = entryToBeRemoved.prevEntry;
			tail.nextEntry = null;
		} else {
			Entry prevEntry = entryToBeRemoved.prevEntry;
			Entry nextEntry = entryToBeRemoved.nextEntry;
			prevEntry.nextEntry = nextEntry;
			nextEntry.prevEntry = prevEntry;
		}
		
		return true;
	}
	
	public V returnLatestValue() {
		return head.value;
	}
	
	public V returnOldestValue() {
		return tail.value;
	}
	

	/**
	 * Doubly linked list where each entry holds the key and value of each entry and also keeps track of the order of the entries.
	 * @author Admin
	 *
	 * @param K
	 * @param V
	 */
	private class Entry {
		
		K key;
		V value;
		Entry prevEntry;
		Entry nextEntry;
		
		public Entry(K key, V value, Entry prevEntry, Entry nextEntry) {
			this.key = key;
			this.value = value;
			this.prevEntry = prevEntry;
			this.nextEntry = nextEntry;
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println("Innitialize LRU");
		LRU<Integer, String> lru = new LRU<>(5); //Initialize LRU holding 5 objects
		lru.put(1, "One");
		lru.put(2, "Two");
		lru.put(3,  "Three");
		lru.put(4, "Four");
	    lru.put(5, "Five");
	    
	    System.out.println("The latest value is: " + lru.returnLatestValue());
	    System.out.println("The oldest value is: " + lru.returnOldestValue());
	    
	    System.out.println("Get ONE");
	    String retrieved = lru.get(1);
	    System.out.println("Retrieved: " + retrieved);
	    System.out.println("The latest value is: " + lru.returnLatestValue());
	    System.out.println("The oldest value is: " + lru.returnOldestValue());
	    
	    System.out.println("Add SIX");
	    lru.put(6, "Six");
	    System.out.println("The latest value is: " + lru.returnLatestValue());
	    System.out.println("The oldest value is: " + lru.returnOldestValue());
	    
	    System.out.println("Remove TWO");
	    lru.remove(2);
	    System.out.println("The latest value is: " + lru.returnLatestValue());
	    System.out.println("The oldest value is: " + lru.returnOldestValue());
	    
	    System.out.println("Remove FOUR");
	    lru.remove(4);
	    System.out.println("The latest value is: " + lru.returnLatestValue());
	    System.out.println("The oldest value is: " + lru.returnOldestValue());
	    
	    System.out.println("Remove SIX");
	    lru.remove(6);
	    System.out.println("The latest value is: " + lru.returnLatestValue());
	    System.out.println("The oldest value is: " + lru.returnOldestValue());
	    
	}
}
