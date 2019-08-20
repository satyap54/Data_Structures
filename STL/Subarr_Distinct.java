import java.util.*;

class Subarr_Distinct
{
	static Scanner sc = new Scanner(System.in);
	static int MOD=1000000000+7;
	public static void main(String[] args) {
		HashSet<Integer> h = new HashSet<Integer>();
		int n=sc.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		int j=0;
		int ans=0;
		for(int i=0;i<n;i++)
		{
			// for(int j=i;j<n;j++)
			// {
			// 	if(!h.contains(arr[j]))
			// 	{
			// 		ans+=(j-i+1);
			// 		h.add(arr[j]);
			// 	}
			// }
			// h.clear();

			while(j<n && !h.contains(arr[j]))
			{
				h.add(arr[j]);
				j++;
				
			}
			ans+=(j-i)*(j-i+1)/2;
			h.remove(arr[i]);
		}
		System.out.println(ans);
	}
}
