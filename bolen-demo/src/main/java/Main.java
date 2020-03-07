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
}