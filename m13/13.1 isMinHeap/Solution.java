import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	String s1=s.nextLine();
	//Maxheap m1=new Maxheap();
	switch(s1)
	{
	case "String":int n=s.nextInt();
	              String s2[]=new String[n];
	              String s01=s.nextLine();
	              for(int i = 0;s.hasNext();i++)
	              {
	            	 String s3=s.next();
	            
	            	 String s4[]=null;
	            	 s4=s3.split(",");
	            	
	            	 Minheap m=new Minheap();
	            	System.out.println(m.sink(1,s4));
	              }
	              break;
	case "Integer":
		int n1=s.nextInt();
        String s21[]=new String[n1];
        String s011=s.nextLine();
        
        for(int i = 0;s.hasNext();i++)
        {
      	 String s3=s.next();
      
      	 String s4[]=null;
      	 s4=s3.split(",");
      	Double d[]=new Double[s4.length+1];
      	for(int p=1;p<=s4.length;p++)
      	{
      		d[p]=Double.parseDouble(s4[p-1]);
      	}
      	 Minheap m=new Minheap();
      	System.out.println(m.sink1(1,d));
        }
        break;
	case "Double":
		int n11=s.nextInt();
        String s211[]=new String[n11];
        String s0111=s.nextLine();
        
        for(int i = 0;s.hasNext();i++)
        {
      	 String s3=s.next();
      
      	 String s4[]=null;
      	 s4=s3.split(",");
      	Double d[]=new Double[s4.length+1];
      	for(int p=1;p<=s4.length;p++)
      	{
      		d[p]=Double.parseDouble(s4[p-1]);
      	}
      	 Minheap m=new Minheap();
      	System.out.println(m.sink1(1,d));
        }
        break;
        
	case "Float":
		int n111=s.nextInt();
        String s2111[]=new String[n111];
        String s01111=s.nextLine();
        
        for(int i = 0;s.hasNext();i++)
        {
      	 String s3=s.next();
      
      	 String s4[]=null;
      	 s4=s3.split(",");
      	Double d[]=new Double[s4.length+1];
      	for(int p=1;p<=s4.length;p++)
      	{
      		d[p]=Double.parseDouble(s4[p-1]);
      	}
      	 Minheap m=new Minheap();
      	System.out.println(m.sink1(1,d));
        }
        break;
	}

	}

}

class Minheap
{
	
	boolean sink(int k,String[] a)
	{
		boolean z = false;
		int n=a.length-1;
		while(2*k<=n)
		{
			int j=2*k;
			if(j<n&&less(a,j+1,j))
				j++;
			if(!less(a,k,j))
				{
				
				return false;}
			else
			{
			//exch(k,j);
			k=j;
			 //z=false;
			}
		}
		return true;
	}
	boolean sink1(int k,Double[] d)
	{

		int n=d.length-1;
		if(n==0)
                     {
return false;
                      }
else
{
               while(2*k<=n)
		{
			int j=2*k;
			if(j<n&&less1(d,j+1,j))
				j++;
			if(!less1(d,k,j))
				{
				
				return false;}
			else
			{
			//exch(k,j);
			k=j;
			 //z=false;
			}
		}
		return true;
}	}
	private boolean less(String[] a,int j, int i) {
		
		return a[j].compareTo(a[i])<=0;
	}
	
	private boolean less1(Double[] d,int j, int i) {
		//System.out.println(d.length+" "+j+" "+i);
		return d[j]<=d[i];
	}
}