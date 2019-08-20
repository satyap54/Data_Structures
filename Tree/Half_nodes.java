//Nodes with only with child-> half-node
import java.util.*;

class Half_nodes{

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

	static int getHalfNodes(Node node){
		Queue<Node> q=new LinkedList<>();
		Node temp;
		q.add(node);
		int count=0;

		while(!q.isEmpty()){
			temp=q.poll();

			if((temp.right==null && temp.left!=null) || (temp.right!=null && temp.left==null))
				count++;

			if(temp.left!=null)
				q.add(temp.left);
			if(temp.right!=null)
				q.add(temp.right);
		}

		return count;
	}

}