//package m13;

import java.util.Arrays;
import java.util.Scanner;

 class heapsort 
{
public  void sort(int[] pq,int l)
{
int	n=l;
	
	for(int k=n/2;k>=1;k--)
		sink(pq,k,n);
		
	while(n>1)
	{
		exch(pq,1,n--);
		sink(pq,1,n);
	}	
}
public  void sink(int[] pq,int k,int n)
{
	while(2*k<=n)
	{
		int j=2*k;
		if(j<n&&less(pq,j,j+1))
			j++;
		if(!less(pq,k,j))
			break;
		exch(pq,k,j);
		k=j;
	}
}
public void display(int[] a,int l)
{
	
	 if(l==1)
	 {
	   double no=a[l-1];
       System.out.println(no);
	 }
	 else  if(l%2==0)
	 {
		double k= (double)(a[(l/2)-1]+a[(l/2)])/2.0;
	    System.out.println(k);
	 }
	 else
	 {
		 double p=a[((l)/2)];
		 System.out.println(p);
	 }
}
private  void exch(int[] pq,int n2, int i) {
	int swap=pq[n2-1];
	pq[n2-1]=pq[i-1];
	pq[i-1]=swap;
	
}
private  boolean less(int[] pq,int j, int i) {
	
	return pq[j-1]<pq[i-1];
}

}
public class Solution
{
public static void main(String[] args)
{
	heapsort h=new heapsort();
	Scanner s=new Scanner(System.in);
	int n=s.nextInt();
	int[] a=new int[n];
	int l=0;
	for(int i = 0;i<n;i++){
		a[i]=s.nextInt();
		l=i+1;
		h.sort(a,l);
		h.display(a,l);
		}
}
}