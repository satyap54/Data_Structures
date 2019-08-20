//I tried to do some Level-Order operations on a simple binary tree
//The time complexity is O(n); n->no. of nodes
import java.util.*;

class Min_depth{

	static Scanner sc = new Scanner(System.in);

	static class Node{
		Node left,right;
		int data,depth;

		public Node(int n){
			left=null;
			right=null;
			data=n;
			depth=0;
		}
	}

	static Node root;

	public static void main(String[] args) {
		int n=sc.nextInt();//No. of elements to be inserted into the tree;
		int first_item=sc.nextInt();
		root=new Node(first_item);n--;

		for(int i=0;i<n;i++)
			insert_node(root,sc.nextInt());
		root.depth=1;
		System.out.println(find_min_depth(root));
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

	//Level-Order printing
	// static void print_levelorder(Node node){
	// 	Queue<Node> q=new LinkedList<>();
	// 	q.add(node);
	// 	Node temp;
	// 	while(!q.isEmpty()){
	// 		temp=q.poll();

	// 		if(temp.left!=null)
	// 			q.add(temp.left);
	// 		if(temp.right!=null)
	// 			q.add(temp.right);

	// 		System.out.print(temp.data+" ");

	// 	}
	// }

	static int find_min_depth(Node node){
		Queue<Node> q=new LinkedList<>();
		q.add(node);
		Node temp,temp1;

		while(!q.isEmpty()){
			//System.out.println("///");
			temp=q.poll();

			if(temp.left==null && temp.right==null)
				return temp.depth;

			if(temp.left!=null){
				temp1=temp.left;
				temp1.depth=temp.depth+1;
				q.add(temp1);
			}

			if(temp.right!=null){
				temp1=temp.right;
				temp1.depth=temp.depth+1;
				q.add(temp1);
			}
		}

		return 1;
	}
}