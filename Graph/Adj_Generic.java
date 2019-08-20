import java.util.*;

class Adj_Generic{

	static class Graph{
		static HashMap<String, LinkedList<String>> map;

		public Graph(){
			map=new HashMap<>();
		}

		void addEdge(String u,String v,boolean bidir){
			if(!map.containsKey(u))
				map.put(u,new LinkedList<>());
			if(!map.containsKey(v))
				map.put(v,new LinkedList<>());

			map.get(u).add(v);

			if(bidir)
				map.get(v).add(u);

		}

		void adj_print(){
			for(String i : map.keySet()){
				LinkedList<String> x=map.get(i);
				System.out.print(i+" -> ");

				for(String j:x)
					System.out.print(j+" ");
				System.out.println();
			}
		}
	}
	public static void main(String[] args) {
		Graph g=new Graph();
		g.addEdge("Putin","Trump",false);
		g.addEdge("Putin","Modi",false);
		g.addEdge("Putin","Pope",false);
		g.addEdge("Modi","Trump",true);
		g.addEdge("Modi","Yogi",true);
		g.addEdge("Yogi","Prabhu",false);
		g.addEdge("Prabhu","Modi",false);

		g.adj_print();
	}
}