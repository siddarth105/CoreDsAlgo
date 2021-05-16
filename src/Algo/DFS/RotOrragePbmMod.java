package Algo.DFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RotOrragePbmMod {
	
	
	public final static int R = 3; 
    public final static int C = 5; 
      
    static class Ele 
    { 
        int x = 0; 
        int y = 0; 
        Ele(int x,int y) 
        { 
            this.x = x; 
            this.y = y; 
        } 
    } 
      
    static boolean isValid(int i, int j) 
    { 
        return (i >= 0 && j >= 0 && i < R && j < C); 
    } 
      
  
    static boolean isDelim(Ele temp) 
    { 
        return (temp.x == -1 && temp.y == -1); 
    } 
      
    static boolean checkAll(List<List<Integer> > arr) 
    { 
         for (int i=0; i<arr.size(); i++) 
               for (int j=0; j<arr.get(0).size(); j++) 
                  if (arr.get(i).get(j) == 1) 
                     return true; 
         return false; 
    } 
      

    static int rotOranges(List<List<Integer> > grid) { 
        Queue<Ele> Q=new LinkedList<>(); 
        Ele temp;  
        int ans = 0;  
        for (int i=0; i < R; i++) 
           for (int j=0; j < C; j++) 
               if (grid.get(i).get(j) == 1) 
                   Q.add(new Ele(i,j)); 
                  
        Q.add(new Ele(-1,-1)); 
          
        while(!Q.isEmpty()) 
        { 
            boolean flag = false; 
              
            while(!isDelim(Q.peek())) 
            { 
                temp = Q.peek(); 
                  
                if(isValid(temp.x+1, temp.y) && grid.get(temp.x+1).get(temp.y) == 0) 
                { 
                    if(!flag) 
                    { 
                        ans++; 
                        flag = true; 
                    } 
                    
                    
                    grid.get(temp.x+1).set(temp.y, 1); 
                      
                    temp.x++; 
                    Q.add(new Ele(temp.x,temp.y)); 
                       
                    temp.x--; 
                } 
                  
                
                if (isValid(temp.x-1, temp.y) && grid.get(temp.x-1).get(temp.y) == 0) 
                 { 
                        if (!flag) 
                        { 
                            ans++; 
                            flag = true; 
                        } 
                        grid.get(temp.x-1).set(temp.y, 1); 
                        temp.x--; 
                        Q.add(new Ele(temp.x,temp.y)); 
                        temp.x++; 
                 } 
                  
                 if (isValid(temp.x, temp.y+1) && grid.get(temp.x).get(temp.y+1) == 0) { 
                        if(!flag) 
                        { 
                            ans++; 
                            flag = true; 
                        } 
                        grid.get(temp.x).set(temp.y+1, 1);
                        temp.y++; 
                        Q.add(new Ele(temp.x,temp.y));
                        temp.y--; 
                    } 
                   
                 if (isValid(temp.x, temp.y-1) && grid.get(temp.x).get(temp.y-1) == 0)  
                 { 
                        if (!flag) 
                        { 
                            ans++; 
                            flag = true; 
                        } 
                        grid.get(temp.x).set(temp.y-1, 1); 
                        temp.y--; 
                        Q.add(new Ele(temp.x,temp.y)); 
                 } 
                 Q.remove(); 
            } 
            Q.remove(); 
              
            if (!Q.isEmpty())  
            { 
                Q.add(new Ele(-1,-1)); 
            } 
        } 
        return (checkAll(grid))? -1: ans; 
          
    } 
      
    public static void main(String[] args) { 
        int arr[][] = { {2, 1, 0, 2, 1}, 
                        {1, 0, 1, 2, 1}, 
                        {1, 0, 0, 2, 1}}; 
        int ans = 0; //rotOranges(arr); 
        if(ans == -1) 
            System.out.println("All oranges cannot rot"); 
        else
            System.out.println("Time required for all oranges to rot = " + ans); 
    } 

}
