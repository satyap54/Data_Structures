import java.util.*;

class Bottom_up_Fib{
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n=sc.nextInt();

		int[] arr=new int[n+1];

		arr[0]=0;arr[1]=1;

		for(int curr_ans=2;curr_ans<=n;curr_ans++)
			arr[curr_ans]=arr[curr_ans-1]+arr[curr_ans-2];

		System.out.println(arr[n]);
	}
}