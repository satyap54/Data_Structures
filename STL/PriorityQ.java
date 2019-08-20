import java.util.*;
class PriorityQ
{
	public static void main(String[] args) {
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		pq.add(5);
		pq.add(6);
		pq.add(17);
		pq.add(18);
		pq.add(9);
		pq.add(11);
		System.out.println(pq.toString());//prints min-heap if we don't use comparator 

		PriorityQueue<Integer> p=new PriorityQueue<>(Collections.reverseOrder());
		p.add(5);
		p.add(6);
		p.add(17);
		p.add(18);
		p.add(9);
		p.add(11);
		System.out.println(p.toString());

		for(int i=0;i<6;i++)
			System.out.println(p.poll());
	}
}
