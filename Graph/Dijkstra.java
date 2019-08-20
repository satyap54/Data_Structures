import java.util.*;

class Dijkstra{

	static class Pair{
		int node;
		int wt;

		public Pair(int n,int w){
			node=n;
			wt=w;
		}
	}

	static class Graph{

		static int V;
		static LinkedList<Pair> l[];
		static int dist[];
		static boolean visited[];

		public Graph(int v){
			V=v;

			l=new LinkedList[V];
			for(int i=0;i<V;i++)
				l[i]=new LinkedList<Pair>();

			dist=new int[V];
			Arrays.fill(dist,Integer.MAX_VALUE);

			visited=new boolean[V];
			Arrays.fill(visited,false);
		}

		void addEdge(int u,int v,int w){
			l[u].add(new Pair(v,w));
			l[v].add(new Pair(u,w));
		}

		void dijkstra(int src){
			dist[src]=0;
			
			for(int i=0;i<V;i++){
				int city=find_min();
				LinkedList<Pair> x=l[city];
				visited[city]=true;
				for(Pair p : x){
					if(!visited[p.node]){
						int temp=dist[city]+p.wt;

						if(temp<dist[p.node])
							dist[p.node]=temp;
					}
				}
			}

			for(int i=0;i<V;i++)
				System.out.println(i+"-->"+dist[i]);
		}

		static int find_min(){
			int min=-1;

			for(int i=0;i<V;i++)
			{
				if(!visited[i] && (min==-1 || dist[i]<dist[min]))
					min=i;
			}

			return min;
		}
	}

	public static void main(String[] args) {
		Graph g=new Graph(5);

		g.addEdge(1,2,1);
		g.addEdge(2,3,1);
		g.addEdge(3,4,2);
		g.addEdge(4,1,7);
		g.addEdge(1,3,4);

		g.dijkstra(1);
	}
}