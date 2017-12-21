package MultiThreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class J8Stream {

	public static void main(String[] args) {
		
		List<String> lst = new ArrayList<String>();
		lst.add("Chn");
		lst.add("Mum");
		lst.add("Dlh");
		lst.add("Blr");
		
		parallelProcess(lst);
		System.out.println();
		serialProcess(lst);
	}
	
	public static void printVal(String s) {
		System.out.println(s + " : " + Thread.currentThread().getId());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void parallelProcess(List<String> lst) {
		
		System.out.println("Parallel Processing");
		ForkJoinPool forkJoinPool = new ForkJoinPool(4);
		long l = System.currentTimeMillis();
		forkJoinPool.submit(() ->
		lst.stream().parallel().forEach(s -> J8Stream.printVal(s))).join();
		System.out.println("Time taken :: " + (System.currentTimeMillis() - l) + " ms");
	}
	
	public static void serialProcess(List<String> lst) {
		
		System.out.println("Serial Processing");
		long l = System.currentTimeMillis();
		for (String s : lst) {
			J8Stream.printVal(s);
		}
		System.out.println("Time taken :: " + (System.currentTimeMillis() - l) + " ms");
	}
}
