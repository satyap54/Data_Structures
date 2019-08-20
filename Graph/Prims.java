import java.util.*;

class Prims{

	static class List{
		int node,wt;
		public List(int vertex,int w){
			node=vertex;
			wt=w;
		}
	}

	static class Graph{
		static LinkedList<List> l[];
		static boolean visited[];
		static int V,weight[],parent[];

		public Graph(int v){
			V=v;

			parent=new int[V];
			Arrays.fill(parent,-1);

			weight=new int[V];
			Arrays.fill(weight,Integer.MAX_VALUE);

			l=new LinkedList[V];
			visited=new boolean[V];

			Arrays.fill(visited,false);

			for(int i=0;i<V;i++){
				l[i]=new LinkedList<List>();
			}
		}

		void addEdge(int u,int v,int w){
			l[u].add(new List(v,w));
			l[v].add(new List(u,w));
		}

		static int findMinVertex(){
			int min=-1;

			for(int i=0;i<V;i++){
				if(!visited[i] && (min==-1 || weight[i]<weight[min]))
					min=i;
			}

			return min;
		}

		void prims(){
			parent[0]=-1;
			weight[0]=0;

			for(int i=0;i<V;i++){
				int minVertex=findMinVertex();
				visited[minVertex]=true;

				for(List e : l[minVertex]){
					if(!visited[e.node] && e.wt<weight[e.node])
						weight[e.node]=e.wt;
						parent[e.node]=minVertex;
				}
			}

			for(int i=0;i<V;i++)
				System.out.println(i+"--->"+parent[i]+" wt="+weight[i]);
		}
	}
}