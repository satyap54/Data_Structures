import java.util.*;

class keypad_letter
{
	static Scanner sc = new Scanner(System.in);
	static String letters[]={" "," ","ABC ","DEF ","GHI ","JKL ","MNO ","PQRS ","TUV ","WXYZ "};
	static char out[];static char in[]={'3','2','2','\0'};
	static Vector<String> v = new Vector<>();
	public static void main(String[] args) {
		
		out=new char[100];
		keypad(0,0);
		System.out.println(v);
	}

	static void keypad(int i,int j)
	{
		if(in[i]=='\0')
		{
			out[j]='\0';
			v.add(String.valueOf(out));
			return;
		}

		int digit=in[i]-'0';

		for(int k=0;letters[digit].charAt(k)!=' ';k++)
		{
			out[j]=letters[digit].charAt(k);
			keypad(i+1,j+1);
		}
	}
}