import java.util.*;

class Strongly_Conn{

	static class Graph{
		static boolean visited[];
		static LinkedList<Integer> l1[],l2[];
		static int V;

		public Graph(int v){
			V=v;
			visited=new boolean[V];
			l1=new LinkedList[V];
			l2=new LinkedList[V];

			for(int i=0;i<V;i++){
				l1[i]=new LinkedList<Integer>();
				l2[i]=new LinkedList<Integer>();
			}
		}

		void addEdge(int u,int v){
			l1[u].add(v);
			l2[v].add(u);
		}

		boolean dfs(){
			Arrays.fill(visited,false);
			dfs_helper(l1,0);
			int a=0;
			for(boolean x : visited)
				if(x)
					a++;

			Arrays.fill(visited,false);
			dfs_helper(l2,0);
			int b=0;
			for(boolean x : visited)
				if(x)
					b++;
			System.out.println(a+" "+b);
			if(a==b)
				return true;
			else
				return false;

		}

		static void dfs_helper(LinkedList<Integer> l[],int node){
			visited[node]=true;
			
			LinkedList<Integer> x=l[node];

			for(Integer n : x){
				if(!visited[n])
					dfs_helper(l,n);
			}

		}
	}

	public static void main(String[] args) {
		Graph g=new Graph(3);

		g.addEdge(1,2);
		//g.addEdge(2,1);
		g.addEdge(0,1);
		// g.addEdge(1,0);
		// g.addEdge(2,0);
		//g.addEdge(1,2);

		System.out.println(g.dfs());
	}
}