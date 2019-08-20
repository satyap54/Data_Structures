import java.util.Scanner;
import java.math.*;
class bigint
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String a=sc.next(),b=sc.next();
		BigInteger x=new BigInteger(a);
		BigInteger y=new BigInteger(b);
		BigInteger res=x.gcd(y);
		System.out.println(res);

		//factorial
		 a=sc.next();
		 int p=Integer.parseInt(a);
		 BigInteger f=new BigInteger("1");
		 for(int i=1;i<=p;i++)
		 	f = f.multiply(BigInteger.valueOf(i));
		 System.out.println(f);

		 //remainder
		 a=sc.next();b=sc.next();
		 x=new BigInteger(a);y=new BigInteger(b);
		 System.out.println(x.mod(y));

		 //You can also specify base . I know am gonna be needing binaries . E.g x=new BigInteger(s,BASE)
		 a=sc.next();b=sc.next();
		 x=new BigInteger(a,2);y=new BigInteger(b,2);
		 System.out.println(x.multiply(y));
		 x=x.multiply(y);
		 System.out.println(x);

		 //nextProbablePrime()-finds the next prime no.
	}
}