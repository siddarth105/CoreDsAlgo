package Algo.BFS;

import java.util.*;

// https://leetcode.com/problems/keys-and-rooms/
public class KeysNRooms {

    public static void openRoom(List<List<Integer>> rooms) {
        boolean[] isVisited = new boolean[rooms.size()];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0); isVisited[0] = true;

        while (!q.isEmpty()) {
            int room = q.remove();
            List<Integer> keys = rooms.get(room);
            for (int key : keys) {
                if (!isVisited[key]) {
                    q.add(key);
                }
                isVisited[key] = true;
            }
        }

        for (int i=0; i<isVisited.length; i++) {
            if (!isVisited[i]) {
                System.out.println("Room "+i+" is not visited");
            }
        }
    }

    public static void main(String[] args) {

        Integer[] keys = new Integer[]{1,3};
        List<Integer> keysList = Arrays.asList(keys);

        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(0, keysList);

        keys = new Integer[]{3,0,1};
        keysList = Arrays.asList(keys);
        rooms.add(1, keysList);

        keys = new Integer[]{2};
        keysList = Arrays.asList(keys);
        rooms.add(2, keysList);

        keys = new Integer[]{0};
        keysList = Arrays.asList(keys);
        rooms.add(3, keysList);

        openRoom(rooms);
    }
}
