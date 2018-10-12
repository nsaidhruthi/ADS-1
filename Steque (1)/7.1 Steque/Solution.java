import java.util.Scanner;


public class Solution{
	public static void main(String args[])
	{
Scanner s=new Scanner(System.in);
int n=s.nextInt();
String st1[]=new String[2];
String st=null;
int i;
for(i=0;i<=n;i++)
{
	Linkl l=new Linkl();


	do
	{
		st=s.nextLine();
		
		
		//	System.out.println(st);
			st1=st.split(" ");
			switch(st1[0])
			{
			case "push":
		                     l.pushfront(Integer.parseInt(st1[1]));
		                     l.display();

	System.out.println();
			                 break;
			case "enqueue":
		                     l.pushend(Integer.parseInt(st1[1]));   
		                     l.display();

	System.out.println();
		                     break;
			case "pop":l.popfront();
							l.display();

	System.out.println();
			                 break;
			//default:break;
		   
		                
			}
			
		}while(s.hasNext() && st.length()!=0);
if(i!=0)
	{
System.out.println();
	}
	

}
	}
}
class Linkl{
Node head;

public void pushend(int a)
	{
		Node n=new Node(a);
	
		if(head==null)
		{
			head=n;
			
		}
		else
		{	Node temp =head;
		while(temp.next!=null)
		{
			temp=temp.next;
		}
		
		temp.next=n;
		
		}
		
	}
	public int  popend()
{
		Node temp1=null;
	
	if(head==null)
		
	{
		return 0;
	}
	else if(head.next==null)
	{Node temp=head;
	head=null;
		return temp.data;
	}
	else
	{
		Node temp=head;
	
	while(temp.next.next!=null)
	{
		temp=temp.next;
	}
	temp1=temp.next;
	temp.next=null;
	return temp1.data;
	}
	

}

public void display()
{	
	Node temp=head;
	if(head==null)
	{
		System.out.print("Steque is empty.");
	}
	else
	{
		//System.out.print("[");
	while(temp!=null)
	{
		
		System.out.print(temp.data);
		temp=temp.next;
		if(temp!=null)
		System.out.print(", ");
	}
	//System.out.print("]");
	}
}
public void pushfront(int a)
{

		Node n=new Node(a);
	
		if(head==null)
		{
			head=n;
			
		}
		else
		{	n.next=head;
		    head=n;
		    
		}
		
}
public int popfront()
{
	
		if(head==null)
		{
			return 0;
		}
		else
		{	Node temp1=head;
		head=head.next;
		   return temp1.data;
		}
		
}


public int size()
{Node temp1=head;
int count=0;
while(temp1!=null)
{
	temp1=temp1.next;
	count++;
	
}
return count;
	
}
public String toString() {
	Node temp=head;
	
	return head+"";
}

}



 class Node {
int data;
Node next;
Node(int a)
{
	this.data=a;
}
@Override
public String toString() {
	return data +""+next;
}

}
 
