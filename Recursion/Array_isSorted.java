import java.util.*;

class Array_isSorted
{
	static Scanner sc = new Scanner(System.in);
	static int size;
	static int arr[];
	public static void main(String[] args) {
		size=sc.nextInt();
		arr=new int[size];
		for(int i=0;i<size;i++)
			arr[i]=sc.nextInt();
		System.out.println(check_isSorted(0));	
	}

	static boolean check_isSorted(int i)
	{
		if(i==size-1)
			return true;

		if(arr[i]<arr[i+1])
			return check_isSorted(++i);
		else
			return false;
		
	}
}