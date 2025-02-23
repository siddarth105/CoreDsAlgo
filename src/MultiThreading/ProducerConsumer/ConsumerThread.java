package MultiThreading;

public class ConsumerThread extends Thread {
	
	Common c;
    
    ConsumerThread(Common c){
        this.c=c;
    }
    
    public void run(){
        
        while(true){
            
            int x=c.consume();
            System.out.println("Consumer consumes "+x);
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }  
        }  
    }

}
