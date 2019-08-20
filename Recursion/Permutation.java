import java.util.*;

class Permutation
{
	static Scanner sc = new Scanner(System.in);
	static char in[];
	public static void main(String[] args) {
		String s=sc.next()+'\0';
		in=s.toCharArray();	
		//System.out.println(in);
		permute(0);
	}

	static void permute(int i)
	{
		//base case
		if(in[i]=='\0')
		{
			System.out.println(in);
			return;
		}

		//recurseive case
		for(int j=i;in[j]!='\0';j++)
		{
			//swap
			char temp=in[i];
			in[i]=in[j];in[j]=temp;
			//System.out.println(in);
			permute(i+1);
			//BackTrack-to restore the original array
			temp=in[i];
			in[i]=in[j];in[j]=temp;
		}
	}
}