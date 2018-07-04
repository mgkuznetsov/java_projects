package testProject;

public class Mammal extends Animal {
	
	Boolean hasFur=false;
	
	public Mammal() {
		noise = "mammal noise";
	}
	
	public Boolean isFurry() {
		return hasFur;
	}
}
