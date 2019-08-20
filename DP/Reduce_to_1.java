import java.util.*;


class Reduce_to_1{
	static Scanner sc = new Scanner(System.in);
	static int inf=Integer.MAX_VALUE;
	static int memopad[];
	public static void main(String[] args) {
		int n=sc.nextInt();
		memopad=new int[1000];

		Arrays.fill(memopad,-1);
		memopad[1]=0;memopad[2]=1;memopad[3]=1;memopad[0]=0;
		System.out.println(min_steps(n));

		Arrays.fill(memopad,0);
		memopad[1]=0;memopad[2]=1;memopad[3]=1;memopad[0]=0;

		System.out.println(bottom_up(n));
	}

	//top-down
	static int min_steps(int n){
		if(n==1)
			return 0;

		if(memopad[n]!=-1)
			return memopad[n];

		int q1=inf,q2=inf,q3=inf;

		if(n%3==0)
			q3=1+min_steps(n/3);
		if(n%2==0)
			q2=1+min_steps(n/2);
		q1=1+min_steps(n-1);

		memopad[n] = Math.min(q1, Math.min(q2, q3));
		return memopad[n];
	}

	//bottom-up
	static int bottom_up(int n){

		for(int curr_num=4;curr_num<=n;curr_num++){
			int q1=inf,q2=inf,q3=inf;
			if(curr_num%3==0)
				q3=1+memopad[curr_num/3];
			if(curr_num%2==0)
				q2=1+memopad[curr_num/2];
			q1=1+memopad[curr_num-1];

			memopad[curr_num] = Math.min(q1, Math.min(q2, q3));
		}
		return memopad[n];	
	}
}