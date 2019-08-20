import java.util.*;

class Krushkal{

	static class Edge{
		int src,des,wt;
		public Edge(){
			src=0;des=0;wt=0;
		}
	}

	static class Graph{

		static int V,E;
		static LinkedList<Edge> edge_list,ans_list;
		static int parent[];
		//static LinkedList<Edge> l[];

		public Graph(int v,int e){
			V=v;
			E=e;

			parent=new int[V];
			Arrays.fill(parent,-1);

			edge_list=new LinkedList<Edge>();
			ans_list=new LinkedList<Edge>();
			
			//l=new LinkedList<Edge>[];
		}

		void addEdge(int u,int v,int w,Edge e){
			e.src=u;e.des=v;e.wt=w;
			edge_list.add(e);
		}

		static int find_parent(int node){
			if(parent[node]==-1)
				return node;
			return find_parent(parent[node]);
		}

		void krushkal(){
			for(Edge e : edge_list){
				int s_par=find_parent(e.src);
				int d_par=find_parent(e.des);

				if(s_par==d_par)
					continue;
				else{
					parent[e.des]=s_par;
					ans_list.add(0,e);
				}
			}

			for(Edge e : ans_list){
				System.out.println(e.src+"-->"+e.des+" with wt="+e.wt);
			}
		}
	}

	static class Sort_by_wt implements Comparator<Edge>{

		public int compare(Edge a,Edge b){
			return a.wt-b.wt;
		}
	}

	public static void main(String[] args) {
		Graph g=new Graph(7,8);

		Edge arr[]=new Edge[8];
		for(int i=0;i<8;i++)
			arr[i]=new Edge();

		g.addEdge(0,3,4,arr[0]);
		g.addEdge(0,1,6,arr[1]);
		g.addEdge(1,2,5,arr[2]);
		g.addEdge(3,2,7,arr[3]);
		g.addEdge(3,4,2,arr[4]);
		g.addEdge(4,5,4,arr[5]);
		g.addEdge(5,6,1,arr[6]);
		g.addEdge(4,6,3,arr[7]);

		Collections.sort(g.edge_list,new Sort_by_wt());

		// for(Edge e : g.edge_list)
		// 	System.out.println(e.wt);
		g.krushkal();
	}
}