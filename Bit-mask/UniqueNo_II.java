import java.util.*;

class UniqueNo_II
{
	public static void main(String[] args) {
		int arr[]={1,1,2,2,3,3,5,6,6,7,8,8};
		int res=0;
		for(int i : arr)
			res=res^i;
		int temp=res,j=0;
		while(temp>0)
		{
			int x= temp & 1;
			if(x == 1)
				break;
			j++;
			temp=temp>>1;
		}
		int u1=0,u2=0,mask=1<<j;
		for(int i : arr)
		{
			int x= mask & i;
			if(x != 0)
				u1=u1^i;
			else
				u2=u2^i;
		}
		if(u1 >  u2)
			System.out.println(u2+" "+u1);
		else
			System.out.println(u1+" "+u2);
	}
}