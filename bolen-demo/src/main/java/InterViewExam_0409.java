
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author 张周俊 2020-04-09
 * 
 */
public class InterViewExam_0409 {

	public static void main(String[] args) {
		String translate = translate(703);
		System.out.println(translate);
	}

	public static String translate(int num) {
		List<Integer> result=new ArrayList<>();
		modResult(num, result);
		StringBuilder sb=new StringBuilder();
		for(int i:result) {
			
			sb.append((char)(96+i));
		}

		return sb.reverse().toString();
	}

	public static List<Integer> modResult(int num, List<Integer> result) {
		if (0 < num && num < 26) {
			result.add(num);
		} else if (num >= 26) {
			int mod = num % 26;
			if (mod == 0) {
				result.add(26);
				num -= 26;
			} else {
				result.add(mod);
			}
			num /= 26;
			modResult(num, result);
		}

		return result;
	}

}
