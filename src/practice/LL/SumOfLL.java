package practice.LL;

public class SumOfLL {

	public static void main(String[] args) {

		Node num1 = new Node(7);

		Node second = new Node(1);

		Node third = new Node(6);

		num1.next = second;
		second.next = third;

		Node num2 = new Node(5);

		Node fourth = new Node(19);

		Node five = new Node(2);

		num2.next = fourth;

		fourth.next = five;

		sumOfNumbers(num1, num2);

	}

	private static void sumOfNumbers(Node num1, Node num2) {

		int carry = 0;

		Node op = null;

		Node prev = null;

		while (num1 != null || num2 != null) {

			int a = num1 != null ? num1.data : 0;

			int b = num2 != null ? num2.data : 0;

			int tsum = carry + a + b;

			if (tsum >= 10) {
				carry = tsum / 10;
				tsum = tsum % 10;
			}

			Node t = new Node(tsum);

			if (op == null) {
				op = t;
			} else {

				prev.next = t;
			}

			prev = t;

			num1 = num1 != null ? num1.next : num1;
			num2 = num2 != null ? num2.next : num2;

		}

		if (carry > 0) {
			
			prev.next=new Node(carry);
		}
		
		printList(op);

	}

	private static void printList(Node head) {

		Node temp = head;

		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}

	}

}
