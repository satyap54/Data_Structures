import java.util.*;

class Cycle_Detect_DFS{

	static boolean visited[];
	static LinkedList<Integer> l[];
	static int V;

	static class Graph{

		public Graph(int v){
			V=v;
			visited=new boolean[V+1];
			Arrays.fill(visited,false);

			l=new LinkedList[V+1];
			for(int i=0;i<=V;i++){
				l[i]=new LinkedList<Integer>();
			}

		}

		void addEdge(int u,int v){
			l[u].add(v);
			l[v].add(u);
		}

		boolean isCyclic_dfs(){
			for(int i=0;i<=V;i++){
				if(!visited[i]){
					boolean ans=isCyclic_helper(i,i);
					if(ans)
						return true;
				}
			}

			return false;
		}

		static boolean isCyclic_helper(int node,int parent){
			LinkedList<Integer> x=l[node];
			visited[node]=true;

			for(int n: x){
				
				if(!visited[n]){
					boolean detect=isCyclic_helper(n,node);
					if(detect)
						return true;
				}
				else if(n!=parent)
					return true;
			}

			return false;
		}
	}

	public static void main(String[] args) {
		Graph g=new Graph(3);
		// g.addEdge(0,1);
		// g.addEdge(0,4);
		// g.addEdge(4,3);
		// g.addEdge(1,4);
		// g.addEdge(1,2);
		// g.addEdge(2,3);
		// g.addEdge(1,3);
		// g.addEdge(3,5);
		// g.addEdge(3,4);

		g.addEdge(0,1);
		g.addEdge(1,2);
		g.addEdge(2,3);

		System.out.println(g.isCyclic_dfs());
	}
}