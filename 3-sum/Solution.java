import java.util.Arrays;
import java.util.Scanner;

public class Solution{

	public static void main(String[] args) {Scanner sc = new Scanner(System.in);
	int count=0;
	int i=0,j,k,l,k1=0,sum;
	//System.out.println("enter size");
	int n=sc.nextInt();
int  q[]=new int[n];

		while(sc.hasNext() ) {
			 q[i] =  sc.nextInt();
			 i++;
		}
		Arrays.sort(q);
		for(j=0;j<q.length;j++)
		{
			for(k=(j+1);k<q.length;k++)
			{
				 sum=q[j]+q[k];
				 k1 = Arrays.binarySearch(q, -sum);
				if(k1>k)
				{
	            count++;
					
				}
			}
		}
		System.out.println(count);
	}
	

}
