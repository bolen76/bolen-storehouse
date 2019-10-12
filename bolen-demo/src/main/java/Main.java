import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String nextLine = in.nextLine();
			int[] arr;
			try {
				nextLine = nextLine.substring(1, nextLine.length() - 1);
				String[] split = nextLine.split(" ");
				arr = new int[split.length];
				for (int i = 0; i < split.length; i++) {
					arr[i] = Integer.parseInt(split[i]);
					if (arr[i] == 0) {
						throw new IllegalArgumentException("Invalid input 0,index is " + i);
					}
				}
			} catch (Exception e) {
				System.out.println("[-1]");
				continue;
			}
			List<Integer> escaped = escape(arr);
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			for (int i = 0; i < escaped.size(); i++) {
				sb.append(escaped.get(i));
				if (i != escaped.size() - 1) {
					sb.append(" ");
				}
			}
			sb.append("]");

			System.out.println(sb.toString());
		}
		/*
		 * int[] arr={5,10,8,-8,-5}; int sum = sum(arr,2,4); [5 10 8 -10 20 -8
		 * -5] System.out.println(sum); List<Integer> escaped = escape(arr);
		 * System.out.println(escaped);
		 */
	}

	private static List<Integer> escape(int[] arr) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			int power = arr[i];
			int sum = power;
			boolean flag = true;
			if (power > 0) {
				for (int j = i + 1; j < arr.length; j++) {
					sum += arr[j];
					if (sum <= 0) {
						flag = false;
						break;
					}
				}

			} else if (power < 0) {
				for (int j = i - 1; j >= 0; j--) {
					sum += arr[j];
					if (sum >= 0) {
						flag = false;
						break;
					}
				}

			}
			if (flag) {
				list.add(power);
			}
		}
		return list;
	}
}