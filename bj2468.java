package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2468 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int map[][];
	static boolean inWater[][];
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		inWater=new boolean[N][N];
		int tmp=0;
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int input=Integer.parseInt(st.nextToken());
				if(tmp<input)
					tmp=input;
				map[i][j]=input;
			}
		}
		int ans=1;
		for(int i=1;i<=tmp;i++) {
			bfs(new boolean[N][N], i);
			boolean safe[][]=new boolean[N][N];
			int cnt=0;
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					if(!inWater[j][k]&&!safe[j][k]) {
						countSafe(safe, j, k);
						cnt++;
					}
				}
			}
			if(cnt>ans)
				ans=cnt;
		}
		System.out.println(ans);
	}
	static class pair{
		int x;
		int y;
		public pair(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	static boolean isRange(int x, int y) {
		return x>=0&&x<N&&y>=0&&y<N;
	}
	static void bfs(boolean check[][],int height) {
		Queue<pair> queue=new LinkedList<>();
		queue.add(new pair(0, 0));
		check[0][0]=true;
		if(map[0][0]<=height) {
			inWater[0][0]=true;
		}
		while(!queue.isEmpty()) {
			pair next=queue.poll();
			for(int i=0;i<4;i++) {
				int nx=next.x+dx[i];
				int ny=next.y+dy[i];
				if(isRange(nx, ny)&&!check[nx][ny]) {
					check[nx][ny]=true;
					if(map[nx][ny]<=height&&!inWater[nx][ny]) {
						inWater[nx][ny]=true;
					}
					queue.add(new pair(nx, ny));
				}
			}
		}
	}
	static void countSafe(boolean check[][],int x, int y) {
		Queue<pair> queue=new LinkedList<>();
		queue.add(new pair(x, y));
		check[x][y]=true;
		while(!queue.isEmpty()) {
			pair next=queue.poll();
			for(int i=0;i<4;i++) {
				int nx=next.x+dx[i];
				int ny=next.y+dy[i];
				if(isRange(nx, ny)&&!inWater[nx][ny]&&!check[nx][ny]) {
					queue.add(new pair(nx, ny));
					check[nx][ny]=true;
				}
			}
		}
	}
}
