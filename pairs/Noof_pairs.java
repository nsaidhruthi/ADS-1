import java.util.Arrays;
import java.util.Scanner;

public class Noof_pairs {

	public static void main(String[] args) {
		
     int[] a;
     int[] b;
     int n;
     Scanner sc=new Scanner(System.in);
     System.out.println("enter number of elments to be entered");
     n=sc.nextInt();
     a=new int[n];
     b=new int[a.length];
     for(int i=0;i<n;i++)
     {
    	 a[i]=sc.nextInt();
     }
     for(int i=0;i<n;i++)
     {
    	 for(int j=i+1;j<n;j++)
    	 {
    		 if(a[i]==a[j])
    		 {
    			b[i]=a[i];
    		 }
    	 }
     }
     Arrays.sort(b);
    System.out.println(Arrays.toString(b));
	}
}