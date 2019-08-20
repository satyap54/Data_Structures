import java.util.*;

class N_Queen
{
	static Scanner sc = new Scanner(System.in);
	static int board[][],n;
	public static void main(String[] args) {
		n=sc.nextInt();
		board=new int[n][n];
		compute(0);
	}

	static boolean compute(int i)
	{
		if(i==n)
		{
			for(int p=0;p<n;p++){
				for(int q=0;q<n;q++)
					System.out.print(board[p][q]);
				System.out.println();
			}
			return true;
		}

		for(int j=0;j<n;j++)
		{
			if(isSafe(i,j))
			{
				board[i][j]=1;
				boolean nextQueenSafe=compute(i+1);
				if(nextQueenSafe)
					return true;
				board[i][j]=0;
			}
		}
		//When we are not able to place queen in any column of a 
		//row , we return false
		return false;
	}

	static boolean isSafe(int i,int j)
	{
		//we check first if that column has any queen
		for(int row=0;row<=i;row++)
		{
			if(board[row][j]==1)
				return false;
		}

		//left diagonal
		int x=i,y=j;
		while(x>=0 && y>=0){
			if(board[x][y]==1)
				return false;
			x--;y--;
		}

		//right diagonal
		x=i;y=j;
		while(x>=0 && y<n){
			if(board[x][y]==1)
				return false;
			x--;y++;
		}

		return true;
	}
}