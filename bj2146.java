package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2146 {
	//1. bfs 한번씩 돌면서 섬의 번호 붙이기.
	//2. map이 0이 아니면서, 4방중에 0이 
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int map[][];
	static int N;
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	static List<pair> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		list=new ArrayList<>();
		ans=Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		boolean check[][]=new boolean[N][N];
		int cnt=1;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]!=0&&!check[i][j]) {
					bfs(i, j, check, cnt);
					cnt++;
				}
			}
		}
		for(int i=0;i<list.size();i++) {
			bfs2(list.get(i).x, list.get(i).y,new boolean[N][N]);
		}
		System.out.println(ans);
	}
	static int ans;
	static class pair{
		int x;
		int y;
		int cnt;
		public pair(int x, int y) {
			this.x=x;
			this.y=y;
		}
		public pair(int x, int y,int cnt) {
			this.x=x;
			this.y=y;
			this.cnt=cnt;
		}
		public String toString() {
			return x+" "+y;
		}
	}
	static boolean isRange(int x, int y) {
		return x>=0&&x<N&&y>=0&&y<N;
	}
	static void bfs(int x, int y,boolean check[][],int cnt) {
		Queue<pair> queue=new LinkedList<>();
		queue.add(new pair(x, y));
		check[x][y]=true;
		map[x][y]=cnt;
		while(!queue.isEmpty()) {
			pair next=queue.poll();
			boolean flag=false;
			for(int i=0;i<4;i++) {
				int nx=next.x+dx[i];
				int ny=next.y+dy[i];
				if(isRange(nx, ny)) {
					if(map[nx][ny]==0)
						flag=true;
					if(map[nx][ny]!=0&&!check[nx][ny]) {
						map[nx][ny]=cnt;
						check[nx][ny]=true;
						queue.add(new pair(nx, ny));
					}
				}
			}
			if(flag)
				list.add(new pair(next.x, next.y));
		}
	}
	static void bfs2(int x, int y,boolean check[][]) {
		Queue<pair> queue=new LinkedList<>();
		queue.add(new pair(x, y, 0));
		check[x][y]=true;
		while(!queue.isEmpty()) {
			pair next=queue.poll();
			if(next.cnt>ans)
				continue;
			for(int i=0;i<4;i++) {
				int nx=next.x+dx[i];
				int ny=next.y+dy[i];
				if(isRange(nx, ny)) {
					if(map[nx][ny]==0&&!check[nx][ny]) {
						check[nx][ny]=true;
						queue.add(new pair(nx, ny, next.cnt+1));
						continue;
					}
					if(!check[nx][ny]&&map[nx][ny]!=0&&map[x][y]!=map[nx][ny]) {
						if(ans>next.cnt) {
							ans=next.cnt;
						}
					}
				}
			}
		}
	}
}