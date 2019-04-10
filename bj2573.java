package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2573 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int M;
	static int map[][];
	static int dx[]= {1,-1,0,0};
	static int dy[]= {0,0,-1,1};
	static List<iceberg> list;
	public static void main(String[] args) throws IOException {
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		list=new ArrayList<iceberg>();
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				int input=Integer.parseInt(st.nextToken());
				map[i][j]=input;
				if(input!=0) {
					list.add(new iceberg(i, j, map[i][j]));
				}
			}
		}
		int ans=1;
		while(true) {
			int icebergcnt=0;
			for(int i=0;i<list.size();i++) {
				if(list.get(i).cnt!=0) {
					int tmp=0;
					for(int k=0;k<4;k++) {
						int nx=list.get(i).x+dx[k];
						int ny=list.get(i).y+dy[k];
						if(isRange(nx, ny)) {
							if(map[nx][ny]==0) {
								tmp++;
							}
						}
					}
					list.get(i).minus=tmp;
				}
			}
			for(int i=0;i<list.size();i++) {
				list.get(i).cnt-=list.get(i).minus;
				int x=list.get(i).x;
				int y=list.get(i).y;
				if(list.get(i).cnt<=0) {
					map[x][y]=0;
					list.remove(i);
					i--;
				}
				else {
					map[x][y]=list.get(i).cnt;
				}
			}
			if(list.size()==0) {
				ans=0;
				break;
			}
			boolean check[][]=new boolean[N][M];
			for(int i=0;i<list.size();i++) {
				int x=list.get(i).x;
				int y=list.get(i).y;
				if(map[x][y]!=0&&!check[x][y]) {
					bfs(x, y, check);
					icebergcnt++;
				}
			}
			if(icebergcnt>=2) {
				break;
			}
			ans++;
		}
		System.out.println(ans);
	}
	static void print() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	static boolean isRange(int x, int y) {
		return x>=0&&x<N&&y>=0&&y<M;
	}
	static class iceberg {
		int x;
		int y;
		int cnt;
		int minus;
		public iceberg(int x, int y, int cnt) {
			this.x=x;
			this.y=y;
			this.cnt=cnt;
		}
	}
	static void bfs(int x, int y, boolean check[][]) {
		Queue<iceberg> queue=new LinkedList<iceberg>();
		queue.add(new iceberg(x, y, map[x][y]));
		check[x][y]=true;
		while(!queue.isEmpty()) {
			iceberg next=queue.poll();
			for(int i=0;i<4;i++) {
				int nx=next.x+dx[i];
				int ny=next.y+dy[i];
				if(isRange(nx, ny)) {
					if(!check[nx][ny]&&map[nx][ny]!=0) {
						check[nx][ny]=true;
						queue.add(new iceberg(nx, ny, map[nx][ny]));
					}
				}
			}
		}
	}
}
