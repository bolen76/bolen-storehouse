import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main5 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {

			String sentence = in.nextLine();
			List<String> list = new ArrayList<>();
			char[] charArray = sentence.toCharArray();
			for(int i=0;i<charArray.length;i++){
				if ( isSpliter(charArray[i])) {
					charArray[i]=' ';
				}
			}
			String string = new String(charArray);
			string=string.trim();
			String[] split = string.split(" ");
			
			
			StringBuilder sb=new StringBuilder();
			for (int i = split.length - 1; i > -1; i--) {
				
				if (split[i].length() > 0) {
					if (i == 0) {
						sb.append(split[i]);
					} else {
						sb.append(split[i]);
						sb.append(" ");
					}

				}
			}
			System.out.print(sb.toString());

		}
	}

	private static boolean isSpliter(char ch) {
		return !(('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z'));
	}
}
