import java.util.Stack;

public class EvaluatePostfix {
static Stack<String> s =new Stack<String>();

public static void pushIt(int value)
{
	s.push(Integer.toString(value));
}
private static int popInt()
{
	if(!s.isEmpty()){
		return Integer.parseInt(s.pop());
	}
	return -1;
	
}
public static int evaluate(String s1)
{
	for(int i=0;i<s1.length();i++){
		char d=s1.charAt(i);
		if(Character.isDigit(d)){
			s.push(Character.toString(d));
		}
		else if(!Character.isDigit(d)&&!Character.isLetter(d)){
			
			int i1=popInt();
			int i2=Integer.parseInt(s.pop());;
			switch(d)
			{
			case '+': pushIt(i1+i2);
			break;
			case '-': pushIt(i1-i2);
			break;
			case '*': pushIt(i1*i2);
			break;
			case '/': pushIt(i1/i2);
			break;
			
			}
		}
	}
	return Integer.parseInt(s.pop());
}
public static void main(String args[])
{
	System.out.println(evaluate("231*+9-"));
}


}
