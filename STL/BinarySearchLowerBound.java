class BinarySearchLowerBound
{
	public static void main(String[] args) {
		int arr[]={1,2,2,2,4,4,5};
		int e=6,s=0,ans=-1,key=2;
		while(s<=e)
		{
			int mid=(s+e)/2;
			if(arr[mid]==key)
			{
				ans=mid;
				e=mid-1;
			}
			else if(arr[mid]>key)
				e=mid-1;
			else
				s=mid+1;
		}
		System.out.println(ans);
	}
}