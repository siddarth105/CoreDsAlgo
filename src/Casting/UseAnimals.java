package Casting;

public class UseAnimals {
	
	public static void main (String []args) {
		
		Animal a = new Cat(); //1
		Animal b = (Animal) new Cat(); //2
		
		// 1 & 2 both are same and is called Upcasting
		a.makeNoise(); // makeNoise of Cat
		a.makeAnimalNoise();
       //a.makeCatNoise();   //Compilation Error -> makeCatNoise should be present in both the classes
		
		Cat c = (Cat) a; //3
		// Downcasting -> after downcasting an upcasted object -> it can access both the individual mthds
		c.makeCatNoise();
		c.makeAnimalNoise();
		c.makeNoise();
		
		Cat cat = new Cat();
		Animal ani = (Animal) cat; //4 :: Upcasting
		ani.makeNoise(); // makeNoise of Cat
		ani.makeAnimalNoise();
		
		
		Animal a1 = new Animal();
		Cat c1 = (Cat) a1; //5 :: Run Time Exception -> ClassCastException
	}

}
