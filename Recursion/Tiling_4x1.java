import java.util.*;

class Tiling_4x1
{
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n=sc.nextInt();

		System.out.println(tile(n));
	}

	static int tile(int n)
	{
		if(n<0)
			return 0;


		if(n<4)
			return 1;
		else if(n==4)
			return 2;
		else
			return tile(n-1)+tile(n-4);
	}
}