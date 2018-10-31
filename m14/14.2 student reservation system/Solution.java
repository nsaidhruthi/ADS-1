//package m13;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

 class student {
String name,dob;
int m1,m2,m3,tot;
String cat;
public student()
{
	
}
public student(String[] data)
{
	this.name=data[0];
	this.dob=data[1];
	this.m1=Integer.parseInt(data[2]);
	this.m2=Integer.parseInt(data[3]);
	this.m3=Integer.parseInt(data[4]);
	this.tot=Integer.parseInt(data[5]);
	//System.out.println(tot);
	this.cat=data[6];
}

}
class heap
{
	public  void sort(ArrayList<student> pq)
	{
	int	n=pq.size();
		System.out.println(n);
		n=n-1;
		for(int k=(n/2)-1;k>=0;k--)
			sink(pq,k,n);
		
		while(n>0)
		{
			exch(pq,0,n--);
			sink(pq,0,n);
		}	
	}
	public  void sink(ArrayList<student> pq,int k,int n)
	{
		while(2*k+1<=n)
		{
			int j=2*k+1;
			if(j<n&&less(pq.get(j),pq.get(j+1)))
				j++;
			if(!less(pq.get(k),pq.get(j)))
				break;
			exch(pq,k,j);
			k=j;
		}
	}
	private  void exch(ArrayList<student> pq,int n2, int i) {
		Object swap=pq.get(n2);
		//System.out.println(n2+" "+i);
		pq.set((n2),(student)pq.get(i));
		pq.set((i),(student)swap);
		
	}
	private  boolean less(student a,student b) {
		
		if((a.tot)==b.tot)
		{
			if(a.m3==b.m3)
			{
				if(a.m2==b.m2)
				{
					if(compareToDob(a.dob,b.dob)<=0)
					{
								return false;
					}
					return true;
				}
				else if(a.m2<b.m2)
					return false;
					else
						return true;	
				}
			else if(a.m3<b.m3)
				return false;
			else
				return true;
				}
				
		else if(a.tot<b.tot)
			return false;
			else 
			return true;
		
	}
	private static int compareToDob(String dOB, String dOB2) {
		String[] a=dOB.split("-");
		String[] b=dOB2.split("-");
		if(Integer.parseInt(a[2])==Integer.parseInt(b[2]))
		{
			if(Integer.parseInt(a[1])==Integer.parseInt(b[1]))
			{
				if(Integer.parseInt(a[0])==Integer.parseInt(b[0]))
				{
					return 0;
				}
				else if(Integer.parseInt(a[0])>Integer.parseInt(b[0]))
					return 1;
				else
					return -1;
			}
			if(Integer.parseInt(a[1])>Integer.parseInt(b[1]))
				return 1;
			else
				return -1;
		}
		if(Integer.parseInt(a[2])>Integer.parseInt(b[2]))
			return 1;
		else
			return -1;		
	}
}
//package m13;

public class Solution {
	static ArrayList<student> al; 
	
	public void catfil(String cat, int nc, int cp, int op) {
		int j = 0, k = op;
		for(int i = cp;i < al.size() && j < nc;i++) {
			if (al.get(i).cat.equals(cat)) {
				student st1 = al.remove(i);
				while (k < cp && st1.tot < al.get(k).tot)
					k++;
				al.add(k++, st1);
				cp++;
				j++;
			}
		}
		for (k = op; j < nc; cp++, j++) {
			student st1 = al.remove(cp);
			while (st1.tot < al.get(k).tot)
				k++;
			al.add(k++, st1);
		}
	}

	public static void main(String[] args) throws IOException {
		
     Solution s=new Solution();
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	Scanner s1=new Scanner(System.in);
	al= new ArrayList<student>(30);
	
		int tst,tv,ur,bc,sc,st;
	tst=s1.nextInt();
	tv=s1.nextInt();
	ur=s1.nextInt();
	bc=s1.nextInt();
	sc=s1.nextInt();
	st=s1.nextInt();
	//System.out.println(tst+" "+st+" "+al.size());
	for(int i=0;i<tst;i++)
	{
	//	System.out.println(i);
		String z=s1.next();
		//sSystem.out.println(z);
		al.add(new student(z.split(",")));
	}
	heap h=new heap();
	h.sort(s.al);
	for (int i = 0; i <tst; i++)
		System.out.println(s.al.get(i).name+","+s.al.get(i).tot+","+s.al.get(i).cat);
	System.out.println();
	int cp = ur;
	s.catfil("BC", bc, cp, ur);
	cp+=bc;
	s.catfil("SC", sc, cp, ur);
	cp+=sc;
	s.catfil("ST", st, cp, ur);
	cp+=st;
	for(int i=0;i<tv;i++)
	{
		System.out.println(s.al.get(i).name+","+s.al.get(i).tot+","+s.al.get(i).cat);
	}
	}
}