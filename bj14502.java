import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int map[][];
	static List<Pair> slist;
	static List<Pair> blist;
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	static int ans;
	static int cmap[][];
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		StringTokenizer token=new StringTokenizer(br.readLine());
		N=Integer.parseInt(token.nextToken());
		M=Integer.parseInt(token.nextToken());
		map=new int[N][M];
		cmap=new int[N][M];
		slist=new ArrayList<Pair>();
		blist=new ArrayList<Pair>();
		ans=0;
		for(int i=0;i<N;i++) {
			token=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(token.nextToken());
				if(map[i][j]==0)
					slist.add(new Pair(i, j));
				else if(map[i][j]==2)
					blist.add(new Pair(i, j));
					
			}
		}
		for(int i=0;i<N;i++) {
			cmap[i]=Arrays.copyOf(map[i], map[i].length);//map[i].clone();
		}
		combi(new int[N][M],map,new Pair[3], 0, 0);
		System.out.println(ans);
	}
	static class Pair{
		int x;
		int y;
		public Pair(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	static void combi(int[][] copy,int[][] tmp,Pair[] sel, int n , int r) {
		if(r==sel.length) {
			for(int i=0;i<sel.length;i++) {
				map[sel[i].x][sel[i].y]=1;
			}
			bfs(new boolean[N][M], new int[N][M]);
			for(int i=0;i<sel.length;i++) {
				map[sel[i].x][sel[i].y]=0;
			}
			return;
		}
		if(slist.size()==n)
			return;
		sel[r]=slist.get(n);
		combi(copy,tmp,sel, n+1, r+1);
		combi(copy,tmp,sel, n+1, r);
	}
	static boolean isRange(int x, int y) {
		return x>=0&&x<N&&y>=0&&y<M;
	}
	static void bfs(boolean[][] check,int[][] tmp) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				tmp[i][j]=map[i][j];
			}
		}
		Queue<Pair> queue=new LinkedList<Pair>();
		for(int i=0;i<blist.size();i++) {
			queue.add(blist.get(i));
			check[blist.get(i).x][blist.get(i).y]=true;
		}
		while(!queue.isEmpty()) {
			Pair next=queue.poll();
			for(int i=0;i<4;i++) {
				int nx=next.x+dx[i];
				int ny=next.y+dy[i];
				if(isRange(nx, ny)) {
					if(tmp[nx][ny]==0&&!check[nx][ny]) {
						tmp[nx][ny]=2;
						check[nx][ny]=true;
						queue.add(new Pair(nx, ny));
					}
				}
			}
		}
		int cnt=countSafe(tmp);
		if(cnt>ans) {
			ans=cnt;
		}
	}
	static int countSafe(int[][] tmp) {
		int cnt=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(tmp[i][j]==0)
					cnt++;
			}
		}
		return cnt;
	}
}
