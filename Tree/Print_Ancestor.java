//I tried to do some Level-Order operations on a simple binary tree
//The time complexity is O(n); n->no. of nodes
import java.util.*;

class Print_Ancestor{

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

		int x=sc.nextInt();
		if(printAncestor(root,x)==false)
			System.out.println("Not found");
		
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
	static boolean printAncestor(Node node,int x){
		//base case
		if(node==null)
			return false;

		if(node.data==x)
			return true;

		//If target is in left or right sub-tree of node, print this node
		if(printAncestor(node.left,x) || printAncestor(node.right,x)){
			System.out.print(node.data+" ");
			return true;

		}
		return false;
	}
}