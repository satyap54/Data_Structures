import java.util.*;

class Subseq_recur
{
	static Scanner sc = new Scanner(System.in);
	static char in[]={'a','b','c','\0'},out[];	
	public static void main(String[] args) {
		out=new char[100];
		subseq(0,0);
	}

	static void subseq(int i,int j)
	{
		if(in[i]=='\0')
		{
			out[j]='\0';
			System.out.println(out);
			return;
		}

		out[j]=in[i];
		subseq(i+1,j+1);
		subseq(i+1,j);
	}
}