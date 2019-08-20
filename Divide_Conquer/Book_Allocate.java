import java.util.*;

class Book_Allocate
{
	static Scanner sc = new Scanner(System.in);
	static int arr[],n,k;
	public static void main(String[] args) {
		n=sc.nextInt();k=sc.nextInt();
		int sum=0;
		//n->no. of books  k->no. of students
		arr=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
			sum+=arr[i];
		}

		book_allocate(0,sum);
	}

	static void book_allocate(int s,int e){
		int ans=0;

		while(s<=e){
			int mid=(s+e)/2;

			if(isValid(mid)){
				ans=mid;
				e=mid-1;
			}
			else{
				s=mid+1;
			}
		}

		System.out.println(ans);
	}

	static boolean isValid(int mid){
		int students=1,current_pages=0;

		for(int i=0;i<n;i++){
			if(current_pages+arr[i]<=mid)
				current_pages+=arr[i];
			else{
				current_pages=arr[i];
				students++;
			}
		}

		if(students>k)
			return false;
		else
			return true;
	}
}