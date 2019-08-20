import java.util.*;

class Range_max{
	static Scanner sc = new Scanner(System.in);
	static int N,tree[];
	public static void main(String[] args) {
		N=sc.nextInt();
		tree=new int[N+1];
		for (int i=1;i<=N ;i++ ) {
			int x=sc.nextInt();
			update(i,x);	
		}

		int t=sc.nextInt();
		while(t-- > 0){
			int idx=sc.nextInt();
			System.out.println(query(idx));
		}
	}

	static void update(int i,int incr){
		while(i<=N){
			tree[i]=Math.max(tree[i], incr);
			i+=(i&(-i));
		}
	}

	static int query(int i){
		int ans=tree[i];
		while(i>0){
			ans=Math.max(ans, tree[i]);
			i-=(i&(-i));
		}

		return ans;
	}
}