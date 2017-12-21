package PassByVal;

public class Array {
	
	public static void main (String []args) {
		
		int i[] = {1,'a'};
		//i[2] = 3; //ArrayIndexOutOfBound
		
		char j[] = new char[4];
		j[0] = 1;
		j[1] = 'a';
		j[2] = 'A';
		for (char k : j) {
			System.out.println(k);
		}
		
		for (int k : j) {
			System.out.println(k);
		}
	}

}
