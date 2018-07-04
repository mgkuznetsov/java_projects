/**
 * For synchronized statements, the input is an object, and that's what we lock onto
 * Advantage over synchronized methods is:
 * 1. Synchronized code is as small as possible - don't need a full method
 * 2. We don't synchronize on the object itself, so we can use any object to synchronize
 * 3. We can do processing and know that some other thread isn't simultaneously modifying the value
 */
class SeparateGroups {
	private double aVal = 0.0;
	private double bVal = 1.1;
	private String name = "SeparateGroups";
	protected final Object lockA = new Object();
	protected final Object lockB = new Object();

	public double getA() {
		synchronized (lockA) {
			return aVal;
		}
	}

	public void setA(double val) {
		synchronized (lockA) {
			aVal = val;
		}
	}

	public double getB() {
		synchronized (lockB) {
			return bVal;
		}
	}

	public void setB(double val) {
		synchronized (lockB) {
			bVal = val;
		}
	}

	//Lock on both A and B when we reset them at the same time 
	public void resetBothAB() {
		synchronized (lockA) {
			synchronized (lockB) {
				aVal = bVal = 0.0;
			}
		}
	}
	
	class InnerClass {
		void 
	}
}
