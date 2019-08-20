/*It's an important interview based question .
You've to find the unique no. from an array where all elements except one are repeated thrice . 
*/
import java.util.*;

class UniqueNo_III
{

	static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) {
		int arr[]={1,1,1,3,3,3,4,4,4,5,6,6,6,8,8,8};
		int res[] = new int[32];	
		for (int i = 0; i<arr.length ; i++ ) {
			int j=0,temp=arr[i];
			while(temp>0)
			{
				int x= temp & 1;
				if(x == 1)
					res[j]++;
				j++;
				temp=temp>>1;
			}
		}

		for (int i=0; i<res.length ;i++ ) {
			res[i]=res[i]%3;
		}

		String s="";
		for(int i=0;i<32;i++)
		{
			if(res[i] == 1)
				s="1"+s;
			else
				s="0"+s;
		}
		System.out.println(Integer.parseInt(s,2));
	}
}