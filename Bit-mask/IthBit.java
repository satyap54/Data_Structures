import java.util.*;
class IthBit
{
	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt(),i=sc.nextInt();
	System.out.println(get_i_bit(n,i));	
	}

	static int get_i_bit(int n,int i)
	{
		return (n & (1<<i))==0?0:1;
	}
}