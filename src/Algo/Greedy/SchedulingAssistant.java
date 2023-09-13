package Algo.Greedy;

import java.util.TreeMap;

// https://leetcode.com/problems/my-calendar-i/editorial/
public class SchedulingAssistant {
    TreeMap<Integer, Integer> calendar;

    SchedulingAssistant() {
        calendar = new TreeMap();
    }

    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start),
                next = calendar.ceilingKey(start);
        if ((prev == null || calendar.get(prev) <= start) &&
                (next == null || end <= next)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }
}

/*USERS  ::  U1, U2, U3

        U1
        M1  -  (09:10, 09:20)
        M3  -  (09:30, 09:40)

        U2
        M5  -  (09:25, 09:45)

        U3
        M1  -  (09:10, 09:20)
        M8  -  (10:10, 10:20)


        TreeMap
        (09:10, 09:20)
        (09:25, 09:45)
        (09:30, 09:40)    <-    Floor (09:50)
        (10:10, 10:20)    <-    Ceiling (09:50)

        ---------------------------------------------------------------------------------------------------------------------->>>

        Is it possible to schedule a meeting (M6) between U1, U2, U3 between (09:50, 10:05)
        M6 - (09:50, 10:05)


        1) Add the meetings of U1, U2, U3 in TreeMap :: O(log N)
        TreeMap is sorted based on the key

        2)  getFloor gives the greatest key less than or equal to the given key  :: O(log N)
        getCeiling gives the smallest key greater than or equal to the given key  :: O(log N)

        ---------------------------------------------------------------------------------------------------------------------->>>*/
