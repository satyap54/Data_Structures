import java.util.*;

class Connected_Compo{

	static class Graph{
		static HashMap<String,Boolean> visited;
		static HashMap<String,LinkedList<String>> map;

		public Graph(){
			visited=new HashMap<>();
			map=new HashMap<>();
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

			map.get(v).add(u);
		}

		void dfs(String src){
			dfs_helper(src);
			for(String city : map.keySet()){
				if(!visited.get(city)){
					System.out.println();
					dfs_helper(city);
				}
			}
		}

		static void dfs_helper(String node){
			visited.put(node,true);
			System.out.print(node+" ");

			LinkedList<String> x=map.get(node);

			for(String n:x){
				if(!visited.get(n)){
					dfs_helper(n);
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Graph g=new Graph();
		g.addEdge("Amritsar","Jaipur");
		g.addEdge("Amritsar","Delhi");
		g.addEdge("Delhi","Jaipur");
		g.addEdge("Mumbai","Jaipur");
		g.addEdge("Mumbai","Bhopal");
		g.addEdge("Delhi","Bhopal");
		g.addEdge("Mumbai","Bangalore");
		g.addEdge("Agra","Delhi");
		g.addEdge("Andaman","Nicobar");

		g.dfs("Amritsar");
	}

}