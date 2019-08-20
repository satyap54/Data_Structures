import java.util.*;

class Dijkstra_v2{

		static class Node{
			int dist,node_val;
			public Node(){
				dist=Integer.MAX_VALUE;
				node_val=0;
			}
		}

		static class Edge{
			int des,wt;
			public Edge(int w,int d){
				wt=w;
				des=d;
			}
		}

		static class Sort_by_wt implements Comparator<Node>{
			public int compare(Node a,Node b){
				return a.dist-a.dist;
			}
		}

		static class Graph{

			static Node city[];
			static LinkedList<Edge> l[];
			static int V;

			public Graph(int v){
				V=v;

				l=new LinkedList[V];
				city=new Node[V];

				for(int i=0;i<V;i++){
					l[i]=new LinkedList<Edge>();
					city[i]=new Node();
					city[i].node_val=i;
				}
			}

			void addEdge(int u,int v,int w){
				l[u].add(new Edge(w,v));
				l[v].add(new Edge(w,u));
			} 

			void dijkstra(int src){
				PriorityQueue<Node> pq = new PriorityQueue<>(new Sort_by_wt());
				city[src].dist=0;

				boolean visited[]=new boolean[V];
				Arrays.fill(visited,false);

				pq.add(city[src]);

				while(!pq.isEmpty()){
					Node parent=pq.poll();
					int par=parent.node_val;
					visited[par]=true;

					//Go to neighbours
					LinkedList<Edge> x=l[par];
					for(Edge e : x){
						if(!visited[e.des]){
							int temp=parent.dist+e.wt;
							int current_dist=city[e.des].dist;
							//Node t=city[e.des];

							if(temp<current_dist){
								
								pq.remove(city[e.des]);	
								city[e.des].dist=temp;

								System.out.println(temp);
							}

							//System.out.println(t + " "+ city[e.des]);
							//pq.add(t);
							pq.add(city[e.des]);
						}
					}
				}

				for(int i=0;i<V;i++){
					System.out.println(i+"--->"+city[i].dist);
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