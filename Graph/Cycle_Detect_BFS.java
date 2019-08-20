import java.util.*;

class Cycle_Detect_BFS{

	static class Graph{
		static int V;
		static LinkedList<Integer> l[];
		static boolean visited[];
		static int[] parent;

		public Graph(int v){
			V=v;
			l=new LinkedList[V];
			for(int i=0;i<V;i++)
				l[i]=new LinkedList<Integer>();
			
			visited=new boolean[V];
			Arrays.fill(visited,false);
			parent=new int[V];
		}

		void addEdge(int u,int v){
			l[u].add(v);
			l[v].add(u);
		}

		boolean isCyclic(int src){
			Queue<Integer> q=new LinkedList<>();

			q.add(src);
			parent[src]=src;
			visited[src]=true;

			while(!q.isEmpty()){
				int node=q.poll();

				LinkedList<Integer> x=l[node];

				for(Integer n: x){
					if(visited[n]==true && n!=parent[node]){
						return true;
					}
					else if(!visited[n]){
						parent[n]=node;
						visited[n]=true;
						q.add(n);
					}
				}
			}

			return false;
		}
	}

	public static void main(String[] args) {
		Graph g=new Graph(6);
		g.addEdge(0,1);
		g.addEdge(0,4);
		g.addEdge(4,3);
		g.addEdge(1,4);
		g.addEdge(1,2);
		g.addEdge(2,3);
		g.addEdge(1,3);
		g.addEdge(3,5);
		g.addEdge(3,4);

		System.out.println(g.isCyclic(0));
	}
}