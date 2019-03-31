package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
//1번 상,하,좌,우
//2번 {상,하}, {좌,우}
//3번 {상,좌}, {상,우}, {하,좌}, {하,우}
//4번 {상,좌,우}, {상,우,하}, {우,하,좌}, {하,좌,상}
public class bj15683 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int M;
	static int map[][];
	static int dx[]= {-1,1,0,0};//상,하,좌,우
	static int dy[]= {0,0,-1,1};
	static int dx2[][]= {{-1,1,0,0},{0,0,0,0}};
	static int dy2[][]= {{0,0,0,0},{0,0,-1,1}};
	static int dx3[][]= {{-1,0,0,0},{-1,0,0,0},{0,1,0,0},{0,1,0,0}};
	static int dy3[][]= {{0,0,-1,0},{0,0,0,1},{0,0,-1,0},{0,0,0,1}};
	static int dx4[][]= {{-1,0,0,0},{-1,0,0,1},{0,1,0,0},{1,0,-1,0}};
	static int dy4[][]= {{0,0,-1,1},{0,1,0,0},{0,0,-1,1},{0,-1,0,0}};
	static List<Cctv> cctvlist;
	static List<Cctv> cctv5list;
	static int cnt=0;
	static int ans;
	public static void main(String[] args) throws IOException {
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		cctvlist=new ArrayList<Cctv>();
		cctv5list=new ArrayList<Cctv>();
		ans=Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				int tmp=Integer.parseInt(st.nextToken());
				map[i][j]=tmp;
				if(tmp!=6&&tmp!=0&&tmp!=5) {
					cctvlist.add(new Cctv(i, j, tmp));
				}
				else if(tmp==5) {
					cctv5list.add(new Cctv(i, j, tmp));
				}
				else if(tmp==0)
					cnt++;
			}
		}
		for(int i=0;i<cctv5list.size();i++) {
			cctv5Check(cctv5list.get(i).x, cctv5list.get(i).y);
		}
		select(new int[cctvlist.size()], new boolean[cctvlist.size()], 0);
		if(cctv5list.size()==0&&cctvlist.size()==0)
			ans=cnt;
		System.out.println(ans);
	}
	static void print(int[][] map) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	static int countzero(int[][] map) {
		int cnt=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0)
					cnt++;
			}
		}
		if(cnt<ans)
			ans=cnt;
		return cnt;
	}
	static void select(int sel[],boolean visited[],int n) {
		if(n==cctvlist.size()) {
			if(ans==0)
				return;
			int tmp[][]=new int[N][M];
			for(int i=0;i<N;i++) {
				tmp[i]=Arrays.copyOf(map[i], map[i].length);
			}
			for(int i=0;i<sel.length;i++) {
				if(cctvlist.get(i).kind==2) {
					cctv2Check(cctvlist.get(i).x, cctvlist.get(i).y, sel[i]-1,tmp);
					int cnt=countzero(tmp);
					if(cnt==0)
						break;
				}
				else if(cctvlist.get(i).kind==1) {
					cctv1Check(cctvlist.get(i).x, cctvlist.get(i).y, sel[i]-1, tmp);
					int cnt=countzero(tmp);
					if(cnt==0)
						break;
				}
				else if(cctvlist.get(i).kind==3) {
					cctv3Check(cctvlist.get(i).x, cctvlist.get(i).y, sel[i]-1,tmp);
					int cnt=countzero(tmp);
					if(cnt==0)
						break;
				}
				else if(cctvlist.get(i).kind==4) {
					cctv4Check(cctvlist.get(i).x, cctvlist.get(i).y, sel[i]-1, tmp);
					int cnt=countzero(tmp);
					if(cnt==0)
						break;
				}
			}
			return;
		}
		if(cctvlist.get(n).kind==2) {
			for(int i=1;i<=2;i++) {
				visited[n]=true;
				sel[n]=i;
				select(sel, visited, n+1);
				visited[n]=false;
				sel[n]=0;
			}
		}
		else {
			for(int i=1;i<=4;i++) {
				visited[n]=true;
				sel[n]=i;
				select(sel, visited, n+1);
				visited[n]=false;
				sel[n]=0;
			}
		}
	}
	static boolean isRange(int x, int y) {
		return x>=0&&x<N&&y>=0&&y<M;
	}
	static void cctv5Check(int x, int y) {
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			while(isRange(nx, ny)) {
				if(map[nx][ny]==6)
					break;
				else if(map[nx][ny]==0){
					map[nx][ny]=8;
				}
				nx=nx+dx[i];
				ny=ny+dy[i];
			}
		}
		countzero(map);
	}
	static void cctv1Check(int x, int y,int d,int map[][]) {
		int nx=x+dx[d];
		int ny=y+dy[d];
		while(isRange(nx, ny)) {
			if(map[nx][ny]==6)
				break;
			else if(map[nx][ny]==0){
				map[nx][ny]=8;
			}
			nx=nx+dx[d];
			ny=ny+dy[d];
		}
	}
	static void cctv2Check(int x, int y,int d,int map[][]) {
		for(int i=0;i<4;i++) {
			if(dx2[d][i]!=0||dy2[d][i]!=0) {
				int nx=x+dx2[d][i];
				int ny=y+dy2[d][i];
				while(isRange(nx, ny)) {
					if(map[nx][ny]==6)
						break;
					else if(map[nx][ny]==0){
						map[nx][ny]=8;
					}
					nx=nx+dx2[d][i];
					ny=ny+dy2[d][i];
				}
			}
		}
	}
	static void cctv3Check(int x, int y,int d,int [][]map) {
		for(int i=0;i<4;i++) {
			if(dx3[d][i]!=0||dy3[d][i]!=0) {
				int nx=x+dx3[d][i];
				int ny=y+dy3[d][i];
				while(isRange(nx, ny)) {
					if(map[nx][ny]==6)
						break;
					else if(map[nx][ny]==0){
						map[nx][ny]=8;
					}
					nx=nx+dx3[d][i];
					ny=ny+dy3[d][i];
				}
			}
		}
	}
	static void cctv4Check(int x, int y,int d,int [][]map) {
		for(int i=0;i<4;i++) {
			if(dx4[d][i]!=0||dy4[d][i]!=0) {
				int nx=x+dx4[d][i];
				int ny=y+dy4[d][i];
				while(isRange(nx, ny)) {
					if(map[nx][ny]==6)
						break;
					else if(map[nx][ny]==0){
						map[nx][ny]=8;
					}
					nx=nx+dx4[d][i];
					ny=ny+dy4[d][i];
				}
			}
		}
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
	static class Cctv{
		//cctv의 x,y좌표값/ cctv의 종류
		int x;
		int y;
		int kind;
		public Cctv(int x, int y, int kind) {
			this.x=x;
			this.y=y;
			this.kind=kind;
		}
	}
}
