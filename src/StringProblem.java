import java.util.Arrays;
import java.util.*;

/**
 * @author shravan
 *
 */
public class StringProblem {

	static boolean stringUnique(String a)
	{
		if(a.length()>128)
		{
			return false;
		}
		
		
		boolean[] arr=new boolean[128];
		
		for(int i=0;i<a.length();i++)
		{
			int  ascii=a.charAt(i);
			if(arr[ascii])
			return false;
			
			arr[ascii]=true;
		}
		return true;
	}
	
	static boolean isPermutation(String a ,String b)
	{
		char[] ch1=a.toCharArray();
		char[] ch2=b.toCharArray();
		Arrays.sort(ch1);
		Arrays.sort(ch2);
		String SortedString1=new String(ch1);
		String SortedString2=new String(ch2);
		return SortedString1.equals(SortedString2);
	}
	
	//this method tells whether two strings are one edit away
	static boolean isOneEditReplace(String s1,String s2)
	{
		if(s1.length()==s2.length())
		{
		boolean onceDiffFound=false;
		for(int i=0;i<s1.length();i++)
	   {
		   if(s1.charAt(i)!=s2.charAt(i)){
			   if(onceDiffFound){
				   return false;
			   }
			   onceDiffFound=true;
		   }
	   }
		
		return true;
		}
		else{
			return false;
		}
	}
	
	static boolean oneInsertAway(String s1,String s2)
	{
		int index1=0;
		int index2=0;
		while(index2<s2.length() && index1<s1.length())
		{
			if(s1.charAt(index1)!=s2.charAt(index2))
			{
				if(index1!=index2)
				{
					return false;//this condition of character not equal and indexes not equal mean they are unequal second time and hence not one insert away
				}
				index2++;
				
			}
			else{
				index1++;
				index2++;
			}
		}
		return true;
	}
	
	
	 static String compress(String str) {
		 StringBuilder compressed = new StringBuilder();
		int countConsecutive = 0;
		 for (int i = 0; i < str.length(); i++) {
		 countConsecutive++;

		 if ( i + 1 >= str.length()||str.charAt(i) != str.charAt(i + 1)) {
		 compressed.append(str.charAt(i));
		 compressed.append( countConsecutive);
		 countConsecutive = 0;
		 }
		 }
		 return compressed.length() < str.length() ? compressed .toString() : str;
		}
	 
	 static void StairCase(int n) {
	       
	        int j_counter=0;
	        for(int i=1;i<=n;i++)
	            {
	        for(int j=0;j<=n-i;j++)
	           {
	           System.out.print(" ");
	            j_counter=j;
	       }
	        while(j_counter<n){
	            System.out.print("#");
	            j_counter++;
	        }
	            System.out.println();
	        }

	    }
		
		
		
		
		
	
	

		public static String longestPalindrome(String s) {
		    if(s==null || s.length()<=1)
		        return s;
		 
		    int len = s.length();
		    int maxLen = 1;
		    boolean [][] dp = new boolean[len][len];
		 
		    String longest = null;
		    for(int l=0; l<s.length(); l++){
		        for(int i=0; i<len-l; i++){
		            int j = i+l;
		            if(s.charAt(i)==s.charAt(j) && (j-i<=2||dp[i+1][j-1])){
		                dp[i][j]=true;
		 
		                if(j-i+1>maxLen){
		                   maxLen = j-i+1; 
		                   longest = s.substring(i, j+1);
		                }
		            }
		        }
		    }
		 
		    return longest;
		}

	public static void main(String args[])
	{
//		String a =new String("abcd");
//		System.out.println(stringUnique(a));
		
//		System.out.println(isPermutation("abc","bcad"));
		
		//System.out.println(isOneEditReplace("pale","pali"));
		//System.out.println(oneInsertAway("ple","pale"));
		//System.out.println(compress("aabbcddddefgggggggggf"));
		//StairCase(6);
		System.out.println(longestPalindrome("ababbacd"));
	}
}
