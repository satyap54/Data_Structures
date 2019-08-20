import java.util.*;

class Binary_Search
{
	static int arr[]={1,3,5,7,9,10};
	static int s=0,e=5;
	public static void main(String[] args) {
		System.out.println(binary_search(10));
	}

	static int binary_search(int x)
	{
		while(s<=e)
		{
			int mid=(s+e)/2;
			if(arr[mid]==x)
				return mid;
			else if(arr[mid]>x)
				e=mid-1;
			else
				s=mid+1;
		}

			return -1;
	}
}