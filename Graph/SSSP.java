import java.util.*;

class SSSP{

	static class Graph{

		static int V;
		static LinkedList<Integer> l[];
		static boolean visited[];
		static int[] dist,parent;

		public Graph(int v){
			V=v;
			l=new LinkedList[V];

			parent=new int[V];
			dist=new int[V];
			Arrays.fill(dist,Integer.MAX_VALUE);

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

		void bfs(int src){
			Queue<Integer> q=new LinkedList<>();
			q.add(src);
			
			visited[src]=true;
			dist[src]=0;
			parent[src]=src;

			while(!q.isEmpty()){
				int node=q.poll();
				//System.out.print(node+" ");
				LinkedList<Integer> x=l[node];

				for(Integer neighbour : x){
					if(!visited[neighbour]){
						q.add(neighbour);
						dist[neighbour]=dist[node]+1;
						parent[neighbour]=node;
						visited[neighbour]=true;
					}
				}
			}
			
			for(int i=0;i<V;i++)
				System.out.println("Distance of "+i+" is "+dist[i]);
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

		g.bfs(0);
	}
}