import java.util.*;

class Upper_Bound
{
	static int arr[]={1,2,2,2,2,4,4};
	public static void main(String[] args) {
		System.out.println(upper_bound(4));
	}

	static int upper_bound(int n)
	{
		int s=0,e=arr.length-1,ans=-1,mid=0;

		while(s<=e)
		{
			mid=(s+e)/2;

			if(arr[mid]<n)
				s=mid+1;
			else if(arr[mid]>n)
				e=mid-1;
			else
			{
				ans=mid;
				s=mid+1;
			}
		}

		return ans;
	}
}