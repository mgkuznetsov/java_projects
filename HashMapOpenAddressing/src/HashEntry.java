
/**
 * Representation of entry in hash table for open addressing.
 * If entry is not deleted, the isDeleted flag is set to false.
 * If entry is deleted, the key and value are null, and hte isDeleted flag is set to true.
 * @author Admin
 *
 * @param <K>
 * @param <V>
 */
public class HashEntry<K, V> {

	private K key;
	private V value;
	private boolean isDeleted = false;
	
	public HashEntry(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public void markAsDeleted() {
		key = null;
		value = null;
		isDeleted = true;
	}
	
	public boolean isDeletedEntry() {
		return isDeleted;
	}
	
	public K getKey() {
		return key;
	}
	
	public V getValue() {
		return value;
	}
}
