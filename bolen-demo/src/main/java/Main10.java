import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main10 {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String nextLine = in.nextLine();
			String[] split = nextLine.split(" ");
			int number = Integer.parseInt(split[0]);
			int k = Integer.parseInt(split[split.length - 1]);
			// String word=split[k-1];
			int number2 = number(split, k+1);
			
			System.out.println(number2+" "+split[k]);

		}
	}

	private static int number(String[] arr, int k) {
		String word = arr[k - 1];
		String sorted = sort(word);
		int sum = 0;
		for (String str : arr) {
			if (word.equals(str)) {
				continue;
			}
			if (word.length() != str.length()) {
				continue;
			}
			if (sorted.equals(sort(str))) {
				sum++;
			}

		}
		return sum;
	}

	private static String sort(String str) {

		char[] charArray = str.toCharArray();
		List<String> list = new ArrayList<>();
		for (char ch : charArray) {
			list.add(new String(new char[] { ch }));
		}
		list.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}

		});

		StringBuilder sb = new StringBuilder();
		for (String s : list) {
			sb.append(s);
		}
		return sb.toString();

	}
}