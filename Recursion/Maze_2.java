import java.util.*;

class Maze_2
{
	static Scanner sc = new Scanner(System.in);
	static int sol[][],count;
	static char maze[][];
	public static void main(String[] args) {
		maze=new char[4][4];
		String s;
		count=0;
		for(int i=0;i<4;i++){
			s=sc.next();	
			maze[i]=s.toCharArray();
		}
		System.out.println();
		sol=new int[4][4];
		// for(int i=0;i<4;i++){
		// 	for(int j=0;j<4;j++){
		// 		System.out.print(maze[i][j]);
		// 	}
		// 	System.out.println();
		// }
		ratInMaze(0,0);
		
	}

	static boolean ratInMaze(int i,int j)
	{
		if(i==3 && j==3)
		{
			sol[i][j]=1;
			for(int p=0;p<4;p++){
				for(int q=0;q<4;q++){
					System.out.print(sol[p][q]);
				}
				System.out.println();
			}
			System.out.println();
			return true;
		}

		//Check if rat is inside the maze
		if(i>3 || j>3)
			return false;

		//Check if there's a blockage
		if(maze[i][j]=='X')
			return false;
	
		sol[i][j]=1;

		//Since we are counting the no. of possible paths, 
		//we'll check both if we can go down or right of a particular grid
		
		if(ratInMaze(i,j+1))
			return true;
		else if(ratInMaze(i+1,j))
			return true;
		sol[i][j]=0;
		return false;
	}
}