import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		while (in.hasNextInt()) {

			int num = in.nextInt();
			List<Integer> arr = new ArrayList<>(num);
			for (int i = 0; i < num; i++) {
				arr.add(in.nextInt());
			}
			List<Integer> sortList = sort(arr);

			for (Integer i : sortList) {

				System.out.println(i);
			}

		}
	}

	public static List<Integer> sort(List<Integer> arr) {

		Set set = new HashSet<>();

		for (int i : arr) {
			set.add(i);
		}

		List<Integer> list = new ArrayList<>();
		list.addAll(set);

		list.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}

		});

		return list;

	}

}
