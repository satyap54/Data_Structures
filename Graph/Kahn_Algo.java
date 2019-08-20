import java.util.*;

class Kahn_Algo{

	static class Graph{

		static HashMap<String,LinkedList<String>> map;
		static HashMap<String,Integer> in_deg;
		//static HashMap<String,Boolean> visited;

		public Graph(){
			map=new HashMap<>();
			in_deg=new HashMap<>();
			//visited=new HashMap<>();
		}

		static void addEdge(String u,String v){
			if(!map.containsKey(u)){
				map.put(u,new LinkedList<>());
				//visited.put(u,false);
				in_deg.put(u,0);
			}

			if(!map.containsKey(v)){
				map.put(v,new LinkedList<>());
				//visited.put(v,false);
				in_deg.put(v,0);
			}

			map.get(u).add(v);

			int x=in_deg.get(v);
			in_deg.put(v,x+1);
		}

		void bfs(){
			Queue<String> q=new LinkedList<>();

			for(String node : map.keySet()){
				if(in_deg.get(node)==0)
					q.add(node);
			}

			while(!q.isEmpty()){
				String node=q.poll();
				System.out.print(node+"  ");

				LinkedList<String> x=map.get(node);

				for(String n : x){
					int y=in_deg.get(n);
					in_deg.put(n,y-1);

					if(in_deg.get(n)==0)
					{
						q.add(n);
					}

				}
			}

		}
	}

	public static void main(String[] args) {
		Graph g=new Graph();
		g.addEdge("English","Prog. Logic");
		g.addEdge("Maths","Prog. Logic");
		g.addEdge("Prog. Logic","HTML");
		g.addEdge("Prog. Logic","Python");
		g.addEdge("Prog. Logic","Java");
		g.addEdge("Prog. Logic","JS");
		g.addEdge("Python","Web dev");
		g.addEdge("HTML","CSS");
		g.addEdge("CSS","JS");
		g.addEdge("JS","Web dev");
		g.addEdge("Java","Web dev");
		g.addEdge("Python","Web dev");
		//g.adj_print();

		g.bfs();
		System.out.println();

		// for(String s:g.in_deg.keySet())
		// 	System.out.println(s+" "+g.in_deg.get(s));
	}
}