import java.util.*;

class vec
{
	public static void main(String[] args) {
		Vector<Integer> v = new Vector<>();
		v.ensureCapacity(15);
		v.add(1);
		v.add(2);
		v.add(3);
		v.add(4);
		v.add(5);
		v.add(7);

		//push_back 
		v.add(8);
		for(int i : v)
			System.out.print(i+" ");
		System.out.println();

		//pop_back
		v.remove(v.size()-1);//remove() removes element from a specified index
		for(int i : v)
			System.out.print(i+" ");
		System.out.println();

		//Sort
		Collections.sort(v);
		for(int i : v)
			System.out.print(i+" ");
		System.out.println();

		//Reverse
		Collections.reverse(v);
		for(int i : v)
			System.out.print(i+" ");
		System.out.println();

		//first element of a vector
		System.out.println("First elemet:");
		System.out.println(v.firstElement()+" "+v.get(0));

		//setElementAt - method similar to set method replaces the element with the element specified in the method at the specified index
		v.setElementAt(8,0);
		System.out.println(v.toString());

		//insert element in b/w ; v.add(index,element)
		v.add(1,7);
		System.out.println(v.toString());
	}
}		
