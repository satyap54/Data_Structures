import java.util.*;

class DFS{

	static class Graph{

		static int V;
		static LinkedList<Integer> l[];
		static boolean visited[];

		public Graph(int v){
			V=v;
			l=new LinkedList[V];

			for(int i=0;i<V;i++){
				l[i]=new LinkedList<Integer>();
			}

			visited=new boolean[V];
			Arrays.fill(visited,false);
		}

		void addEdge(int u,int v,boolean bidir){
			l[u].add(v);
			if(bidir)
				l[v].add(u);
		}

		void adj_print(){

			for(int i=0;i<V;i++){
				System.out.print(i+"->");
				for(Integer j : l[i])
					System.out.print(j+" ");
				System.out.println();
			}
		}

		static void dfs(int src){
			dfs_helper(src);
		}

		static void dfs_helper(int node){
			//Whenever you come to a node, mark it as visited
			visited[node]=true;
			System.out.print(node+" ");

			//Find out a neighbour of current node which is not yet visited
			LinkedList<Integer> x=l[node];

			for(Integer neighbour: x){
				if(!visited[neighbour]){
					dfs_helper(neighbour);
				}
			}
		}
	}

	public static void main(String[] args) {
		Graph g=new Graph(6);
		g.addEdge(0,1,true);
		g.addEdge(0,4,true);
		g.addEdge(4,3,true);
		g.addEdge(1,4,true);
		g.addEdge(1,2,true);
		g.addEdge(2,3,true);
		g.addEdge(1,3,true);
		g.addEdge(3,5,true);
		g.addEdge(3,4,true);

		//g.adj_print();

		g.dfs(0);
	}
}