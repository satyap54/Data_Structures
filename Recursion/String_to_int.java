import java.util.*;

class String_to_int
{
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String s=sc.next();

		System.out.println(int_of(s,s.length()));
	}

	static int int_of(String s,int l)
	{
		int c=s.charAt(0)-'0';

		if(l==1)
			return c;

		int pow_mul=(int)Math.pow(10,l-1);

		return (c*pow_mul)+int_of(s.substring(1),l-1);
	}
}