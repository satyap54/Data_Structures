import java.util.*;

class Shoptrip{
	static Scanner sc = new Scanner(System.in);

	static class Pair{
		int x,y;
		public Pair(int a,int b){
			x=a;
			y=b;
		}
	}

	static double distance[][],dp[][];
	static int n,k,ingredients[],pos_comb;
	static Pair coords[];

	static double dist(Pair a,Pair b){
		int dx=a.x-b.x,dy=a.y-b.y;
		double dist=Math.sqrt(dx*dx+dy*dy);
		return dist;
	}

	public static void main(String[] args) {
		int t=sc.nextInt();

		while(t-- > 0){
			process();
		}
	}

	static void process(){
		n=sc.nextInt();k=sc.nextInt();
		coords=new Pair[n+1];
		pos_comb=(1<<k);
		int possible=0;

		dp=new double[pos_comb][n+1];
		for(double row[] : dp)
			Arrays.fill(row,-1);

		pos_comb--;

		coords=new Pair[n+1];
		ingredients=new int[n+1];

		for(int i=1;i<=n;i++)
		{
			int x=sc.nextInt(),y=sc.nextInt();
			coords[i]=new Pair(x,y);
		}

		for(int i=1;i<=n;i++){
			String s=sc.next();
			StringBuilder input = new StringBuilder(); 
			input.append(s);
			input=input.reverse();
			s=input.toString();
			ingredients[i]=Integer.parseInt(s,2);
			possible=possible|ingredients[i];
		}

		if(possible!=pos_comb)
			System.out.println("-1");
		else{
			distance=new double[n+1][n+1];
			for(int i=1;i<=n;i++){
				for(int j=1;j<=n;j++)
					distance[i][j]=dist(coords[i],coords[j]);
			}

			double ans=shoptrip(0,0);
		}

	}

	static double shoptrip(int mask,int idx){
		if(mask==pos_comb){
			return distance[idx][0];
		}

		if(dp[mask][idx]!=-1)
			return dp[mask][idx];

		dp[mask][idx]=Integer.MAX_VALUE;

		for(int i=0;i<=n;i++){
			int temp=mask|ingredients[i];
			if(temp!=mask){
				dp[mask][idx]=Math.min(dp[mask][idx],distance[i][idx]+shoptrip(temp,i));
			}
		}

		return dp[mask][idx];
	}
}