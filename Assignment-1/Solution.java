//package pc;
import java.util.Scanner;
class AddLargeNumbers {
	
    public static LinkedList numberToDigits(String number) 
    {
    	 LinkedList l=new LinkedList();
    	 char c;
         char ch[]=number.toCharArray();
		for(int i=0;i<ch.length;i++)
		{
			c=ch[i];
	        l.push(c);
		}
		return l;
        
    }

    public static String digitsToNumber(LinkedList list)
    {
    	//System.out.println(list.pop());
    	String s1=list.toString();
    	return s1;

    }

    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
		return null;

    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch(input){
            case "numberToDigits":
                LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
                LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
                System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
                System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
                break;

            case "addLargeNumbers":
                LinkedList pDigits1 = AddLargeNumbers.numberToDigits(p);
                LinkedList qDigits1 = AddLargeNumbers.numberToDigits(q);
                LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits1, qDigits1);
                System.out.println(AddLargeNumbers.digitsToNumber(result));
                break;
        }
    }
    
}