//package pc;

class Node
{
char data;
Node next;
Node(char d)
{
	data=d;
}
public String toString() {
	if(next==null)
	{
		return data+"";
	}
	else
	{
	return data+""+next;
	}
}  
}

public class LinkedList {
	Node head;
	
	
	public boolean isEmpty()
	{
		return head==null;
	}
    public void push(char new_data)
    {
    	Node n=new Node(new_data);
     	
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
    public char pop()
    {
    	char data=head.data;
    	head=head.next;
		return data;
    }
    public void printList() 
    { 
    Node tnode = head; 
    while (tnode != null) 
    { 
        System.out.print(tnode.data+" "); 
        tnode = tnode.next; 
    } 
}
    void append(char new_data)
    {
    	Node new_node=new Node(new_data);
    	if(head==null)
    	{
    		head=new Node(new_data);
    		return;
    	}
    	new_node.next=null;
    	Node last=head;
    	while(last.next!=null)
    	{
    		last=last.next;
    	}
    	last.next=new_node;
    	return;
    }
    public String toString()
    {
		if(head.next==null)
		{
			return head.data+"";
		}
		else
		{
		return head.toString();
		}
	}
}
