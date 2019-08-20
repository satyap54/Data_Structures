import java.util.*;
class Que
{
	public static void main(String[] args) {
		Queue<Integer> q=new LinkedList<>();
		q.add(1);
		q.add(3);
		q.add(5);		
		q.add(2);
		q.add(7);	

		//peek()-view the head of queue without removing 
		System.out.println(q.peek());

		//poll()-removes and returns the head of the queue
		System.out.println(q.poll());

		System.out.println(q.toString());
	}
}