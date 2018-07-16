package practice.LL;

public class LengthOfLinkedList {

	public static void main(String[] args) {

		Node start = new Node(1);

		Node second = new Node(2);

		Node third = new Node(3);

		Node fourth = new Node(4);

		Node five = new Node(5);

		start.next = second;

		second.next = third;

		third.next = fourth;

		fourth.next = five;

		 five.next = second;

		// printList(start);

		/*
		 * int l = iterativeLength(start);
		 * 
		 * System.out.println("Iterative Length " + l);
		 * 
		 * l = recLength(start);
		 * 
		 * System.out.println("Rec length " + l);
		 */
		// String re = searchElementRec(start, 11);

		// System.out.println(re);

		/*
		 * Node head=deleteElement(start, 10);
		 * 
		 * printList(head);
		 * 
		 */
		// int data = middleElement(start);

		// findMergeOfLL(start, head2);

	//int op = detectCycle(start);
		
		//printList(start);

		removeLoop(start);
		

	}

	private static void removeLoop(Node start) {
		
		Node temp=start;
		
		Node slow = temp;

		Node fast = temp;

		while (slow != null && fast != null && fast.next != null) {

			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				break;
			}

		}
		
		Node head=start;
		
		Node prev=null;
		
		while(head!=slow) {
			
			prev=slow;
			
			slow=slow.next;
			
			head=head.next;
		}
		
		prev.next=null;
		
		printList(start);
		
	}

	private static int detectCycle(Node start) {

		Node temp = start;

		Node slow = temp;

		Node fast = temp;

		while (slow != null && fast != null && fast.next != null) {

			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				return countNodes(slow);
			}

		}

		return 0;

	}

	private static int countNodes(Node slow) {
		
		Node temp=slow;
		
		int res=1;
		
		while(temp.next!=slow) {
			
			res++;
			
			temp=temp.next;
			
		}
		
		return res;
	}

	private static int findMergeOfLL(Node head1, Node head2) {

		int m = 0;
		int n = 0;

		Node temp1 = head1;

		Node temp2 = head2;

		while (head1 != null) {
			m++;
			head1 = head1.next;
		}

		while (head2 != null) {

			n++;
			head2 = head2.next;
		}

		int remaining = 0;

		if (m > n) {
			int loop = m - n;

			remaining = n;

			for (int i = 0; i < loop; i++) {
				temp1 = temp1.next;
			}
		} else if (n > m) {
			int loop = n - m;

			remaining = m;

			for (int i = 0; i < loop; i++) {
				temp2 = temp2.next;
			}

		}

		for (int i = 0; i < remaining; i++) {

			if (temp1.data == temp2.data) {

				return temp1.data;
			}

			temp1 = temp1.next;

			temp2 = temp2.next;

		}

		return 0;

	}

	private static int middleElement(Node start) {

		if (start != null && start.next == null) {
			return start.data;
		}

		return 0;
	}

	private static void printList(Node head) {
		
		Node temp=head;

		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}

	}

	private static Node deleteElement(Node start, int i) {

		Node prev = start;

		if (start != null && start.data == i) {
			return start.next;
		}

		Node current = start;

		while (current != null) {

			Node next = current.next;

			if (current.data == i) {

				prev.next = next;

				return start;
			}
			prev = current;

			current = next;

		}

		return start;

	}

	private static String searchElementRec(Node start, int i) {

		if (start != null) {

			if (start.data == i) {
				return "YES";
			} else {

				return searchElementRec(start.next, i);
			}

		}

		return "No";

	}

	private static int recLength(Node start) {

		if (start != null) {
			return 1 + recLength(start.next);
		}

		return 0;
	}

	private static int iterativeLength(Node start) {
		int count = 0;

		while (start != null) {

			count++;

			start = start.next;
		}

		return count;
	}

}
