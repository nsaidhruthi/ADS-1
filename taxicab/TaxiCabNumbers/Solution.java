//package m15;

import java.util.Scanner;

public class Solution {
	 public static void Taxinumber(int N,int M) 
	    {  
	        int i = 1, count = 0; 
	        while (count < N)  
	        { 
	           int int_count = 0; 
	           for (int j = 1; j <= Math.pow(i, 1.0/3); j++)  
	 
	              for (int k = j + 1; k <= Math.pow(i, 1.0/3); k++) 
	       
	                  if (j * j * j + k * k * k == i) 
	                      int_count++;
	           if (int_count == M)  
	           { 
	              count++; 
	             // System.out.println(count + " " + i);   
	           } 
	       
	           i++;
	        } 
	        System.out.println(i-1);
	    } 
	      
	    /* Driver program to test above function */
	    public static void main(String[] args)  
	    {
	    	Scanner sc=new Scanner(System.in);
	    	String s=sc.nextLine();
	    	//System.out.println(s);
	    	String s1[]=s.split(" ");
	    	//System.out.println(s1[0]+""+s1[1]);
	    	Taxinumber(Integer.parseInt(s1[0]),Integer.parseInt(s1[1]));
	          
	    } 

}
