/**
 * This is a node in a chain of nodes
 * @author Admin
 *
 * @param <K>
 * @param <V>
 */
public class HashNode<K, V> {
	
	K key;
	V value;
	HashNode<K, V> next;
	
	public HashNode(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public HashNode<K,V> getNext() {
		return next;
	}
	
	public boolean hasNext() {
		return !(next == null);
	}
	
	public void setNext(HashNode<K, V> nextNode) {
		next = nextNode;
	}
	
	public K getKey() {
		return key;
	}
	
	public V getValue() {
		return value;
	}

	
}
