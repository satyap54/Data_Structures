import java.util.*;

class Bipartite{

	static class Graph{
		static int color[],V;
		static LinkedList<Integer> l[];

		public Graph(int v){
			V=v;
			l=new LinkedList[V+1];
			for(int i=0;i<V;i++)
				l[i]=new LinkedList<Integer>();

			color=new int[V];
			Arrays.fill(color,-1);
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
				for(Integer v: x){
					if(color[v]==-1){
						color[v]=1-color[u];
						q.add(v);
						//System.out.println(color[v]+" "+color[u]);
					}
					else if(color[v]==color[u]){
						return false;
					}
				}
			}

			return true;
		}
	}

	public static void main(String[] args) {
		Graph g=new Graph(4);
		g.addEdge(0,1);
		g.addEdge(2,0);
		g.addEdge(1,3);
		g.addEdge(2,3);
		//g.addEdge(0,3);

		System.out.println(g.isBipartite(0));
	}
}