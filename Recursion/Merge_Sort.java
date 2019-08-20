import java.util.*;

class Merge_Sort
{
	static int a[]={5,6,1,2,4,0};

	static void mergeSort(int s,int e)
	{
		if(s>=e)
			return;

		int mid=(s+e)/2;

		mergeSort(s,mid);
		mergeSort(mid+1,e);

		merge(s,e);
	}

	static void merge(int s,int e)
	{
		int mid=(s+e)/2;
		int i=s,j=mid+1,temp[]=new int[100],k=s;

		while(i<=mid && j<=e)
		{
			if(a[i]<a[j]){
				temp[k]=a[i];
				k++;i++;
			}
			else if(a[i]>a[j]){
				temp[k]=a[j];
				k++;j++;
			}
			else
			{
		    	//System.out.println("here");
				temp[k]=a[i];
				i++;k++;
				temp[k]=a[j];
				j++;k++;
			}
		}

		while(i<=mid)
			temp[k++]=a[i++];
		while(j<=e)
			temp[k++]=a[j++];

		for(int p=s;p<=e;p++)
			a[p]=temp[p];
	}
	public static void main(String[] args) {
		
		int l=a.length;
		mergeSort(0,l-1);
		System.out.println(Arrays.toString(a));
	}
}