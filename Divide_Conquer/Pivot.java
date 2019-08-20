import java.util.*;

class Pivot
{
	static int arr[]={3,4,5,6,7,8,9,10,1,2};
	public static void main(String[] args) {
		System.out.println(pivot());
	}

	static int pivot()
	{
		int s=0,e=arr.length-1,mid=0;
		if(s==e)//when only one element is present
			return 0;

		while(s<=e)
		{
			mid=(s+e)/2;
			if(arr[mid]<arr[mid-1])
				return mid-1;

			if(arr[mid+1]<arr[mid])
				return mid;

			if(arr[mid]<=arr[s])//left part is unsorted so, search there
				e=mid-1;
			else if(arr[mid]>=arr[e])//right part is unsorted
				s=mid+1;
		}

		return -1;
	}
}