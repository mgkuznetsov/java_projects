package testProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MainClass {

	
	public static void main(String[] args){
		
		Animal myAnimal = new Animal();
		System.out.println("Animal Sound: " + myAnimal.makeNoise());
		
		Dog myDog = new Dog();
		Animal myDogAnimal = myDog;
		System.out.println("Dog Sound: " + myDog.makeNoise());

		System.out.println("Dog's animal noise: " + myDogAnimal.makeNoise());
		
		myDog.getFunky();
		
		myDogAnimal.getFunky();
	}
	
	public void dataStructures() {
		final List<String> testLinkedList = new LinkedList<>();
		//testLinkedList.
		final Map<String, String> myMap = new HashMap<>();
		final TreeMap<String, String> treeMap = new TreeMap<>();
		final LinkedHashMap<String, String> linkedMap = new LinkedHashMap<>();
		final int[] myIntArray = new int[10];
		List<Integer> listInterface = new ArrayList<>();
		LinkedList<Integer> linkedList = new LinkedList<>();
		final Set<String> mySet = new HashSet<>();
	}
}
