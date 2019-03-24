package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14503 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int map[][];
	static boolean check[][];
	static int N;
	static int M;
	static Point robot;
	static int dx[]= {-1,0,1,0};//0상, 1우, 2 하, 3 좌
	static int dy[]= {0,1,0,-1};
	static int cnt;
	public static void main(String[] args) throws IOException {
		StringTokenizer token=new StringTokenizer(br.readLine());
		N=Integer.parseInt(token.nextToken());
		M=Integer.parseInt(token.nextToken());
		map=new int[N][M];
		check=new boolean[N][M];
		cnt=0;
		tmpcnt=0;
		token=new StringTokenizer(br.readLine());
		int r=Integer.parseInt(token.nextToken());
		int c=Integer.parseInt(token.nextToken());
		int d=Integer.parseInt(token.nextToken());
		robot=new Point(r, c, d);
		for(int i=0;i<N;i++) {
			token=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(token.nextToken());
			}
		}
		dfs();
		System.out.println(cnt);
	}
	static class Point{
		int x;
		int y;
		int d;
		public Point(int x,int y, int d) {
			this.x=x;
			this.y=y;
			this.d=d;
		}
	}
	static boolean checkRound(int x, int y) {
		boolean flag=true;
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
				if(!check[nx][ny]) {
					flag&=false;
					break;
				}
		}
		return flag;
	}
	static int tmpcnt;
	static void dfs() {
		//종료조건
		if(tmpcnt==4) {	//4방향 다 청소가 돼있는 경우
			robot.x=robot.x+dx[(robot.d+2)%4];
			robot.y=robot.y+dy[(robot.d+2)%4];
			if(map[robot.x][robot.y]==1)
				return;
			tmpcnt=0;
		}
		//현재 위치 청소가 안돼있는 경우
		if(map[robot.x][robot.y]==0) {
			map[robot.x][robot.y]=2;
			check[robot.x][robot.y]=true;
			cnt++;
		}
		int nx=robot.x+dx[(robot.d+3)%4];
		int ny=robot.y+dy[(robot.d+3)%4];
			check[nx][ny]=true;
			if(map[nx][ny]==0) {	//청소 안돼있는 경우
				tmpcnt=0;
				map[nx][ny]=2;
				cnt++;
				robot.x=nx;
				robot.y=ny;
				robot.d=(robot.d+3)%4;
				dfs();
			}
			else {	//청소가 되어있는 경우
				robot.d=(robot.d+3)%4;
				tmpcnt++;
				dfs();
			}
	}
}
