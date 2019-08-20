import java.util.*;

class Union_Find{

	static class Graph{

		static class Edge{
			int src,des;

			public Edge(){
				src=0;des=0;
			}
		}

		static int V,E;
		static Edge edge[];
		static int parent[];

		public Graph(int v,int e){
			V=v;
			E=e;
			edge=new Edge[E];
			parent=new int[V];

			Arrays.fill(parent,-1);

			for(int i=0;i<E;i++)
				edge[i]=new Edge();
		}

		void addEdge(int s,int d,Edge E){
			E.src=s;
			E.des=d;
		}

		static int find_parent(int node){
			System.out.println(node+" "+parent[node]);
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
				int parent_s=find_parent(e.src);
				int parent_d=find_parent(e.des);

				if(parent_s==parent_d)
					return true;
				else
					parent[e.des]=parent_s;
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
        int V = 3, E = 2; 
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
        //g.addEdge(2,3,g.edge[2]);
        //g.addEdge(0,2,g.edge[2]);

        System.out.println(g.isCyclic());
	}

}