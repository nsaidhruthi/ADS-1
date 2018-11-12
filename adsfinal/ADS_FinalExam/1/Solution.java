import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;
import java.util.StringTokenizer;
class Method<Value,Keys>
{
	int m=30001;
	Value[] val=(Value[]) new Object[m*9];
	Student[] keys= new Student[m*9];
	int hash(Value k)
	{
		//System.out.println(k.hashCode());
		return k.hashCode();
	}
	void put(Student k,Value v)
	{
		int i;
	
		for(i=hash(v);val[i]!=null;i=(i+1)%m)
		{
			//System.out.println(i);
		if(v.equals(val[i]))
			return;
		}
		val[i]=v;
		keys[i]=k;
	}
	public Student get(Value v)
	{
		int i;
		for(i=hash(v);val[i]!=null;i=(i+1)%m)
			if(v.equals(val[i]))
			return keys[i];
		return null;
	}
}
class Student {
String rollnumber;
String name;
double marks;
public Student(String rollnumber, String name,double marks) {
	this.rollnumber = rollnumber;
	this.name = name;
    this.marks=marks;
}
}

public class Solution {

	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int s=Integer.parseInt(br.readLine());
		//System.out.println(s);
		//Student[] s1=new Student[s*9];
		Method m=new Method();
		
		for(int i=1;i<=s;i++)
		{
			String a=br.readLine();
			StringTokenizer st=new StringTokenizer(a,",");
			String b[]=new String[st.countTokens()];
			int j=0;
			while(st.hasMoreTokens())
			{
				b[j++]=st.nextToken();
			}
			//System.out.println(b[0]+" "+b[1]+" "+b[2]);
		Student s2=new Student(b[0],b[1],Double.parseDouble(b[2]));
			m.put(s2, b[0]);
		}
		int p=Integer.parseInt(br.readLine());
		while(p>0)
		{
			String c=br.readLine();
			String d[]=c.split(" ");
			switch(d[0])
			{
			case "get":
				if(Integer.parseInt(d[2])==1)
				{
					System.out.println(m.get(d[1]).name);
				}
				else
					System.out.println(m.get(d[1]).marks);
				break;
			}
			p--;
		}

	}}

