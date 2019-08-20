// Java code for stack implementation 

import java.io.*; 
import java.util.*; 

class StackTest 
{ 
	// Pushing element on the top of the stack 
	static void stack_push(Stack<Integer> stack) 
	{ 
		for(int i = 0; i < 5; i++) 
		{ 
			stack.push(i); 
		} 
	} 
	
	// Popping element from the top of the stack 
	static void stack_pop(Stack<Integer> stack) 
	{ 
		System.out.println("Pop :"); 

		for(int i = 0; i < 5; i++) 
		{ 
			Integer y = (Integer) stack.pop(); 
			System.out.println(y); 
		} 
	} 

	// Displaying element on the top of the stack 
	static void stack_peek(Stack<Integer> stack) 
	{ 
		Integer element = (Integer) stack.peek(); 
		System.out.println("Element on stack top : " + element); 
	} 
	
	// Searching element in the stack 
	static void stack_search(Stack<Integer> stack, int element) 
	{ 
		Integer pos = (Integer) stack.search(element); 

		if(pos == -1) 
			System.out.println("Element not found"); 
		else
			System.out.println("Element is found at position " + pos); 
	} 


	public static void main (String[] args) 
	{ 
		Stack<Integer> stack = new Stack<Integer>(); 
		stack.push(1);
		stack.push(2);
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		stack.push(3);
		int pos=stack.search(2);
		System.out.println("Position of 2 = "+pos);
		pos=stack.search(1);
		System.out.println("Position of 1 = "+pos);
		System.out.println("Peek : "+stack.peek());
		if(stack.contains(3))
			System.out.println("This stack contains 3");
		for(int s : stack)
			System.out.println(s);
		System.out.println("Size of stack "+stack.size());
	} 
} 
