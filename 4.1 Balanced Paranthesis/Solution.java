

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class Node
{

	public char item;
	public Node next;
	Node(char item)
	{
		this.item=item;
		this.next=null;
	}
	
}
class Paranthesis
{
	private Node first=null;
	public boolean isEmpty()
	{
		return first==null;
	}
	public void push(char c)
	{
		Node n=new Node(c);
		if(first==null)
		{
			first=n;
		}
		else
		{
			n.next=first;
			first=n;
		}
		
	}public char pop()
	{
		char item = 0;
		if(first!=null)
		{
			item=first.item;
			first=first.next;
			
		}
		return item;
	}
}
class Paran
{
	Paranthesis pa=new Paranthesis();
	char ch;
	boolean b=true;
	
	 public Paran(String s)
	{
   //for(int j=0;j<s.length();j++)
	//{
	for(int i=0;i<s.length();i++)
	{
		char c=s.charAt(i);
		if(c=='('||c=='{'||c=='[')
		{
			pa.push(c);
		}
		else if(c=='}'||c==']'||c==')')
		{
			if(pa.isEmpty())
			{
				System.out.println("NO");
				return;
			}
			ch=pa.pop();
			boolean t=isMatch(ch,c);
			if(t==false)
			{
				System.out.println("NO");
				return;
			}
		}	
	}
	  
	
	  
		   System.out.println("YES");
	   		
		
	}

	private boolean isMatch(char ch2, char c) {
		if(ch=='[' && c==']')
		{
			return true;
		}
		else if(ch=='{' && c=='}')
		{
			return true;
		}
		else if(ch=='(' && c==')')
		{
		return true;
		}
		else
		{
			return false;
		}
		
	}
}
public class Solution {

	public static void main(String[] args) throws IOException {
		 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int s;
		s=Integer.parseInt(br.readLine());
		//System.out.println("string"+s);
		
		for(int i=0;i<s;i++)
		{
			Paran p1=new Paran(br.readLine());
		}
      
	}

}
