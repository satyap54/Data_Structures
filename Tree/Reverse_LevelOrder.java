import java.util.*;

class Reverse_LevelOrder{

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

		print_reverse_level(root);
	}

	static void print_reverse_level(Node node){
		Stack<Node> stack = new Stack<>();
		Queue<Node> q=new LinkedList<>();

		Node temp;
		q.add(node);

		while(!q.isEmpty()){
			temp=q.poll();
			stack.push(temp);

			if(temp.right!=null)
				q.add(temp.right);

			if(temp.left!=null)
				q.add(temp.left);
		}

		while(!stack.isEmpty())
			System.out.print(stack.pop().data+" ");
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

	
}