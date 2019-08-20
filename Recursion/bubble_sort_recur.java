import java.util.*;

class bubble_sort_recur
{
	static Scanner sc = new Scanner(System.in);
	static int[] arr={5,4,3,2,1};	
	public static void main(String[] args) {
		

		bubble(arr.length,0);

		System.out.println(Arrays.toString(arr));
	}

	static void bubble(int n,int i)
	{
		if(i==n-1)
			return;

		for(int j=0;j<n-i-1;j++)
		{
			if(arr[j]>arr[j+1])
			{
				arr[j]=arr[j+1]^arr[j];
				arr[j+1]^=arr[j];
				arr[j]^=arr[j+1];
			}
		}

		bubble(n,++i);
	}
}