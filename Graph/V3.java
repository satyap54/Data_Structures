import java.util.*;

class V3{

	static class Edge{
		int wt,end;
		public Edge(int w,int d){
			wt=w;
			end=d;
		}
	}

	static class Node{
		int dist,val;
		LinkedList<Edge> edge;
		public Node(int i){
			dist=Integer.MAX_VALUE;
			edge=new LinkedList<Edge>();
			val=i;
		}
	}

	static class Sort_by_wt implements Comparator<Node>{
		public int compare(Node a,Node b){
			return a.dist-b.dist;
		}
	}

	static class Graph{
	
		static Node city[];
		static int V;
		static boolean visited[];
		public Graph(int v){
			V=v;

			city=new Node[v];
			for(int i=0;i<V;i++){
				city[i]=new Node(i);
			}

			visited=new boolean[V];
			Arrays.fill(visited,false);
		}

		void addEdge(int u,int v,int w){
			city[u].edge.add(new Edge(w,v));
			city[v].edge.add(new Edge(w,u));
		}

		void dijkstra(int src){
			city[src].dist=0;
			PriorityQueue<Node> pq = new PriorityQueue<>(new Sort_by_wt());
			pq.add(city[src]);

			while(!pq.isEmpty()){
				Node parent=pq.poll();
				visited[parent.val]=true;
				System.out.println(parent.val+" "+city[parent.val].dist);
				LinkedList<Edge> x=parent.edge;
				for(Edge e : x){

					if(!visited[e.end]){
						int temp=parent.dist+e.wt;
						if((city[e.end].dist) > temp){
							pq.remove(city[e.end]);
							city[e.end].dist=temp;
						}
						pq.add(city[e.end]);
					}
				}
				// for(int i=0;i<V;i++)
				// 	System.out.println(i+"--->"+city[i].dist);
				System.out.println();
			}
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