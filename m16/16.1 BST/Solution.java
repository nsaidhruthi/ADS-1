//package Bst;
import java.util.Scanner;

class Book
{
	String name,author;
	float price;
	Book(String n,String a,float p)
	{
		this.name=n;
		this.author=a;
		this.price=p;
	}
}
class Bst {
	Node root;
	class Node
	{
		Book key;
		int value;
		Node left,right;
		int size;
		public Node(Book key, int value) {
			this.key = key;
			this.value = value;
		}
		
	}
	public void display()
	{
		Node n=root;
		while(n!=null)
		{
			System.out.println(n.value);
			n=n.right;
		}
	}
	public int size() {
        return size(root);
    }
	 private int size(Node x) {
	        if (x == null) return 0;
	        else return x.size;
	    }
   public int get(String k,Node x)
   {
	   
	   if(x!=null)
	   {
		   //System.out.println(x.key.name);
		   int cmp=k.compareTo(x.key.name);
		   if(cmp<0)
		   {
			    return get(k,x.left);
		   }
		   else if(cmp>0)
		   {
			   return get(k,x.right);
		   }
		   else
			   return x.value;
	   }
	   
	return 0;
   
   }
   private int compare(Book k, Book key) {
	if(k.name.equals(key.name))
	{
		return 0;
	}
	else if(k.name.compareTo(key.name)>0)
	{
		return 1;
	}
	else
	return -1;
}
public void put(Book k,int v)
   {
	//System.out.println(k.name+""+v);
	   root=put(root,k,v);
   }
  Node   put(Node x,Book k,int v)
   {
	  if(x==null)
	  {
		  return new Node(k,v);
	  }
		  int cmp=compare(k,x.key);
		  if(cmp<0)
		  {
			  x.left=put(x.left,k,v);
			  
		  }
		  else if(cmp>0)
		  {
			  x.right=put(x.right,k,v);
		  }
		  else
			  //System.out.println(v);
			  x.value=v;
			  //System.out.println(x.value);
	return x;
	   
   }
}
//package Bst;


public class Solution {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Bst z=new Bst();
		while(sc.hasNext())
		{
		String str=sc.nextLine();
		String a[]=str.split(",");
		switch(a[0])
		{
		case "put":
			Book b=new Book(a[1],a[2],Float.parseFloat(a[3]));
			int x=Integer.parseInt(a[4]);
			//System.out.println("a[4"+a[4]);
			z.put(b, x);
			break;
		case "get":
			
			//System.out.println(s.);
			//System.out.println("hh");
			int h=z.get(a[1],z.root);
			//System.out.println(h);
			//System.out.println(h);
			if(h==0)
			{
				System.out.println("null");
			}
			else
			 System.out.println(h);
			
				break;
		}
	}
	}
}
