import java.util.ArrayList;

/**
 * Representation of the entire hash map / hash table using open addressing with quadratic probing
 * @author Admin
 *
 * @param <K>
 * @param <V>
 */
public class HashMap<K, V> {

	private ArrayList<HashEntry<K, V>> map;
	private int size; //current size of HashMap
	private int mapCapacity; //capacity of HashMap
	private static final double OPTIMUM_LOAD_FACTOR = 0.7;
	
	public HashMap() {
		map = new ArrayList<>();
		size = 0;
		mapCapacity = 10;
		
		//Initialize empty HashMap
		for(int i=0; i<mapCapacity; i++) {
			map.add(null);
		}
	}

	/**
	 * Retrieve the input key to find the index in the HT
	 * Traverse the liked list corresponding to the HT, if you find the value then return it else if you fully traverse the list without returning 
	 * it means the value is not present in the table and can’t be fetched so return null
	 * @param key
	 * @return
	 */
	public V get(K key) {
		
		//Traverse all the indices with quadratic probing.
		
		int index;
		HashEntry<K, V> entryAtIndex;
		for(int i=0; i<mapCapacity; i++) {
			index = (key.hashCode() + i^2)%mapCapacity;
			entryAtIndex = map.get(index);
			
			if(entryAtIndex == null) {
				return null; //There is nothing at that index, so entry with desired key has not been added
			}
			
			if(entryAtIndex.isDeletedEntry()) {
				continue; //There is a deleted entry here. The desired entry may be at the next iteration of the hash
			}
			
			if(entryAtIndex.getKey().equals(key)) {
				return entryAtIndex.getValue();
			}
		}
				
		return null; //If we did not find the value
	}
	
	/**
	 * Similar to get method, but we need to mark the entry as deleted
	 * @return
	 */
	public V remove(K key) {
		//Traverse all the indices with quadratic probing.
		
		int index;
		HashEntry<K, V> entryAtIndex;
		for(int i=0; i<mapCapacity; i++) {
			index = (key.hashCode() + i^2)%mapCapacity;
			entryAtIndex = map.get(index);
			
			if(entryAtIndex == null) {
				return null; //There is nothing at that index, so entry with desired key has not been added
			}
			
			if(entryAtIndex.isDeletedEntry()) {
				continue; //There is a deleted entry here. The desired entry may be at the next iteration of the hash
			}
			
			if(entryAtIndex.getKey().equals(key)) {
				entryAtIndex.markAsDeleted(); //Mark entry as deleted
				return entryAtIndex.getValue();
			}
		}
				
		return null; //If we did not find the value
	}
	
	/**
	 * Just like remove steps till traversal and adding and two cases (addition at head spot or non-head spot) remain the same.
	 * Towards the end if load factor is greater than 0.7
	 * We double the size of the array list and then recursively call add function on existing keys because in our case hash value generated uses 
	 * the size of the array to compress the inbuilt JVM hash code we use ,so we need to fetch new indices for the existing keys. 
	 * This is very important to understand please re read this paragraph till you get a hang of what is happening in the add function.
	 */
	public void add(K key, V value) {
		
		//Add new element to hash map
		int index = getNextAvailableIndex(key, map);
		
		if(index == -1) {
			//todo: throw some exception because there no space for new entries. This should not happen with open addressing.
		}
		
		map.set(index, new HashEntry<K, V>(key, value));
		size++;
		
		//Rehash the hashmap if load factor will be greater than desired load factor (0.7)		
		double loadFactor = (double) (size+1) / (double) mapCapacity;
		if(loadFactor > OPTIMUM_LOAD_FACTOR) {			
			rehash();
		}
	}
	
	private void rehash() {
		//Initialize empty HashMap with twice the size
		mapCapacity = 2*mapCapacity;
		ArrayList<HashEntry<K, V>> newMap = new ArrayList<>();
		
		
		for(int i=0; i<mapCapacity; i++) {
			newMap.add(null);
		}
		
		//Go through the old hashmap and redestribute elements to new HashMap
		int newIndex;
		for(HashEntry<K, V> entry : map) {
			newIndex = getNextAvailableIndex(entry.getKey(), newMap);
			newMap.set(newIndex, entry);
		}
		
		map = newMap;		
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	/**
	 * Use function to find index for key using Quadratic Probing.
	 * For each index that we derive, we need to check if there is a collision. If there is, then we come up with a new index.
	 * We do this for as many times as there are elements in the array (mathematical proof needed).
	 * @return
	 */
	private int getNextAvailableIndex(K key, ArrayList<HashEntry<K, V>> map) {
		
		int index;
		for(int i=0; i<mapCapacity; i++) {
			index = (key.hashCode() + i^2)%mapCapacity;
			
			if(map.get(index) == null || map.get(index).isDeletedEntry()) {
				return index;
			}
		}
		
		return -1; //Did not find an available index. This should not happen with resizing.		
	}
}
