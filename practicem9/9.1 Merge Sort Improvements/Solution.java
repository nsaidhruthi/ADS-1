//package m9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
     int a[];
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     String s;
     while((s=br.readLine())!=null)
     {
    	 //System.out.println(s);
    	 String st[]=s.split(",");
    	 //a.length=st.length;
    	 a=new int[st.length];
    	 //System.out.println(Arrays.toString(st));
    	 if(st[0].equals(""))
    	 {
    		 System.exit(0);
    	 }
    	 for(int i=0;i<a.length;i++)
    	 {
    		 a[i]=Integer.parseInt(st[i]);
    	 }
    	 
    	 merge m=new merge();
         m.sort(a, 0, a.length-1);
         m.display(a);
         System.out.println("");
     }
     
       
	}
}

class merge {
	public static void insertionsort(int a[],int l,int r)
	{
		for (int i = l; i <= r; i++)
            for (int j = i; j > l && less(a[j], a[j-1]); j--)
                exch(a, j, j-1);
	}
	  private static boolean less(Comparable a, Comparable b) {
	        return a.compareTo(b) < 0;
	    }
	  private static void exch(int[] a, int i, int j) {
	        int swap = a[i];
	        a[i] = a[j];
	        a[j] = swap;
	    }
void merge(int a[],int l,int m,int r)
{
	
	int p=m-l+1;
	int q=r-m;
	int L[]=new int[p];
	int R[]=new int[q];
	for(int i=0;i<p;i++)
	{
		L[i]=a[l+i];
	}
	for(int j=0;j<q;j++)
	{
		R[j]=a[m+1+j];
	}
	
	int i=0,j=0;
	int k=l;
	while(i<p&&j<q)
	{
		String s=String.valueOf(L[i]);
		String v=String.valueOf(R[j]);
		if(s.compareTo(v)<=0)
		{
			a[k]=L[i];
			k++;
			i++;
		}
		else 
		{
			a[k]=R[j];
			j++;
			k++;
		}
	}
	while(i<p)
	{
		a[k]=L[i];
	    k++;
	    i++;
	}
	while(j<q)
	{
		a[k]=R[j];
		k++;
		j++;
	}
}

void sort(int a[],int l,int r)
{
	
	 if (r-l<=7) 
	 { 
		 System.out.println("Insertion sort method invoked...");
		 insertionsort(a,l,r);
         
     }
	 else
	{
		
		int m=(l+r)/2;
		sort(a,l,m);
		sort(a,m+1,r);
		if(!(a[m]<=a[m+1])){
			merge(a,l,m,r);	
		}
		else
		{
			System.out.println("Array is already sorted. So, skipped the call to merge...");
		}
		
	}
}
void display(int a[])
{
	int n=a.length;

	System.out.print("[");
	for(int i=0;i<n;i++)
	{
		
		if(i==a.length-1)
		{
			System.out.print(a[i]);
		}
		else
		{
			System.out.print(a[i]+","+" ");
		}
	}
	System.out.println("]");
}
}
