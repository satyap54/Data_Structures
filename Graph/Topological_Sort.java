import java.util.*;


class Topological_Sort{

	static class Graph{

		static HashMap<String,Boolean> visited;
		static HashMap<String,LinkedList<String>> map;
		static Vector<String> ordering;

		public Graph(){
			visited=new HashMap<>();
			map=new HashMap<>();
			ordering=new Vector<>();
		}

		void addEdge(String u,String v){
			if(!map.containsKey(u)){
				map.put(u,new LinkedList<>());
				visited.put(u,false);
			}

			if(!map.containsKey(v)){
				visited.put(v,false);
				map.put(v,new LinkedList<>());
			}

			map.get(u).add(v);
		}

		void dfsTopological(){
			for(String i : map.keySet()){
				if(!visited.get(i))
					dfs_helper(i);
			}
		}

		static void dfs_helper(String node){
			visited.put(node,true);

			LinkedList<String> x=map.get(node);

			for(String n:x){
				if(!visited.get(n)){
					dfs_helper(n);
				}
			}
			
			ordering.add(0,node);
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

		g.dfsTopological();

		for(String x : g.ordering)
			System.out.print(x+" ");

		System.out.println();
	}

}