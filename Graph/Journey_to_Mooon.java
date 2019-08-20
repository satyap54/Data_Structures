import java.util.*;

class Journey_to_Mooon{

	static class Graph{
		static boolean visited[];
		static LinkedList<Integer> l[];
		static int ci,N,same_country_pairs;//ci-> no. of members belonging to a particular country

		public Graph(int v){
			N=v;

			l=new LinkedList[N];
			for(int i=0;i<N;i++)
				l[i]=new LinkedList<Integer>();

			visited=new boolean[N];
			Arrays.fill(visited,false);
			ci=0;
		}

		void addEdge(int u,int v){
			l[u].add(v);
			l[v].add(u);
		}

		int dfs(){

			for(int i=0;i<N;i++){
              	if(!visited[i]){
              		ci=1;
              		dfs_helper(i);
              		same_country_pairs+=Comb(ci);
              		//System.out.println(ci);
              	}
			}

			return Comb(N)-same_country_pairs;
		}

		static void dfs_helper(int node){
			visited[node]=true;
			LinkedList<Integer> x=l[node];
			for(Integer n: x){
				if(!visited[n]){
					ci++;
					dfs_helper(n);
				}
			}
		}

		static int Comb(int m){
			//Compute mC2
			if(m==0)
				return 0;

			int ans=(int) (m*(m-1))/2;
			return ans;
		}

	}

	public static void main(String[] args) {
		Graph g=new Graph(5);
		g.addEdge(0,1);
		g.addEdge(2,3);
		g.addEdge(0,4);

		System.out.println(g.dfs());

	}
}