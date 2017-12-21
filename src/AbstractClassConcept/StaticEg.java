package AbstractClassConcept;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class StaticEg {
	
	static int j = 2;
	public int k = 2;
	
	public void add(){
		j++;
		k++;
	}
	
	static {
		System.out.println("hi");
	}
	
	public static void main(String[] args) {
		
		StaticEg eg = new StaticEg();
		System.out.println(" Initial -> "); 
		System.out.println(" EG Object :: j :: "+eg.j);
		System.out.println(" EG Object :: k :: "+ eg.k);
		eg.add();
		System.out.println(" After Add1 ->");
		System.out.println(" EG Object :: j :: "+eg.j);
		System.out.println(" EG Object :: k :: "+ eg.k);
		StaticEg eg1 = new StaticEg();
		eg1.add();
		System.out.println(" After Add2 ->");
		System.out.println(" EG1 Object :: j :: "+ eg1.j);
		System.out.println(" EG Object :: k :: "+ eg.k);
		eg.add();
		System.out.println(" After Add3 ->");
		System.out.println(" EG Object :: j :: "+ eg.j);
		System.out.println(" EG Object :: k :: "+ eg.k);
		
		//List is not declared as generic
		List l = new ArrayList();
		l.add(1);
		l.add("a");
	}

}

