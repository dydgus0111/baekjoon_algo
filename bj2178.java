import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2178 {
	static class xy{
		int nx;
		int ny;
		int cnt;
		xy(int x,int y,int c){
			nx=x;
			ny=y;
			cnt=c;
		}
	}
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		//시작점 0,0
		//목적 도착점 r-1, c-1
		//0은 이동불가, 1은 이동가능
		//dfs로
		//출력은 출발점에서 도착점까지 몇개의 1을 밟았는지
		StringTokenizer token=new StringTokenizer(br.readLine());
		n=Integer.parseInt(token.nextToken());
		m=Integer.parseInt(token.nextToken());
		int[][] map=new int[n][m];
		for(int i=0;i<n;i++) {
			String str=br.readLine();
			for(int j=0;j<m;j++) {
				char temp=str.charAt(j);
				map[i][j]=temp-'0';
			}
		}
		check=new int[n][m];
		boolean [][]visited=new boolean[n][m];
//		dfs(map,visited,0,0,0);
//		System.out.println(ans+1);
		bfs(map,0,0);
	}
	static int n=0;
	static int m=0;
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,1,-1};
	static int[][] check;
	static int ans=Integer.MAX_VALUE;
	static void dfs(int[][] map,boolean[][] visited, int x, int y,int cnt) {
		if(x==n-1&&y==m-1) {
			if(ans>cnt)
				ans=cnt;
			return;
		}
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx>=0&&nx<n&&ny>=0&&ny<m) {
				if(map[nx][ny]==1&&visited[nx][ny]==false) {
					visited[nx][ny]=true;
					dfs(map,visited,nx,ny,cnt+1);
					visited[nx][ny]=false;
				}
			}
		}
	}
	static void bfs(int[][] map, int x, int y) {
		Queue<xy> queue=new LinkedList<>();
		boolean [][]check=new boolean[n][m];
		queue.add(new xy(x,y,1));
		check[x][y]=true;
		while(!queue.isEmpty()) {
			xy node=queue.poll();
			if(node.nx==n-1&&node.ny==m-1) {
				System.out.println(node.cnt);
				return;
			}
			for(int i=0;i<4;i++){
				int nx=node.nx+dx[i];
				int ny=node.ny+dy[i];
				if(nx>=0&&nx<n&&ny>=0&&ny<m) {
					if(map[nx][ny]==1&&!check[nx][ny]) {
						check[nx][ny]=true;
						queue.add(new xy(nx,ny,node.cnt+1));
					}
				}
			}
		}
	}
}