import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
		 
		 while(in.hasNextLine()){
			 
			 String s=in.nextLine();
			 int te = te(s);
			 System.out.println(te);
			 
			 
		 }
	}
	public static int te(String str	){
		if(str==null) throw new IllegalArgumentException();
		
		str=str.trim();
		int j=0;
		for(int i=str.length()-1;i>-1;i--){
			char ch=str.charAt(i);
			if(('a'<=ch&&ch<='z')||('A'<=ch&&ch<='Z')){
				j++;
			}else{
				return j; 
			}
			
		}
		
		return j;
	}
	
	
}
