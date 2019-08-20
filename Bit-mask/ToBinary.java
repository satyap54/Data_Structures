import java.util.*;

class ToBinary
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		String s=Integer.toBinaryString(n);
		System.out.println(s);
		n=Integer.parseInt(s,2);
		System.out.println(n);
	}
}