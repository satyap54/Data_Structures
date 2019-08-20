import java.util.*;
//The problem set is : You are given Hulk and your enemy is at some level x. You've to reach there by using jumps which are 
//in the powers of 2. What will be the min. no. of jumps required ? 
//To solve it , use bit-masking . No. of set bits in binary representation of x gives the answer . Eg. 13 = 1101 , 3 is the ans.

class IncredibleHulk
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int level=sc.nextInt();
		String s=Integer.toBinaryString(level);
		int count=0;
		for(int i=0;i<s.length();i++)
		{
			char c=s.charAt(i);
			if(c=='1')
				count++;
		}
		System.out.println(count);
	}
}