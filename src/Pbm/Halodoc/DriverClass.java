package Pbm.Halodoc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DriverClass {

    public static void main (String[] args) {

        Keystore ks = new KeystoreImpl();

        List<Attribute> attrList = new ArrayList<>();
        // Attribute will accept any datatype. Not declared any specific
        Attribute pollutionLevel = new Attribute("pollution_level", "very_high");
        Attribute population = new Attribute("population", "10 million");
        Attribute freeFood = new Attribute("free_food", false);
        attrList.addAll(Arrays.asList(pollutionLevel, population, freeFood));

        //INSERT :: TIME_COMPLEXITY :: O(1) -> Avg Case (using map)
        ks.insert("delhi", attrList);

        //REV_SEARCH :: TIME_COMPLEXITY :: O(1) -> Avg Case
        String revSearch = (String) ks.getRevSearch("pollution_level", "very_high");
        System.out.println("Rev Search for very_high :: " + revSearch);

        //Handling corner case of inserting the attribute value with a different type : Eg :- pollution_level
        // Throws exception
        List<Attribute> attrList2 = new ArrayList<>();
        Attribute pollutionLevel2 = new Attribute("pollution_level", Boolean.FALSE);
        Attribute population2 = new Attribute("population", "10 million");
        attrList2.addAll(Arrays.asList(pollutionLevel2, population2));

        ks.insert("mumbai", attrList2);
    }

}
