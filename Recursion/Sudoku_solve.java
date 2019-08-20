import java.util.*;

class Sudoku_solve
{
	static Scanner sc = new Scanner(System.in);
	static int sudoku[][],n,sub_n;

	public static void main(String[] args) {
		n=sc.nextInt();//Sudoku board is n x n
		sudoku=new int[n+1][n+1];

		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++){
				sudoku[i][j]=sc.nextInt();
			}
		}
		System.out.println();
		sub_n=(int)Math.sqrt(n);//dimension of sub matrix
		boolean flag=sudoku_solve(0, 0);
		if(flag)
			;
		else
			System.out.println("This can't be solved");	
	}

	
	static boolean sudoku_solve(int i,int j)
	{
		//System.out.println(i);
		if(i==n){
			for(int p=0;p<n;p++){
				for(int q=0;q<n;q++)
					System.out.print(sudoku[p][q]+" ");
				System.out.println();
			}
			System.out.println();
			return true;
		}

		if(j==n)
			return sudoku_solve(i+1,0);
		//If the current cell is filled, go to the next cell
		if(sudoku[i][j]!=0)
			return sudoku_solve(i,j+1);

		for(int number=1;number<=n;number++){
			if(canPlace(i,j,number)){
				sudoku[i][j]=number;

				boolean couldSolveNext=sudoku_solve(i,j+1);
				if(couldSolveNext)
					return true;
			}
		}
				
		//When the further calls by placing all values of number doesn't
		//work, undo the current call and go to previous call
		//by passing false;
		sudoku[i][j]=0;
		return false;
		
	}

	static boolean canPlace(int i,int j,int number){
		for(int p=0;p<n;p++){
			if(sudoku[p][j]==number)
				return false;
		}

		for(int p=0;p<n;p++){
			if(sudoku[i][p]==number)
				return false;
		}

		int sx=(i/sub_n)*sub_n,sy=(j/sub_n)*sub_n;

		for(int p=sx;p<sx+sub_n;p++){
			for(int q=sy;q<sy+sub_n;q++){
				if(sudoku[p][q]==number)
					return false;
			}
		}

		return true;
	}
}