//This program demonstrates use of BigInteger class in java.
import java.util.*;
import java.math.*;
 class Julkaa
 {
 	public static void main(String[] args) {
 		Scanner sc=new Scanner(System.in);
 		BigInteger appltogether,more;
 		appltogether=sc.nextBigInteger();more=sc.nextBigInteger();
 		BigInteger two=new BigInteger("2");
 		BigInteger res=appltogether.subtract(more);
 		res=res.divide(two);
 		System.out.println(res);	
 	}
 }