package twichtendahl_itc155_final;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FinalExam {
	
	/* Problem 1
	 * This algorithm is O(N^2). Twice for each n, a 
	 * n-length loop with one executable line of 
	 * code executes. Then, irrespective of n,
	 * 200 lines execute - this is the final for
	 * loop. Therefore, in total, 2N^2 + 200
	 * statements execute, which is of order O(N^2)
	 */
	
	// Method definition for problem 2
	public static Stack<Integer> copyStack(Stack<Integer> stack) {
		
		// Creates a stack of integers in reversed order
		Stack<Integer> intermediate = new Stack<Integer>();
		while(!stack.isEmpty()) {
			intermediate.add(stack.pop());
		}
		
		// Creates a queue whose head is the first element in the original
		Queue<Integer> intermediateQ = new LinkedList<Integer>();		
		while(!intermediate.isEmpty()) {
			intermediateQ.add(intermediate.pop());
		}
		
		// Repopulates the passed stack as well as the storage stack
		// in the original order of the passed stack.
		while(!intermediateQ.isEmpty()) {
			int removed = intermediateQ.remove();
			stack.push(removed);
			intermediate.push(removed);
		}
		
		return intermediate;
	}

	public static void main(String[] args) {
		// Test of problem 2
		int[] testData = {0, 1, 2, 3, 4, 5};
		Stack<Integer> testStack = new Stack<Integer>();
		for(int i = 0; i < testData.length;  i++) {
			testStack.add(testData[i]);
		}
		
		Stack<Integer> copied = copyStack(testStack);
		int j = 5;
		// Fifth should be listed first and indexes should match data
		while(!copied.isEmpty()) {
			System.out.println("Element " + j + ": " + copied.pop());
			j--;
		}
		
		// Test of problem 3
		int[] listData1 = {0, 1, -1, 2, 3, 5};
		int[] listData2 = {-1, 0, 0, 1, 2, 4};
		
		LinkedIntList list1 = new LinkedIntList();
		LinkedIntList list2 = new LinkedIntList();
		
		for(int i = 0; i < listData1.length; i++) {
			list1.add(listData1[i]);
		}
		
		for(int i = 0; i < listData2.length; i++) {
			list2.add(listData2[i]);
		}
		
		System.out.println("List 1 sorted?: " + list1.isSorted()); // false
		System.out.println("List 2 sorted?: " + list2.isSorted()); // true
	}

}
