package testProject;

public class Dog extends Mammal {
	
	@Override
	public String makeNoise() {
		return noise;
	}
	
	public Dog() {
		hasFur=true;
		noise="bark";
	}
	
	public static void getFunky() {
		System.out.println("Dogs are funky");
	}
}
