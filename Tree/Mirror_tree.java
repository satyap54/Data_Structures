import java.util.*;

class Mirror_tree{

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

		mirror_this(root);
		print_levelorder(root);

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

	static void mirror_this(Node node){
		if(node==null)
			return;

		mirror_this(node.left);
		mirror_this(node.right);
		Node temp=node.left;
		node.left=node.right;
		node.right=temp;
	}
}