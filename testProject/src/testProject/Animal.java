package testProject;

public class Animal {
	
	String noise;
	
	public Animal() {
		noise = "animal noise";
	}
	
	public String makeNoise() {
		return "I'm an animal!" + noise;
	}
	
	public String makeSuperAnimalNoise() {
		return "Super Animal Noise";
	}
	
	public static void getFunky() {
		System.out.println("Animals are funky");
	}
}
