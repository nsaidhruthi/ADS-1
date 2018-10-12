import java.util.Scanner;

class Node
{
	int item;
	Node next ;
	Node(int a)
	{
		this.item=a;
	}
	
}
class Link
{
	Node first=null;
	public boolean isEmpty()
	{
		return first==null;
	}
	public void push(int item)
	{
		Node n=new Node(item);
		
		if(first==null)
		{
			first=n;
			
		}
		else
		{	
		
		n.next=first;
                 first=n;
		}
	}
	public void enqueue(int item)
	{
		Node n=new Node(item);
		
		if(first==null)
		{
			first=n;
			
		}
		else
		{	
               Node temp=first;
               while(temp.next!=null)
               {
              temp=temp.next;
		}
              temp.next=n; 
                } 
	}
	public int pop()
	{
		if(first==null)
		{
			return 0;
		}
		else
		{
		Node old=first;
		first=first.next;
		return old.item;
	    }
	}
	public void display()
	{	
		Node temp=first;
		if(first==null)
		{
			System.out.println("Steque is empty");
		}
		else
		{
		while(temp!=null)
		{
			
			System.out.print(temp.item+"ppp");
			temp=temp.next;
			if(temp!=null)
			System.out.print(", ");
		}
		System.out.println();
		}
	}
}
public class Solution {
public static void main(String args[])
{
	Scanner s=new Scanner(System.in);
	int n=s.nextInt();
	String st1[]=new String[2];
	String st=null;
	int i;
	for(i=0;i<=n;i++)
	{
		Link l=new Link();
       do
		{
			st=s.nextLine();
				st1=st.split(" ");
				switch(st1[0])
				{
				case "push":
			          l.push(Integer.parseInt(st1[1]));
			          l.display();
                      break;
				case "enqueue":
			          l.enqueue(Integer.parseInt(st1[1]));   
			          l.display();
			          break;
				case "pop":
					l.pop();
					l.display();
                    break;
		        }
		}
       while( s.hasNext() &&st.length()!=0);
	   if(i!=0)
		{
	     System.out.println();
		}
		}
}
}
