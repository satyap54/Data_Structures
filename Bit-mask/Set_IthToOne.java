import java.util.*;

class Set_IthToOne
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),i=sc.nextInt();
		int mask=1<<i;
		System.out.println(Integer.toBinaryString(n));
		n=n|mask;
		System.out.println(Integer.toBinaryString(n));
	}
}