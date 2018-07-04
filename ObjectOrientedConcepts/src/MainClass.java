
public class MainClass {
	public static void main(String[] args) {
		
		//Demonstrate Local Inner Class vs. Anonymous Inner Class:
		NestedClass1 nestedClass1 = new NestedClass1();
		nestedClass1.usingLocalInnerClass(); //local inner class
		nestedClass1.usingAnonymousInnerClass(); //same logic with annonymous inner class
		
	}
}
