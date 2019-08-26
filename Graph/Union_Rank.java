import java.util.*;

class Union_Rank{

	static class Graph{

		static class Edge{
			int src,des;

			public Edge(){
				src=0;des=0;
			}
		}

		static int V,E;
		static Edge edge[];
		static int parent[],rank[];

		public Graph(int v,int e){
			V=v;
			E=e;
			edge=new Edge[E];
			parent=new int[V];
			rank=new int[V];

			Arrays.fill(parent,-1);

			for(int i=0;i<E;i++)
				edge[i]=new Edge();
		}

		void addEdge(int s,int d,Edge E){
			E.src=s;
			E.des=d;
		}

		static int find_parent(int node){
			//System.out.println(node);
			if(parent[node]==-1)
				return node;
			return find_parent(parent[node]);
		}

		boolean isCyclic(){
			for(Edge e : edge){
				// if(parent[e.des]==-1){
				// 	parent[e.des]=e.src;
				// }
				// else{
				// 	parent[e.src]=find_parent(e.src);
				// 	parent[e.des]=find_parent(e.des);

				// 	if(parent[e.src]==parent[e.des])
				// 		return true;
				// }
				System.out.println(e.src+" "+e.des);
				int x_par=find_parent(e.src);
				int y_par=find_parent(e.des);

				if(x_par==y_par){
					System.out.println(x_par+" "+y_par);
					return true;
				}

				if(rank[x_par] > rank[y_par]){
					parent[e.des]=x_par;
					rank[x_par]++;
				}
				else if(rank[x_par] < rank[y_par]){
					parent[e.src]=y_par;
					rank[y_par]++;
				}
				else{
					parent[e.src]=y_par;
					rank[y_par]++;
				}
			}

			return false;
		}
	}

	public static void main(String[] args) {
		/* Let us create following graph 
         0 
        |  \ 
        |    \ 
        1-----2 */
        int V = 3, E = 3; 
        Graph g = new Graph(V, E); 
  
        // // add edge 0-1 
        // graph.addEdge[0].src = 0; 
        // graph.edge[0].dest = 1; 
  
        // // add edge 1-2 
        // graph.addEdge[1].src = 1; 
        // graph.edge[1].dest = 2; 
  
        // // add edge 0-2 
        // graph.addEdge[2].src = 0; 
        // graph.addEdge[2].dest = 2; 

        g.addEdge(0,1,g.edge[0]);
        g.addEdge(1,2,g.edge[1]);
        g.addEdge(0,2,g.edge[2]);

        System.out.println(g.isCyclic());
	}

}