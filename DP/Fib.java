import java.util.*;

class Fib{
	static Scanner sc = new Scanner(System.in);

	static int memopad[];

	public static void main(String[] args) {
		memopad=new int[100];

		Arrays.fill(memopad,-1);

		memopad[0]=0;memopad[1]=1;

		int n=sc.nextInt();

		System.out.println(fib(n));
	}

	static int fib(int n){
		if(n==0){
			return 0;
		}

		if(n==1){
			return 1;
		}

		if(memopad[n]!=-1)
			return memopad[n];

		int ans=fib(n-1)+fib(n-2);
		memopad[n]=ans;
		return ans;
	}
}