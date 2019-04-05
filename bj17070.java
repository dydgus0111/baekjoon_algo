import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj17070 {
	//대각선 이동은 대각선,오른쪽,아래 3군데가 다 빈칸이어야함
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int map[][];
	static int dx[]= {0,1,1};//0우,1하,2오른대각아래
	static int dy[]= {1,0,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		N=Integer.parseInt(br.readLine());
		map=new int[N+1][N+1];
		for(int i=1;i<N+1;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=1;j<N+1;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		if(map[1][1]==0&&map[1][2]==0) {
			dfs(new Pipe(1, 2, 0));
		}
		else
			ans=0;
		System.out.println(ans);
	}
	static class Pipe{
		int x;
		int y;
		int d;
		public Pipe(int x, int y, int d) {
			this.x=x;
			this.y=y;
			this.d=d;
		}
	}
	static boolean isRange(int x, int y) {
		return x>=1&&x<=N&&y>=1&&y<=N;
	}
	static int ans=0;
	static void dfs(Pipe pipe) {
		//pipe 방향이 0이면 0,2만
		//pipe 방향이 1이면 1,2만
		//pipe 방향이 2이면 0,1,2
		if(pipe.x==N&&pipe.y==N) {
			ans++;
			return;
		}
		if(!isRange(pipe.x, pipe.y))
			return;
		for(int i=0;i<3;i++) {
			if(pipe.d==0) {
				if(i==1)
					continue;
			}
			else if(pipe.d==1) {
				if(i==0)
					continue;
			}
			int nx=pipe.x+dx[i];
			int ny=pipe.y+dy[i];
			if(i==2) {
				boolean flag=true;
				for(int j=0;j<3;j++) {
					int tx=pipe.x+dx[j];
					int ty=pipe.y+dy[j];
					if(!isRange(tx, ty)) {
						flag=false;
						break;
					}
					if(map[tx][ty]==1) {
						flag=false;
						break;
					}
				}
				if(flag)
					dfs(new Pipe(nx, ny, i));
			}
			else {
				if(isRange(nx, ny)&&map[nx][ny]==0) {
					dfs(new Pipe(nx, ny, i));
				}
			}
		}
	}
}
