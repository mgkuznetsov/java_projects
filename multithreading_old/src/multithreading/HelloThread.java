package multithreading;

public class HelloThread extends Thread {
	public void run() {
		System.out.println("Hello Thread " + this.getId());
	}
}
