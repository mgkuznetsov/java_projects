/**
 * Threads cooperate through locks
 * Acquiring lock prevents other threads to acquire the lock until the holder releases it
 * Locks can be acquired and released through "synchronized" objects
 * Locks are given on a per thread basis - a thread can call multiple synchronized methods once it
 * gets a lock on object. This allows for calling recursive methods.
 * We need both getters and setters to be synchronized because if at Thread calls both methods to 
 * update the bank account, then we must be sure no other threads are accessing the bank account at 
 * the same time.
 * Synchronized methods synchronize on the instance of the object from whichthey are call
 * If the synchronized method is static, they synchronize on the class instance - this blocks any synchronized
 * methods
 * Synchronized Method = "mutex"
 */
public class BankAccount {
	private long number; // account number
	private long balance; // current balance (in cents)

	/**
	 * Note: Constructors can't be declared as synchronized
	 * @param initialDeposit
	 */
	public BankAccount(long initialDeposit) {
		balance = initialDeposit;
	}

	/**
	 * Operations where field can be modified by multiple threads simultaneously should be synchronized
	 * even if they are reads or writes
	 * @return
	 */
	public synchronized long getBalance() {
		return balance;
	}

	public synchronized void deposit(long amount) {
		balance += amount;
	}
	// ... rest of methods ...
}
