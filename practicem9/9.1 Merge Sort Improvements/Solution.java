

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
     String a[]=null;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     String s;
     while((s=br.readLine())!=null)
     {
    	 String st[]=s.split(",");
    	// a.length=st.length;
    	 a=new String[st.length];
    	 for(int i=0;i<a.length;i++)
    	 {
    		 //System.out.println(st[i]);
    		 a[i]=st[i];
    	 }
    	 merge m=new merge();
         m.sort(a, 0, a.length-1);
         m.display(a);
         
     }
     
         
	}
}
//package m9;
class merge {
	public static void insertionsort(String a[],int l,int r)
	{
		for (int i = l; i <= r; i++)
            for (int j = i; j > l && less(a[j], a[j-1]); j--)
                exch(a, j, j-1);
	}
	  private static boolean less(Comparable a, Comparable b) {
	        return a.compareTo(b) < 0;
	    }
	  private static void exch(String[] a, int i, int j) {
	        String swap = a[i];
	        a[i] = a[j];
	        a[j] = swap;
	    }
void merge(String[] a,int l,int m,int r)
{
	
	int p=m-l+1;
	int q=r-m;
	String L[]=new String[p];
	String R[]=new String[q];
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

void sort(String a[],int l,int r)
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
		if(!(a[m].compareTo(a[m+1])<=0)){
			merge(a,l,m,r);	
		}
		
	}
}
void display(String a[])
{
	int n=a.length;
System.out.println("array is already sorted. So, skipped the call to merge...");
	System.out.print("[");
	for(int i=0;i<n;i++)
	{
		
		if(i==a.length-1)
		{
			System.out.print(a[i]);
		}
		else
		{
			System.out.print(a[i]+",");
		}
	}
	System.out.println("]");
}
}
