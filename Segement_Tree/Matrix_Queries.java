import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.*;
class Matrix_Queries
{ 
    static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st;
        public FastReader() 
        { 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        }
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    }

    static class Node{
        int[][] a=new int[2][2];

        Node right,left;
        public Node(){
            right=null;left=null;
        }
    }

    static void build_tree(int s,int e,Node node){
        if(s==e){
            node.a=arr[s];
            return;
        }

        int mid=(s+e)/2;
        Node l=new Node();
        Node r=new Node();
        node.left=l;
        node.right=r;


        build_tree(s,mid,node.left);
        build_tree(mid+1,e,node.right);

        node.a=mul(node.left.a,node.right.a);
    } 

    static int[][] mul(int[][] A,int[][] B){
        int[][] C=new int[2][2];

        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<2;k++)
                    C[i][j]+=A[i][k]*B[k][j];
            }
        }

        return C;
    }

    static int n,arr[][][],res[][];
    static Node root;
    static FastReader sc=new FastReader();

    public static void process()
    {
          //Queries
        int l=sc.nextInt(),r=sc.nextInt();
        res=new int[2][2];
        res=query(0,n-1,l-1,r-1,root);

        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++)
                System.out.print(res[i][j]+" ");
            System.out.println();
        }

        System.out.println();
        
    }
    static int[][] identity_mat={{1,0},{0,1}};
    static int[][] query(int s,int e,int qs,int qe,Node node){
        if(qs<=s && qe>=e)
            return node.a;

        //Out of bound case
        if(qs>e || qe<s)
            return identity_mat;

        //Partial overlap
        int mid=(s+e)/2;

        return mul(query(s,mid,qs,qe,node.left),query(mid+1,e,qs,qe,node.right));
    }

    static void get_arrs(){
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++)
                for(int k=0;k<2;k++)
                    arr[i][j][k]=sc.nextInt();
        }

    }

    // static void print_arrs(){
    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<2;j++){
    //             for(int k=0;k<2;k++)
    //                 System.out.print(arr[i][j][k]+" ");
    //             System.out.println();
    //         }
    //         System.out.println();
    //     }

    // }

    
    public static void main(String[] args) 
    { 
        root=new Node();
        n=sc.nextInt(); int q=sc.nextInt();
        arr=new int[n][2][2];
        get_arrs();
        //print_arrs();
        build_tree(0,n-1,root);

        while(q-- > 0)
            process();
    } 
} 
    