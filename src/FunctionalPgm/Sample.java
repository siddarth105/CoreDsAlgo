package FunctionalPgm;

import java.util.Arrays;
import java.util.List;

public class Sample {

	public static void main(String[] args) {
		List<String> arr = Arrays.asList("a", "b", "c", "d");
		arr.parallelStream().forEach(k -> System.out.println(k));
	}

}
