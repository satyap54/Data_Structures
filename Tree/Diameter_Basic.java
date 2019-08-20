//Basic approach to find diameter of a binary tree
import java.util.*;

class Diameter_Basic{

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
		//int n=sc.nextInt();//No. of elements to be inserted into the tree;
		int first_item=sc.nextInt();
		root=new Node(first_item);

			insert_node(root);

		System.out.println(diameter(root));
	}

	//Level-Order insertion
	static void insert_node(Node node){
		Queue<Node> q=new LinkedList<>();
		Node temp;
		int key=0;
		q.add(node);
		while(!q.isEmpty()){
			
			temp=q.poll();
				
			System.out.println("Enter left node of "+temp.data);
			key=sc.nextInt();
			if(key!=-1){
				temp.left=new Node(key);
				q.add(temp.left);
			}
				

				
			System.out.println("Enter right node of "+temp.data);
			key=sc.nextInt();
			if(key!=-1){
				temp.right=new Node(key);
				q.add(temp.right);
			}
		}

	}

	static int height(Node node){
		if(node==null)
			return 0;

		int lh=height(node.left);
		int rh=height(node.right);

		return 1+Math.max(lh, rh);
	}

	public static int diameter(Node node){
		if(node==null)
			return 0;

		int option1=height(node.left)+height(node.right);
		int option2=diameter(node.left);
		int option3=diameter(node.right);

		return Math.max(option1, Math.max(option2, option3));
	}
}