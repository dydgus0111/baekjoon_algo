package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj4963 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int W;
	static int H;
	static int map[][];
	static int dx[]= {1,-1,0,0,-1,-1,1,1};
	static int dy[]= {0,0,-1,1,1,-1,-1,1};
	static boolean visited[][];
	static int ans;
	public static void main(String[] args) throws IOException {
		while(true) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			W=Integer.parseInt(st.nextToken());
			H=Integer.parseInt(st.nextToken());
			if(W==0&&H==0)
				break;
			map=new int[H][W];
			visited=new boolean[H][W];
			ans=0;
			for(int i=0;i<H;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<W;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					if(map[i][j]==1&&!visited[i][j]) {
						bfs(i, j);
						ans++;
					}
				}
			}
			System.out.println(ans);
		}
	}
	static class Pair{
		int x;
		int y;
		public Pair(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	static boolean isRange(int x, int y) {
		return x>=0&&x<H&&y>=0&&y<W;
	}
	
	static void bfs(int x, int y) {
		Queue<Pair> queue=new LinkedList<Pair>();
		queue.add(new Pair(x, y));
		visited[x][y]=true;
		while(!queue.isEmpty()) {
			Pair next=queue.poll();
			for(int i=0;i<8;i++) {
				int nx=next.x+dx[i];
				int ny=next.y+dy[i];
				if(isRange(nx, ny)) {
					if(!visited[nx][ny]&&map[nx][ny]==1) {
						visited[nx][ny]=true;
						queue.add(new Pair(nx, ny));
					}
				}
			}
		}
	}
}
