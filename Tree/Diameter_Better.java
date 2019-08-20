//Basic approach to find diameter of a binary tree
import java.util.*;

class Diameter_Better{

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

		Pair obj=diameter(root);
		System.out.println(obj.dm);
	}

	static class Pair{
		int ht,dm;
		Pair(){
			ht=0;
			dm=0;
		}
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

	// static int height(Node node){
	// 	if(node==null)
	// 		return 0;

	// 	int lh=height(node.left);
	// 	int rh=height(node.right);

	// 	return 1+Math.max(lh, rh);
	// }

	public static Pair diameter(Node node){
		if(node==null){
			Pair ob=new Pair();
			ob.ht=0;
			ob.dm=0;
			return ob;
		}

		Pair lo=diameter(node.left);
		Pair ro=diameter(node.right);
		int height=1+Math.max(lo.ht, ro.ht);

		int option1=lo.ht+ro.ht;
		int option2=lo.dm;
		int option3=ro.dm;

		int diam=Math.max(option1, Math.max(option2, option3));

		Pair ob=new Pair();
			ob.ht=height;
			ob.dm=diam;
			return ob;
		
	}
}