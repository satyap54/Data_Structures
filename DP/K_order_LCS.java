import java.util.*;

class K_order_LCS{
	static Scanner sc = new Scanner(System.in);
	static int m,n;
	static int[][][] memopad;
	public static void main(String[] args) {
		m=sc.nextInt();n=sc.nextInt();
		int k=sc.nextInt();
		memopad=new int[m][n][k];

		for(int p=0;p<m;p++)
			for(int q=0;q<n;q++)
				for(int r=0;r<k;r++)
					memopad[p][q][r]=-1;

		char[] x=new char[m];
		String s=sc.next();
		x=s.toCharArray();

		
		char[] y=new char[n];
		s=sc.next();
		y=s.toCharArray();


		System.out.println(LCS(x,y,0,0,k));
	}

	static int LCS(char x[],char y[],int i,int j,int k){
		if(i==m || j==n)
			return 0;

		if(memopad[i][j][k]!=-1)
			return memopad[i][j][k];

		if(x[i]==y[j])
			return 1+LCS(x,y,i+1,j+1,k);

		int res=0;

		if(k>0)
			res=Math.max(res, LCS(x,y,i+1,j+1,k-1));

		res=Math.max(res, LCS(x,y,i+1,j,k));
		res=Math.max(res, LCS(x,y,i,j+1,k));

		memopad[i][j][k]=res;
		return memopad[i][j][k];
	}
}