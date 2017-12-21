package Generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseClass {
	
	public static void main (String []args) {
		List<ClassA> lstA = new ArrayList<ClassA>();
		List<ClassB> lstB = new ArrayList<ClassB>();
		List<ClassC> lstC = new ArrayList<ClassC>();
		//lstA = lstB; //Compilation Error
		
		/*List<? extends ClassA> lst8 = new ArrayList<ClassA>();*/
		
		lstA.add(new ClassA());
		lstA.add(new ClassB());
		lstA.add(new ClassC());
		lstB.add(new ClassB());
		lstC.add(new ClassC());
		
		// Reusable methods that operate on collections of type ClassA
		getList(lstA);
		getList(lstB);
		getList(lstC);
		
		// Reusable methods that operate on collections of type ClassA and its sub-class
		getExtendList(lstA);
		getExtendList(lstB);
		getExtendList(lstC);
		
		// Reusable methods that operate on collections of type ClassB and its super-class
		getSuperList(lstB);
		// Compilation Error
		//getSuperList(lstC);
		
		List<? extends ClassA> lstAB = new ArrayList<ClassA>();
		//lstAB.add(new ClassB()); Compilation Error
		
		Map<? extends ClassA, ? extends ClassB>  m1 = new HashMap();
		
		//Way to add objects of only 2 different Classes in a single list
		//Implement a common interface in both of the classes and create a list of type Interface 
		//This is where a marker interface plays its role, the implemented interface may be a Marker interface for better convinience 
		List<InterI> lst  = new ArrayList<InterI>();
		lst.add(new ClassD());
		lst.add(new ClassE());
		
	}
	
	
	// This is where wildcard play its role
	// 1. A list of any Type
	public static void getList(List<?> lst) {
		for (Object o : lst) {
			
		}
	}
	
	// 2. A list of any Type
	public static void getExtendList(List<? extends ClassA> lst) {
		for (ClassA a : lst) {
			
		}
	}
	
	// 3. A list of any Type
	public static void getSuperList(List<? super ClassB> lst) {
		for (Object o : lst) {
			
		}
	}

}
