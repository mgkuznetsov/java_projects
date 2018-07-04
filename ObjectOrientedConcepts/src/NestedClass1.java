/**
 * This class is an example of using a local inner class and an anonymous inner class
 * Anonymous inner class is that it is only used once where it is defined
 * The advantage is that we can only use that code within that class
 * That becomes imported for multihreading where we overwrite the "run" method
 * @author Admin
 *
 */
public class NestedClass1 {
	
	/**
	 * This is an example of using local inner class
	 */
	public void usingLocalInnerClass() {
		Interface1 localInnerClass = new LocalInnerClass();
		localInnerClass.doSomething();
	}
	
	/**
	 * This is an example of using anonymous inner class
	 * We define the implementation of anonymous class directly in the code
	 */
	public void usingAnonymousInnerClass() {
		//We define the anonymous class with the word "new" and specify what type the anonymous class will be
		//The anonymous class will be of type SUPERTYPE of the anonymous class (in this case object)
		//The anonymous class will implement interface Interface1
		//Anonymous inner class can't have modifiers, annotations, or explicitly extend or implement interfaces
		Interface1 anonymousInnerClass = new Interface1() {
			//Whatever other methods this class has
			
			public void doSomething() {
				System.out.println("I am an anonymous inner class!");
			}
		}; //We need to end the definition of the anonymous inner class with a semicolon
		
		//Now use the anonymous inner class to do its thing:
		anonymousInnerClass.doSomething();
	}
	
	class LocalInnerClass implements Interface1 {		
		public void doSomething() {
			System.out.println("I am a local inner class!");
		}
	}
}
