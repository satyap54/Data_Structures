import java.util.*;

class Gen_SubString
{
	static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) {
		String s=sc.nextLine();
		int l=s.length();
		int no_of_subs=(int)Math.pow(2,l);
		String[] res = new String[no_of_subs];
		for(int i=0;i<no_of_subs;i++)
		{
			String temp="",bin=Integer.toBinaryString(i);
			while(bin.length()!=l)
				bin="0"+bin;

			for(int j=0;j<bin.length();j++)
			{
				char c=bin.charAt(j);
				if(c=='1')
					temp+=s.charAt(j);
			}
			res[i]=temp;

			//alternate sol.

			int no=i,k=0;
			while(no!=0)
			{
				int t=no&1;
				if(t==1)
					System.out.print(s.charAt(k));
				k++;
				no=no>>1;
			}
			System.out.println("");
		}
		System.out.println(Arrays.toString(res));
	}
}