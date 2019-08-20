import java.util.*;
//Map STL implementation
//Remember : <key,value>
/*
    Important functions:
    containsKey()
    containsValue()
    clear()
*/
//Syntax: HashMap<String, Integer> map = new HashMap<>(); 
public class GirlsAndMap
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        HashMap<String,String> map=new HashMap<>();
        int n=sc.nextInt();
        String first,second,k,v;
        for(int i=0;i<n;i++)
        {
            first=sc.next();second=sc.next();
            k=first+" "+second;
            v=sc.next();
            map.put(k,v);
        }
        n=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            first=sc.next();second=sc.next();
            k=first+" "+second;
            System.out.println(map.get(k));
        }
    }
}
