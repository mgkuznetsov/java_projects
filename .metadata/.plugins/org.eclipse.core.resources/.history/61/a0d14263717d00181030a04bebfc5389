
/**
 * Our custom thread class that reports it's status every so often.
 * This thread extends the Thread class, which means it implements the Runnable interface
 * @author Admin
 *
 */
public class TestThread extends Thread {

	private int delay; //delay in ms
	private int secondDelay; //delay in seconds
	
	public TestThread(String name, int secondDelay) {
		super(name); //Call constructor of Thread class and assign name to thread. We could also use "setName" method.
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
