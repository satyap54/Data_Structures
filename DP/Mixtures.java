import java.util.*;

class Mixtures{
	
	static Scanner sc = new Scanner(System.in);
	static int memopad[][];

	public static void main(String[] args) {
		int n=sc.nextInt();
		int[] arr=new int[n];

		memopad=new int[n][n];
		for(int[] row:memopad)
			Arrays.fill(row,-1);

		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		System.out.println(smog(0,n-1,arr));
	}

	static int smog(int s,int e,int arr[]){
		//When u select only one bottle, smog created will be zero
		if(s==e)
			return 0;

		//If ans is present in the array
		if(memopad[s][e]!=-1)
			return memopad[s][e];

		//break the soln into pieces
		memopad[s][e]=Integer.MAX_VALUE;
		for(int k=s;k<=e;k++){
			memopad[s][e]=Math.min(memopad[s][e],smog(s,k,arr)+smog(k+1,e,arr)+csum(s,k,arr)*csum(k+1,e,arr));
		}

		return memopad[s][e];
	}

	static int csum(int i,int j,int arr[]){
		int sum=0;
		for(int p=i;p<=j;p++){
			sum+=arr[p];
			sum=sum%100;
		}

		return sum;
	}
}