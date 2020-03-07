import java.util.*;

public class Main7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String nextLine = sc.nextLine();
			int parseInt = Integer.parseInt(nextLine);
			int rabitts = rabitts(parseInt);
			System.out.println(rabitts);
			int sum = sum(parseInt);
			System.out.println(sum);
		}
	}
	
	
	public static int rabitts(int n){
		if(n==1||n==2)return 1;
		int sum=1;
		int a1=1;
		int a2=1;
		for(int i=3;i<n+1;i++){
			sum=sum+a1;
			a1=a2;
			a2=sum;
		}
		
		return sum;
	}
	
	
	public static int sum(int n){
		if(n==1||n==2)return 1;
		
		return sum(n-2)+sum(n-1);
	}
}