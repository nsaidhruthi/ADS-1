import java.util.Scanner;

public class Solution {

	public static void main(String[] args)
     {
	Scanner s=new Scanner(System.in);
	int m=s.nextInt();
	int n=s.nextInt();
	String a[]=new String[m*5];
    int no[]=new int[m];
    hash h=new hash(m*5);
    for(int i=0;i<m;i++)
    {
    	String s4=s.next();
		a[h.hashfunc(s4)]=s4;
		no[i]=h.hashfunc(s4);
	}
	int count=0;int c1;
	for(int i = 0;i<n;i++)
	{
		String s4=s.next();
		int p=h.hashfunc(s4);
		c1=0;
		for(int j = 0;j<m;j++)
		{
			if(p==no[j])
			{
				c1++;
				break;
			}
		}
		if(c1==0)
		{
			break;
		}
		else
		{
		if(a[p].equals(s4))
		{
			a[p]=a[p]+"...";
			count++;
			
		}
	    }
	}
		if(count==n)
		{
			System.out.println("Yes");
		}
		else
		{
			System.out.println("No");
		}

	
}}
	


 class hash {
	int n;

	public hash(int n) {
	
	this.n = n;
}

	public int hashfunc(String s)
	{
		int nn = 6784;
		int sum=0;
		for(int i = 0;i<s.length();i++)
		{
			sum=sum+(s.charAt(i))*i;
		}
		sum=sum%n;
		return sum;
	}
}
