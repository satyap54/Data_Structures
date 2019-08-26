import java.util.*;

class Snake_Ladder{

	static class Graph{

		static int V;
		static LinkedList<Integer> l[];
		static boolean visited[];
		static int[] dist,parent;

		public Graph(int v){
			V=v;
			l=new LinkedList[V];

			parent=new int[V];
			dist=new int[V];
			Arrays.fill(dist,Integer.MAX_VALUE);

			for(int i=0;i<V;i++){
				l[i]=new LinkedList<Integer>();
			}

			visited=new boolean[V];
			Arrays.fill(visited,false);
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

		int bfs(int src,int des){
			Queue<Integer> q=new LinkedList<>();
			q.add(src);
			
			visited[src]=true;
			dist[src]=0;
			parent[src]=src;

			while(!q.isEmpty()){
				int node=q.poll();
				//System.out.print(node+" ");
				LinkedList<Integer> x=l[node];

				for(Integer neighbour : x){
					if(!visited[neighbour]){
						q.add(neighbour);
						dist[neighbour]=dist[node]+1;
						parent[neighbour]=node;
						visited[neighbour]=true;
					}
				}
			}
			
			// for(int i=0;i<V;i++)
			// 	System.out.println("Distance of "+i+" is "+dist[i]);

			int temp=des;

			while(temp!=src){
				System.out.print(parent[temp]+" ");
				temp=parent[temp];
			}
			System.out.println();

			return dist[des];
		}
	}

	public static void main(String[] args) {
		Graph g=new Graph(50);
		int[] board=new int[50];
		board[2]=13;
		board[5]=2;
		board[9]=18;
		board[18]=11;
		board[17]=-13;
		board[20]=-14;
		board[24]=-8;
		board[25]=-10;
		board[32]=-2;
		board[34]=-22;

		for(int u=0;u<=35;u++){
			for(int dice=1;dice<=6;dice++){
				int v=u+dice+board[u+dice];
				g.addEdge(u,v,false);
			}
		}

		//g.adj_print();

		System.out.println(g.bfs(0,36));
	}
}