package Algo.Hashing;

import java.util.HashMap;
import java.util.Map;

public class PrintItinerary {

	private static void printResult(Map<String, String> dataSet) {
		Map<String, String> reverseMap = new HashMap<String, String>();

		// To fill reverse map, iterate through the given map :: O(n)
		for (Map.Entry<String, String> entry : dataSet.entrySet())
			reverseMap.put(entry.getValue(), entry.getKey());

		// Find the starting point of itinerary
		String start = null;
		for (Map.Entry<String, String> entry : dataSet.entrySet()) {
			if (!reverseMap.containsKey(entry.getKey())) {
				start = entry.getKey();
				break;
			}
		}

		if (start == null) {
			System.out.println("Invalid Input");
			return;
		}

		String to = dataSet.get(start);
		while (to != null) {
			System.out.print(start + "->" + to + ", ");
			start = to;
			to = dataSet.get(to);
		}
	}

	public static void main(String[] args) {
		Map<String, String> dataSet = new HashMap<String, String>();
		dataSet.put("Chennai", "Banglore");
		dataSet.put("Bombay", "Delhi");
		dataSet.put("Goa", "Chennai");
		dataSet.put("Delhi", "Goa");

		printResult(dataSet);
	}
	
	
	/*
		ALGORITHM :-
		1) Which ever is not there in the TO list is the Starting Point
	*/

}
