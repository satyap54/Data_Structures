import java.util.*;

class Rotated_Search
{
	static int a[]={6,7,1,2,3},key=0;
	public static void main(String[] args) {
		key=5;
		System.out.println(searchIn(0,4));
	}
	static int searchIn(int s,int e)
	{
		if(s>e)
			return -1;

		int mid=(s+e)/2;

		if(a[mid]==key)
			return mid;

		//Left part is sorted
		if(a[s]<=a[mid])
		{
			if(a[s]<=key && key<=a[mid])
				return searchIn(s,mid-1);
			else
				return searchIn(mid+1,e);
		}
		else if(a[e]>=a[mid])//right part is sorted
		{
			if(a[mid]<=key && key<=a[e])
				return searchIn(mid+1,e);
			else
				return searchIn(s,mid-1);
		}

		return -1;
	}
}