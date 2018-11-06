//package m19;
import java.util.NoSuchElementException;
import java.util.Stack;
import java.util.Scanner;

public class Solution {
public static void main(String[] args)
{
	Scanner sc=new Scanner(System.in);
	ordered o=new ordered();
	while(sc.hasNext())
	{
		String s=sc.nextLine();
		String a[]=s.split(",");
		Book b =new Book();
		
		switch(a[0])
		{
		
		case "put":
			 b=new Book(a[1],a[2],Double.parseDouble(a[3]));
			int x=Integer.parseInt(a[4]);
			o.put(b, x);
		break;
		case "get":
		  int h=o.get(a[1],o.root);
		if(h==0)
		  {
			  System.out.println("null");
	       }
		  else
			  System.out.println(h);
		break;
		case "max":
			System.out.println(o.max().name+","+o.max().author+","+o.max().price);
			break;
		case "min":
			System.out.println(o.min().name+","+o.min().author+","+o.min().price);
			break;
		case "select":
			//System.out.println(a[1]);
		//o.rank("IT")
			System.out.println(o.select(Integer.parseInt(a[1])).name+","+o.select(Integer.parseInt(a[1])).author+","+o.select(Integer.parseInt(a[1])).price);
		
			break;
		case "floor":
			System.out.println(o.floor(a[1]).name+","+o.floor(a[1]).author+","+o.floor(a[1]).price);
			break;
		case "ceiling":
			System.out.println(o.ceiling(a[1]).name+","+o.ceiling(a[1]).author+","+o.ceiling(a[1]).price);
			break;
			
		}
	}
}
}
//package m19;


class Book
{
	String name;
	String author;
	double price;
	public Book(String name, String author, double price) 
	{
		this.name = name;
		this.author = author;
		this.price = price;
	}
	public Book() {
		
	}
	public int compareTo(Book key) {
				if(this.name.equals(key.name))
				{
					return 0;
				}
				else if(this.name.compareTo(key.name)>0)
				{
					return 1;
				}
				else
				return -1;
	}
	
}
 class ordered {
Node root;
	class Node
{
	int value;
	Book key;
	Node left,right;
	int size;
	public Node(Book key,int value,int size) {
		
		this.value = value;
		this.key = key;
		this.size=size;
	}
	
}
void put(Book k,int val)
{
	root=put(root,k,val);
}
Node put(Node root,Book k,int v)
{
	if(root==null)
		return new Node(k,v,1);
	int cmp=k.compareTo(root.key);
	if(cmp<0)
		root.left=put(root.left,k,v);
	else if(cmp>0)
		root.right=put(root.right,k,v);
	else
		root.value=v;
	root.size=1+size(root.left)+size(root.right);
	return root;
}
int get(String k,Node x)
{
	
	while(x!=null)
	{
		//System.out.println("Name:"+x.key.name);
		int cmp=k.compareTo(x.key.name);
		if(cmp<0)
			x=x.left;
		else if(cmp>0)
			x=x.right;
		else
			return x.value;
	}
	return 0;
}
Book floor(String k)
{
	Node x=floor(root,k);
	if(x==null)
		return null;
	return x.key;
}
Node floor(Node x,String k)
{
	if(x==null)
		return null;
	int cmp=k.compareTo(x.key.name);
	if(cmp==0)
		return x;
	if(cmp<0)
		return floor(x.left,k);
	Node t=floor(x.right,k);
	if(t!=null)
		return t;
	else
		return x;
}
public Book min()
{
	if(isEmpty())
		throw new NoSuchElementException("calls min() with empty symbol table");
	return min(root).key;
}
private Node min(Node x)
{ 
    if (x.left == null) 
    	return x; 
    else
    	return min(x.left); 
}
public Book max()
{
	if(isEmpty())
		throw new NoSuchElementException("calls max() with empty symbol table");
	return max(root).key;
}
private Node max(Node x)
{
	if(x.right==null)
		return x;
	else
		return max(x.right);
}
private boolean isEmpty() {
	return false;
}
Book ceiling(String key)
{
	 Node x = ceiling(root, key);
     if (x == null) return null;
     else return x.key;
}
private Node ceiling(Node x,String k)
{
	if(x==null)
		return null;
	int cmp=k.compareTo(x.key.name);
	if(cmp==0)
		return x;
	if(cmp<0)
	{
		Node t=ceiling(x.left,k);
	   if(t!=null)
		   return t;
	   else return x;
	}
	return ceiling(x.right,k);
}
public Book select(int k) 
{
  // System.out.println("k"+k); 
	Node x = select(root, k);
    return x.key;
} 
 Node select(Node x, int k) {
     
    while(x!=null)
    {
    //System.out.println(x.left+"left");
    int t = size(x.left); 
    if      (t > k) return select(x.left,  k); 
    else if (t < k) return select(x.right, k-t-1); 
    else            return x; 
	}
    return null;
 }
public int rank(String key) {
    if (key == null) throw new IllegalArgumentException("argument to rank() is null");
    return rank(key, root);
} 
private int rank(String key, Node x) {
    if (x == null) return 0; 
    int cmp = key.compareTo(x.key.name); 
    if      (cmp < 0) return rank(key, x.left); 
    else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right); 
    else              return size(x.left); 
}
public int size() {
    return size(root);
}
private int size(Node x) {
    if (x == null)
    	return 0;
    else return x.size;
}
public Iterable<Book> keys() {
    if (isEmpty()) return new Stack<Book>();
    return keys(min(), max());
}
public Iterable<Book> keys(Book lo, Book hi) {
    if (lo == null) throw new IllegalArgumentException("first argument to keys() is null");
    if (hi == null) throw new IllegalArgumentException("second argument to keys() is null");

    Stack<Book> q = new Stack<Book>();
    keys(root, q, lo, hi);
    return q;
} 
private void keys(Node x, Stack<Book> q, Book lo, Book hi) { 
    if (x == null) return; 
    int cmplo = lo.compareTo(x.key); 
    int cmphi = hi.compareTo(x.key); 
    if (cmplo < 0) keys(x.left, q, lo, hi); 
    if (cmplo <= 0 && cmphi >= 0) q.push(x.key); 
    if (cmphi > 0) keys(x.right, q, lo, hi); 
}
}