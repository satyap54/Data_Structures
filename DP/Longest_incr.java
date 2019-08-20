import java.util.*;

class Longest_incr{
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n=sc.nextInt();

		int[] arr=new int[n],dp=new int[n+1];

		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
			dp[i]=1;
		}

		int best=1;

		for(int i=0;i<n;i++){
			for(int j=0;j<i;j++){
				if(arr[i]>arr[j])
					dp[i]=Math.max(dp[i],dp[j]+1);
			}

			best=Math.max(dp[i],best);
		}

		System.out.println(best);
	}
}