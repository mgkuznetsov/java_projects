public class MainClass {

	/**
	 * Out of the box, the Thread object does nothing
	 * We need to provide a class that Overrides the "Runnable" interface.
	 * Starts new thread. This will invoke t1's "run" method.
	 * When the thread is done, the "run" method will return. Invoking the
	 * thread multiple times causes IllegalThreadStateException
	 */
	public static void basicMultithreadingExtendingThreadClass() {

		// Instantiate our threads:
		TestThread t1 = new TestThread("t1", 1);
		TestThread t2 = new TestThread("t2", 2);

		// Start threads:
		t1.start();
		t2.start();
	}
	
	/**
	 * We can also do multithreading by implementing the Runnable interface.
	 * This is better because Java doesn't support multiple inheritence. This
	 * means that we can only extend Thread class and can't extend other class.
	 * A thread object can then execute whatever we specify in the "run" method.
	 */
	public static void basicMultithreadingImplementingRunnableInterface() {

		// Instantiate our threads:
		Runnable t3 = new TestRunnable("t3", 3);
		Runnable t4 = new TestRunnable("t4", 4);

		// Start threads:
		new Thread(t3).start();
		new Thread(t4).start();
	}
	
	/**
	 * We define the multithreading code in an anonymous inner class
	 * We define the code right in the constructor, and the last thing we do is launch the runnable code in the constructor
	 * The other methods of the class are still accessible by the other threads
	 * Each method that defines a "Runnable" instance becomes like a unit of work
	 * We can pass these units of work between classes
	 */
	public static void basicMultithreadingAnonymousInnerClass() throws InterruptedException {
		
		//Start the worker:
		TestMultithreadingAnonymousInnerClass testClass = new TestMultithreadingAnonymousInnerClass(2);
		
		//See if other methods of the class can be accessed within this thread:
		Thread.sleep(5000); //wait
		TestMultithreadingAnonymousInnerClass.printSomeString("Just checking!");
	}
	
	/**
	 * Synchronized statements can synchronize on any object
	 * The input for synchronized statement must be 
	 * For example, this method returns the absolute value of some integer
	 * We can do this processing and know that some other thread isn't simultaneously modifying the value
	 * Advantage of synchronized statement is that it makes the synchronized part of the code as small as possible
	 */
	private static void basicSynchronizedStatement(Integer value) {
		//Synchronize on Integer object "value"
		synchronized(value) {
			System.out.println("Absolute value of integer " + value + " is " + Math.abs(value));
		}
	}

	// TODO: Callables

	// TODO: FutureTasks
	
	//TODO: Need to really understand how to implement asynchronous
	
	//TODO: Need to understand thread pools
	
	//TODO: What does "blocking" mean
	
	//TODO: When is Thread.holdsLock(object) useful?
	
	//TODO: Static synchronized methods - the best practice is to create private synchronized objects
	//Static synchronized can be useful in the factory design pattern

	public static void main(String args[]) throws InterruptedException {

		// Using a class that extends Thread Class:
		//basicMultithreadingExtendingThreadClass(); 
													
		//Using a class that implements Runnable interface:
		//basicMultithreadingImplementingRunnableInterface();
		
		//Defining "run" method in an anonymous inner class for security purposes:
		basicMultithreadingAnonymousInnerClass();
		

	}

}