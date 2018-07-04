
/**
 * Our custom thread class that reports it's status every so often.
 * This thread extends the Thread class, which means it implements the Runnable interface
 * @author Admin
 *
 */
public class TestRunnable implements Runnable {

	private int delay; //delay in ms
	private int secondDelay; //delay in seconds
	private String name;
	
	public String getName() {
		return name;
	}
	
	public TestRunnable(String name, int secondDelay) {
		this.name = name; //Call constructor of Thread class and assign name to thread. We could also use "setName" method.
		this.secondDelay = secondDelay;
		this.delay = secondDelay*1000;
		
	}
	
	//Overrides Thread's default "run" method
	public void run() {
		try {
			while(true) {
				Thread.sleep(delay);
				System.out.println("Thread: " + getName() + ", reporting every " + secondDelay + " seconds.");
			}
		} catch(InterruptedException e) {
			System.out.println("Thread: " + getName() + ". Thread is interrupted.");
		}
		
		System.out.println("Thread: " + getName() + ". Thread will exit.");
		return; //Exit the thread
	}
}
