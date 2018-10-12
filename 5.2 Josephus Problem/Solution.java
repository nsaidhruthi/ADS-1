import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Queue
{
	Node first=null;
	Node last=null;
	int N=0;
    class Node
    {
    	int item;
    	Node next;
    	Node prev; 
    }
	public boolean isEmpty()
	{
		return first==null;
	}
    public int size()
    {
    	return N;
    }
	public void enqueue(int i)
	{
    Node p = last;
    last = new Node();
    last.item = i;
    last.next = null;
    if (isEmpty())
    first = last;
    else
    p.next = last;
    ++N;
    }

	public int dequeue()
	{
	Node o=new Node();
	o.item=first.item;
	first=first.next;
	if(isEmpty())
	{
		last=null;
	}
	N--;
	return o.item;
	}
}

public class Solution {
  public static void main(String args[]) throws IOException
  {
	  Queue q=new Queue();
	  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	  int test,n,m;
	  test=Integer.parseInt(br.readLine());
	  while(test>0)
	  {
	  //System.out.println("n"+n);
		  
	    String s=br.readLine();
	    String st[]=s.split(" ");
	     n=Integer.parseInt(st[0]);
	      m=Integer.parseInt(st[1]);
      StringBuilder str=new StringBuilder("");
	  for(int i=0;i<n;i++)
	  {
		  q.enqueue(i);
	  }
	  int count=0;
	  while(!q.isEmpty())
	  {
		 if(count==m-1)
		 {
			 str.append(q.dequeue()+" ");
			 count=0;
		 }
		 else
		 {
			 q.enqueue(q.dequeue());
			 count++;
		 }
	  }
	int x=str.length();
	  String su=str.substring(0,x-1);
	System.out.println(su);    
	test--;
      }
  }
  }

