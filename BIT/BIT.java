import java.util.*;

class BIT{
	static Scanner sc = new Scanner(System.in);
	static int N,tree[];
	static void update(int i,int incr){
		while(i<=N){
			tree[i]+=incr;
			i+=(i&(-i));
		}
	}

	public static void main(String[] args) {
		N=sc.nextInt();
		tree=new int[N+1];
		int x=0;
		for(int i=1;i<=N;i++){
			x=sc.nextInt();
			update(i,x);
		}

	}

	static int query(int i){
		int sum=0;
		while(i>0){
			sum+=tree[i];
			i-=(i&(-i));
		}

		return sum;
	}

}