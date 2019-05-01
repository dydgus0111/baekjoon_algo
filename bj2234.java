import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2234 {
	//1. 방의 개수/ 가장 넓은 방 넓이 / 벽 하나 없앨을 때 가장 큰 방 넓이
	//2. 벽이 놓아진 위치를 갖는 객체 필요
	//3. bfs돌면서 방번호 지정, 해당 방 크기 구하기
	//4. bfs2 돌면서 근접한 방 찾고, bfs를 돌고있는방 크기+근접한 방크기 중에서 최대값 찾기
	static class wall{
		boolean wall[]=new boolean[4];//0: 좌, 1:상, 2:우, 3:하
		int roomnum;
		public wall(boolean wall[]) {
			this.wall=wall;
		}
	}
	static int dx[]= {0,-1,0,1};//좌,상,우,하
	static int dy[]= {-1,0,1,0};
	static wall map[][];
	static int m;
	static int n;
	static int ans;
	static List<Integer> rlist;
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		map=new wall[m][n];
		rlist=new ArrayList<Integer>();
		ans=0;
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				int input=Integer.parseInt(st.nextToken());
				map[i][j]=new wall(new boolean[4]);
				checkWall(input, i, j);
			}
		}
		boolean check[][]=new boolean[m][n];
		int roomnum=0;
		int maxroom=Integer.MIN_VALUE;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(!check[i][j]) {
					int roomsize=bfs(check, i, j, roomnum);
					rlist.add(roomsize);
					if(maxroom<roomsize)
						maxroom=roomsize;
					roomnum++;
				}
			}
		}
		check=new boolean[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(!check[i][j]) {
					bfs2(check, i, j);
				}
			}
		}
		System.out.println(roomnum);
		System.out.println(maxroom);
		System.out.println(ans);
	}
	static void checkWall(int input,int x, int y) {
		for(int i=3;i>=0;i--) {
			if(input-Math.pow(2, i)>=0) {
				input-=Math.pow(2, i);
				map[x][y].wall[i]=true;
			}
		}
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
		return x>=0&x<m&&y>=0&&y<n;
	}
	static int bfs(boolean check[][], int x, int y,int roomnum) {
		Queue<pair> queue=new LinkedList<>();
		int cnt=1;
		queue.add(new pair(x, y));
		check[x][y]=true;
		map[x][y].roomnum=roomnum;
		while(!queue.isEmpty()) {
			pair next=queue.poll();
			for(int i=0;i<4;i++) {
				int nx=0;
				int ny=0;
				if(!map[next.x][next.y].wall[i]) {
					nx=next.x+dx[i];
					ny=next.y+dy[i];
				}
				else
					continue;
				if(isRange(nx, ny)&&!check[nx][ny]) {
					cnt++;
					map[nx][ny].roomnum=roomnum;
					check[nx][ny]=true;
					queue.add(new pair(nx, ny));
				}
			}
		}
		return cnt;
	}
	static void bfs2(boolean check[][],int x, int y) {
		Queue<pair> queue=new LinkedList<>();
		queue.add(new pair(x, y));
		check[x][y]=true;
		while(!queue.isEmpty()) {
			pair next=queue.poll();
			for(int i=0;i<4;i++) {
				int nx=next.x+dx[i];
				int ny=next.y+dy[i];
				if(isRange(nx, ny)&&!check[nx][ny]&&map[nx][ny].roomnum==map[x][y].roomnum) {
					check[nx][ny]=true;
					queue.add(new pair(nx, ny));
				}
				else if(isRange(nx, ny)&&map[nx][ny].roomnum!=map[x][y].roomnum) {
					int tmp1=map[nx][ny].roomnum;
					int tmp2=map[x][y].roomnum;
					if(rlist.get(tmp1)+rlist.get(tmp2)>ans)
						ans=rlist.get(tmp1)+rlist.get(tmp2);
				}
			}
		}
	}
}
