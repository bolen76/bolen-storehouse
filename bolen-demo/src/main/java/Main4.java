import java.util.Scanner;

public class Main4 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {

			int num = Integer.parseInt(in.nextLine());
			String nextLine = in.nextLine();
			int k = Integer.parseInt(in.nextLine());
			String[] split = nextLine.split(" ");
			Node head = buildList(split);

			if (k<1||k>split.length) {
				System.out.println(0);
			} else {
				Node node = find(head, k);
				System.out.println(node.data);
			}

		}
	}

	public static Node find(Node node, int k) {
		Node first = node;
		Node second = node;
		for (int i = 0; i < k ; i++) {
			first = first.next;
		}
		while (first != null) {
			first = first.next;
			second = second.next;
		}

		return second;
	}

	private static Node buildList(String[] split) {
		if(split.length==0) return null;
		Node head =new Node(Integer.valueOf(split[0]));
		Node point = head;
		for (int i=1;i<split.length;i++) {
			Integer valueOf = Integer.valueOf(split[i]);
			point.next = new Node(valueOf);
			point = point.next;
		}
		return head;
	}

	private static class Node {
		int data;
		Node next;

		public Node(int data) {
			super();
			this.data = data;
		}

	}
}
