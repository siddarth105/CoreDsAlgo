package PassByVal;

public class Sample {
  
    public static void printNext(int number){
        number++;
        System.out.println("number Inside printNext(): "+number);
    }
    
    public static void main(String args[]) {
        int number = 3;
        System.out.println("Inside main(), B4 method "+number);
        printNext(number);
        System.out.println("Inside main(), After method : "+number);
     }
}
