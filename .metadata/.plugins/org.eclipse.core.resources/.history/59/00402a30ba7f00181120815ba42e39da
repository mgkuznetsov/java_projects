/**
 * We define the multithreading code in an anonymous inner class
 * We define the code right in the constructor, and the last thing we do is launch the runnable code in the constructor
 * @author Admin
 */
public class TestMultithreadingAnonymousInnerClass {

	public TestMultithreadingAnonymousInnerClass(int waitTimeSeconds) {
		//Define multithreading code:
		Runnable service = new Runnable() {
			public void run() {
				try {
					while(true) {
						Thread.sleep(waitTimeSeconds*1000);
						System.out.println("I am multithreading behavior defined in an AnonymousInnerClass. "
								+ "I'll be back in " + waitTimeSeconds + " seconds." );			
					}
				} catch(InterruptedException e) {
					System.out.println("Interruprted Exception");
				}
			} 	
		};
		
		//Run multithreading code as last step in constructor by passing Runnable instance to a thread
		new Thread(service).start();
	}
	
	public static void printSomeString(String someString) {
		System.out.println(someString);
	}
	
}
