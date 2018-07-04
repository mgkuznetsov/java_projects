import java.util.ArrayList;

/**
 * Representation of the entire hash map / hash table using separate chaining
 * @author Admin
 *
 * @param <K>
 * @param <V>
 */
public class HashMap<K, V> {

	private ArrayList<HashNode<K,V>> bucketArray;
	private int size; //current size of HashMap
	private int numBuckets; //capacity of HashMap
	private static final double OPTIMUM_LOAD_FACTOR = 0.7;
	
	public HashMap() {
		bucketArray = new ArrayList<>();
		size = 0;
		numBuckets = 10;
		
		//Initialize empty HashMap
		for(int i=0; i<numBuckets; i++) {
			bucketArray.add(null);
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
		
		int bucketIndex = getBucketIndex(key);
		
		HashNode<K, V> head = bucketArray.get(bucketIndex);
		
		//Iterate through the list
		while(head.hasNext()) {
			if(head.getKey().equals(key)) {
				return head.getValue();				
			}
			head = head.getNext();
		}
		
		return null; //If we did not find the value
	}
	
	/**
	 * Fetch the index corresponding to the input key using the helper function
	 * The traversal of linked list similar like in get() but what is special here is that one needs to remove the key along with finding it and 
	 * two cases arise
	 * If the key to be removed is present at the head of the linked list
	 * If the key to be removed is not present at head but somewhere else
	 * @return
	 */
	public V remove(K key) {
		int bucketIndex = getBucketIndex(key);
		
		V returnValue;
		
		HashNode<K, V> head = bucketArray.get(bucketIndex);
		
		//Iterate over the chain and search for the key
		HashNode<K, V> prevNode = null;
		while(head != null) {
			if(head.getKey().equals(key)) {
				break; //We found key			
			}
			
			prevNode = head;
			head = head.getNext();
		}
		
		if(head == null) {
			return null; //We traversed the entire chain and did not find the key there
		}
		
		//Otherwise we have found the key
		returnValue = head.getValue();
		size--; //Reduce size of HashMap
		
		if(prevNode == null) {
			//If key was in the head node - set bucket to point to the next node
			bucketArray.set(bucketIndex, head.getNext());
		} else {
			//Key was not the head node - set the previous node to point to the next node
			prevNode.setNext(head.getNext());
		}
		
		return returnValue;
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
		int bucketIndex = getBucketIndex(key);
		
		HashNode<K, V> newNode = new HashNode<K, V>(key, value);
		
		//If there is nothing at that key, then insert the node
		if(bucketArray.get(bucketIndex) == null) {
			bucketArray.set(bucketIndex, newNode);
		} else {
			//Traverse the chain and add the new node at the end
			HashNode<K, V> head = bucketArray.get(bucketIndex);
			while(head.hasNext()) {
				head = head.getNext();
			}
			
			head.setNext(newNode);
		}
		size++;
		
		//Rehash the hashmap if load factor will be greater than desired load factor (0.7)		
		double loadFactor = (double) (size+1) / (double) numBuckets;
		if(loadFactor > OPTIMUM_LOAD_FACTOR) {			
			rehash();
		}
	}
	
	private void rehash() {
		numBuckets = 2*numBuckets;
		ArrayList<HashNode<K, V>> newBucketArray = new ArrayList<>();
		
		//Initialize empty HashMap
		for(int i=0; i<numBuckets; i++) {
			newBucketArray.add(null);
		}
		
		//Go through the old hashmap and redestribute elements
		int newIndex;
		for(HashNode<K, V> node : bucketArray) {
			newIndex = getBucketIndex(node.getKey());
			newBucketArray.set(newIndex, node);
		}
		
		bucketArray = newBucketArray;		
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	/**
	 * Use function to find index for key
	 * @return
	 */
	private int getBucketIndex(K key) {
		return (key.hashCode())%numBuckets;
	}
	
}
