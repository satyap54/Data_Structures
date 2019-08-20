import java.util.*;

class HOLI{

	static class Pair{
		int node_val,cost;

		public Pair(int d,int c){
			node_val=d;
			cost=c;
		}
	}

	static class Graph{
		static int V,count[],ans;
		static LinkedList<Pair> l[];
		static boolean visited[];

		public Graph(int v){
			V=v+1;ans=0;
			System.out.println(V);
			l=new LinkedList[V];
			visited=new boolean[V];
			count=new int[V];

			for(int i=0;i<V;i++){
				visited[i]=false;
				count[i]=1;
				l[i]=new LinkedList<Pair>();
			}
		}

		void addEdge(int u,int v,int c){
			l[u].add(new Pair(v,c));
			l[v].add(new Pair(u,c));
		}

		static int dfs_helper(int node){
			visited[node]=true;

			for(Pair neighbour : l[node]){
				if(!visited[neighbour.node_val]){
					count[node]+=dfs_helper(neighbour.node_val);
					int s=count[neighbour.node_val];
					ans+=2*Math.min(V-1-s, s)*neighbour.cost;
				}
			}

			return count[node];
		}

		void dfs(){
			dfs_helper(1);
			// for(int i : count)
			// 	System.out.println(i);
			System.out.println(ans);
		}
	}
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int t=sc.nextInt();
		while(t-- > 0)
			process();
	}

	static void process(){
		int n=sc.nextInt();

		Graph g=new Graph(n);
		for(int i=1;i<n;i++){
			int u=sc.nextInt(),v=sc.nextInt(),c=sc.nextInt();
			g.addEdge(u,v,c);
		}

		g.dfs();
	}
}