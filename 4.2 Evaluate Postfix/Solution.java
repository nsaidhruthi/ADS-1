import java.util.Scanner;
class Node
	{
		int item;
		Node next;
	}
class Sort
{
	private Node first=null;
	
	public boolean isEmpty()
	{
		return first==null;
	}
	public void push(int item)
	{
	Node oldfirst=first;
	first=new Node();
	first.item=item;
	first.next=oldfirst;
    }
	public int pop()
	{
		int item=first.item;
		first=first.next;
		return item;
	}
}
class stack
{
	Sort s=new Sort();
	public int postfix(String p)
	{
	
    int i;
    for(i=0;i<p.length();i++)
	{
		char c=p.charAt(i);
		if(c==' ')
		{
			continue;
		}
		else if(Character.isDigit(c))
		{
			int n=0;
			while(Character.isDigit(c))
			{
				n=n*10+(int)(c-'0');
				i++;
				c=p.charAt(i);
			}
			i--;
			s.push(n);
			}
		else
		{
	//		int sum=0;
			int v=s.pop();
			int v2=s.pop();
			switch(c)
			{
			case '+':
		//		sum=v+v2;
				s.push(v+v2);
				break;
			case '-':
			//	sum=v-v2;
				s.push(v-v2);
				break;
			case '*':
				//sum=v*v2;
				s.push(v*v2);
				break;
			case '/':
				//sum=v/v2;
				s.push(v/v2);
				break;
		    }
			
			}
		}
	
	return s.pop();
	}
}
public class Solution
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		String str;
		str=sc.nextLine();
		stack s=new stack();
		System.out.println(s.postfix(str));
	}
}
