

import java.io.IOException;

import java.util.Scanner;
class Deque
{
Node first=null;
Node last=null;
int n=0;
class Node
{
	int item;
	Node next;
	Node prev;
}
public Deque()
{
	
}
public boolean isEmpty()
{
	return first==null;
}
public int size()
{
	return n;
}
void pushLeft(int item)
{
	Node N=new Node();
	N.item=item;
	if(first!=null)
	{
		N.next=first;
		first.prev=N;
	}
	first=N;
	if(last==null)
	last=first;
	n++;
}
void pushRight(int item)
{
    Node N=new Node();
    N.item=item;
    if(last!=null)
    {
    	N.prev=last;
    	last.next=N;
    }
    last=N;
    if(first==null)
    	first=last;
    n++;
}
int  popleft()
{

	if(first==null)
	{
		return 0;
	}
	else
	{	Node temp1=first;
	first=first.next;
	   return temp1.item;
	}
	
}
int popright()
{
Node temp1=null;
	
	if(first==null)
		
	{
		return 0;
	}
	else if(first.next==null)
	{Node temp=first;
	first=null;
		return temp.item;
	}
	else
	{
		Node temp=first;
	
	while(temp.next.next!=null)
	{
		temp=temp.next;
	}
	temp1=temp.next;
	temp.next=null;
	return temp1.item;
	}
	
}
public void display()
{	
	Node temp=first;
	if(first==null)
	{
		System.out.println("Deck is empty");
	}
	else
	{
		System.out.print("[");
	while(temp!=null)
	{
		
		System.out.print(temp.item);
		temp=temp.next;
		if(temp!=null)
		System.out.print(", ");
	}
	System.out.print("]");
	System.out.println();
	}
}
public String toString()
{
	if(first.next==null)
	{
		return first.item+"";
	}
	return null;	
}
}
public class Solution {

	public static void main(String[] args) throws IOException
	{
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		String st[]=new String[n+1];
		int i;
		for(i=0;i<n+1;)
		{

			st[i]=s.nextLine();
			i++;
		}

		String st1[]=new String[2];
		Deque l=new Deque();
		int count=0;
		for(i=0;i<(st.length);i++)
		{
			
			st1=st[i].split(" ");
			switch(st1[0])
			{
			case "pushLeft":
		                     l.pushLeft(Integer.parseInt(st1[1]));
		                     l.display();
			                 break;
			case "pushRight":
		                     l.pushRight(Integer.parseInt(st1[1]));   
		                     l.display();
		                     break;
			case "popLeft":l.popleft();
							l.display();
			
			                 break;
			case "popRight":l.popright();
			                l.display();
		                     break;
			case "size":System.out.println(l.size());
			                 break;
			default:break;
		   
		                
			}
			
		}
	}

}
