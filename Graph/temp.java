import java.util.*;

class Temp{

	static class Graph{

		static int color[],V;
		static LinkedList<Integer> l[];

		public Graph(int v){
			color=new int[v];
			V=v;

			l=new LinkedList[v];

			for(int i=0;i<V;i++)
				l[i]=new LinkedList<Integer>();
		}

		void addEdge(int u,int v){
			l[u].add(v);
			l[v].add(u);
		}

		boolean isBipartite(int s){
			Queue<Integer> q=new LinkedList<>();
			q.add(s);
			color[s]=0;

			while(!q.isEmpty()){
				int u=q.poll();
				LinkedList<Integer> x=l[u];

				for(Integer v : x){
					if(color[v]==-1){
						color[v]=1-color[u];
						q.add(v);
					}
					else if(color[v]==color[u])
						return true;
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
        //g.addEdge(0,2,g.edge[2]);

        System.out.println(g.isCyclic());
	}
}