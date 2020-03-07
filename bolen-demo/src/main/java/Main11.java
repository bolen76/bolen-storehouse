import java.util.Scanner;

public class Main11 {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String nextLine = in.nextLine();
			double number = Double.parseDouble(nextLine);
			double distance = distance(number);
			double heigth = heigth(number);

			System.out.println(distance);
			System.out.println(heigth);

		}
	}

	private static double distance(double k) {
		double sum = k;
		for (int i = 0; i < 4; i++) {
			sum += k;
			k = k / 2;
		}
		return sum;
	}

	private static double heigth(double k) {

		
		return k/32;
	}
}