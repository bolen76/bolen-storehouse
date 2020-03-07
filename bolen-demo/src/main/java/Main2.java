import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
		 
		 while(in.hasNextLine()){
			 
			 String str=in.nextLine();
			 String word=in.nextLine();
			 int te = presentTimes(str,word);
			 System.out.println(te);
			 
			 
		 }
	}
	public static int presentTimes(String str,String word	){
		if(str==null||word==null) throw new IllegalArgumentException();
		if(word.length()!=1) throw new IllegalArgumentException();
		
		str=str.trim();
		String lowerCase = word.toLowerCase();
		char lowrChar=lowerCase.charAt(0);
		String upperCase = word.toUpperCase();
		char upperChar=upperCase.charAt(0);
		int j=0;
		for(int i=str.length()-1;i>-1;i--){
			char ch=str.charAt(i);
			if(ch==lowrChar||ch==upperChar){
				j++;
			}
			
		}
		
		return j;
	}
	
	
}
