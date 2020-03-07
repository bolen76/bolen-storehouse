import java.util.*;

public class Main6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String line = sc.nextLine();
			String[] split = line.split(" ");
			int row = Integer.parseInt(split[0]);
			int col = Integer.parseInt(split[1]);

			int[][] map = new int[row][col];
			int[][] dis = new int[row][col];
			for (int i = 0; i < map.length; i++) {
				String s = sc.nextLine();
				String[] split2 = s.split(" ");
				for (int j = 0; j < map[0].length; j++) {
					map[i][j]=Integer.parseInt(split2[j]);
					dis[i][j] = Integer.MAX_VALUE;
				}
			}
			int[] begin = { 0, 0 };
			int[] end = { row-1, col-1 };
			dis[0][0] = 0;
			Queue<int[]> qu = new LinkedList<>();
			qu.offer(begin);
			// 移动的四个方向
			int[] dx = { 1, 0, -1, 0 };
			int[] dy = { 0, 1, 0, -1 };
			while (!qu.isEmpty()) {
				int[] poll = qu.poll();
				if (poll[0] == end[0] && poll[1] == end[1]) {
					break;
				}

				for (int i = 0; i < dx.length; i++) {
					int nx = poll[0] + dx[i];
					int ny = poll[1] + dy[i];

					if (nx >= 0 && nx < row && ny >= 0 && ny < col && dis[nx][ny] == Integer.MAX_VALUE
							&& map[nx][ny] != 1) {
						dis[nx][ny] = dis[poll[0]][poll[1]] + 1;
						int[] next = { nx, ny };
						qu.offer(next);
					}
				}
			}
			List<int[]> location = new ArrayList<>();

			int[] cur = { row-1, col-1 };

			location.add(new int[]{row-1, col-1 });
			while (dis[cur[0]][cur[1]] != 0) {
				for (int i = 0; i < dx.length; i++) {
					int nx = cur[0] + dx[i];
					int ny = cur[1] + dy[i];

					if (nx >= 0 && nx < row && ny >= 0 && ny < col && dis[nx][ny] < dis[cur[0]][cur[1]]) {
						cur[0] = nx;
						cur[1] = ny;
						location.add(new int[]{nx,ny});
						break;
					}
				}
			}
			StringBuilder sb=new StringBuilder();
			for(int i=location.size()-1;i>-1;i--){
				sb.append("(");
				int[] js = location.get(i);
				sb.append(js[0]);
				sb.append(",");
				sb.append(js[1]);
				sb.append(")");
				sb.append("\r\n");
			}
			System.out.print(sb.toString());
		}
	}

}