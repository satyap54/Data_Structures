import java.util.*;

class Ht_of_tree{

	static Scanner sc = new Scanner(System.in);

	static class Node{
		Node left,right;
		int data;

		public Node(int n){
			left=null;
			right=null;
			data=n;
		}
	}

	static Node root;

	public static void main(String[] args) {
		int n=sc.nextInt();//No. of elements to be inserted into the tree;
		int first_item=sc.nextInt();
		root=new Node(first_item);n--;

		for(int i=0;i<n;i++)
			insert_node(root,sc.nextInt());
		Queue<Node> q=new LinkedList<>();
		q.add(root);
		System.out.println(get_ht(q,0));
		//System.out.println(get_ht(root));

	}

	//Level-Order insertion
	static void insert_node(Node node,int key){
		Queue<Node> q=new LinkedList<>();
		Node temp;
		q.add(node);

		while(!q.isEmpty()){
			temp=q.poll();

			if(temp.left==null){
				temp.left=new Node(key);
				break;
			}
			else
				q.add(temp.left);

			if(temp.right==null){
				temp.right=new Node(key);
				break;
			}
			else
				q.add(temp.right);

		}

	}

	//Iterative method
	// static int get_ht(Node node){
	// 	Queue<Node> q=new LinkedList<>();
	// 	Node temp;
	// 	q.add(node);int ht=0;

	// 	while(true){
	// 		int node_count=q.size();
	// 		if(node_count==0)
	// 			return ht;

			
	// 		while(node_count!=0){
	// 			temp=q.poll();

	// 			if(temp.left!=null)
	// 				q.add(temp.left);
	// 			if(temp.right!=null)
	// 				q.add(temp.right);

	// 			node_count--;
	// 		}
	// 	}
	// }


	//Recursive method
	static int get_ht(Queue<Node> q,int ht){
		int node_count=q.size();
		Node temp;
		//Base case occurs when there are no nodes to process,i.e., queue is empty
		if(node_count==0)
			return ht;

		//If there are nodes to process, we've reached another level
		ht++;

		while(node_count!=0){
			temp=q.poll();

			if(temp.left!=null)
				q.add(temp.left);
			if(temp.right!=null)
				q.add(temp.right);
			node_count--;
		}

		return get_ht(q,ht);
	}

}