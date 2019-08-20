import java.util.*;

class Tower_Hanoi
{
	static Scanner sc = new Scanner(System.in);

	static void move_poll(int n,char src,char destination,char helper)
	{
		if(n==0)
			return;
		move_poll(n-1,src,helper,destination);

		System.out.println("Move "+n+" disc from "+src+" to "+destination);

		move_poll(n-1,helper,destination,src);
	}

	public static void main(String[] args) {
		move_poll(3,'A','B','C');
	}
}