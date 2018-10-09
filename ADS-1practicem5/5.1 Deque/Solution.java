import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
	Node old=first;
	first=first.next;
	if(first==null)
	{
		last=null;
	}
	else
		first.prev=null;
	n--;
	return old.item;
}
int popright()
{
	Node old=last;
	last=last.prev;
	if(last==null)
	{
		last=null;
	}
	else
	{
		last.next=null;
	}
	n--;
	return old.item;
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
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Deque d=new Deque();
		int n;
		int[] a=null;
		n=br.read();
		String w1[]=null;
		for(int i=0;i<=n;i++)
		{
			String s=br.readLine();
			w1=s.split(" ");
			switch(w1[i])
			{
			case "isEmpty":
				System.out.println(d.isEmpty());
				break;
			case "size":
				System.out.println(d.size());
				break;
			case "pushLeft":
				a[i]=Integer.parseInt(w1[i]);
				d.pushLeft(a[i]);
				break;
			case "pushRight":
				break;
			case "popLeft":
				System.out.println(d.popleft());
				break;
			case "popRight":
				System.out.println(d.popleft());
				break;
			}
		}
	}

}
