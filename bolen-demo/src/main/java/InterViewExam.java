

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author 张周俊 2020-02-26
 * 
 */
public class InterViewExam {
	
	public static final int YES=0;//通过
	public static final int NO=1;//不通过
	
	public static void main(String[] args) {
		/**
		 * 0 0 1 1 
		 * 0 1 0 0 
		 * 0 1 0 1  
		 */
		
		/**
		 * 0 0 1 1 0
		 * 0 1 0 0 0 
		 * 0 1 0 1 0
		 * 0 0 0 1 0
		 */
		int[][] arr= new int[4][5];
		arr[0][0]=0;
		arr[0][1]=0;
		arr[0][2]=1;
		arr[0][3]=1;
		arr[0][3]=1;
		
		arr[1][0]=0;
		arr[1][1]=1;
		arr[1][2]=0;
		arr[1][3]=0;
		
		arr[2][0]=0;
		arr[2][1]=0;
		arr[2][2]=0;
		arr[2][3]=0;
		
		int fuc = fuc( arr);
		System.out.println(fuc);
	}
	
	public static int fuc(int[][] arr){
		if(arr==null || arr.length<2||arr[0].length<2){
			throw new IllegalArgumentException("输入参数不正确！");
		}
	    int[][]  dist=new int[arr.length][arr[0].length];	
	    for(int i=0;i<arr.length;i++){
	    	for(int j=0;j<arr[0].length;j++){
	    		dist[i][j]=Integer.MIN_VALUE;
	    	}
	    }
	    
	  
	    Stack<Position> stack=new Stack<>();
	    
	    Position start=new Position(0,0);
	    dist[0][0]=0;
	    stack.push(start);
	    while(!stack.isEmpty()){
	    	Position location = stack.pop();
	    	List<Position> arounds=getAround(location,arr,dist);
	    	for(Position po:arounds){
	    		if(po.x==arr[0].length-1&&po.y==arr.length-1){
	    			dist[po.y][po.x]=dist[location.y][location.x]+1;
	    			return  dist[location.y][location.x]+1;
	    		}
	    		if(arr[po.y][po.x]==YES && dist[po.y][po.x]==Integer.MIN_VALUE){
	    			dist[po.y][po.x]=dist[location.y][location.x]+1;
	    			stack.push(po);
	    		}
	    	}
	    }
	    
	    return -1;
	    
	}
	
	/**
	 * 获取周围4个坐标点
	 * @param location
	 * @param arr
	 * @return
	 */
	private static List<Position> getAround(Position location, int[][] arr,int[][] dist) {
		List<Position> list=new ArrayList<Position>();
		if(location.x-1>-1 && dist[location.y][location.x-1]==Integer.MIN_VALUE ){
			list.add(new Position(location.x-1,location.y));
		}
		if(location.x+1<arr[0].length && dist[location.y][location.x+1]==Integer.MIN_VALUE){
			list.add(new Position(location.x+1,location.y));
		}
		
		if(location.y-1>-1 && dist[location.y-1][location.x]==Integer.MIN_VALUE){
			list.add(new Position(location.x,location.y-1));
		}
		if(location.y+1<arr.length && dist[location.y+1][location.x]==Integer.MIN_VALUE){
			list.add(new Position(location.x,location.y+1));
		}
		
		return list;
	}


	private static class Position{
		private int x;
		private int y;
		public Position(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	/**
	 * 0 0 1 1 0
	 * 0 1 0 0 0 
	 * 0 1 0 1 0
	 * 0 0 0 1 0
	 */
	
	/**
	 * 0 0 0 0 1
	 * 0 0 1 1 0
	 * 0 0 0 0 0
	 * 0 0 0 0 0
	 */
}
