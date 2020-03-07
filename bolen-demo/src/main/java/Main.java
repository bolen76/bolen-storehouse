<<<<<<< HEAD
// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            
        	String nextLine = in.nextLine();
        	String[] split = nextLine.split(" ");
        	if(split.length<2){
        		System.out.println(-1);
        		continue;
        	}
        	List<Integer> list=new ArrayList<>();
        	boolean flag=true;
        	for(String str:split){
        		Integer parseInt=null;
        		try{
        			 parseInt = Integer.parseInt(str);
        		}catch(Exception e){
        			System.out.println(-1);
        			flag=false;
        			break;
        		}
        		if(parseInt<=0){
        			System.out.println(-1);
        			flag=false;
        			break;
        		}
        		list.add(parseInt);
        	}
        	if(!flag){
        		continue;
        	}
        	if(list.get(list.size()-1)<list.size()-1){
              	System.out.println(-1);
              	continue;
              }

              int k=1;
              
              for(;;k++){
              	int total=0;
              	for(int i=0;i<list.size()-1;i++){
              		int add=list.get(i)%k==0?0:1;
              		total+=list.get(i)/k+add;
              	}
              	if(total<=list.get(list.size()-1)){
              		System.out.println(k);
              		break;
              	}
              }
        }
    }
=======
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
>>>>>>> 484895c8fac1f4d4944101997328ad6a0e9786c0
}