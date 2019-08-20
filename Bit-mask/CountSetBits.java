//set bits = no. of 1s in the binary representation.
import java.util.*;
class CountSetBits
{
	static int count_ones(int n)
	{
		int count =0;
		while(n!=0)
		{
			count+=n&1;
			n = n>>1;
		}
		return count;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		System.out.println(count_ones(n));
	}
}