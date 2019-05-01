package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2583 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int map[][];
	static int M;
	static int N;
	static int K;
	static List<pair> list;
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		//y에 |M-y| , x,y 바꾸기
		StringTokenizer st=new StringTokenizer(br.readLine());
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		map=new int[M+1][N+1];
		list=new ArrayList<>();
		for(int i=0;i<K;i++) {
			st=new StringTokenizer(br.readLine());
			int c1=Integer.parseInt(st.nextToken());
			int r1=Integer.parseInt(st.nextToken());
			int c2=Integer.parseInt(st.nextToken());
			int r2=Integer.parseInt(st.nextToken());
			list.add(new pair(c1, r1, c2, r2));
		}
		for(int i=0;i<list.size();i++) {
			bfs(list.get(i).r1, list.get(i).c1, new boolean[M+1][N+1], list.get(i).r1, 
					list.get(i).c1, list.get(i).r2, list.get(i).c2);
		}
		int ans=0;
		List<Integer> anslist=new ArrayList<>();
		boolean check[][]=new boolean[M+1][N+1];
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==0&&!check[i][j]) {
					ans++;
					anslist.add(bfs2(i, j, check));
				}
			}
		}
		anslist.sort(null);
		System.out.println(ans);
		for(int i=0;i<anslist.size();i++) {
			System.out.print(anslist.get(i)+" ");
		}
	}
	static class pair{
		int c1;
		int r1;
		int c2;
		int r2;
		public pair(int c1, int r1, int c2, int r2) {
			this.c1=c1;
			this.r1=r1;
			this.c2=c2;
			this.r2=r2;
		}
	}
	static class point{
		int x;
		int y;
		public point(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	static boolean isRange(int x, int y, int r1, int c1,int r2, int c2) {
		return x>=r1&&x<r2&&y>=c1&&y<c2;
	}
	static void bfs(int x, int y, boolean check[][],int r1, int c1, int r2, int c2) {
		Queue<point> queue=new LinkedList<>();
		queue.add(new point(x, y));
		map[x][y]=1;
		while(!queue.isEmpty()) {
			point next=queue.poll();
			for(int i=0;i<4;i++) {
				int nx=next.x+dx[i];
				int ny=next.y+dy[i];
				if(isRange(nx, ny, r1, c1, r2, c2)) {
					if(!check[nx][ny]) {
						map[nx][ny]=1;
						check[nx][ny]=true;
						queue.add(new point(nx, ny));
					}
				}
			}
		}
	}
	static int bfs2(int x, int y,boolean check[][]) {
		int cnt=1;
		Queue<point> queue=new LinkedList<>();
		queue.add(new point(x, y));
		check[x][y]=true;
		while(!queue.isEmpty()) {
			point next=queue.poll();
			for(int i=0;i<4;i++) {
				int nx=next.x+dx[i];
				int ny=next.y+dy[i];
				if(nx>=0&&nx<M&&ny>=0&&ny<N&&!check[nx][ny]) {
					if(map[nx][ny]==0) {
						check[nx][ny]=true;
						queue.add(new point(nx, ny));
						cnt++;
					}
				}
			}
		}
		return cnt;
	}
}