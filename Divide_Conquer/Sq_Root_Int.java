//For precision P(denotes no. of decimal places) do +0.1, then 0.01 and so on 
import java.util.*;

class Sq_Root_Int
{
	
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int n=sc.nextInt(),p=sc.nextInt();
		System.out.println(sq_root(n));

		float res=(float)sq_root(n),d=1.0f;
		for(int i=1;i<=p;i++)
		{
			d/=10.0;
			//System.out.println(d);
			while(res*res<=n){
				res+=d;
				System.out.println(res);
			}

			res-=d;
			System.out.println(res);
		}

		System.out.println(res);
	}

	static int sq_root(int n)
	{
		int ans=0,mid=0,s=0,e=n;

		while(s<=e)
		{
			mid=(s+e)/2;

			if(mid*mid==n)
			{
				ans=mid;
				break;
			}
			else if(mid*mid<n)
			{
				ans=mid;
				s=mid+1;
			}
			else
			{
				e=mid-1;
			}
		}

		return ans;
	}
}