//Program to find cars closer to the origin (Cars are distributed in a cartesian plane)
//This demonsrates Priority Queue using functor ; custom comparator
import java.util.*; 

public class Functor { 
	public static void main(String[] args){  
		PriorityQueue<Car> pq = new PriorityQueue<Car>(5, new DistanceComparator()); 
				
				int x[]={5,6,17,18,9,11,0,3};				
				int y[]={1,-2,8,9,10,91,1,2};

				for(int i=0;i<8;i++)
				{
					Car c=new Car(i,x[i],y[i]);
					pq.add(c);
				}
				
				System.out.println("Index of cars as per ascending order of distance from origin:"); 
				
				while (!pq.isEmpty()) { 
				System.out.println(pq.poll().id); 
		} 
	} 
} 

class DistanceComparator implements Comparator<Car>{ 
			
			// Overriding compare()method of Comparator 
						// for ascending order of distance of cars in cartesian plane 
			public int compare(Car s1, Car s2) { 
				if (s1.dist()>s2.dist()) 
					return 1; 
				else if (s1.dist() < s2.dist()) 
					return -1; 
								return 0; 
				} 
		} 

class Car { 
	public int id; 
	public int x;
	public int y; 
		
	public Car(int id,int x,int y) {
		this.id=id;
		this.x=x;
		this.y=y;
	} 
	
	public int dist() { 
		return x*x+y*y; 
	} 
} 
