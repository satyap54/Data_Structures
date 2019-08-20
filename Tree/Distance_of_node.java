//I tried to do some Level-Order operations on a simple binary tree
//The time complexity is O(n); n->no. of nodes
import java.util.*;

class Distance_of_node{

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
		System.out.println(find_distance(root,x));
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
	static void print_levelorder(Node node){
		Queue<Node> q=new LinkedList<>();
		q.add(node);
		Node temp;
		while(!q.isEmpty()){
			temp=q.poll();

			if(temp.left!=null)
				q.add(temp.left);
			if(temp.right!=null)
				q.add(temp.right);

			System.out.print(temp.data+" ");

		}
	}

	static int find_distance(Node node,int x){
		if(node==null)
			return -1;

		int dist=-1;

		if((node.data==x) || (dist=find_distance(node.left,x))>=0 || (dist=find_distance(node.right,x))>=0 )
			return dist+1;
		//return -1 if x isn't present is left or right sub-tree
		return dist;
	}
}