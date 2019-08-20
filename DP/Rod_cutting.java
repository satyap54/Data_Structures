import java.util.*;

class Rod_cutting{
	static Scanner sc = new Scanner(System.in);
	static int dp[];
	public static void main(String[] args) {
		int total_len=sc.nextInt();

		int arr[]=new int[total_len+1];

		dp=new int[total_len+1];
		Arrays.fill(dp,-1);

		for(int i=1;i<=total_len;i++)
			arr[i]=sc.nextInt();

		System.out.println(top_down(arr,total_len));

		dp=new int[total_len+1];
		System.out.println(bottom_up(arr,total_len));
	}

	static int top_down(int arr[],int total_len){
		if(total_len==0)
			return 0;

		if(dp[total_len]!=-1)
			return dp[total_len];

		int best=0;

		for(int i=1;i<=total_len;i++){
			int net_profit=arr[i]+top_down(arr,total_len-i);
			best=Math.max(net_profit, best);
		}

		dp[total_len]=best;
		return dp[total_len];
	}

	static int bottom_up(int arr[],int total_len){

		for(int len=1;len<=total_len;len++){
			int best=0;
			for(int cut=len;cut>=1;cut--){
				best=Math.max(best, arr[cut]+dp[len-cut]);
			}

			dp[len]=best;
		}

		return dp[total_len];
	}
}