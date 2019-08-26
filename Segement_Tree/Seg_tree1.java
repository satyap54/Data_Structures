//Range Minimum Query
import java.util.*;

class Seg_tree1
{
	static int arr[]={1,3,2,-5,6,4},tree[];
	static void buildTree(int s,int e,int index){
		if(s==e){
			tree[index]=arr[s];
			return;
		}

		int mid=(s+e)/2;
		buildTree(s,mid,2*index);
		buildTree(mid+1,e,2*index+1);
		tree[index]=Math.min(tree[2*index],tree[2*index+1]);
	}

	static int query(int qs,int qe,int s,int e,int index){

		//Complete Overlap
		if(qs<=s && qe>=e)
			return tree[index];

		//No Overlap
		if(qs>e || qe<s)
			return Integer.MAX_VALUE;

		//Partial Overlap- Call on both sides and update the current ans
		int mid=(s+e)/2;

		return Math.min(query(qs,qe,s,mid,2*index), query(qs,qe,mid+1,e,2*index+1));

	}

	static void update(int s,int e,int i,int increment,int index){
		//Check for no-overlap
		if(i>e || i<s){
			return;
		}

		//bottom-up case or base-case
		if(s==e){
			tree[index]+=increment;
			return;
		}

		//Else, there is some overlapping and you need to call on both sides of the tree
		int mid=(s+e)/2;

		update(s,mid,i,increment,2*index);
		update(mid+1,e,i,increment,2*index+1);
		tree[index]=Math.min(tree[2*index], tree[2*index+1]);
	}

	static void updateRange(int s,int e,int l,int r,int incr,int index){
		//Out of bound
		if(r<s || l>e){
			return;
		}

		if(s==e){
			tree[index]+=incr;
			return;
		}

		//Partial overlap

		int mid=(s+e)/2;
		updateRange(s,mid,l,r,incr,2*index);
		updateRange(mid+1,e,l,r,incr,2*index+1);
		tree[index]=Math.min(tree[2*index], tree[2*index+1]);

		return;
	}

	public static void main(String[] args) {
		int n=arr.length;
		tree=new int[4*n+1];
		buildTree(0,arr.length-1,1);
		

		for(int i:tree){
			if(i!=0)
				System.out.print(i+" ");
		}

		System.out.println();
		System.out.println(query(1,2,0,n-1,1));
		update(0,n-1,3,10,1);

		for(int i:tree){
			if(i!=0)
				System.out.print(i+" ");
		}
	}
}