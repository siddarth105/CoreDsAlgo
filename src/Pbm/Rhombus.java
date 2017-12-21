package Pbm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Rhombus {
	
	static public int ReadInteger()
    {
          try
          {
                InputStreamReader input = new InputStreamReader(System.in);
                BufferedReader reader = new BufferedReader(input);
                String s = reader.readLine();
                return Integer.parseInt(s);
          }
          catch (Exception e)
          {
                e.printStackTrace();
          }
          return -1;
    }

    public static void main(String[] args)
    {
          System.out.println("Program for displaying pattern of *.");
          System.out.print("Enter the maximum number of *: ");
          int n = ReadInteger();
          n = 20;
         
          System.out.println("\nHere is the Diamond of Stars\n");

          for (int i = 1; i <= n; i++)
          {
                for (int j = 0; j < (n - i); j++)
                      System.out.print(" ");
                for (int j = 1; j <= i; j++)
                      System.out.print("*");
                for (int k = 1; k < i; k++)
                      System.out.print("*");
                System.out.println();
          }

          for (int i = n - 1; i >= 1; i--)
          {
                for (int j = 0; j < (n - i); j++)
                      System.out.print(" ");
                for (int j = 1; j <= i; j++)
                      System.out.print("*");
                for (int k = 1; k < i; k++)
                      System.out.print("*");
                System.out.println();
          }

          System.out.println();
    }

}
