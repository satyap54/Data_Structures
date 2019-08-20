import java.util.*;

class Adjacency_List{

	static class Graph{

		int V;
		LinkedList<Integer> l[];

		public Graph(int v){
			V=v;
			l=new LinkedList[V];

			for(int i=0;i<V;i++){
				l[i]=new LinkedList<Integer>();
			}
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
	}

	public static void main(String[] args) {
		Graph g=new Graph(5);
		g.addEdge(0,1,true);
		g.addEdge(0,4,true);
		g.addEdge(4,3,true);
		g.addEdge(1,4,true);
		g.addEdge(1,2,true);
		g.addEdge(2,3,true);
		g.addEdge(1,3,true);

		g.adj_print();
	}
}