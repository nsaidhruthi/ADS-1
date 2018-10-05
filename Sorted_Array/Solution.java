import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int[] a;
     int[] b;
     int n,m;
     Scanner sc=new Scanner(System.in);
     //System.out.println("enter number of elements in first array");
    String s1=sc.next();
     //System.out.println("enter number of elements in second array");
     String s2=sc.next();
     n=Integer.parseInt(s1);
     m=Integer.parseInt(s2);
    // System.out.println("enter array elements");
     a=new int[n];
     b=new int[m];
     for(int i=0;i<n;i++)
     {
    	 //System.out.println("a["+i+"]");
    	 a[i]=sc.nextInt();
     }
     for(int j=0;j<m;j++)
     {
    	// System.out.println("b["+j+"]");
    	 b[j]=sc.nextInt();
     }
     int[] c;
     int i=0,j=0,k=0;
     c=new int[m+n];
     while(i<a.length&&j<b.length)
     {
	   if(a[i]>b[j])
	   {
		   c[k]=b[j];
		   k++;
		   j++;
	   }
	   else
	   {
		   c[k]=a[i];
		   k++;
		   i++;
	   }
      }
     while(i<a.length)
     {
    	 c[k]=a[i];
    	 k++;
    	 i++;
     }
     while(j<b.length)
     {
    	 c[k]=b[j];
    	 k++;
    	 j++;
     }
     //System.out.println("after sorting");
     for(k=0;k<c.length;k++)
     {
    	 System.out.print(c[k]);
     }
	}

}
