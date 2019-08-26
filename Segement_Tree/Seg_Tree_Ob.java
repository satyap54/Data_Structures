import java.util.*;

class Seg_Tree_Ob{

	static class Node { 
  
        int data; 
        Node left,right;
  
        // Constructor 
        Node() 
        { 
            left=null;
            right=null;
        } 
    } 

    static int arr[]={1,3,2,-5,6,4};
    static Node root;

    static void build_tree(int s,int e,Node node){
    	if(s==e){
    		node.data=arr[s];
    		return;
    	}

    	int mid=(s+e)/2;
    	Node l=new Node();
    	Node r=new Node();

    	build_tree(s,mid,l);
    	build_tree(mid+1,e,r);

    	node.left=l;node.right=r;

    	node.data=Math.min(l.data, r.data);
    }

    static int query(int qs,int qe,int s,int e,Node node){
    	//Complete Overlap
    	if(qs<=s && qe>=e){
    		return node.data;
    	}

    	//No overlap
    	if(qs>e || qe<s)
    		return Integer.MAX_VALUE;

    	//Partial Overlap
    	int mid=(s+e)/2;

    	return Math.min(query(qs,qe,s,mid,node.left), query(qs,qe,mid+1,e,node.right));
    }

    static void print_segtree(Node node){

    	if(node==null){
    		return;
    	}

    	print_segtree(node.left);
    	System.out.print(node.data+" ");
    	print_segtree(node.right);
    }

    static void update(int s,int e,int i,int incr,Node node){
    	//Out of bound ; this case automatically deals with bottom-up case when i!=s
    	if(i>e || i<s)
    		return;

    	//bottom-up case
    	if(s==e){
    		node.data+=incr;
    		return;
    	}

    	int mid=(s+e)/2;

    	update(s,mid,i,incr,node.left);
    	update(mid+1,e,i,incr,node.right);

    	node.data=Math.min(node.left.data, node.right.data);
    }

    public static void main(String[] args) {
    	root=new Node();
    	build_tree(0,arr.length-1,root);
    	//System.out.println(root.data+" "+root.left.data+" "+root.right.data+" ");
    	print_segtree(root);
    	System.out.println();
    	System.out.println(query(1,3,0,arr.length-1,root));
    }
}