import java.util.Scanner;

public class Main15 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] set = new String[] { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
		String[] set_teen = new String[] { "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
				"seventeen", "eighteen", "nineteen" };
		String[] set_ty = new String[] { "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };
		String[] set_lion = new String[] { "hundred", "", "thousand", "million", "billion" };
		while (sc.hasNext()) {
			StringBuffer result = new StringBuffer();
			long Num = sc.nextLong();
			char[] num = String.valueOf(Num).toCharArray();
			for (int i = 0; i < num.length; i++) {
				if ((num.length - i) % 3 == 1) {
					if (i >= 2 && Character.getNumericValue(num[i - 2]) != 0) {
						result.append(" ").append(set[Character.getNumericValue(num[i - 2]) - 1]).append(" ")
								.append(set_lion[0]);
					}
					if (i >= 2 && Character.getNumericValue(num[i - 2]) != 0
							&& (Character.getNumericValue(num[i - 1]) != 0 || Character.getNumericValue(num[i]) != 0)) {
						result.append(" and");
					}
					if (i >= 1 && Character.getNumericValue(num[i - 1]) == 1) {
						result.append(" ").append(set_teen[Character.getNumericValue(num[i])]);
					} else if (i >= 1 && Character.getNumericValue(num[i - 1]) >= 2) {
						result.append(" ").append(set_ty[Character.getNumericValue(num[i - 1]) - 2]);
					}
					if (((i >= 1 && Character.getNumericValue(num[i - 1]) != 1) || i == 0)
							&& Character.getNumericValue(num[i]) != 0) {
						result.append(" ").append(set[Character.getNumericValue(num[i]) - 1]);
					}
					result.append(" ").append(set_lion[(num.length - i) / 3 + 1]);
				}
			}
			String Result = result.toString().trim();
			System.out.println(Result);
		}
		sc.close();
	}
}