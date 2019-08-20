import java.util.*;

class LuckyNum
{
	static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) {
		String s=sc.next();
		int l=s.length(),res=0,x=l-1,j=0;
		res+=2*((int)Math.pow(2,x)-1);
		for(int i = l-1 ; i>=0 ; i--)
		{
			char c=s.charAt(i);
			if(c=='7')
				res+=(int)Math.pow(2,j);
			j++;
		}
		System.out.println(res+1);
	}
}