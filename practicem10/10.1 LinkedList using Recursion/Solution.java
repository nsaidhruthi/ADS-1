import java.util.Scanner;

//import adsm8.Recursion;

public class Solution {

	public static void main(String[] args) {
				int n;
				Recursion l=new Recursion();
				Scanner s=new Scanner(System.in);
				String st[]=new String[3];
				String st1;
				for(int i = 0;s.hasNext();i++)
				{
					st1=s.nextLine();
					st=st1.split(" ");
					switch(st[0])
					{
					case "insertAt":
						if(Integer.parseInt(st[1])>=0&&Integer.parseInt(st[1])<=l.size())
						{
						l.InserAt(Integer.parseInt(st[1]),Integer.parseInt(st[2]));
					
						l.display();
						}
						else
						{
							System.out.println("Can't insert at this position.");
						}
						break;
					case "reverse":
						l.reverse(0);
					    l.display();
						break;
					}
				}
			}
}


	
