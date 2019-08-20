import java.util.*;

class Inversion_Count
{
	static int count=0;
	static int a[]={4,6,1,2,3,7};
	static void mergeSort(int s,int e){
		if(s>=e)
			return;

		int mid=(s+e)/2;

		mergeSort(s,mid);
		mergeSort(mid+1,e);

		merge(s,e);
	}

	static void merge(int s,int e){
		int mid=(s+e)/2,temp[]=new int[15],i=s,j=mid+1,k=s;

		while(i<=mid && j<=e){
			if(a[i]<a[j]){//if i<j but a[i] > a[j], an inversion occurs
				temp[k++]=a[i++];
			}
			else{
				count+=mid-i+1;
				temp[k++]=a[j++];
			}
		}

		while(i<=mid)
			temp[k++]=a[i++];

		while(j<=e)
			temp[k++]=a[j++];

		for(i=s;i<=e;i++)
			a[i]=temp[i];
	}

	public static void main(String[] args) {
		mergeSort(0,a.length-1);
		System.out.println(Arrays.toString(a));
		System.out.println(count);
	}
}