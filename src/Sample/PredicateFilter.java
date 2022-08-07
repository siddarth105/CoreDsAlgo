package Sample;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateFilter {
	
	private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "aaryanna",
                "aayanna",
                "airianna",
                "alassandra",
                "allanna",
                "allannah",
                "allessandra",
                "allianna",
                "allyanna",
                "anastaisa",
                "anastashia",
                "anastasia",
                "annabella",
                "annabelle",
                "annebelle"
        );
        
        names.stream()
                .filter(Filter.nameStartingWithPrefix(scanner.nextLine()))
                .map(Mapper.getDistinctCharactersCount())
                .forEachOrdered(System.out::println);
    }
    
    public static class Filter {
    		public static Predicate<String> nameStartingWithPrefix(String nextLine) {
           Predicate<String> predicate =  a -> {
        	   	if (a.length() < nextLine.length()) {
        	   		return nextLine.contains(a);
        	   	}
        	   	return (a.substring(0,nextLine.length()).equals(nextLine));
        	   };
           return predicate;
		}
    }
    
    public static class Mapper {

		public static Function<String, CharactersCount> getDistinctCharactersCount() {
			Function<String, CharactersCount> fun = x -> (new CharactersCount(x,getDistinctChar(x)));
            return fun;
		}
		
		public static int getDistinctChar(String val) {
			Set<String> charSet = new HashSet<>();
			char[] arr = val.toCharArray();
			for (char elt : arr) {
				charSet.add(elt+"");
			}
			return charSet.size();
		}
    	
    }

}

class CharactersCount {
    private final String name;
    private final Integer distinctCharacterCount;
    
    public CharactersCount(String name, Integer distinctCharacterCount) {
        this.name = name;
        this.distinctCharacterCount = distinctCharacterCount;
    }
    
    @Override
    public String toString() {
        return "\"" + this.name + "\" has " + this.distinctCharacterCount + " distinct characters.";
    }
}
