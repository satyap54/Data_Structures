//Remember that the no. of numbers divisible by m and are less than equal to N is given by Floor(N/m).This is very important
//aur questions aate hein iske upar
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.*;
class Not_So_Easy_math
{ 
    static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st;
        public FastReader() 
        { 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        }
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
  
    static FastReader sc=new FastReader();
    static int arr[]={2,3,5,7,11,13,17,19};//length=8
    static int tot_comb=(int)Math.pow(2, 8)-1;
    public static void process()
    {
         int n=sc.nextInt(); 
       	 compute(n); 
    }

    static void compute(int n)
    {
    	int res=0;
    	for(int i=1;i<=tot_comb;i++)
    	{
    		int odd_eve=count_setbits(i);//No. of setbits equlas to no. of no.s u have takes ; determine + or -
    		int idx=7,temp=i,smallres=n,denom=1;
    		while(temp!=0)
    		{
    			int x=temp&1;
    			if(x==1)
    				denom*=arr[idx];
    			idx--;
    			temp=temp>>1;
    		}

    		int y=odd_eve&1;
    		if(y==1)
    			res+=n/denom;
    		else
    			res-=n/denom;
    	}

    	System.out.println(res);
    }

    static int count_setbits(int x)
    {
    	int count =0;
    	while(x!=0)
    	{
    		count ++;
    		x=x&(x-1);
    	}
    	return count;
    }

    public static void main(String[] args) 
    { 
        int t=sc.nextInt();
        while(t-- > 0)
            process();
    } 
} 
    